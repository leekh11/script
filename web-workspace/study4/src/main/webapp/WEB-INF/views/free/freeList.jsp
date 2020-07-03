<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>freeList.jsp</title>
	<script>
		$(document).ready(function () {
			//폼 변수 지정
			var f = document.forms['frm_search'];
			
			//페이지클릭시 이벤트 (데이터에있는 페이지값으로 변경해서.. )	//젤중요
			$('ul.pagination > li > a').click(function(e) {
				e.preventDefault();		//이벤트 전파 방지(막기)
				var p = $(this).data('page');	//this.dataset.page
				f.curPage.value = p;
				f.submit();
			});	//ul.pagination > li > a').click
				
			
			//(행수)rowsize 변경버튼 클릭 //////////////rowSizePerPage
				//TODO: select박스의 값을 폼의 rowSizePerPage에 설정 후 서브밋 호출
			$('#id_btn_rowsize_change').click(function(e) {
				f.rowSizePerPage.value = $('#id_rowSizePerPage option:selected').val();
				f.submit();
			});	//

			
			//초기화버튼 클릭
			$('#id_btn_reset').click(function() {
				f.curPage.value = 1;
				f.searchWord.value = '';
				//TODO: select 박스의 첫번째 option 선택 ////////////
				f.searchType.options[0].selected = true;
				f.searchCategory.options[0].selected = true;
			}); 	//id_btn_reset').click
			
			//검색버튼 클릭
			$('form[name=frm_search]').submit(function(e) {
				e.preventDefault();
				f.curPage.value = 1;
				f.submit();
			})	//form[name=frm_search]').submit
			
			
		}); 	//document.ready

	</script>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp" %>
<!-- curPage=3&searchType&searchWord=길동&searchCategory=BC03 
	jsp:useBean 은 속성에 저장된다 (el 가능)
-->

<div class="container">
	<div class="page-header">
		<h3>자유게시판</h3>
	</div>
	
	<!--  조회목록 위의 검색영역 생성 -->
	<div class="panel panel-default">
	  <div class="panel-body">
	    <form name="frm_search" action="freeList.wow" method="get" class="form-horizontal">
	        <input type="hidden" name="curPage" value="${searchVO.curPage }" >
	        <input type="hidden" name="rowSizePerPage" value="${searchVO.rowSizePerPage }">
	          <div class="form-group">
	            <label for="id_searchType" class="col-sm-2 control-label">검색</label>
	            <div class="col-sm-2">
	                <select id="id_searchType" name="searchType" class="form-control input-sm">			    		
	                    <option value="T" ${searchVO.searchType eq 'T' ? 'selected="selected"' : ''}>제목</option>
	                    <option value="W" ${searchVO.searchType eq 'W' ? 'selected="selected"' : ''}>작성자</option>
	                    <option value="C" ${searchVO.searchType eq 'C' ? 'selected="selected"' : ''}>내용</option>
	                </select>
	            </div>
	            <div class="col-sm-2">	
	              <input type="text" name="searchWord" class="form-control input-sm" 
	              		  value="${searchVO.searchWord }" placeholder="검색어" >			      
	            </div>
	            <label for="id_searchCategory" class="col-sm-2 col-sm-offset-2 control-label">분류</label>
	            <div class="col-sm-2">
	                <select id="id_searchCategory" name="searchCategory" class="form-control input-sm">
	                    <option value="">-- 전체 --</option>
	                    <c:forEach items="${cateList}" var="code">
	                         <option value="${code.commCd}" ${searchVO.searchCategory eq code.commCd ? 'selected="selected"' : '' } >
	                        				${code.commNm}</option>
	                    </c:forEach>
	                </select>
	            </div>
	          </div>
	          <div class="form-group">
	          	<div class="col-sm-2 col-sm-offset-9 text-right">
	          		<button type="button" id="id_btn_reset" class="btn btn-sm btn-default ">
	                    <i class="fa fa-sync fa-rotate-180"></i><!-- fa: font awesome -->
	                    &nbsp;&nbsp;초기화
	                </button>
	          	
	          	</div>
	            <div class="col-sm-1 text-right" >
	                <button type="submit" class="btn btn-sm btn-primary ">
	                    <i class="fa fa-search fa-spin"></i><!-- fa: font awesome -->
	                    &nbsp;&nbsp;검 색
	                </button>
	            </div>
	          </div>
	         </form>
	  </div>
	</div>	
	
	<div class="row">
	    <div class="col-sm-3 form-inline" style="margin-bottom: 5px;" >
	        전체 ${searchVO.totalRowCount} 건 조회
	        <select id="id_rowSizePerPage" name="rowSizePerPage" class="form-control input-sm" >
	            <option value="10" ${searchVO.rowSizePerPage == 10 ?'selected="selected"' : ''} >10</option>
	            <option value="20" ${searchVO.rowSizePerPage == 20 ?'selected="selected"' : ''} >20</option>
	            <option value="30" ${searchVO.rowSizePerPage == 30 ?'selected="selected"' : ''} >30</option>
	            <option value="50" ${searchVO.rowSizePerPage == 50 ?'selected="selected"' : ''} >50</option>
	        </select>
	        <button type="button" id="id_btn_rowsize_change" class="btn btn-sm btn-default ">
               <i class="fa fa-check"></i><!-- fa: font awesome -->
               &nbsp;&nbsp;선택
           </button>
	    </div>
	    <div class="col-sm-2 col-sm-offset-7 text-right" style="margin-bottom: 5px;" >
	        <a href="freeForm.wow" class="btn btn-sm btn-default btn-sm btn-primary" >
	        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 새글쓰기</a>
	    </div>
	</div>
	
	
		<!-- 
		<a href="freeForm.jsp" class="btn btn-default btn-sm btn-primary">
			<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
			&nbsp;글쓰기
		</a> -->

	
	<table class="grid table table-striped table-bordered table-hover">
	<colgroup>
		<col width="10%" />
		<col width="15%" />
		<col />
		<col width="10%" />
		<col width="15%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>글번호</th>
			<th>분류</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	</thead>	
	<tbody>
		<tr class="text-center">
			<c:forEach var="board" items="${freeList}">
					<tr>
						<td>${board.boNum }</td>
						<td>${board.boCategoryNm }</td>
						<td><a href="freeView.wow?boNum=${board.boNum }">
								${board.boTitle }</a>
							<c:forEach var="f" items="${board.attaches}">
								<a href="<c:url value='/attach/download/${f.atchNo}' />"
									 title="${f.atchOriginalName}"	target="_blank"> 
										<span class="glyphicon glyphicon-save" aria-hidden="true"></span> 
								</a>
							</c:forEach>
						</td>
						<td>${board.boWriter }</td>
						<td>${board.boRegDate }</td>
						<td>${board.boHit }</td>
					</tr>
				</c:forEach>
		</tr>
	</tbody>
	</table>
	

	
	 <!-- 조회목록 아래의 페이지네이션  생성 (페이징)-->
	 
	 
	<nav class="text-center">
		<mytag:paging pagingVO="${searchVO}"  linkPage="freeList.wow" />
		
<!-- 	<ul class="pagination"> -->
	    <!-- 이전 페이지 firstPage>1--><!-- if문 -->
	    <%-- <c:if test="${searchVO.startPage>1}">
	    <li>
	    	<a href="freeList.jsp?curPage=${searchVO.startPage-1}" data-page="${searchVO.startPage-1}" ><span aria-hidden="true">&laquo;</span>
	    	</a>
	    </li>
    	 </c:if>
	
	    <!-- 페이지 넘버링  --><!-- foreach -->
	    <c:forEach begin="${searchVO.startPage}" end="${searchVO.endPage}" var="i">
	    	<c:if test="${searchVO.curPage ne i}">
	    	<li><a href="freeList.jsp?curPage=${i}"  data-page="${i}">${i}</a></li>
	    	</c:if>
	    	<c:if test="${searchVO.curPage eq i}">
		    	<li class="active"><a href="#">${i}</a></li>
	    	</c:if>
	    </c:forEach>
	
	
	    <!-- 다음  페이지 lastpage< totalPageCnt -->
	    <c:if test="${searchVO.endPage< searchVO.totalPageCount }">
	    <li><a href="freeList.jsp?curPage=${searchVO.endPage+1}" data-page="${searchVO.endPage+1}" ><span aria-hidden="true">&raquo;</span></a>
		</c:if> --%>
	<!-- </ul> -->	
	</nav>
		
	
	
</div>
</body>
</html>




