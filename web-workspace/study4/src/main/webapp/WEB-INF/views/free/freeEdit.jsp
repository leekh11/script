
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h3>게시판 수정</h3>
		<form:form modelAttribute="board" action="freeModify.wow" >
			<input type="hidden" name="boNum" value="${board.boNum}">
			<table class="table table-striped table-bordered ">
				<colgroup>
					<col width="20%" />
					<col />
				</colgroup>
				<tr>
					<th>제목</th>
					<td><form:input path="boTitle" class="form-control"
							value="${board.boTitle}" /> 
					<form:errors path="boTitle" /> 
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<form:input path="boWriter" value="${board.boWriter}"
							class="form-control" />
						<form:errors path="boWriter" /> 
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<form:password path="boPass" value=""
						class="form-control" title="4글자 이상 입력"/> 
						<form:errors path="boPass" />
						<span>수정 또는 삭제시에 필요합니다.</span>
					</td>
				</tr>
				<tr>
					<th>분류</th>
					<td>		
						<form:select path="boCategory" class="form-control">
							<option value="">-- 선택하세요--</option>
							<form:options items="${cateList}" itemLabel="commNm" itemValue="commCd" />
						</form:select>
					</td>
				</tr>
				<tr>
					<th>IP</th>
					<td>
						<form:input path="boIp"
						value="<%=request.getRemoteAddr()%>" readonly="true" class="form-control" />
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<form:textarea rows="3" path="boContent" class="form-control" />${board.boContent}
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="freeList.wow"
						class="btn btn-default btn-sm"> <span
							class="glyphicon glyphicon-list" aria-hidden="true"></span>
							&nbsp;목록
						</a>
						<button type="submit" formaction="freeDel.wow"
							class="btn btn-danger btn-sm">
							<span class="glyphicon glyphicon-delete" aria-hidden="true"></span>
							&nbsp;삭제
						</button>
						<button type="submit" formaction="freeModify.wow"
							class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
							&nbsp;수정
						</button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>