<%@page import="com.study.free.vo.FreeBoardSearchVO"%>
<%@page import="com.study.code.vo.CodeVO"%>
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
<title>28/ testSumTag</title>
	<%@include file="/WEB-INF/inc/header.jsp" %>
</head>
<body>
	<%
		FreeBoardSearchVO vo = new FreeBoardSearchVO();
		vo.setCurPage(14);
		vo.setTotalRowCount(230);
		vo.setting();
		pageContext.setAttribute("searchVO", vo);
	%>
	<div class="container">
		<div class="page-header">
			<h2>Paging Custom Tag Test</h2>
			<nav class="text-center">
				<mytag:paging pagingVO="${searchVO}"/>
			</nav>
			<hr>
			<%
				vo.setCurPage(22);
				vo.setting();
			%>
			<nav class="text-center">
				<mytag:paging pagingVO="<%=vo %>" linkPage="freeList.jsp"/>
			</nav>
		</div>
	</div>
</body>
</html>