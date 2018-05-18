<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>Edit page</title>
    </head>
    <body>
    
    	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
        
    	<jsp:include page="/WEB-INF/roles/manager/menu.jsp"></jsp:include>
    	
    	<jsp:include page="content/edit.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>