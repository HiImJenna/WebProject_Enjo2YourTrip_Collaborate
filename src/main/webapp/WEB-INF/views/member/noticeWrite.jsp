<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
	type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/write.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<div class="list-gathering-detail">
		<!-- <div class="back-btn-gathering">
      <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
    </div> -->

		<div class="culture-sub-heading-container">
			<span class="culture-sub-heading">글쓰기</span>
		</div>

		<div class="list-gathering gathering-post">
			<div class="list-summary-top">
				<div class="person-information post-gap">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<span class="nickname"><b>${nickName} 님</b></span>
					</div>
				</div>
			</div>
			<div class="post">

			 	<form name="bw" id="gathering-form" action="${pageContext.request.contextPath}/noticeWriteOk.do" method="POST">
					<div class="text-size text-size-margin">제목</div>
					<textarea name="title" form="gathering-form" cols="51" rows="1" maxlength="" class="post-gap"></textarea>
					<div class="text-size text-size-margin">내용</div>
					<textarea name="content" form="gathering-form" cols="51" rows="20"
						maxlength="" class="post-gap"></textarea>
					<div class="right">
						<input type="submit" value="작성완료" class="culture-btn">
					</div>
				</form>
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
</html>