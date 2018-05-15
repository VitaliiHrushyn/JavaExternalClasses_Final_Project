<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer menu</title>
</head>
<body>
	<div align="center">
		<br>
		<a href = "${pageContext.request.contextPath}/app/customer/applications/create"><fmt:message key="text.menu.create_new" /></a>
		|			
       	<a href = "${pageContext.request.contextPath}/app/customer/applications/received"><fmt:message key="text.menu.show.received" /></a>     	 
        |	
		<a href = "${pageContext.request.contextPath}/app/customer/applications/done"><fmt:message key="text.menu.show.done" /></a>     	 
       	|		
       	<a href = "${pageContext.request.contextPath}/app/customer/applications/active"><fmt:message key="text.menu.show.activ" /></a>     	 
       	|
       	<a href = "${pageContext.request.contextPath}/app/customer/applications/nonactive"><fmt:message key="text.menu.show.nonactive" /></a>     	 
       	<br>
	</div>
	
</body>
</html>