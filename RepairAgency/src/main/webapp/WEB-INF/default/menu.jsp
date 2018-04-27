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
		menu:
		<br>
		<b><fmt:message key="text.login" /></b>
		<c:set var="loginmessage" value="${requestScope.loginmessage}"/>
		<p>! <font color="red">${loginmessage}</font></p>
        <form method="post" action="${pageContext.request.contextPath}/app/login">
            <label for="username"><fmt:message key="login.label.login" />:</label>
            <input type="text" id="username" name="username">
            
            <label for="password"><fmt:message key="login.label.password" />:</label>
            <input type="password" id="password" name="password">
           
            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        
        
        
        <b><fmt:message key="text.registration" /></b>
		<c:set var="regmessage" value="${requestScope.regmessage}"/>
		<p> !<font color="red">${regmessage}</font></p>
        <form method="post" action="${pageContext.request.contextPath}/app/registration">
            <label for="username"><fmt:message key="login.label.login" />:</label>
            <input type="text" id="regusername" name="regusername">
           
            <label for="password"><fmt:message key="login.label.password" />:</label>
            <input type="password" id="regpassword" name="regpassword">
            
            <label for="confirmpassword"><fmt:message key="login.label.confirmpassword" />:</label>
            <input type="password" id="confirmpassword" name="confirmpassword">
           
            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        <br>
	</div>
	
</body>
</html>