<!-- 마이페이지 회원탈퇴 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<span class="culture-sub-heading">마이 페이지</span>
			<ul class="page-category">
				<a href="${request.getContextPath}memberEdit.do">
					<li>수정</li>
				</a>
				<a href="${request.getContextPath}memberUnregister.do">
					<li class="sub-heading">탈퇴</li>
				</a>
			</ul>

			<form action="${request.getContextPath}memberUnregisterOk.do" method="post">
				<div class="information-container">
					<div class="information-withdrawal">
						<span class="withdrawal-subheading">회원 탈퇴</span> <img
							src="images/warning.svg">
						<p class="withdrawal-infomation">회원 탈퇴를 하시면 사용자 정보가 모두 삭제됩니다. 그래도 탈퇴하시겠습니까?</p>
						<!-- <button class="withdrawal-btn">탈퇴하기</button> -->
						<input type="hidden" name="id" value="${requestScope.userId}">
						<input type="submit" class="withdrawal-btn" value="탈퇴하기">
					</div>
				</div>
			</form>

		</div>
	</div>
	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>
</body>
</html>