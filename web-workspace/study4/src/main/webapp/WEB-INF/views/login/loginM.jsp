<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@include file="/WEB-INF/inc/header.jsp" %>
	<title>로그인 </title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css"></link>
	<style>
	
	</style>
</head>
<body>
<%-- <%@include file="/WEB-INF/inc/top_menu.jsp" %> --%>
<div class="container">
<div class="login-form">
    <form action="<%=request.getContextPath()%>/login/loginM.mg" method="post">
        <h2 class="text-center">관리자 로그인</h2>   
        <div class="form-group">
        	<div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" name="userId" placeholder="관리자 아이디" required="required">				
            </div>
        </div>
		<div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="userPass" placeholder="비밀번호" required="required">				
            </div>
        </div>        
        <div class="form-group">
            <button type="submit" class="btn btn-primary login-btn btn-block">로그인</button>
        </div>
    </form>
</div>
</div>
</body>
</html>