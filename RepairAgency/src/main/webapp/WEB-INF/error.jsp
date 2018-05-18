<%@ include file="/WEB-INF/components/imports.jsp"%>

<%@ page language="java" isErrorPage="true"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error Page</title>
</head>
    <body>
        <h2>
           Error Page<br/>
            <i>Error <%= exception %></i> 
        </h2>
        <p>Unexpected error has occurred</p>
    	<br>
        <a href="${pageContext.request.contextPath}/app/logout">Return to main page</a>
		<br>
    </body>
</html>