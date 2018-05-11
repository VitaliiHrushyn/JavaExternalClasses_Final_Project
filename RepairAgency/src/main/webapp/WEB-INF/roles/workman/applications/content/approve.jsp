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
		<h3><fmt:message key="text.application.edit" /> id: ${application.id} </h3>
		<br>
		<form method ="post" action="${pageContext.request.contextPath}/app/workman/applications/edit">
			
			<input type="hidden" name="id" value="${application.id}">
			
			<fmt:message key="application.label.status" />: <fmt:message key="application.label.status.${application.status}" />
			<br>
			<fmt:message key="application.label.status.change" />
			<input type="radio" name="status" value="REJECTED"> <fmt:message key="application.label.status.REJECT" /> 
  			<input type="radio" name="status" value="RECEIVED"> <fmt:message key="application.label.status.RECEIVE" /><br>			
			<br>
			<fmt:message key="application.label.create_time" />: ${application.createTime}
			<br>
			<fmt:message key="application.label.description" />: ${application.description}
			<br>
			<fmt:message key="application.label.comment" />: <input type="text" name="comment" value="${application.managerComment}">
			<br>		
			<fmt:message key="application.label.price" />: <input type="text" name="price" value="${application.price}">
			<br>
			<fmt:message key="application.label.customer" />: id: ${application.customer.id} - ${application.customer.name} ${application.customer.surname}
			<br>
			<fmt:message key="application.label.current_workman" />: ${application.workman}
			<br>
			<fmt:message key="application.label.change_workman" />:
			<select name="workman" >
				<option value="${application.workman}" selected>${workman.name} ${workman.surname}</option>			               			
				
					<c:forEach var="workman" items="${requestScope.workmen}">
						
						<option value ="${workman.id}"> <fmt:message key="${workman.name} ${workman.surname}" /> </option>
						
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