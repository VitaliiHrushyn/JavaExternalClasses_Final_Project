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
      <div align="center" style="background-color:#7F97A8; color:white">
        <form>
        	<fmt:message key="form.choose.language" />
	            <select id="language" name="language" onchange="submit()">
	                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
	                <option value="uk" ${language == 'uk' ? 'selected' : ''}>Українська</option>
	            </select>
        </form>
      </div>
        <div align="center">
        	<c:if test="${user.name != null}">
	        	<h2><fmt:message key="text.greatings" />, ${user.name}!</h2>
	        	<a href = "${pageContext.request.contextPath}/app/logout"><fmt:message key="text.menu.logout" /></a> 
        	</c:if>
        	<c:if test="${user.name == null}"> 
        		<h2><fmt:message key="text.greatings" />, <fmt:message key="text.guest.name" />! </h2>
        	</c:if>
        <br>
        	<span>
				<font color="red">
					<c:forEach var="message" items="${requestScope.error_messages}">
						${message}.
					</c:forEach>
				</font>
         	</span>
         	<span>
				<font color="green">
					<c:forEach var="message" items="${requestScope.info_messages}">
						${message}.
					</c:forEach>
				</font>
         	</span>  
        </div>
        <br>
    </body>
</html>