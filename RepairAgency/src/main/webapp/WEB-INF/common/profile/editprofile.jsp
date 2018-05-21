<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>${sessionScope.user.name} edit profile</title>
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
			<h3><fmt:message key="text.editprofile.user" />: ${user.name} </h3>
			<br>
			<form method ="post" action="${pageContext.request.contextPath}/app/${user.role.toString().toLowerCase()}/profile/editprofile">
						
				<fmt:message key="register.label.name" />: <input type="text" name="name" value="${user.name}">
				<br>
				<fmt:message key="register.label.surname" />: <input type="text" name="surname" value="${user.surname}">
				<br>
				<fmt:message key="register.label.login" />: <input type="text" name="login" value="${user.login}">
				<br>		
				<fmt:message key="register.label.email" />: <input type="text" name="email" value="${user.email}">
				<br>
				<fmt:message key="register.label.phone" />: <input type="text" name="phone" value="${user.phone}">
				<br>
				<input type="submit" value="<fmt:message key="text.button.savechanges" />">
				
			</form>	
			<br>
		</div>
        
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
        
    </body>
</html>