<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>${sessionScope.user.name} profile</title>
    </head>
    <body>
    
    	<jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
        
    	<jsp:include page="/WEB-INF/roles/${sessionScope.user.role.toString().toLowerCase()}/menu.jsp"></jsp:include>
    	    	
    	<div>
		<br>
		<div>
			<jsp:include page="sidemenu/sidemenu.jsp"></jsp:include>
		</div>
		<br>		
		<c:set var="user" value="${sessionScope.user}"/>
		<fmt:message key="register.label.name" />: ${user.name}
		<br>
		<fmt:message key="register.label.surname" />: ${user.surname}
		<br>
		<fmt:message key="register.label.login" />: ${user.login}
		<br>
		<fmt:message key="register.label.role" />: ${user.role}
		<br>		
		<fmt:message key="register.label.email" />: ${user.email}
		<br>
		<fmt:message key="register.label.phone" />: ${user.phone}
		<br>
	</div>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>