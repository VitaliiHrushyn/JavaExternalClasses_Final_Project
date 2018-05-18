<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>${requestScope.user.role} page</title>
    </head>
    <body>
    
    	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
        
    	<jsp:include page="/WEB-INF/roles/workman/menu.jsp"></jsp:include>
    	
    	<jsp:include page="content/index.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>