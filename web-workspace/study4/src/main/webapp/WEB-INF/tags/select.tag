<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ tag dynamic-attributes="attributeMap"%>
<%@ attribute name="name" required="true" %>
<%@ attribute name="items" required="true" type="java.util.Collection" %>
<%@ attribute name="itemValue" %>
<%@ attribute name="itemLabel" %>
<%@ attribute name="value" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select name="${name}"
	<c:forEach items="${attributeMap}" var="attr">
		${attr.key} = "${attr.value }"
	</c:forEach>
	>
	<c:forEach items="${items}" var="code">
		<option value="${code[itemValue]}"  ${code[itemValue] eq value ? 'selected' : ''} > ${code[itemLabel]}
	</c:forEach>
</select>

