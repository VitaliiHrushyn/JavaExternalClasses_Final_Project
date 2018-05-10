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
			
			
	<br>
	<br>
	
		<form method ="post" action="${pageContext.request.contextPath}/app/customer/testimonials/create">
		
			<p><fmt:message key="form.testimonial.text" />:</p>
		<textarea name="text"></textarea>	
			<br>
			<input type="submit" value="<fmt:message key="text.button.submit" />">
		</form>		
		</div>
	</body>
</html>