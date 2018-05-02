<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale/messages"/>
<!DOCTYPE html>
<html lang="${language}">
    <head>
        <title>header</title>
    </head>
    <body>
        
        <form>
        	<fieldset>
	        	<legend><fmt:message key="form.choose.language" /></legend>
	            <select id="language" name="language" onchange="submit()">
	                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
	                <option value="uk" ${language == 'uk' ? 'selected' : ''}>Українська</option>
	            </select>
            </fieldset>
        </form>
        <div>
        	<h2>
        		<fmt:message key="text.greatings" />, 
        		<c:if test="${user.name != null}"> ${user.name}! </c:if>
        		<c:if test="${user.name == null}"> <fmt:message key="text.guest.name" />! </c:if>
        	</h2>
        </div>
    </body>
</html>