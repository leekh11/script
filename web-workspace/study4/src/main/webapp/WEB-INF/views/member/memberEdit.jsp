<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>10/ memberForm.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>회원정보 수정</h3>

		<form:form modelAttribute="member" action="memberModify.wow" >
			<input type="hidden" name="memId" value="${member.memId}">
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${member.memId}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><form:password path="memPass"
							class="form-control input-sm"/>
							<form:errors path="memPass"/>
						</td>
					</tr>
					<tr>
						<th>회원명</th>
						<td><form:input path="memName"
							class="form-control input-sm" value="${member.memName}" />
							<form:errors path="memName"/>
						</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>
							<form:input path="memZip"
							class="form-control input-sm" placeholder="우편번호"
							value="${member.memZip}"/>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<form:input path="memAdd1"
							class="form-control input-sm" placeholder="기본 주소"
							value="${member.memAdd1}"/> - 
							<form:input path="memAdd2" class="form-control input-sm" placeholder="상세 주소"
							value="${member.memAdd2}"/>
						</td>
					</tr>
					<tr>
						<th>생일</th>
						<td>
							<form:input path="memBir"
							class="form-control input-sm" value="${member.memBir}"/>
						</td>
					</tr>
					<tr>
						<th>헨드폰</th>
						<td>
							<form:input path="memHp"
							class="form-control input-sm" value="${member.memHp}"/>
						</td>
					</tr>
					<tr>
						<th>메일</th>
						<td>
							<form:input path="memMail"
							class="form-control input-sm" value="${member.memMail}"/>
						</td>
					</tr>
					<tr>
						<th>직업</th>
						<td>
							<form:select path="memJob" class="form-control input-sm">
								<option value="">-- 직업 선택 --</option>
								<form:options items="${jobList}" itemLabel="commNm" itemValue="commCd" />
							</form:select>
						</td>
					</tr>
					<tr>
						<th>취미</th>
						<td>
							<form:select path="memLike" class="form-control input-sm">
								<option value="">-- 직업 선택 --</option>
								<form:options items="${likeList}" itemLabel="commNm" itemValue="commCd" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><a href="memberList.wow"
							class="btn btn-default btn-sm"> <span
								class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
						</a> &nbsp; &nbsp;
							<button type="submit" style="position: relative; left: 200px" class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								수정
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="submit" style="position: relative; left: 500px" formaction="memberRemove.wow" class="btn btn-warning btn-sm">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								삭제
							</button></td>
					</tr>
				</tbody>

			</table>
		</form:form>
	</div>
</body>
</html>