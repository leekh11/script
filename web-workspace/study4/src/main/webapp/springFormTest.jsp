<%@page import="com.study.code.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.study.code.service.CommonCodeServiceImpl"%>
<%@page import="com.study.code.service.ICommonCodeService"%>
<%@page import="java.awt.color.ICC_ColorSpace"%>
<%@page import="com.study.free.vo.FreeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	FreeBoardVO vo = new FreeBoardVO();
	ICommonCodeService codeService = new CommonCodeServiceImpl();
	List<CodeVO> list = codeService.getCodeListByParent("BC00");
	vo.setBoNum(23);
	vo.setBoTitle("오늘은 금요일이야");
	vo.setBoWriter("밀키스");
	vo.setBoCategory("BC03");
	request.setAttribute("board", vo);
	request.setAttribute("cateList", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="board">
		글번호 : <input type="text" name="boNum" value="${board.boNum}">
		글번호 : <form:input path="boNum" />
		<br>	
		작성자 : <input type="password" name="boWriter" value="${board.boWriter}">
		작성자 : <form:hidden path="boWriter" />
		<br>
		글분류 :
		<select name="boCategory" class="form-control" required="required">
			<option value="">-- 선택하세요--</option>
			<c:forEach items="${cateList}" var="code">
				<option value="${code.commCd}"
					${board.boCategory eq code.commCd ? "selected" : "" }>${code.commNm}
				</option>
			</c:forEach>
		</select>
		<br>
		글분류 : 
		<form:select path="boCategory">
			<option value="">-- 선택하세요--</option>
			<form:options items="${cateList}" itemLabel="commNm"
				itemValue="commCd" />
		</form:select>
		<br>
		글분류 :
		<form:radiobuttons path="boCategory" items="${cateList}" itemLabel="commNm" itemValue="commCd" />
		
	</form:form>
</body>
</html>