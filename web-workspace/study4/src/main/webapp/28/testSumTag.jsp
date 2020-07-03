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
</head>
<body>
	<mytag:sum var="hi" end="10" begin="1">
		결과는 ${hi}, s=${sum } <br>
	</mytag:sum>
	
	\${hi} = ${hi }
		
</body>
</html>