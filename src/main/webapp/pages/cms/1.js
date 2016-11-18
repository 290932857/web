Ext.define('Luo.view.Center', {
	extend : 'Ext.tab.Panel',
	// layout:'fit',
	// 注意 加上widget.
	alias : 'widget.center',
	id : 'CenterTab',
	region : 'center',
	initComponent : function() {
		Ext.apply(this, {
			region : 'center',
			defaults : {
				autoScroll : true,
				bodyPadding : 5
			},
			activeTab : 0,
			border : false,
			items : [ {
				id : 'HomePage',
				title : '首页',
				layout : {
					type : 'hbox', // 水平方向
					pack : 'start', // 纵向对齐方式 start：从顶部；center：从中部；end：从底部
					align : 'stretch' // 对齐方式
				// center、left、right：居中、左对齐、右对齐；stretch：延伸；stretchmax：以最大的元素为标准延伸
				},
				items : [ {
					xtype : 'panel',
					flex : 5,
					border : 0,
					width : 604,
					layout : {
						align : 'stretch',
						type : 'vbox'
					},
					header : false,
					title : 'p1',
					items : [ userInfo, {
						xtype : 'panel',
						flex : 1,
						margin : '5 0 0 0 ',
						layout : {
							align : 'stretch',
							type : 'hbox'
						},
						header : false,
						border : 0,
						items : [ onlineUserList, registerUserList ]
					} ]
				} ]
			} ]
		});
		this.callParent(arguments);
	}
})

// 用户信息
var userInfo = Ext.create('Ext.form.Panel', {
	title : '用户信息',
	flex : 1,
	margin : '0 0 0 0 ',
	fieldDefaults : {
		labelWidth : 70,
		labelAlign : "right",
		flex : 1,
		margin : 5,
	},
	items : [ {
		xtype : "container",
		layout : "hbox",
		items : [ {
			xtype : "textfield",
			name : "name",
			fieldLabel : "姓名",
			readOnly : true,
			value : 'xxx'
		}, {
			xtype : "numberfield",
			name : "age",
			fieldLabel : "年龄",
			readOnly : true,
			value : '15'
		} ]
	}, {
		xtype : "container",
		layout : "hbox",
		items : [ {
			xtype : "textfield",
			name : "phone",
			fieldLabel : "电话",
			readOnly : true,
			value : '18600000000'
		}, {
			xtype : "textfield",
			name : "phone",
			fieldLabel : "邮箱",
			readOnly : true,
			value : '1234567@qq.com'
		} ]
	}, {
		xtype : "textareafield",
		name : "remark",
		fieldLabel : "备注",
		height : 50,
		value : '大神一样的男人',
		readOnly : true
	} ],
	renderTo : Ext.getBody()
})

// 在线设备列表
var onlineUserList = Ext.create('Ext.grid.Panel', {
	title : '在线设备',
	flex : 1,
	margin : '0 5 0 0 ',
	//store : onlineUserStore,
	tools : [ {
		type : 'refresh',
		handler : function(event, toolEl, panel) {
			// 实现逻辑
			onlineUserStore.load()
		}
	} ],
	columns : [ {
		header : '设备MAC',
		dataIndex : 'userName'
	}, {
		header : '设备编号',
		dataIndex : 'loginId',
		flex : 1
	}, {
		header : '时长',
		dataIndex : 'age'
	} ],
	renderTo : Ext.getBody()
})

// 注册设备列表
var registerUserList = Ext.create('Ext.grid.Panel', {
	title : '注册设备',
	flex : 1,
	margin : '0 0 0 0 ',
	//store : registerUserListStore,
	tools : [ {
		type : 'refresh',
		handler : function(event, toolEl, panel) {
			// 实现逻辑
			registerUserListStore.load()
		}
	} ],
	columns : [ {
		header : '设备MAC',
		dataIndex : 'userName'
	}, {
		header : '设备编号',
		dataIndex : 'loginId',
		flex : 1
	}, {
		header : '注册时间',
		dataIndex : 'age'
	} ],
	renderTo : Ext.getBody()
})
