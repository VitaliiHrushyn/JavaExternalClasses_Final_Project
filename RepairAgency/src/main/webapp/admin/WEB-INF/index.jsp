<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>Index page</title>
    </head>
    <body>
    
    	<jsp:include page="role/header.jsp"></jsp:include>
        
    	<jsp:include page="role/menu.jsp"></jsp:include>
    	
    	<jsp:include page="role/content.jsp"></jsp:include>
        
        <h2><fmt:message key="text.greatings" /></h2>
        
        <jsp:include page="role/footer.jsp"></jsp:include>
        
    </body>
</html>