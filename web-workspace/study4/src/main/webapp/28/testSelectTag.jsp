<%-- <%@page import="com.study.code.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.study.code.service.CommonCodeServiceImpl"%>
<%@page import="com.study.code.service.ICommonCodeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>28/ testSelectTag</title>
</head>
<body>
	<%
		ICommonCodeService codeService = new CommonCodeServiceImpl();
		List<CodeVO> codeList = codeService.getCodeListByParent("BC00");
		request.setAttribute("catList", codeList);
	%>
	원본 :
	<select name="searchCategory"
		class="form-control input-sm">
		<option value="">-- 전체 --</option>
		<c:forEach items="${catList}" var="code">
			<option value="${code.commCd}"
				${searchVO.searchCategory eq code.commCd ? 'selected="selected"' : '' }>
				${code.commNm}</option>
		</c:forEach>
	</select>
	<hr>
	tag 1 : 
	<mytag:select  id="id_searchCategory" name="searchCategory" class="form-control input-sm"/>
		
	 tag2 :
		<mytag:select name="searchCategory"  id= "id_searchCategory"  class="form-control input-sm"  
		items ="${catList}"  itemValue="commCd"  itemLabel="commNm"  value="${SearchVO.searchCategory }"/>
		
</body>
</html> --%>