<!-- 회원 가입 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/information-page.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function check() {
		if (!bbs.id.value) {
			alert("아이디 입력하세요");
			bbs.id.focus();
			return false;
		}
		if (!bbs.pw.value) {
			alert("비밀번호를 입력하세요");
			bbs.pw.focus();
			return false;
		}
		if (!bbs.pw_confirm.value) {
			alert("재확인 비밀번호를 입력하세요");
			bbs.pw_confirm.focus();
			return false;
		}
		if (!bbs.nickname.value) {
			alert("닉네임을 입력하세요");
			bbs.nickname.focus();
			return false;
		}
		if (!bbs.email.value) {
			alert("이메일을 입력하세요");
			bbs.email.focus();
			return false;
		}
		if (!bbs.address.value) {
			alert("주소를 입력하세요");
			bbs.address.focus();
			return false;
		}
		if (bbs.pw.value != bbs.pw_confirm.value) {
			alert("비밀번호가 일치하지 않습니다.");
			bbs.pw.focus();
			return;
		}
		var regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if (!regex.test(bbs.email.value)) {
			alert("올바른 이메일 형식이 아닙니다");
			bbs.email.focus();
			return;
		}
		// alert("비밀번호가 일치합니다.");
		document.bbs.submit();
	}
</script>
</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>
	<br>
	<!-- main -->
	<div class="information-container">
		<div class="information">
			<div class="project-name">
				<div>ENJO2 YOUR</div>
				<div class="project-name-2">TRIP</div>
			</div>
			<div class="information-text">
				<span class="sub-heading">회원가입</span>
			</div>
			<form name="bbs"
				action="${pageContext.request.contextPath}/joinOk.do" method="POST">
				<input type="text" name="id" placeholder="아이디" required /><br /> <input
					type="password" name="pw" placeholder="비밀번호" required /><br /> <input
					type="password" name="pw_confirm" placeholder="비밀번호 확인" required /><br />
				<input type="text" name="nickname" placeholder="닉네임" required /><br />
				<input type="email" name="email" placeholder="이메일" required /><br />
				<input type="hidden" name="member" value="ordinary" /><br /> <input
					type="submit" value="회원가입" onclick="check();" /><br /> <a
					href="${pageContext.request.contextPath}"> <input type="button" value="페이지 이동" /></a>
			</form>
		</div>
	</div>
	<br>
	<br>
	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>
</body>
</html>
