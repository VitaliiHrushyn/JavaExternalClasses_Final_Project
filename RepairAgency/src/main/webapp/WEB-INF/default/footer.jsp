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
<title>Insert title here</title>
</head>
<body>
	<div>
		footer:
		<br>
		<a href = "${pageContext.request.contextPath}/app/exception">Exception</a>
		<br>
       	<a href = "${pageContext.request.contextPath}/app/message">Message</a>
       	<br>
      	<a href = "${pageContext.request.contextPath}/login.jsp">Login page</a>
      	<br>
      	<a href = "${pageContext.request.contextPath}/registration.jsp">Registration page</a>
	</div>
	
</body>
</html>