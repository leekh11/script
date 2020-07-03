<%@page import="com.study.exception.BizPasswordNotMatchedException"%>
<%@page import="com.study.exception.BizNotEffectedException"%>
<%@page import="com.study.exception.BizDuplicateException"%>
<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%> 
<div class="container">
		<h3>회원가입</h3>
		<jsp:useBean id="board" class="com.study.free.vo.FreeBoardVO"></jsp:useBean>
		<jsp:setProperty property="*" name="board" />

		<%
			IFreeBoardService boardService = new FreeBoardServiceImpl();
			try {
				boardService.removeBoard(board);
		%>
		<div>
			<h3>게시판 삭제 성공</h3>
		</div>
		<%
			} catch (BizNotEffectedException | BizPasswordNotMatchedException e) {
		%>
		<div>
			<h3>게시판 삭제 실패</h3>
			<p>오류 발생!.</p>
			<a href="#" onclick=history.go(-1) class="btn btn-warning btn-sm"> <span
				class="glyphicon glyphicon-list" aria-hidden="true"></span> 뒤로가기
			</a>
		</div>
		<%
			}
		%>
		<a href="freeList.jsp" class="btn btn-default btn-sm"> <span
			class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
		</a>
	</div>
</body> 
</html>