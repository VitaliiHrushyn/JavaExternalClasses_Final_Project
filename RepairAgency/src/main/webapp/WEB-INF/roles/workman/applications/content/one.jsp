<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
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
				<jsp:include page="sidemenu.jsp"></jsp:include>		
			</div>
		<br>						
		<c:set var="application" value="${requestScope.application}"/>
		<h3><fmt:message key="text.application.show" /> id: ${application.id} </h3>
		<br>
			
			
			
			<fmt:message key="application.label.status" />: <fmt:message key="application.label.status.${application.status}" />
			
			<br>
			<fmt:message key="application.label.description" />: ${application.description}
			<br>
			<fmt:message key="application.label.comment" />: ${application.managerComment}
			<br>		
			<fmt:message key="application.label.price" />: ${application.price}
			<br>
			<fmt:message key="application.label.customer" />: id ${application.customer.id} - ${application.customer.name} ${application.customer.surname}
			<br>
			<fmt:message key="application.label.workman" />: ${application.workman.name} ${application.workman.surname}
			<br>
			<fmt:message key="application.label.testimonial" />: ${application.testimonial.createTime} | ${application.testimonial.text}
			<br>
			<fmt:message key="application.label.create_time" />: ${application.createTime}
			<br>
		<br>
	</div>
	</body>
</html>