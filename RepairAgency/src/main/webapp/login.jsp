<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>Login page</title>
    </head>
    <body>
    
    	<jsp:include page="WEB-INF/page/header.jsp"></jsp:include>
        
    	<jsp:include page="WEB-INF/page/menu.jsp"></jsp:include>
    	
    	<jsp:include page="WEB-INF/page/content.jsp"></jsp:include>
    	
    	<h2><fmt:message key="text.login" /></h2>
    	
        <form method="post" action="${pageContext.request.contextPath}/app/login">
            <label for="username"><fmt:message key="login.label.username" />:</label>
            <input type="text" id="username" name="username">
            <br>
            <label for="password"><fmt:message key="login.label.password" />:</label>
            <input type="password" id="password" name="password">
            <br>
            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
        </form>
        
        <br>
        
        <jsp:include page="WEB-INF/page/footer.jsp"></jsp:include>
        
    </body>
</html>