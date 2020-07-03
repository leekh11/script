<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- left.jsp --%>
<div class="left-memu">
		<ul>
			<li>자유게시판</li>
			<li>QnA</li>
			<li>자료실</li>
			<li>1:1게시판</li>
			
			<li>이름: <%=request.getParameter("name") %></li>
			<li>나이대: <%=request.getParameter("gen") %></li>			
			
			
		</ul>
	</div>