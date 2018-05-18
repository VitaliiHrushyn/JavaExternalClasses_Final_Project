<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>${requestScope.user.role} page</title>
    </head>
    <body>
    
    	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
        
    	<jsp:include page="/WEB-INF/roles/${sessionScope.user.role.toString().toLowerCase()}/menu.jsp"></jsp:include>
    	
    	<jsp:include page="content/show_to_approve.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>