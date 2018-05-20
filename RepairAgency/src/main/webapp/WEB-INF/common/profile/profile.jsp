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
		 		
		<table style="width:60%">
			  <tr>
			    <th align="right"><fmt:message key="register.label.name" />:</th>
			    <td>${user.name}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.surname" />:</th>
			    <td>${user.surname}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.login" />:</th>
			    <td>${user.login}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.role" />:</th>
			    <td>${user.role}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.email" />:</th>
			    <td>${user.email}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.phone" />:</th>
			    <td>${user.phone}</td>
			  </tr>
			</table>
		
	</div>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>