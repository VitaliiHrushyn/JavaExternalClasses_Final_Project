<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>content</title>
	</head>
	<body>
		<div align="center">
			<br>
			<div>
				<jsp:include page="sidemenu.jsp"></jsp:include>		
			</div>
		<br>						
		<c:set var="user" value="${requestScope.edited_user}"/>
		<h3><fmt:message key="text.user.edit" /> id: ${user.id} </h3>
		<br>

		<form method="post" action="${pageContext.request.contextPath}/app/manager/users/edit">
            <input type="hidden" name="userid" value="${user.id}">
            
            <fmt:message key="register.label.login" />: <input type="text" id="login" name="login" required value="${user.login}">
            <br>
            <input type="password" id="password" name="password" placeholder="<fmt:message key="register.label.password" />">
            <br>
            <input type="password" id="confirmpassword" name="confirmpassword" placeholder="<fmt:message key="register.label.confirmpassword" />">
            <br>
            <label for="role"><fmt:message key="register.label.role" />:</label>
            <select name="role">
            	<option value="${user.role}" selected><fmt:message key="user.label.role.${user.role}" /></option>			               
				<option value ="MANAGER"> <fmt:message key="user.label.role.MANAGER" /> </option>
				<option value ="CUSTOMER"> <fmt:message key="user.label.role.CUSTOMER" /> </option>
				<option value ="WORKMAN"> <fmt:message key="user.label.role.WORKMAN" /> </option>
			</select>
            <br>
            <fmt:message key="register.label.name" />: <input type="text" id="name" name="name" required value="${user.name}">
            <br>
            <fmt:message key="register.label.surname" />: <input type="text" id="surname" name="surname" required value="${user.surname}" />
            <br>
            <fmt:message key="register.label.email" />: <input type="email" id="email" name="email" required value="${user.email}">
            <br>
            <fmt:message key="register.label.phone" />: <input type="text" id="phone" name="phone" required value="${user.phone}">
            <br>            
            <input type="submit" name="submit" value="<fmt:message key="text.button.edit"/>">
        </form>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/app/manager/users/delete">
            <input type="hidden" name="deleting_userid" value="${user.id}">
			<input type="submit" style="color:red" name="submit" value="<fmt:message key="text.button.delete"/>">
		</form>
		<br>
	</div>
	</body>
</html>