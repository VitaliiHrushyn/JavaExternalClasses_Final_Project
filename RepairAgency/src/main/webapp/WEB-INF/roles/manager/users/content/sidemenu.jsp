<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer menu</title>
</head>
<body>
	<div align="center">
		<br>
		<br>
		<a href = "${pageContext.request.contextPath}/app/manager/users/create"><fmt:message key="text.menu.users.create" /></a>     	 
       	|
		<a href = "${pageContext.request.contextPath}/app/manager/users/show?role=customer"><fmt:message key="text.menu.users.customers" /></a>
		|       	
       	<a href = "${pageContext.request.contextPath}/app/manager/users/show?role=workman"><fmt:message key="text.menu.users.workmen" /></a>     	 
       	|       	
       	<a href = "${pageContext.request.contextPath}/app/manager/users/show?role=manager"><fmt:message key="text.menu.users.managers" /></a>     	 
       	<br>
	</div>
	
</body>
</html>