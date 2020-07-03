<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/ index.jsp</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"></link>
</head>
<body>
	<!-- 상단 메뉴  -->
	<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>

	<!-- 왼쪽 메뉴  -->
	<jsp:include page="/WEB-INF/inc/left.jsp"></jsp:include>

	<!-- 본문  -->
	<div class="content">
		
	</div>
	<!-- 하단 메뉴  -->
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>

</body>
</html>