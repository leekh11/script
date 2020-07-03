<%@page import="com.study.login.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<fmt:setBundle basename="resource.message" var="res" />
    <%-- top.jsp --%>

	<div class="top-menu">
		<ul>
			<li>Home</li>
			<li>게시판 관리</li>
			<li>회원 관리</li>
			<%
				//세션에 "USER_INFO"
					//if null이라면
					UserVO user = (UserVO)session.getAttribute("USER_INFO");
					if(user == null) {
			%>
			<li><a href="<%=request.getContextPath()%>/11/login.jsp">로그인</a></li>
			<%
				//else
				} else {
			%>
			<li><fmt:message bundle="${res}" key="topmenu.login.info">
						<fmt:param value="${USER_INFO.userRole }" />
						<fmt:param value="${USER_INFO.userName }" />
					</fmt:message>
			<li><a href="<%=request.getContextPath()%>/11/logout.jsp">로그아웃</a></li>
			<%} %>
		
			
		</ul>
	</div>
	