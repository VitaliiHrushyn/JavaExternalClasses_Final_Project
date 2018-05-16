<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title></title>
	</head>
	<body>
		<div align="center">
		<br>
		<a href = "${pageContext.request.contextPath}/app/index"><fmt:message key="text.menu.home" /></a> | 
		<a href = "${pageContext.request.contextPath}/app/login"><fmt:message key="text.menu.login" /></a> |
       	<a href = "${pageContext.request.contextPath}/app/registration"><fmt:message key="text.menu.registration" /></a>
       	<br>
	</div>
	</body>
</html>