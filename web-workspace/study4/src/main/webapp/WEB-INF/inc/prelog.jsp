<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	// 클라이언트의 ip, uri 로그를 찍고
	//공통변수 APP_PATH
	String ip = request.getRemoteAddr();
	String uri = request.getRequestURI();
	String APP_PATH = request.getContextPath();
	log("ip=" + ip + ", uri= " + uri);
%>
