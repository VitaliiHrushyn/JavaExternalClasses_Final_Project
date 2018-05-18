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
	
				<c:forEach var="application" items="${requestScope.applications}">
					<form method ="post" action="${pageContext.request.contextPath}/app/${user.role.toString().toLowerCase()}/applications/approve">
						<input type="hidden" name="id" value="${application.id}">
						<p>
							ID: ${application.id} | <fmt:message key="application.label.status.${application.status}" /> | ${application.description} | ${application.createTime}
							<input type="submit" value="<fmt:message key="text.button.show" />">
						</p>
					</form>
				</c:forEach>				
			<br>
			<div><fmt:message key="text.pages" />: 
				<c:set var="page" value="1" />
				<c:set var="numberOfPages" value="${requestScope.number_of_pages}" />
				<c:forEach begin="1" end="${numberOfPages}" >		
					<a href = "${requestScope.pagination_link}${page}">${page}</a>
					<c:set var="page" value="${page + 1 }"/>
				</c:forEach>
			</div>			
		</div>
	</body>
</html>