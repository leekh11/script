<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>첨부파일 테스트</h4>
	<form action="<c:url value='/upload/result'/>" method="post">
		제 목 : <input type="text" name="boTitle" /> <br> 
		작성자 : <input type="text" name="boWriter" /> <br> 
		첨부파일 : <input type="file" name="boFile" /> <br>
		<button type="submit">저장</button>
	</form>
</body>
</html>