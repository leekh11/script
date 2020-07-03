<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp"  %>
	<title>17/ memberEdit.jsp </title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
 <div class="container">	
	<h3>회원가입</h3>		
<script type="text/javascript">
/* 	$(document).ready(function() {
		$('form[name=frm_member]').submit(function(e) {
			$f = $(this);
			e.preventDefault();
			if(!/^\w{6,12$}/.test($f.find('[name=memId]').val() ) ){
				console.log(  !/^\w{6,12$}/.test($f.find('[name=memId]').val() )  );
				alert("아이디는 6~12글자로 해주세요!");
				return;
			}
			if(!/^\w{6,12$}/.test($f.find('[name=memPass]').val() ) ){
				alert("비밀번호는 6~12글자로 해주세요!");
				return;
			}
			if(!/^[가-힣]{2,5}$/.test($f.find('[name=memName]').val() ) ){
				alert("올바른 이름 형식이 아니다!");
				return;
			}
			if(!/^/.test($f.find('[name=memMail]').val() ) ){
				alert("올바른 이메일 형식이 아닙니다.!");
				return;
			}
			alert("검증성공");
			return true;
			$f.submit();
		});
	}); */
</script>
	<form name="frm_member" action="memberRegist.wow" method="post">
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memId" pattern="^\w{6,12}$" required="required"  class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPass" pattern="\w{4,12}" required="required"  class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" pattern="[가-힣]{2,5}" required="required" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<input type="text" id="sample6_postcode" name="memZip"  placeholder="우편번호">
					<input type="button" class="btn btn-primary btn-sm" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
					<!-- <input type="text" name="memZip" class="form-control input-sm" placeholder="우편번호"> -->
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" id="sample6_address"  name="memAdd1" placeholder="주소"><br>
					<input type="text" id="sample6_detailAddress" name="memAdd2" placeholder="상세주소"> &nbsp;
					<input type="text" id="sample6_extraAddress" placeholder="참고항목">
					<!-- <input type="text" name="memAdd1" class="form-control input-sm" placeholder="기본 주소">
					-
					<input type="text" name="memAdd2" class="form-control input-sm" placeholder="상세 주소"> -->
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="memBir" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>헨드폰</th>
				<td><input type="tel" name="memHp" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="tel" name="memMail" pattern="[\w.]+@\w+(\.\w+){1,4}" required="required" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="memJob" class="form-control input-sm">
						<option value="">-- 직업 선택 --</option>
						<c:forEach items="${jobList}" var="code">							
							<option value="${code.commCd}">${code.commNm}</option>
						</c:forEach>			
					</select>				
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<select name="memLike" class="form-control input-sm">
						<option value="">-- 취미 선택 --</option>
						<c:forEach items="${likeList}" var="code">							
							<option value="${code.commCd}">${code.commNm}</option>
						</c:forEach>					
					</select>				
				</td>
			</tr>			
			<tr>
				<td><a href="memberList.jsp"
							class="btn btn-default btn-sm"> <span
								class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록</a></td>
				<td><button type="submit" class="btn btn-primary btn-sm">회원가입</button></td>
			</tr>
		</tbody>	
	</table>
	</form>
</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    } 
    </script>
</body>
</html>