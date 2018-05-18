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
	
				<table>
		 			<thead>
						<tr bgcolor="lightgray">
							<th>ID</th>
							<th><fmt:message key="application.label.status" /></th>
							<th><fmt:message key="application.label.description" /></th>
							<th><fmt:message key="application.label.create_time" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="application" items="${requestScope.applications}">								
									<tr >
										<td>${application.id}</td>
										<td width="100" align="center"><fmt:message key="application.label.status.${application.status}" /></td>
										<td width="400">${application.description}</td>
										<td width="200" align="center"><customtag:datetimeview localDateTime="${application.createTime}" language="${sessionScope.language}" /></td>
										<td>
											<form method ="post" action="${pageContext.request.contextPath}/app/${user.role.toString().toLowerCase()}/applications/approve">
												<input type="hidden" name="id" value="${application.id}">
												<input type="submit" value="<fmt:message key="text.button.show" />"> 
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
					<a href = "${requestScope.pagination_link}${page}">${page}</a>
					<c:set var="page" value="${page + 1 }"/>
				</c:forEach>
			</div>			
		</div>
	</body>
</html>