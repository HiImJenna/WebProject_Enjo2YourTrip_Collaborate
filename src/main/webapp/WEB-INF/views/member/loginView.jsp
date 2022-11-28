<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/information-page.css" rel="stylesheet" type="text/css" />
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
				<span class="sub-heading">로그인</span>
			</div>
			<form action="loginOk.do" method="post">
				<input type="text" name="id" placeholder="아이디" required><br>
				<input type="password" name="pwd" placeholder="비밀번호" required><br>
				<input type="submit" value="로그인"><br> <a
					href="joinView.do"> <input type="button" value="회원가입"
					class="register-btn">
				</a>
			</form>
		</div>
	</div>
	<br>
	<br>
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>