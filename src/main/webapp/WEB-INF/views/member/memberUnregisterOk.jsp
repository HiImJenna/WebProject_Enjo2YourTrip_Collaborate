<!-- 마이페이지 회원탈퇴 완료 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/header-footer.css" rel="stylesheet" type="text/css" />
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
		<!-- 	<span class="culture-sub-heading">마이 페이지</span>
			<ul class="page-category">
				<li>수정</li>
				<li class="sub-heading">탈퇴</li>
			</ul> -->

			<div class="information-container">
				<div class="information-withdrawal">
					<span class="withdrawal-subheading">탈퇴 완료</span> <img
						src="images/comfirm.svg">
					<p>
						회원 탈퇴가 완료되었습니다.<br> 이용해주셔서 감사합니다.
					</p>
					
					<a href="/team2">
						<button class="withdrawal-btn">
							메인페이지로 이동
						</button>
					</a>
					
				</div>
			</div>

		</div>
	</div>
	<!-- footer -->
	<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>