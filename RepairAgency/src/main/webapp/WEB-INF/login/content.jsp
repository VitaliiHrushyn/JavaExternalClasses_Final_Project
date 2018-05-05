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
	<br>
	<div>
		<b><fmt:message key="text.login" /></b>
		<br>
		<br>
        <form method="post" action="${pageContext.request.contextPath}/app/login">
           
            <input type="text" id="login" name="login" required placeholder="<fmt:message key="login.label.login" />">  
            <input type="password" id="password" name="password" required placeholder="<fmt:message key="login.label.password" />">

            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
         
          <span>
			<font color="red">
				<c:forEach var="loginmessage" items="${loginmessages}">
					<fmt:message key="${loginmessage}"/>.
				</c:forEach>
			</font>
         </span>           
        </form>     	
	</div>
	<br>
</body>
</html>