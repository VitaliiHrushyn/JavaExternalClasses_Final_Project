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
		<h3><fmt:message key="text.application.show" /> id: ${application.id} </h3>
		<br>
		
			<table style="width:60%">
			  <tr>
			    <th align="right"><fmt:message key="application.label.status" />:</th>
			    <td><fmt:message key="application.label.status.${application.status}" /></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.create_time" />:</th>
			    <td><customtag:datetimeview localDateTime="${application.createTime}" language="${sessionScope.language}" /></td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.description" />:</th>
			    <td width="300">${application.description}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.comment" />:</th>
			    <td>${application.managerComment}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.price" />:</th>
			    <td>${application.price}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.customer" />:</th>
			    <td>${application.customer.id} - ${application.customer.name} ${application.customer.surname}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.workman" />:</th>
			    <td>${application.workman.id} - ${application.workman.name} ${application.workman.surname}</td>
			  </tr>
			  <tr>
			    <th align="right"><fmt:message key="application.label.testimonial" />:</th>
			    <td><customtag:datetimeview localDateTime="${application.testimonial.createTime}" language="${sessionScope.language}" /> <br> ${application.testimonial.text}</td>
			  </tr>
			</table>
			
		<br>
	</div>
	</body>
</html>