<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  // inc/top_menu.jsp
	request.setCharacterEncoding("UTF-8");
%>  
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="<%=request.getContextPath() %>/index.jsp">하하하하</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath() %>/index.jsp">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="<%=request.getContextPath() %>/member/memberList.wow">회원목록</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">게시판 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">          	
            <li><a href="<c:url value='/free/freeList.wow' />">자유게시판</a></li>
            <li><a href="#">자료실</a></li>
            <li><a href="#">1:1 문의 </a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${empty sessionScope.USER_INFO}">
      		<li>
      			<a href="<c:url value='/login/login.wow' />">
      				<i class="fa fa-sign-in-alt" ></i>&nbsp;&nbsp;로그인
      			</a>
      		</li>
      		 <li>
      			<a href="<c:url value='/join/join' />">
      				<i class="fa fa-sign-in-alt" ></i>&nbsp;&nbsp;회원가입
      			</a>
      		</li>
      	</c:if>
        <c:if test="${not empty sessionScope.USER_INFO}">
        	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
          	${sessionScope.USER_INFO.userName}님 <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">          	
            <li><a href="<c:url value='/mypage/myinfo.wow' />">
            			<i class="fa fa-cog" ></i>&nbsp;&nbsp;
            			회원정보
            		</a>
            </li>
            <li><a href="#"><i class="fa fa-key" ></i>&nbsp;&nbsp;비밀번호 변경</a></li>
            <li class="divider"></li>            
            <li><a href="<c:url value='/login/logout.wow' />">
            			<i class="fa fa-sign-out-alt" ></i>&nbsp;&nbsp;
            			로그아웃
            		</a>
            </li>
          </ul>
        </li>
        </c:if>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
<br><br><br>
<div></div>