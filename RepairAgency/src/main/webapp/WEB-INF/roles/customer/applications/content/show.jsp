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
	
				<c:forEach var="application" items="${requestScope.applications}">
					<form method ="post" action="${pageContext.request.contextPath}/app/customer/applications/one">
						<input type="hidden" name="id" value="${application.id}">
						<p>
							<fmt:message key="application.label.status.${application.status}" /> | ${application.description} | ${application.createTime}
							<input type="submit" value="<fmt:message key="text.button.show" />">
						</p>
					</form>
				</c:forEach>
				
			<br>		
		</div>
	</body>
</html>