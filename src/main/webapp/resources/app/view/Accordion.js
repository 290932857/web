Ext.define('Luo.view.Accordion', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.accordion',
	id : 'Accordion',
	// 是否可以折叠
	collapsible : true,
	// 是否可以通过拖动改变宽度
	split : true,
	title : '管理后台',
	width : 250,
	// 布局方式
	layout : 'accordion',
	region : 'west',
	layoutConfig : {
		titleCollapse : true, // 设置为点击整个标题栏都可以收缩
		animate : true, // 开启默认动画效果
		activeOnTop : true
	// 展开的面板总是在最顶层
	},
	items : initMenu()
});

/**
 * 顶级菜单循环拼接
 * 
 * @returns {String}
 */
function initMenu() {
	var menu = "";
	Ext.Ajax.request({
		url : "index.do",
		method : 'POST',
		async : false,
		success : function(response) {
			var jsonArr = Ext.JSON.decode(response.responseText);
			menu += "[";
			// 顶级菜单
			for (var i = 0; i < jsonArr.length; i++) {
				var json = jsonArr[i];
				menu += "{";
				menu += "title : '" + json.name + "',";
				menu += "xtype : 'treepanel',";
				menu += "expanded : true,";
				menu += "animate : true,";
				menu += "enable : false,";
				menu += "border : false,";
				menu += "rootVisible: false,";
				menu += "containerScroll : true,";
				menu += "root : {";
				// menu += "id : 'root',";
				menu += "expanded : true,";
				menu += "children : [";
				if (json.children != 'undefined'
						&& json.children.length > 0) {
					menu += initChildMenu(json.children);
				}
				menu += "]";
				menu += "}, ";
				menu += "listeners : {"
						+ "itemclick : function(v, r, item) {"
						+ "var tab = Ext.getCmp(\"CenterTab\");"
						+ "var n = tab.getComponent(r.raw.id);"
						+ "if (r.raw.id == 'root') {return;} "
						+ "if (r.raw.id == undefined) {return;} "
						+ "if (!n) {"
						+ "	n = tab.add({'id' : r.raw.id,  'title' : r.raw.text, closable : true, "
						+ "	html : '<iframe scrolling=\"auto\" frameborder=\"0\" width=\"100%\" height=\"100%\" src=\"'+r.raw.value+'\"></iframe>'"
						+ "	});} tab.setActiveTab(n);}" + "}";
				menu += "}";
				if (i != jsonArr.length - 1) {
					menu += ",";
				}
			}
			menu += "]";
		}
	});
	menu = Ext.JSON.decode(menu);
	return menu;
}
/**
 * 子菜单递归循环拼接
 */
function initChildMenu(childJson) {
	var childMenu = "";
	for (var i = 0; i < childJson.length; i++) {
		var json = childJson[i];
		childMenu += "{";
		childMenu += "text : '" + json.name + "',";
		if (json.children != 'undefined' && json.children.length > 0) {
			childMenu += "leaf : false,";
			childMenu += "children : ["
			childMenu += initChildMenu(json.children);
			childMenu += "]"
		} else {
			childMenu += "leaf : true,";
			childMenu += "value : '" + json.path + "'";
		}
		childMenu += "}";
		if (i != childJson.length - 1) {
			childMenu += ",";
		}
	}
	return childMenu;
}
