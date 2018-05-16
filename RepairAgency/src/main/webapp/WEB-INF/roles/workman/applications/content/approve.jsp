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
		<form method ="post" action="${pageContext.request.contextPath}/app/workman/applications/edit">
			
			<c:set var="application" value="${application}" scope="session"/>
			
			<input type="hidden" name="status" value="EXECUTING">	
			
			<fmt:message key="application.label.status" />: <fmt:message key="application.label.status.${application.status}" />
			<br>
			<fmt:message key="application.label.create_time" />: ${application.createTime}
			<br>
			<fmt:message key="application.label.description" />: ${application.description}
			<br>
			<fmt:message key="application.label.comment" />: ${application.managerComment}
			<br>		
			<fmt:message key="application.label.price" />: ${application.price}
			<br>
			<fmt:message key="application.label.customer" />: id: ${application.customer.id} - ${application.customer.name} ${application.customer.surname}
			<br>
			<fmt:message key="application.label.current_workman" />: ${application.workman.id}
			<br>
	
			
			<input type="submit" value="<fmt:message key="text.button.executing" />">
		</form>	
		<br>
	</div>
	</body>
</html>