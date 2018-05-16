<%@ include file="/WEB-INF/components/imports.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>default content</title>
</head>
<body>
	<br>
	<div align="center">
		<b><fmt:message key="text.login" /></b>
		<br>
		<br>
        <form method="post" action="${pageContext.request.contextPath}/app/login">
           
            <input type="text" id="login" name="login" required placeholder="<fmt:message key="login.label.login" />">  
            <input type="password" id="password" name="password" required placeholder="<fmt:message key="login.label.password" />">

            <fmt:message key="login.button.submit" var="buttonValue" />
            <input type="submit" name="submit" value="${buttonValue}">
           
        </form>     	
	</div>
	<br>
</body>
</html>