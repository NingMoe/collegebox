<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>College Box</title>
<c:choose>
	<c:when test="${param.login_error == '1'}">
		<script type="text/javascript">
		alert("${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}");
		</script>
	</c:when>
	<c:when test="${param.login_error == '2'}">
		<script type="text/javascript">
		alert("会话超时，请重新登录");
		</script>
	</c:when>
</c:choose>
</head>
<body>
<div class="loginForm">
	<form name='f' action='login' method='post'>
		<p>
			<label>用户名：</label><input type="text" name="username" size="20" class="login_input" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" />
		</p>
		<p>
			<label>密　码：</label><input type="password" name="password" size="20" class="login_input" />
		</p>
		<p>
			<label style="width:56px;">验证码：</label>
			<input class="code"  type="text" name="j_captcha" size="5" />
			<span><img src="getCode" alt="点击重新获取验证码" width="75" height="23" style="vertical-align:middle;" /></span>
		</p>
		<div class="login_bar">
			<input class="sub" type="submit" value="submit"/>
		</div>
	</form>
</div>
</body>
</html>