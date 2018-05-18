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
       	<a href = "${pageContext.request.contextPath}/app/manager/applications/new"><fmt:message key="text.menu.show.new" /></a>     	 
       	|
       	<a href = "${pageContext.request.contextPath}/app/manager/applications/active"><fmt:message key="text.menu.show.activ" /></a>     	 
       	|
       	<a href = "${pageContext.request.contextPath}/app/manager/applications/nonactive"><fmt:message key="text.menu.show.nonactive" /></a>     	 
       	|
       	<a href = "${pageContext.request.contextPath}/app/manager/applications/all"><fmt:message key="text.menu.show.all" /></a>
		|
       	<form method="post" action="${pageContext.request.contextPath}/app/manager/applications/findbyid">
       	<fmt:message key="text.menu.find_by_id" />
       	<input type="number" name="id">
       	<input type="submit" value ="<fmt:message key="text.button.search" />">
       	</form>
       	<br>
	</div>
	
</body>
</html>