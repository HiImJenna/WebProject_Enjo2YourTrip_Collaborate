<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
<meta charset="UTF-8">
<title>ENJO2 YOUR TRIP</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- 이미지 모아주는 cdn --><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<!-- 이미지 슬라이드 --><script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/table.css" rel="stylesheet" type="text/css" />
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "get",
			url : "mainInfo.do",
			success : function(data) {
				
				const noticeList = data.noticeList;
				const qnaList = data.qnaList;
				console.log(data);
				
				if(noticeList.length > 0){
					$('#noticeBox').show();
				} else{
					$('#noticeBox').hide();
					return;
				}
				
				$('#noticeTable').empty();
				
				for(const notice of noticeList){
					let tempHtml = `<tr>
										<td><a href="noticeContent.do?no=\${notice.no}">\${notice.title}</a></td>
										<td style="font-size : 10pt; text-align:right">\${notice.date}</td>
									</tr>`
					$('#noticeTable').append(tempHtml);
				}
				for(const qna of qnaList){
					let tempHtml = `<tr>
										<td><a href="noticeContent.do?no=\${qna.no}">\${qna.title}</a></td>
										<td style="font-size : 10pt; text-align:right">\${qna.date}</td>
									</tr>`
					$('#qnaTable').append(tempHtml);
				}
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error)
			}
		});
	});
</script>
</head>
<body>
	<!-- header -->
	<% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
	<!-- main -->
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" margin="auto">
			<!-- 항공 -->
			<div class="carousel-item active" style="text-align: center;">
				<a href="mainView.flight"><img
					src="https://www.rd.com/wp-content/uploads/2022/04/GettyImages-1140602972-e1651249657746.jpg"
					width="830" height="430" alt="image"></a>
				<!-- class="d-block w-10" -->
			</div>
			<!-- 맛집 -->
			<div class="carousel-item" style="text-align: center;">
				<a href="mainView.restaurant"><img
					src="https://zahramediagroup.com/wp-content/uploads/2018/07/shutterstock_394775977.jpg"
					width="830" height="430" alt="image"></a>
			</div>
			<!-- 문화공간 -->
			<div class="carousel-item" style="text-align: center;">
				<a href=""><img
					src="https://i.insider.com/57f3ccc78c6c5022008b458b?width=1000&format=jpeg&auto=webp"
					width="830" height="430" alt="image"></a>
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
	<div class = "imageDiv">
		<div class = "imgdiv">
	 		<a href="mainView.restaurant"><img src="images/맛집메인.png" alt="image" class = "img"></a>
			<a href="mainView.restaurant"><img src="images/문화메인.png" alt="image" class = "img" ></a>
			<a href="mainView.flight"><img src="images/항공메인.png" alt="image" class = "img" ></a>
		</div>
		
	</div>
	<!-- 공지사항 QNA -->
	<div style="margin: 0pt auto; max-width: 100%; min-width: 830px;">
		<div>
			<table class="content-table" style="float : left;">
				<thead>
					<th scope="col" colspan="2" width="100%">
					<a href="${request.getContextPath}management.do?type=notice"><b>NOTICE</b></a></th>
				</thead>
				<tbody id="noticeTable"></tbody>
			</table>
		</div>
		<div>
			<table class="content-table" style="float : right;">
				<thead>
					<th scope="col" colspan="2" width="100%">
					<a href="${request.getContextPath}management.do?type=qna"><b>QNA</b></a></th>
				</thead>
				<tbody id="qnaTable"></tbody>
			</table>
		</div>
	</div>
	<footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
	</footer>
</body>
</html>