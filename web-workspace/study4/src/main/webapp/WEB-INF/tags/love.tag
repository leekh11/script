<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="count" type="java.lang.Integer" required="true"   %>
<%@ attribute name="value" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	/* JspWriter jspOut =jspContext.get */
	if(StringUtils.isBlank(value)){
		value = "사랑해요 밀키스";
	}
	for(int i =1; i <=count; i++){
		out.write(value + "<br>");	
	}
--%>
<c:if test="${empty value}">
<jsp:doBody var="value" />
</c:if>

<c:forEach begin="1" end="${count }">
	${value} -- <br>
</c:forEach>