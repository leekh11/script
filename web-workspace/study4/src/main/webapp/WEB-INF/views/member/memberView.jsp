<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>17/ memberView.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>회원 상세 정보</h3>
		<form action="memberRegist.wow" method="post">
			<c:if test="${empty member }">
				<p>회원조회에 실패했습니다</p>
			</c:if>
			<table class="table table-striped table-bordered">
				<tbody>
					<c:if test="${not empty member}">
						<tr>
							<th>아이디</th>
							<td>${member.memId}</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<%-- <%=list.getMemPass() %> + --%> ${member.memPass}
							</td>
						</tr>
						<tr>
							<th>회원명</th>
							<td>${member.memName}</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td>${member.memZip}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${member.memAdd1}-${member.memAdd2}</td>
						</tr>
						<tr>
							<th>생일</th>
							<td>${member.memBir}</td>
						</tr>
						<tr>
							<th>헨드폰</th>
							<td>${member.memHp}</td>
						</tr>
						<tr>
							<th>메일</th>
							<td>${member.memMail}</td>
						</tr>
						<tr>
							<th>직업</th>
							<td>${member.memJobNm}</td>
						</tr>
						<tr>
							<th>취미</th>
							<td>${member.memLikeNm}</td>
						</tr>
						<tr>
							<td colspan="2"><a href="memberList.wow"
								class="btn btn-default btn-sm"> <span
									class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
							</a> &nbsp; &nbsp; <a href="memberEdit.wow?memId=${member.memId}"
								class="btn btn-success btn-sm"> <span
									class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									수정
							</a></td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>