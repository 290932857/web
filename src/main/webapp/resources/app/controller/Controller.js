Ext.define('Luo.controller.Controller',{//定义类  
        extend:'Ext.app.Controller',//一定要继承Controller  
        //添加views，让控制器找到  
        views:[  
            'Accordion',  
            'Center',  
            'Top',  
            'Bottom'  
        ],  
        //自动调用此方法  
        init:function(){  
            console.log('The panel was rendered');  
        }  
    }  
);