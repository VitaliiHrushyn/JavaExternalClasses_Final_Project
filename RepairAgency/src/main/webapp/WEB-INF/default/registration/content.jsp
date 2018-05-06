<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>default content</title>
</head>
<body>
	
	<div>
		
        <br>
        <b><fmt:message key="text.registration" /></b>
		<c:set var="regmessage" value="${requestScope.regmessages}"/>
		
		<p>|  
			<font color="red">
				<c:forEach var="regmessage" items="${regmessages}">
					<fmt:message key="${regmessage}"/>.
				</c:forEach>
			</font>
		</p>
        
        <form method="post" action="${pageContext.request.contextPath}/app/registration">
            
            <input type="text" id="reglogin" name="reglogin" required placeholder="<fmt:message key="register.label.login" />">
            <br>
            <input type="password" id="regpassword" name="regpassword" required placeholder="<fmt:message key="register.label.password" />">
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
            <input type="text" id="name" name="name" required placeholder="<fmt:message key="register.label.name" />">
            <br>
            <input type="text" id="surname" name="surname" required placeholder="<fmt:message key="register.label.surname" />">
            <br>
            <input type="text" id="email" name="email" required placeholder="<fmt:message key="register.label.email" />">
            <br>
            <input type="text" id="phone" name="phone" required placeholder="<fmt:message key="register.label.phone" />">
            <br>
            <fmt:message key="register.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        <br>		 	
	</div>
</body>
</html>