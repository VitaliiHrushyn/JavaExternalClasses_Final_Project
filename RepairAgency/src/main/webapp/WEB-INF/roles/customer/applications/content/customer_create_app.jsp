<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>content</title>
	</head>
	<body>
		<div>
			<br>
			<div>
				<jsp:include page="/WEB-INF/roles/${sessionScope.user.role.toString().toLowerCase()}/applications/sidemenu.jsp"></jsp:include>		
			</div>
			
	<br>
	<br>
	
		<form method ="post" action="${pageContext.request.contextPath}/app/customer/applications/create">
			
			<p><fmt:message key="form.application.description" />:</p>
		<textarea name="description"></textarea>	
			<br>
			<input type="submit" value="<fmt:message key="text.button.submit" />">
		</form>			
		</div>
	</body>
</html>