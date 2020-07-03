<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>16/ memberList.jsp</title>
<script>
	$(document)
			.ready(
					function() {
						//폼 변수 지정
						var f = document.forms['frm_search'];

						//페이지클릭시 이벤트 (데이터에있는 페이지값으로 변경해서.. )	//젤중요
						$('ul.pagination > li > a').click(function(e) {
							e.preventDefault(); //이벤트 전파 방지(막기)
							var p = $(this).data('page'); //this.dataset.page
							f.curPage.value = p;
							f.submit();
						}); //ul.pagination > li > a').click

						//(행수)rowsize 변경버튼 클릭 //////////////rowSizePerPage
						$('#id_btn_rowsize_change')
								.click(
										function(e) {
											f.rowSizePerPage.value = $(
													'#id_rowSizePerPage option:selected')
													.val();
											f.submit();
										}); //

						//초기화버튼 클릭
						$('#id_btn_reset').click(function() {
							f.curPage.value = 1;
							f.searchWord.value = '';
							f.searchType.options[0].selected = true;
							f.searchJob.options[0].selected = true;
							f.searchLike.options[0].selected = true;
						}); //id_btn_reset').click

						//검색버튼 클릭
						$('form[name=frm_search]').submit(function(e) {
							e.preventDefault();
							f.curPage.value = 1;
							f.submit();
						}) //form[name=frm_search]').submit

					}); //document.ready
</script>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top_menu.jsp"%>

<%-- 	<jsp:useBean id="searchVO" class="com.study.member.vo.MemberSearchVO" />
	<jsp:setProperty property="*" name="searchVO" />
 --%>

	<div class="container">
		<div class="page-header">
			<h3>회원 목록</h3>
		</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<form name="frm_search" action="memberList.wow" method="post"
					class="form-horizontal">
					<input type="hidden" name="curPage" value="${searchVO.curPage}">
					<input type="hidden" name="rowSizePerPage"
						value="${searchVO.rowSizePerPage}">
					<div class="form-group">
						<label for="id_searchType" class="col-sm-2 control-label">검색</label>
						<div class="col-sm-2">
							<select id="id_searchType" name="searchType"
								class="form-control input-sm">
								<option value="ID"
									${searchVO.searchType eq 'ID' ? 'selected' : ''}>아이디</option>
								<option value="NM"
									${searchVO.searchType eq 'NM' ? 'selected' : ''}>회원명</option>
								<option value="HP"
									${searchVO.searchType eq 'HP' ? 'selected' : ''}>핸드폰</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input type="text" name="searchWord"
								class="form-control input-sm" value="${searchVO.searchWord}"
								placeholder="검색어">
						</div>
						<label for="id_searchJob"
							class="col-sm-2 col-sm-offset-2 control-label">직업</label>
						<div class="col-sm-2">
							<select id="id_searchJob" name="searchJob"
								class="form-control input-sm">
								<option value="">-- 전체 --</option>
								<c:forEach items="${jobList}" var="code">
									<option value="${code.commCd}"
										${code.commCd == searchVO.searchJob ? 'selected' : '' }>${code.commNm}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="id_searchLike" class="col-sm-2 control-label">취미</label>
						<div class="col-sm-2">
							<select id="id_searchLike" name="searchLike"
								class="form-control input-sm">
								<option value="">-- 전체 --</option>
								<c:forEach items="${likeList}" var="code">
									<option value="${code.commCd}"
										${code.commCd == searchVO.searchLike ? 'selected' : '' }>${code.commNm}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-2 col-sm-offset-8 text-right">
							<button type="button" id="id_btn_reset"
								class="btn btn-sm btn-default ">
								<i class="fa fa-sync fa-rotate-180"></i>
								<!-- fa: font awesome -->
								&nbsp;&nbsp;초기화
							</button>
						</div>
						<div class="col-sm-1 text-right">
							<button type="submit" class="btn btn-sm btn-primary ">
								<i class="fa fa-search"></i> &nbsp;&nbsp;검 색
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-3 form-inline" style="margin-bottom: 5px;">
				전체 ${searchVO.totalRowCount} 건 조회 <select id="id_rowSizePerPage"
					name="rowSizePerPage" class="form-control input-sm">
					<option value="10"
						${searchVO.rowSizePerPage == 10 ? 'selected="selected"' : '' }>10</option>
					<option value="20"
						${searchVO.rowSizePerPage == 20 ? 'selected="selected"' : '' }>20</option>
					<option value="30"
						${searchVO.rowSizePerPage == 30 ? 'selected="selected"' : '' }>30</option>
					<option value="50"
						${searchVO.rowSizePerPage == 50 ? 'selected="selected"' : '' }>50</option>
				</select>
				<button type="button" id="id_btn_rowsize_change"
					class="btn btn-sm btn-default ">
					<i class="fa fa-check"></i>
					<!-- fa: font awesome -->
					&nbsp;&nbsp;선택
				</button>
			</div>
			<div class="col-sm-2 col-sm-offset-7 text-right"
				style="margin-bottom: 5px;">
				<a href="memberForm.wow" class="btn btn-primary btn-sm"> <span
					class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;회원가입
				</a>
			</div>
		</div>

		<table class="table table-striped  table-hover">
			<colgroup>
				<col style="width: 10%" />
				<col style="width: 10%" />
				<col />
				<col style="width: 20%" />
				<col style="width: 20%" />
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>회원명</th>
					<th>주소</th>
					<th>이메일</th>
					<th>HP</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${memberList}">
					<tr>
						<td><a href="memberView.wow?memId=${member.memId}">
								${member.memId} </a></td>
						<td>${member.memName}</td>
						<td>${member.memAdd1}${member.memAdd2}</td>
						<td>${member.memMail}</td>
						<td>${member.memHp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav class="text-center">
			<ul class="pagination">
				<mytag:paging pagingVO="${searchVO}"/>
				
				<!-- 이전 페이지 startPage > 1  -->
<%-- 				<c:if test="${searchVO.startPage > 1}">
					<li><a href="memberList.jsp?curPage=${searchVO.startPage-1}"
						data-page="${searchVO.startPage-1}"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<!-- 페이지 넘버링  -->
				<c:forEach begin="${searchVO.startPage}" end="${searchVO.endPage}"
					var="i">
					<c:if test="${searchVO.curPage ne i}">
						<li><a href="memberList.jsp?curPage=${i}" data-page="${i}">${i}</a></li>
					</c:if>
					<c:if test="${searchVO.curPage eq i}">
						<li class="active"><a href="#">${i}</a></li>
					</c:if>
				</c:forEach>
				<!-- 다음  페이지 endPage < totalPageCount 태원아빠  -->
				<c:if test="${searchVO.endPage < searchVO.totalPageCount}">
					<li><a href="memberList.jsp?curPage=${searchVO.endPage+1}"
						data-page="${searchVO.endPage+1}"><span aria-hidden="true">&raquo;</span></a>
				</c:if> --%>
			</ul>
		</nav>
	</div>
</body>
</html>

