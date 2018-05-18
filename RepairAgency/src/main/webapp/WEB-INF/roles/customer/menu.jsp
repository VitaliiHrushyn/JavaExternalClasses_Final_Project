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
		<a href = "${pageContext.request.contextPath}/app/customer/profile"><fmt:message key="text.menu.profile" /></a> 
		|
		<a href = "${pageContext.request.contextPath}/app/customer/applications"><fmt:message key="text.menu.applications" /></a>
       	<br>  
       	<br>
	</div>
	
</body>
</html>