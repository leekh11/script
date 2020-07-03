<%@page import="com.study.member.vo.MemberVO"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@page import="com.study.member.service.IMemberService"%>
<%@page import="oracle.jdbc.OracleDriver"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>17/ memberDelete.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>회원정보 수정</h3>
		<jsp:useBean id="member" class="com.study.member.vo.MemberVO"></jsp:useBean>
		<jsp:setProperty property="*" name="member" />
			<%
				/* String id = request.getParameter("memId"); */
				IMemberService memberService = new MemberServiceImpl();
				/* memberVO list = memberService.getMember(id); */
				memberService.removeMember(member);
			%>
		<%
				out.println("성공");
			

	/* 		if (cnt > 0) {
			} else {
				out.println("실패");
			} */
		%>

		<a href="memberList.jsp" class="btn btn-default btn-sm"> <span
			class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
		</a>
	</div>
</body>
</html>