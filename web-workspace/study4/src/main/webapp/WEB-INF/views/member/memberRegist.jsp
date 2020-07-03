<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<meta charset="UTF-8">
<title>17/ memberInsert.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>회원가입</h3>
<%-- 		<jsp:useBean id="member" class="com.study.member.vo.memberVO"></jsp:useBean>
		<jsp:setProperty property="*" name="member" /> --%>

<%-- 		<%
			/* String id = request.getParameter("memId"); */
			IMemberService memberService = new MemberServiceImpl();
			/* memberVO list = memberService.getMember(id); */
			try {
				memberService.registMember(member);
		%>
		<div>
			<h3>회원가입 성공</h3>
		</div>
		<%
			} catch (BizDuplicateException e) {
		%> --%>
		<div>
			<h3>회원가입 실패</h3>
			<p>해당 아이디는 이미 사용 중입니다.</p>
			<a href="#" onclick=history.go(-1) class="btn btn-warning btn-sm"> <span
				class="glyphicon glyphicon-list" aria-hidden="true"></span> 뒤로가기
			</a>
		</div>
<%-- 		<%
			}
		%> --%>
		<a href="memberList.jsp" class="btn btn-default btn-sm"> <span
			class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
		</a>
	</div>
</body>
</html>