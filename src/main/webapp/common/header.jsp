<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/ext/classic/theme-neptune/resources/theme-neptune-all.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ext/ext-bootstrap.js"></script>
<script type="text/javascript">
	//初始化ContextPath对象
	var contextPath = '';
	Ext.onReady(function() {
		contextPath = '${pageContext.request.contextPath}';
	});
	Ext.Ajax.on('requestcomplete', function(conn, response, options) {
		try {
			if (response != 'undefined' && response.getResponseHeader("sessionstatus") != 'undefined' && response.getResponseHeader("sessionstatus") == 'timeout') {
				Ext.MessageBox.alert("提示", "登录超时，请重新登录！", function(btn) {
					window.top.location = contextPath + "/login.jsp";
				});
			}
		} catch (err) {
			console.log(response);
		}
	});
</script>
