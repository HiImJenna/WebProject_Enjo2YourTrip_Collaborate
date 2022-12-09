<!-- 마이페이지 수정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/information-page.css" rel="stylesheet" type="text/css" />
<link href="style/mypage.css" rel="stylesheet" type="text/css" />

<body>
	<!-- header -->
	<%
		pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<div class="culture-container">
		<div class="culture-information">
			<span class="culture-sub-heading">마이 페이지</span>
			<ul class="page-category">
				<a href="${request.getContextPath}memberEdit.do">
					<li class="sub-heading">수정</li>
				</a>
				<a href="${request.getContextPath}memberUnregister.do">
					<li>탈퇴</li>
				</a>
			</ul>

			<div class="information-container">
				<div class="information">
					<span class="member-information">회원정보</span>
					<form action="${request.getContextPath}memberEditOk.do" method="post">
						<input type="text" name="id" placeholder="" value="${requestScope.member}" readonly><br>
						<input type="password" name="pw" placeholder="비밀번호"><br>
						<input type="password" name="pwConfirm" placeholder="비밀번호 확인"><br> 
						<input type="text" name="nickname"placeholder="닉네임" value="${requestScope.nickName}"><br> 
						<input type="email" name="email" placeholder="이메일" value="${requestScope.email}"><br> 
						<!-- <input type="text" name="address" placeholder="주소" required><br> -->
						<!-- <input type="hidden" name="member" value="ordinary"><br> -->
						<input type="button" value="완료" onclick="requestUpdate(this.form);">
					</form>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>
</body>

<script type="text/javascript">
	function isFormWrong(form) {
 		if (form.pw.value == "") {
			alert("비밀번호를 입력해주세요");
			form.pw.focus();
			return true;
		}
		if (form.pwConfirm.value == "") {
			alert("재확인 비밀번호를 입력해주세요");
			form.pwConfirm.focus();
			return true;
		}
		if (form.pw.value != form.pwConfirm.value) {
			alert("비밀번호가 일치하지 않습니다.");
			form.pw.focus();
			return true;
		}
		if (form.nickname.value == "") {
			alert("닉네임을 입력해주세요");
			form.nickname.focus();
			return true;
		}
		if (form.email.value == "") {
			alert("이메일을 입력해주세요");
			form.nickname.focus();
			return true;
		}
		var regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if (!regex.test(form.email.value)) {
			alert("올바른 이메일 형식이 아닙니다");
			form.email.focus();
			return true;
		}
		return false;
	}
	function requestUpdate(form) {
		if (isFormWrong(form)) {
			return;
		}
		$.ajax(
			{
				type : "get",
				url : "checkNickname.do",
				data : {
					id : form.id.value,
					nickname : form.nickname.value
				},
				success : function(data) {
					form.submit();
				},
				error : function(request, status, error) {
					alert('이미 존재하는 닉네임입니다.');
					form.nickname.focus();
				}
			}
		)
	}
</script>
</html>