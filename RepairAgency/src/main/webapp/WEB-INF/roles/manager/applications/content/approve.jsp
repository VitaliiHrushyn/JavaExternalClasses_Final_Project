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
		<c:set var="application" value="${requestScope.application}"/>
		<h3><fmt:message key="text.application.edit" /> id: ${application.id} </h3>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/manager/applications/approve">
			
			<c:set var="application" value="${application}" scope="session"/>
			
			<fmt:message key="application.label.status" />: <fmt:message key="application.label.status.${application.status}" />
			<br>
			<fmt:message key="application.label.status.change" />
			<input type="radio" name="status" value="REJECTED"> <fmt:message key="application.label.status.REJECT" /> 
  			<input type="radio" name="status" value="RECEIVED" checked> <fmt:message key="application.label.status.RECEIVE" /><br>			
			<br>
			<fmt:message key="application.label.create_time" />: <customtag:datetimeview localDateTime="${application.createTime}" language="${sessionScope.language}" />
			<br>
			<fmt:message key="application.label.description" />: ${application.description}
			<br>
			<fmt:message key="application.label.comment" />: <br>
			<textarea name="comment">${application.managerComment}</textarea>
			<br>		
			<fmt:message key="application.label.price" />: 
			<input type="number" min="0.00" max="10000.00" step="0.01" name="price" value="${application.price}">
			<br>
			<fmt:message key="application.label.customer" />: id: ${application.customer.id} - ${application.customer.login} : ${application.customer.name} ${application.customer.surname}
			<br>
			<fmt:message key="application.label.workman" />:
			<select name="workman_id" >
				<option value="${application.workman.id}" selected>${application.workman.id} - ${application.workman.name} ${application.workman.surname}</option>			               			
				
					<c:forEach var="workman" items="${requestScope.workmen}">
						
						<option value ="${workman.id}"> ${workman.id} - ${workman.name} ${workman.surname}  </option>
						
					</c:forEach>         	
         	</select>
			
			<br>
			<fmt:message key="application.label.testimonial" />: ${application.testimonial.text}
			<br>
			
			<input type="submit" value="<fmt:message key="text.button.savechanges" />">
		</form>	
		<br>
	</div>
	</body>
</html>