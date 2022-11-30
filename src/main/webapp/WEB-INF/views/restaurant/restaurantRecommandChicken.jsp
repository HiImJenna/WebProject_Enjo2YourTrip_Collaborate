<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="style/restaurant/ranking1.css">
</head>
<body>
   <header>
      <!-- header -->
      <%
      pageContext.include("/WEB-INF/views/include/header.jsp");
      %>
   </header>
  <!-- Card -->
<div class="card">
	<!-- Title -->
	<div class="title">
		<h1>치킨 순위</h1>
		<p>에디터가 고심해서 고른 치킨 순위.<br/>확인해보세요.</p>
	</div>
	
	<!--Rancking -->
	<div class="box"> <!-- #01 -->
		<!-- Number-->
		<div class="number">01</div>
		<!-- Cover -->
		<div class="cover"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MDhfMjkz%2FMDAxNjYyNTY0MzU5Nzc1.EMDMmjOWoJQ2JXVLwsx8FjU-3mVk2BT2LvxUwSx1WXkg.xTswQXja7JejDhioQUWQE3gWrAs28vtJqqBgPhE7eDAg.JPEG.jy8451474%2F20220907%25A3%25DF130356.jpg" alt="01"></div>
		<!-- Name -->
		<div class="name"><span>효도치킨</span> 짭짤한 간장 양념에 버무려진 바삭한 치킨과 꽈리고추 그리고 고소한 멸치의 맛!</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=효도치킨" alt="효도치킨">상세보기</a></div>
	</div>
	
	<!-- Separator -->
	<div class="separator"></div>
	
	<div class="box"> <!-- #02 -->
		<!-- Number-->
		<div class="number">02</div>
		<!-- Cover -->
		<div class="cover"><img src="https://ldb-phinf.pstatic.net/20160225_215/1456378490994zaQu0_JPEG/176175546469913_0.jpg" alt="02"></div>
		<!-- Name -->
		<div class="name"><span>계열사</span> 부암동 수요미식회에 방영된 치킨 맛집</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=계열사">상세보기</a></div>
	</div>
	
	<!-- Separator -->
	<div class="separator"></div>
	
	<div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">03</div>
		<!-- Cover -->
		<div class="cover"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjAzMjRfMTYx%2FMDAxNjQ4MDQ4NTE0ODAy.V82_nDfMHJZfDvQxv4c4tItXp3H2ldzxe-Uuqk8aIXgg.teu1AfYBoK4KOVgGvqQNQZc4h4erQY6PchdTBzqUpmkg.JPEG.hyeyoung0809%2F%25C4%25A1%25C5%25B21.JPG" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>삼통치킨</span> 1981년 전통의 맛을 컨셉으로 고대 앞에서 27년 이상 영업중인 고대의 명물</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=삼통치킨">상세보기</a></div>
	</div>
  <div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">04</div>
		<!-- Cover -->
		<div class="cover"><img src="https://pup-review-phinf.pstatic.net/MjAyMjExMjNfMTg0/MDAxNjY5MTU2MTIxODE1.rTB0JfjumWVxitkiUFgZanM9UEt1UG6hjYIy5xIjLfEg.f23GmzsfTteT3MuR7EbxX8wi5XmhrjpX9ek9g5cEkpAg.JPEG/3CB81F33-1539-4C1E-8A17-A1A27954E8AF.jpeg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>한남동 한방 통닭</span> 이영자 소화제로 유명한 장작구이 통닭 맛집</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=한남동 한방 통닭">상세보기</a></div>
	</div>
  <div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">05</div>
		<!-- Cover -->
		<div class="cover"><img src="https://ldb-phinf.pstatic.net/20151222_62/1450769254214Gh5Lo_JPEG/167172565753161_2.jpg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>양재닭집</span> 노포 느낌의 옛날 통닭 맛집</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=양재닭집">상세보기</a></div>
	</div>
  <div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">06</div>
		<!-- Cover -->
		<div class="cover"><img src="https://pup-review-phinf.pstatic.net/MjAyMjExMDVfNDEg/MDAxNjY3NjI0MzMxNDcy.pBGDqqB3wcnloPacCZsZ4XrovniDXnzO8JczDqu5xFog.slKvzV270nyQDGrPOfetj1ykj2kSejQVvSn9Xf19alog.JPEG/20221104_211109.jpg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>미락치킨</span> 오감 자극하는 철판마늘치킨</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=미락치킨">상세보기</a></div>
	</div>
  <div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">07</div>
		<!-- Cover -->
		<div class="cover"><img src="https://img.siksinhot.com/article/1586486992902333.jpg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>국수찾아닭만리</span> 쭉쭉 늘어나는 콘치즈에 통닭을 돌돌 말아먹으면 맥주 안주로 최고. 
			</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=국수찾아닭만리">상세보기</a></div>
	</div>
  <div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">09</div>
		<!-- Cover -->
		<div class="cover"><img src="https://pup-review-phinf.pstatic.net/MjAyMjExMTZfNzIg/MDAxNjY4NTI0NDI4MDky.rcz-fjzMm_EHA8KoSm7hBPcWMCQpBF96A_UcZ9nNwAMg.IlsMQPp26ANJwaL2gulasJjZmCQYekL06VTfv7TVzDMg.JPEG/20221115_190221.jpg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span >아웃닭</span> 홍대 치킨 아웃닭은 다시 먹어도 맛있는 치킨 맛집</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=아웃닭">상세보기</a></div>
	</div>
	<div class="box"> <!-- #03 -->
		<!-- Number-->
		<div class="number">10</div>
		<!-- Cover -->
		<div class="cover"><img src="https://img.siksinhot.com/article/1586487015955334.jpg" alt="03"></div>
		<!-- Name -->
		<div class="name"><span>감미치킨</span> 감미치킨’은 숯불에서 닭을 직화로 구운 바비큐 치킨을 맛볼 수 있는 곳			
			</div>
		<!-- Button -->
		<div  class="link"><a href="recommand.restaurant?&value=감미치킨">상세보기</a></div>
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