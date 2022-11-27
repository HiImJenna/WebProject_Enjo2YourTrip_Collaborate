<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>
	<!-- main -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner " width="50%" height="30%" margin="auto">
			<div class="carousel-item active" style="text-align: center;">
				<a href="mainView.restaurant"><img
					src="https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/3rWZ/image/rXpMIl8sMxtoBzR1PL6OHK1KxLw.jpg"
					width="70%" height="30%" alt="image"></a>
			</div>
			<div class="carousel-item" style="text-align: center;">
				<a href=""><img
					src="https://m.nongmin.com/upload/bbs/202209/20220906091547637/20220906091547637.jpg"
					width="70%" height="30%" alt="image"></a>
			</div>
			<div class="carousel-item" style="text-align: center;">
				<a href="mainView.flight"><img
					src="http://res.heraldm.com/content/image/2016/11/20/20161120000213_0.jpg"
					width="70%" height="30%" alt="image"></a>
				<!-- class="d-block w-10" -->
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-target="#carouselExampleIndicators" data-slide="prev">
			<!-- <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span> -->
		</button>
		<button class="carousel-control-next" type="button"
			data-target="#carouselExampleIndicators" data-slide="next">
			<!--  <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span> -->
		</button>
	</div>
	<div style="text-align: center;">

		<!-- <br> <br> <br> <img src="images/main/메인게시판1.PNG"
			width="70%" height="20%" margin="auto" alt="image"> <br> <br> -->
		<br>
	</div>

	<%-- https://cms.kookmin.ac.kr/apply/notice/faq.do?mode=view&articleNo=1191
<div class = "main-mini-box main-mini-box02">
   <div class = "mini-tab-box>
    <ul>
    <li class="active><a class="mini-board-tab" href="#a" title="공지사항"> 공지사항 </a>
       <!-- 게시판 타입 1 -->
       <c:import charEncoding="utf-8" url="/cms/content/widget.do">
          <c:param name="widgetKey" value="/_share/_widget/miniboard-board-type01.jsp"/>
          <c:param name="miniBoardNo" value="24"/> <!-- 게시판 번호 -->
          <c:param name="boardUrl" value="etc-board/board03.do"/> <!-- 이동할 게시판 주소 -->
          <c:param name="articleCount" value="5"/> <!-- 출력할 게시물 갯수 -->
          <c:param name="categoryId" value=""/>   <!-- 카테고리 아이디 -->
        </c:import><a class="viewmore" href="etc-board/board03.do" title="공모/대외활동 바로가기"> 더보기</a></li>
   <li class="active><a class="mini-board-tab" href="#a" title="문의사항"> 문의사항 </a>
       <!-- 게시판 타입 2 -->
       <c:import charEncoding="utf-8" url="/cms/content/widget.do">
          <c:param name="widgetKey" value="/_share/_widget/miniboard-board-type01.jsp"/>
          <c:param name="miniBoardNo" value="24"/> <!-- 게시판 번호 -->
          <c:param name="boardUrl" value="etc-board/board03.do"/> <!-- 이동할 게시판 주소 -->
          <c:param name="articleCount" value="5"/> <!-- 출력할 게시물 갯수 -->
          <c:param name="categoryId" value=""/>   <!-- 카테고리 아이디 -->
        </c:import><a class="viewmore" href="etc-board/board03.do" title="공모/대외활동 바로가기"> 더보기</a></li>
   </ul>
</div>
</div>
--%>
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>