Ext.define('Luo.view.Top', {
	extend : 'Ext.Component',
	alias : 'widget.top',
	padding : 10,
	html :  '<div style="position:relative;">'
		  + '<span style="font-size: xx-large; font-weight: 700; font-style: italic">管理后台</span>'
		/*  + '<div style="position:absolute;left: 15%;z-index: 99;top: 0;" id="menu">'
		  + '<ul id="webmenu" class="first-menu">'
		  + '	<li><a href="#">建立网站</a>'
		  + '		<ul style="display: none;" id="subMusic" class="second-menu">'
		  + '    		<li><a href="#" class="arrow">域名空间</a>'
		  + '     	 		<ul class="third-menu">'
		  + '        			<li><a href="#">fatcow</a></li>'
		  + '      			</ul>'
		  + '			</li>'	
		  + '  		</ul>'
		  + ' 	</li>'
		  + '</ul>'
		  + '</div>'  '+userName+'*/
		  + '<div style="position:absolute;right:0px; bottom:0px; font-weight: 70">欢迎<span></span>，'
		  + '<a href="javascript:void(0)" onclick="logout()">退出</a>'
		  + '</div>'
		  + '</div>',
	region : 'north',
	initComponent : function() {
		var sobj = document.createElement('script');   
	      sobj.type = "text/javascript";   
	      var headobj = document.getElementsByTagName('head')[0];   
	      headobj.appendChild(sobj); 
	}
});


/**
 * 退出
 */
function logout(){
	 Ext.MessageBox.confirm("标题", "你确定要退出？", function (btn) {
       	if(btn == 'yes') {
       		Ext.Ajax.request({
       		    url: 'user/logout.do',
       		    success: function(response){
       		    	var json = Ext.JSON.decode(response.responseText);
       		    	if(json.success == true) {
       		    		window.location.href = 'login.jsp'
       		    	} else {
       		    		Ext.Msg.alert("提示", json.message);
       		    	}
       		    }
       		});
       	}
       });
}