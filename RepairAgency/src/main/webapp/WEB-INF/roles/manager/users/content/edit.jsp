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
		<div align="center">
			<br>
			<div>
				<jsp:include page="sidemenu.jsp"></jsp:include>		
			</div>
		<br>						
		<c:set var="user" value="${requestScope.users}"/>
		<h3><fmt:message key="text.user.edit" /> id: ${user.id} </h3>
		<br>

		<form method="post" action="${pageContext.request.contextPath}/app/manager/users/edit">
            <input type="hidden" name="id" value="${user.id}">
            
            <input type="text" id="login" name="login" required value="${user.login}">
            <br>
            <input type="password" id="password" name="password" required placeholder="<fmt:message key="register.label.password" />">
            <br>
            <input type="password" id="confirmpassword" name="confirmpassword" required placeholder="<fmt:message key="register.label.confirmpassword" />">
            <br>
            <label for="role"><fmt:message key="register.label.role" />:</label>
            <select name="role">			               
				<option value ="MANAGER"> manager </option>
				<option value ="CUSTOMER"> customer </option>
				<option value ="WORKMAN"> workman </option>
			</select>
            <br>
            <input type="text" id="name" name="name" required value="${user.name}">
            <br>
            <input type="text" id="surname" name="surname" required value="${user.surname}" />">
            <br>
            <input type="email" id="email" name="email" required value="${user.email}">
            <br>
            <input type="text" id="phone" name="phone" required value="${user.phone}">
            <br>            
            <input type="submit" name="submit" value="<fmt:message key="text.button.submit"/>">
        </form>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/app/manager/users/delete">
            <input type="hidden" name="id" value="${user.id}">
			<input type="submit" name="submit" value="<fmt:message key="text.button.delete"/>">
		</form>
		<br>
	</div>
	</body>
</html>