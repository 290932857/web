Ext.Loader.setConfig({enabled:true});//必须加这句，否则会报错  
Ext.application({  
        //定义命名控件  
        name:'Luo',  
        //定义文件夹  
        appFolder:'resources/app',  
        //添加控制器  
        controllers:['Controller'],  
        //页面完全加载后将运行此方法  
        launch:function() {  
            Ext.create('Ext.container.Viewport', {  
                //布局方式  
                layout:'border',  
                items: [{  
                            xtype:'top'//这里可以写对应view的alias的属性  
                        },{  
                            xtype:'accordion'  
                        },{  
                            xtype:'center'  
                        },{  
                            xtype:'bottom'  
                        }  
                ]  
            });  
        }  
    }  
);

Ext.Ajax.on('requestcomplete', function(conn, response, options) {
	if (response.getResponseHeader("sessionstatus") == 'timeout') {
		Ext.MessageBox.alert("提示","登录超时，请重新登录！",function(btn){ 
			window.location = "login.jsp";
		}); 
	}
});
