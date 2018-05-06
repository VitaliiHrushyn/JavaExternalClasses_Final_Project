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
<title>content</title>
</head>
<body>
	<div>
		<br>
		<div>
			<jsp:include page="sidemenu.jsp"></jsp:include>
		</div>
		<br>						
		<c:set var="user" value="${sessionScope.user}"/>
		<h3><fmt:message key="text.editprofile.user" />: ${user.name} </h3>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/customer/profile/editprofile">
			
			<input type="hidden" name="userid" value="${user.id}">
			
			<fmt:message key="register.label.name" />: <input type="text" name="name" value="${user.name}">
			<br>
			<fmt:message key="register.label.surname" />: <input type="text" name="surname" value="${user.surname}">
			<br>
			<fmt:message key="register.label.login" />: <input type="text" name="login" value="${user.login}">
			<br>		
			<fmt:message key="register.label.email" />: <input type="text" name="email" value="${user.email}">
			<br>
			<fmt:message key="register.label.phone" />: <input type="text" name="phone" value="${user.phone}">
			<br>
			<input type="submit" value="<fmt:message key="text.button.savechanges" />">
		</form>	
		<br>
	</div>
</body>
</html>