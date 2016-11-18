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
	Ext.onReady(function() {
		var siteStore = Ext.create('Ext.data.Store', {
			fields : [ 'id', 'code', 'name' ],
			pageSize : 20,
			remoteSort : false,
			remoteFilter : true,
			proxy : {
				type : 'ajax',
				url : contextPath + '/cms/getcmssiteinfo.do',
				reader : {
					type : 'json',
					rootProperty : 'list',
					totalProperty : 'rowCount'
				}
			},
			autoLoad : true
		});
		var syncStore = Ext.create('Ext.data.Store', {
			fields : [ 'id', 'cmsId', 'sitename', 'packId', 'version',
					'rsyncPath', 'syncType', 'syncConfigPath', 'incrementSize',
					'dateline' ],
			pageSize : 20,
			remoteSort : false,
			remoteFilter : true,
			proxy : {
				type : 'ajax',
				url : contextPath + '/cms/getcmssyncinfo.do',
				reader : {
					type : 'json',
					rootProperty : 'list',
					totalProperty : 'rowCount'
				}
			}
		});
		syncStore.on("beforeload", function(){
			var siteGrid = panel.down('#siteGrid');
			var site = siteGrid.getSelectionModel().getSelection();
			if(site.length != 0){
				var siteId = site[0].data.id;
				var queryParams = {
					'siteId' : siteId
				};
				Ext.apply(syncStore.proxy.extraParams, queryParams);
			}
		});
		var panel = Ext.create('Ext.panel.Panel', {
			width : '100%',
			layout : 'hbox',
			items : [ {
				title : 'Site',
				id : 'siteGrid',
				xtype : 'grid',
				flex : 1,
				store : siteStore,
				columns : [ {
					text : 'id',
					dataIndex : 'id',
					width : 60
				}, {
					text : '站点全拼',
					dataIndex : 'code',
					width : 150
				}, {
					text : '站点名称',
					dataIndex : 'name',
					width : 150
				}, {
					xtype:'actioncolumn',
					width: 100,
					text : '操作',
					items: [ {
						handler : function(grid, rowIndex) {
		                    var rec = grid.getStore().getAt(rowIndex);
		                    var id = rec.data.id;
		                    Ext.MessageBox.confirm("导出", "您确定要导出最新版本的相关数据？", function (btn) {
             					if(btn == 'yes') {
				                    window.location.href = contextPath + '/device/syncrecord.do?id=' + id;
	                      		}
                      		});
		                },
		                margin : '20 20 20 20',
						icon    : contextPath + '/resources/image/icons/filesave.png',
		                tooltip : '保存'
					},"-","-","-", {
						handler : function(grid, rowIndex) {
							var rec = grid.getStore().getAt(rowIndex);
		                    var id = rec.data.id;
		                    var name = rec.data.name;
		                    Ext.MessageBox.confirm("同步", "确定要同步: " + name + " 站点？？", function (btn) {
             					if(btn == 'yes') {
									Ext.Ajax.request({
										url: contextPath + '/cms/syncSite.do',
										method : 'POST',
									  	params: {
									  		siteId : id,
									    },
									  	success: function (result) {
									  		alert(result.responseText);
										},
										failure: function (result) {
											alert(result.responseText);
										}
									});
	                      		}
                      		});
						},
						margin : '20 20 20 20',
						icon    : contextPath + '/resources/image/icons/sync.png',
						tooltip : '同步'
					} ]
				} ],
				/* dockedItems : [ {
					xtype : 'toolbar',
					dock : 'top',
					items : [ {
						text : '新建',
						icon:contextPath + '/resources/image/icons/edit_add.png',
						handler : addSite
					} ]
				} ], */
				bbar : new Ext.PagingToolbar({
					store : siteStore,
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
			            this.siteStore.load({params:o});
				   }
				})
			}, {
				title : 'Sync',
				id : 'syncGrid',
				xtype : 'grid',
				store : syncStore,
				flex : 1,
				margin : '0 0 0 5',
				columns : [ {
					text : 'id',
					dataIndex : 'id',
					width : 65
				}, {
					text : '网站版本',
					dataIndex : 'version',
					width : 75
				}, {
					text : 'CDN路径',
					dataIndex : 'cdnPath',
					width : 420
				}, {
					text : '同步标识',
					dataIndex : 'syncType',
					width : 80,
					renderer : function(value) {
						switch (value) {
						case '0':
							return '同步服务器';
						default:
							return '全部同步';
						}
					}
				}, {
					text : '增量包大小(单位:MB)',
					dataIndex : 'incrementSize',
					renderer : function(value) {
						if (value != null) {
							var size = value/1024/1024;
							return size.toFixed(3);
						}
						return '没有相关数据';
					},
					width : 150
				}, {
					text : '创建时间',
					dataIndex : 'dateline',
					renderer : function(value) {
						if (value != null) {
			 		    	return new Date(parseInt(value) * 1000).toLocaleString().substr(0,17);
						}
						return '无时间';
				 	},
				 	width : 150
				} ],
				viewConfig:{  
	                enableTextSelection:true  
	            },
				bbar : new Ext.PagingToolbar({
					store : syncStore,
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
			            this.syncStore.load({params:o});
				   }
				})
			} ],
			renderTo : Ext.getBody()
		});
		function addSite() {
			form = Ext.widget('form', {
	        	requires: [
					'Ext.grid.*',
					'Ext.form.*',
					'Ext.layout.container.Column'
       	       	],
       	       	border: true,
	            bodyPadding: 10,
	            fieldDefaults: {
	                labelAlign: 'top',
	                labelStyle: 'font-weight:bold'
	            },
	            items: [{
	            	xtype: 'fieldcontainer',
	                layout: 'hbox',
	                height : 50,
	                defaultType: 'textfield',
	                fieldDefaults: {
	                    labelAlign: 'top'
	                },
	                items: [ {
	                	flex: 0.5,
	                    name: 'id',
	                    fieldLabel: '站点ID',
	                    xtype : 'numberfield',
	                }, {
	                	flex: 0.5,
	                	name: 'code',
	                    fieldLabel: '站点缩写',
	                    xtype: 'textfield',
	                }, {
	                	flex: 0.5,
	                	name: 'name',
	                    fieldLabel: '站点名称',
	                    xtype: 'textfield',
	                } ]
	            }],
	            buttons: [ {
	                text: '取消',
	                handler: function() {
	                	this.up('form').getForm().reset();
	                	conWin.destroy();
	                }
	            }, {
	                text: '保存',
	                disabled: true,
                    formBind: true,
	                handler: function() {
	                	this.up('form').getForm().submit({
	                		clientValidation: true,
                    	    url: contextPath + '/cms/addsite.do',
                    	    success: function(form, action) {
                    	       Ext.Msg.alert('提示', '保存成功');
                    	       siteStore.load();
                    	       form.reset();
                    	       conWin.destroy();
                    	    },
                    	    failure: function(form, action) {
                    	        switch (action.failureType) {
                    	            case Ext.form.action.Action.CLIENT_INVALID:
                    	                Ext.Msg.alert('失败', '服务器异常1');
                    	                break;
                    	            case Ext.form.action.Action.CONNECT_FAILURE:
                    	                Ext.Msg.alert('失败', '服务器异常2');
                    	                break;
                    	            case Ext.form.action.Action.SERVER_INVALID:
                    	                Ext.Msg.alert('失败', '服务器异常3');
                    	       }
                    	    }
	                	});
	                }
	            } ]
			});
			var conWin = Ext.widget('window', {
	            title: '添加站点',
	            closeAction: 'destroy',
	            width: 600,
	            minWidth: 150,
	            minHeight: 150,
	            layout: 'fit',
	            resizable: true,
	            modal: true,
	            items: form
	        });
			conWin.show();
		}
		var siteGrid = panel.down('#siteGrid');
		siteGrid.getSelectionModel().on('selectionchange', function(selections) {
			syncStore.load()
		});
		var syncGrid = panel.down('#syncGrid');
		syncGrid.getSelectionModel().on('selectionchange', function() {
			var sync = syncGrid.getSelectionModel().getSelection();
			if(sync.length != 0) {
				var version = sync[0].data.version;
				Ext.getBody().mask("loading...","x-mask-loading");
			 	Ext.Ajax.request({
	                url: contextPath + '/device/count.do',
	                params: { version : version },
	                method: 'GET',
	                success: function (response, options) {
	                	Ext.getBody().unmask();
	                    Ext.MessageBox.alert('完成同步的设备数量', '版本号为: ' + version + '. 设备数量为: ' + response.responseText);
	                },
	                failure: function (response, options) {
	                	Ext.getBody().unmask();
	                    Ext.MessageBox.alert('错误！！！', '请求超时或网络故障,错误编号：' + response.status);
	                }
	            });
			}
		});
	});
</script>
</head>
<body>
</body>
</html>