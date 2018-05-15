<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>${requestScope.user.role} page</title>
    </head>
    <body>
    
    	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
        
    	<jsp:include page="/WEB-INF/roles/manager/menu.jsp"></jsp:include>
    	
    	<jsp:include page="content/index.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>