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
    
    	<jsp:include page="header.jsp"></jsp:include>
        
    	<jsp:include page="menu.jsp"></jsp:include>
    	
    	<jsp:include page="content.jsp"></jsp:include>
        
        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
</html>