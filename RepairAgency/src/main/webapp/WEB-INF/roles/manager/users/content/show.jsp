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
				
				<table>
		 			<thead>
						<tr bgcolor="lightgray">
							<th>ID</th>
							<th><fmt:message key="register.label.role" /></th>
							<th><fmt:message key="register.label.name" /></th>
							<th><fmt:message key="register.label.surname" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${requestScope.users}">								
									<tr>
										<td>${user.id}</td>
										<td width="100" align="center"><fmt:message key="user.label.role.${user.role}" /></td>
										<td width="400">${user.name}</td>
										<td width="200" align="center">${user.surname}</td>
										<td>
											<form method ="post" action="${pageContext.request.contextPath}/app/manager/users/edit">
												<input type="hidden" name="userid" value="${user.id}">
													<input type="submit" value="<fmt:message key="text.button.show" />">
													<c:set var="role" value="${user.role.toString().toLowerCase()}"></c:set>
											</form>
										</td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				
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