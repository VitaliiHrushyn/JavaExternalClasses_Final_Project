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
		<form method ="post" action="${pageContext.request.contextPath}/app/manager/applications/edit">
			
			<c:set var="application" value="${application}" scope="session"/>
						
			<table style="width:60%">
			  <tr>
			    <th align="right"><fmt:message key="application.label.create_time" />:</th>
			    <td><customtag:datetimeview localDateTime="${application.createTime}" language="${sessionScope.language}" /></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.status" />:</th>
			    <td><fmt:message key="application.label.status.${application.status}" /></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.status.change" /></th>
			    <td>
			    	<select name="status" >
						<option value="${application.status}" selected><fmt:message key="application.label.status.${application.status}" /></option>			               
						<option value ="NEW"> <fmt:message key="application.label.status.NEW" /> </option>
						<option value ="RECEIVED"> <fmt:message key="application.label.status.RECEIVED" /> </option>
						<option value ="REJECTED"> <fmt:message key="application.label.status.REJECTED" /> </option>
						<option value ="APPROVED"> <fmt:message key="application.label.status.APPROVED" /> </option>
						<option value ="EXECUTING"> <fmt:message key="application.label.status.EXECUTING" /> </option>
						<option value ="DONE"> <fmt:message key="application.label.status.DONE" /> </option>
						<option value ="FINISHED"> <fmt:message key="application.label.status.FINISHED" /> </option>
					</select>
			    </td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.description" />:</th>
			    <td width="300">${application.description}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.comment" />:</th>
			    <td><textarea name="comment">${application.managerComment}</textarea></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.price" />:</th>
			    <td><input type="number" min="0.00" max="10000.00" step="0.01" name="price" value="${application.price}"></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.customer" />:</th>
			    <td>id: ${application.customer.id} - ${application.customer.login} : ${application.customer.name} ${application.customer.surname}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.workman" />:</th>
			    <td>
			    	<select name="workman_id" >
						<option value="${application.workman.id}" selected>${application.workman.id} - ${application.workman.name} ${application.workman.surname}</option>			               			
						<c:forEach var="workman" items="${requestScope.workmen}">						
							<option value ="${workman.id}"> ${workman.id} - ${workman.name} ${workman.surname}  </option>						
						</c:forEach>         	
         			</select>
			    </td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.testimonial" />:</th>
			    <td>
			    	<customtag:datetimeview localDateTime="${application.testimonial.createTime}" language="${sessionScope.language}" />
			    	<br>
			    	${application.testimonial.text}
			    </td>
			  </tr>
			  <tr>
			    <th align="right"></th>
			    <td><input type="submit" value="<fmt:message key="text.button.savechanges" />"></td>
			  </tr>
			</table>			
			
		</form>
		<br>
	</div>
	</body>
</html>