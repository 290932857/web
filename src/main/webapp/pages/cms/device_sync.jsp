<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../common/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/ext/classic/theme-neptune/resources/theme-neptune-all.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ext/ext-bootstrap.js"></script>
<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
	Ext.onReady(function(){
		var deviceStore = Ext.create('Ext.data.Store', {
			fields : [ 'id', 'cityName', 'apmac', 'deviceFactory', 'time' ],
			pageSize : 20,
			remoteSort : false,
			remoteFilter : true,
			proxy : {
				type : 'ajax',
				url : contextPath + '/device/list.do',
				reader : {
					type : 'json',
					rootProperty : 'list',
					totalProperty : 'rowCount'
				}
			},
			autoLoad : true
		});
		var contentStore = Ext.create('Ext.data.Store', {
			fields : [ 'id', 'success', 'message', 'type', 'version', 'dateline' ],
			pageSize : 20,
			remoteSort : false,
			remoteFilter : true,
			proxy : {
				type : 'ajax',
				url : contextPath + '/content/apmac.do',
				reader : {
					type : 'json',
					rootProperty : 'list',
					totalProperty : 'rowCount'
				}
			}
		});
		contentStore.on('beforeload', function() {
			var deviceGrid = panel.down('#deviceGrid');
			var device = deviceGrid.getSelectionModel().getSelection();
			if(device.length != 0) {
				var apmac = device[0].data.apmac;
				var queryParams = {
					'apmac' : apmac
				};
				Ext.apply(contentStore.proxy.extraParams, queryParams);
			}
		});
		var panel = Ext.create('Ext.panel.Panel', {
			width : '100%',
			layout : 'hbox',
			items : [{
				title : 'Device',
				id : 'deviceGrid',
				xtype : 'grid',
				flex : 1,
				store : deviceStore,
				columns : [{
				 	text : 'ID',
				 	dataIndex : 'id',
				 	width : 65
			 	}, {
				 	text : '城市',
			 		dataIndex : 'cityName',
			 		width : 65
			 	}, {
			 		text : 'Apmac',
					dataIndex : 'apmac',
					width : 120
				}, {
				 	text : '设备厂商',
				 	dataIndex : 'deviceFactory',
				 	width : 75,
				 	renderer : function(value) {
						switch (value) {
						case 'maipu':
							return '迈普';
						case 'ruijie':
							return '锐捷';
						case 'datang':
							return '大唐';
						default:
							return value;
						}
					}
			 	}, {
				 	text : '创建时间',
				 	dataIndex : 'time',
				 	renderer : function(value) {
				 		if(value != null){
			 		    	return new Date(parseInt(value) * 1000).toLocaleString().substr(0,17);
				 		}
				 		return '无时间';
				 	},
				 	width : 150
			 	}],
			 	dockedItems : [ {
					xtype : 'toolbar',
					dock : 'top',
					items : [ {
						text : '过滤',
						hidden : false,
						icon : contextPath + '/resources/image/icons/search.gif',
						tooltip : '显示/隐藏数据过滤面板',
						enableToggle : true,
						toggleHandler : function(pressed) {
							var filter = Ext.getCmp('FilterPanel');
							if (pressed) {
								filter.setVisible(true);
							} else {
								filter.setVisible(false);
							}
						}
			 		}, {
				 		id : 'FilterPanel',
						xtype : 'toolbar',
						dock : 'top',
						hidden : true,
						items : [ {
							xtype: 'textfield',
							width : 258, 
							id : 'search', 
							emptyText: 'apmac'
						}, {
							text : '搜索', 
							handler : function() {
					        	deviceStore.load({
									params : {
				        				'apmac' : Ext.getCmp("search").value
				        			}
					        	});
				        	}
						}, {
					        text : '重置', 
				        	handler : function() {
				        	Ext.getCmp("search").setValue("");
				        		deviceStore.reload({
				        			params : {
					        			'page' : "1",
					        			'limit' : '20'
					        		}
					        	});
					        }
						} ]
					} ]
			 	} ],
			 	bbar : new Ext.PagingToolbar({
			 		store : deviceStore,
			 		pageSize : 20,
			 		displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
					emptyMsg : "没有相关记录",
					beforePageText:"第",
					afterPageText:"/　{0}页",
					firstText:"首页",
					prevText:"上一页",
					nextText:"下一页",
					lastText:"尾页",
					refreshText:"刷新",
					flex : 1,
					displayInfo : true,
					doLoad : function(start){
						record_start = start;
						var o = {}, pn = this.getParams();
						o[pn.page] = start;
						o[pn.limit] = this.pageSize;
						this.deviceStore.load({params:o});
					}
			 	})
		 	},{
			 	title : 'Content',
			 	id : 'contentGrid',
				xtype : 'grid',
				store : contentStore,
				flex : 1,
				margin : '0 0 0 5',
				columns : [{
					text : 'ID',
					dataIndex : 'id',
					width : 80
				}, {
					text : '是否成功',
					dataIndex : 'success',
					width : 75,
					renderer : function(value){
						switch (value){
						case 0:
							return '成功';
						case 1:
							return '失败';
						default:
							return value;
						}
					}
				}, {
					text : '消息',
					dataIndex : 'message'
				}, {
					text : '同步步骤',
					dataIndex : 'type',
					width : 80,
					renderer : function(value){
						switch (value){
						case 'start':
							return '开始';
						case 'receive':
							return '接收';
						case 'complete':
							return '完成';
						default:
							return value;
						}
					}
				}, {
					text : '版本',
					dataIndex : 'version',
					width : 55
				}, {
					text : '时间',
					dataIndex : 'dateline',
					renderer : function(value) {
						if (value == null) {
							return '无时间';
						} else {
			 		    	return new Date(parseInt(value) * 1000).toLocaleString().substr(0,17);
						}
				 	},
				 	width : 150
				}],
				bbar : new Ext.PagingToolbar({
					store : contentStore,
					pageSize : 20,
					displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
					emptyMsg : "没有相关记录",
					beforePageText:"第",
					afterPageText:"/　{0}页",
					firstText:"首页",
					prevText:"上一页",
					nextText:"下一页",
					lastText:"尾页",
					refreshText:"刷新",
					flex : 1,
					displayInfo : true,
					doLoad : function(start){
				        record_start = start;
			            var o = {}, pn = this.getParams();
			            o[pn.page] = start;
			            o[pn.limit] = this.pageSize;
			            this.contentStore.load({params:o});
				   }
				})
			}],
			renderTo : Ext.getBody()
		});
		
		var deviceGrid = panel.down('#deviceGrid');
		deviceGrid.getSelectionModel().on('selectionchange',
		function(selections) {
			contentStore.load()
		});
	});
</script>
</head>
<body>
</body>
</html>