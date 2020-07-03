<%@page import="com.study.code.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.study.code.service.CommonCodeServiceImpl"%>
<%@page import="com.study.code.service.ICommonCodeService"%>
<%@page import="com.study.free.service.FreeBoardServiceImpl"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@page import="com.study.free.service.IFreeBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>게시판 삭제</h3>
		<form action="freeDel.jsp" method="post">
			<%
				String boNum = request.getParameter("boNum");
				IFreeBoardService boardService = new FreeBoardServiceImpl();
				FreeBoardVO listVo = boardService.getBoard(Integer.parseInt(boNum));
				request.setAttribute("board", listVo);
			%>
			<c:if test="${empty board}">
				<p>게시판조회에 실패했습니다</p>
			</c:if>
			<c:if test="${not empty board}">
				<input type="hidden" name="boNum" value="${board.boNum}">
				<table class="table table-striped table-bordered ">
					<colgroup>
						<col width="20%" />
						<col />
					</colgroup>
					<tr>
						<th>제목</th>
						<td><input type="text" name="boTitle"
							value="${board.boTitle}" class="form-control"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="boWriter"
							value="${board.boWriter}" class="form-control"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="boPass" value=""
							class="form-control" title="4글자 이상 입력"> <span>수정
								또는 삭제시에 필요합니다.</span></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="pull-left">
								<a href="freeList.jsp" class="btn btn-sm btn-default">목록으로</a>
							</div>
							<div class="pull-right">
								<button type="submit" class="btn btn-warning btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									삭제하기
								</button>
							</div>
						</td>
					</tr>
				</table>
			</c:if>
		</form>
	</div>
</body>
</html>