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
		<b><fmt:message key="text.login" /></b>
		
        <form method="post" action="${pageContext.request.contextPath}/app/login">
            <label for="login"><fmt:message key="login.label.login" />:</label>
            <input type="text" id="login" name="login">
           
            <label for="password"><fmt:message key="login.label.password" />:</label>
            <input type="password" id="password" name="password">
           
            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
         
          <span>
          	<font color="red">
            	<c:set var="loginmessage" value="${requestScope.loginmessage}"/>
				<c:if test = "${loginmessage != null}" >
					<fmt:message key="${loginmessage}"/>
				</c:if>		
         	</font>
         </span>           
        </form>    
		
        <br>
        <hr>
        <hr>
        <br>
        <b><fmt:message key="text.registration" /></b>
		<c:set var="regmessage" value="${requestScope.regmessages}"/>
		
		<p>... 
			<font color="red">
				<c:forEach var="regmessage" items="${regmessages}">
					<c:if test = "${regmessage != null}" >
						<fmt:message key="${regmessage}"/>
					</c:if>
				</c:forEach>
			</font>
		</p>
        
        <form method="post" action="${pageContext.request.contextPath}/app/registration">
            
            <label for="reglogin"><fmt:message key="register.label.login" />:</label>
            <input type="text" id="reglogin" name="reglogin">
            <br>
            <label for="password"><fmt:message key="register.label.password" />:</label>
            <input type="password" id="regpassword" name="regpassword">
            <br>
            <label for="confirmpassword"><fmt:message key="register.label.confirmpassword" />:</label>
            <input type="password" id="confirmpassword" name="confirmpassword">
            <br>
            <label for="role"><fmt:message key="register.label.role" />:</label>
            <select name="role">			               
				<option value ="MANAGER"> manager </option>
				<option value ="CUSTOMER"> customer </option>
				<option value ="WORKMAN"> workman </option>
			</select>
            <br>
            <label for="name"><fmt:message key="register.label.name" />:</label>
            <input type="text" id="name" name="name">
            <br>
            <label for="surname"><fmt:message key="register.label.surname" />:</label>
            <input type="text" id="surname" name="surname">
            <br>
            <label for="email"><fmt:message key="register.label.email" />:</label>
            <input type="text" id="email" name="email">
            <br>
            <label for="phone"><fmt:message key="register.label.phone" />:</label>
            <input type="text" id="phone" name="phone">
            <br>
            <fmt:message key="register.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        <br>		 	
	</div>
</body>
</html>