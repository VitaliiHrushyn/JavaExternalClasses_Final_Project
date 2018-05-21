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
                  
       		<table style="width:60%">
			  <tr>
			    <th align="right"><fmt:message key="register.label.login" />:</th>
			    <td><input type="text" id="login" name="login" required value="${user.login}"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.password" />:</th>
			    <td><input type="password" id="password" name="password" placeholder="<fmt:message key="register.label.password" />"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.confirmpassword" />:</th>
			    <td><input type="password" id="confirmpassword" name="confirmpassword" placeholder="<fmt:message key="register.label.confirmpassword" />"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.role" />:</th>
			    <td>
			    	<select name="role">
		            	<option value="${user.role}" selected><fmt:message key="user.label.role.${user.role}" /></option>			               
						<option value ="MANAGER"> <fmt:message key="user.label.role.MANAGER" /> </option>
						<option value ="CUSTOMER"> <fmt:message key="user.label.role.CUSTOMER" /> </option>
						<option value ="WORKMAN"> <fmt:message key="user.label.role.WORKMAN" /> </option>
					</select>
				</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.name" />:</th>
			    <td><input type="text" id="name" name="name" required value="${user.name}"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.surname" />:</th>
			    <td><input type="text" id="surname" name="surname" required value="${user.surname}" /></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.email" />:</th>
			    <td><input type="email" id="email" name="email" required value="${user.email}"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="register.label.phone" />:</th>
			    <td><input type="text" id="phone" name="phone" required value="${user.phone}"></td>
			  </tr>
			  <tr>
			    <th align="right"></th>
			    <td><input type="submit" name="submit" value="<fmt:message key="text.button.edit"/>"></td>
			  </tr>
			</table>       
       
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