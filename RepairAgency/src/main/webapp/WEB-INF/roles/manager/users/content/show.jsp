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
				
				<c:forEach var="user" items="${requestScope.users}">
					<form method ="post" action="${pageContext.request.contextPath}/app/manager/users/edit">
						<input type="hidden" name="userid" value="${user.id}">
						<p>
							ID: ${user.id} | <fmt:message key="user.label.role.${user.role}" /> | ${user.name} ${user.surname} 
							<input type="submit" value="<fmt:message key="text.button.show" />">
							<c:set var="role" value="${user.role.toString().toLowerCase()}"></c:set>
						</p>
					</form>
				</c:forEach>
				
			<br>
			<div><fmt:message key="text.pages" />:  
				<c:set var="page" value="1" />
				<c:set var="numberOfPages" value="${requestScope.number_of_pages}" />
				<c:forEach begin="1" end="${numberOfPages}" >		
					<a href = "${pageContext.request.contextPath}/app/manager/users/show?role=${role}&page_number=${page}">${page}</a>
					<c:set var="page" value="${page + 1 }"/>
				</c:forEach>
			</div>			
		</div>
	</body>
</html>