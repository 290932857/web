<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<title>登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style/css/login.css" />
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="login">
<meta http-equiv="description" content="login">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-easyui-1.4/jquery.min.js"></script>
<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
	function login() {
		var username = $("#username").val();
		var password = $("#password").val();
		var code = $("#kaptcha").val();
		if (username == '') {
			alert("用户名不能为空");
			return;
		}
		if (password == '') {
			alert("密码不能为空");
			return;
		}
		var user = {
			"loginId" : username,
			"password" : password,
		};
		$.post(contextPath + "/user/login.do", user, function(data) {
			if (data.success == false) {
				alert(data.message);
			} else {
				location.href = "index.jsp";
			}
		}, "json");
	}
</script>
<body>
	<div class="warp_login">
		<div class="login">
			<div class="login_logo">
				<img
					src="${pageContext.request.contextPath}/resources/style/images/ltop.jpg">
			</div>
			<div class="login_con">
				<div class="login_peo">
					<i class="login_peo_i"></i><input id="username" type="text"
						value="" placeholder="请输入用户名">
					<div class="clear"></div>
				</div>
				<div class="login_peo">
					<i class="login_key_i"></i><input id="password" type="password"
						value="" placeholder="请输入密码">
					<div class="clear"></div>
				</div>
				<input type="button" value="登录" class="login_deng"
					onclick="return login()">
			</div>
		</div>
	</div>
</body>
</html>
