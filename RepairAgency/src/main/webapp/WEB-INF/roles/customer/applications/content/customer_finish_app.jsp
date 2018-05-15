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
				<jsp:include page="/WEB-INF/roles/${sessionScope.user.role.toString().toLowerCase()}/applications/sidemenu.jsp"></jsp:include>		
			</div>
		<br>						
		<c:set var="application" value="${requestScope.application}"/>
		<h3><fmt:message key="text.application.edit" /> id: ${application.id} </h3>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/customer/applications/edit">
			
			<input type="hidden" name="id" value="${application.id}">			
			<input type="hidden" name="status" value="FINISHED">
			<input type="hidden" name="testimonial_id" value="${application.testimonial.id}">
			<input type="hidden" name="last_update" value="${application.lastUpdateTime}">
			
			<fmt:message key="application.label.status" />: <fmt:message key="application.label.status.${application.status}" />
			<br>
			<fmt:message key="application.label.left_testimonial" />: 
			<br>
				<textarea name="testimonial_text">${application.testimonial.text}</textarea>
			<br>
			<fmt:message key="application.label.description" />: ${application.description}
			<br>
			<fmt:message key="application.label.comment" />: ${application.managerComment}
			<br>		
			<fmt:message key="application.label.price" />: ${application.price}
			<br>
			<fmt:message key="application.label.workman" />: ${application.workman.id} - ${application.workman.name} ${application.workman.surname}
			<br>
 			<fmt:message key="application.label.create_time" />: ${application.createTime}
			<br>
			<input type="submit" value="<fmt:message key="text.button.finishapp" />">
		</form>	
		<br>
	</div>
	</body>
</html>