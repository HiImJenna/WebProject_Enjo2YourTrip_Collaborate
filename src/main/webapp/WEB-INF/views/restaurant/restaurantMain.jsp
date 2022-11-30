<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="style/restaurant/job.css">

<link rel="js" href="js/script.js">
<script src="https://kit.fontawesome.com/b81e202536.js"
	crossorigin="anonymous"></script>
<script src="./basic.js" type="module"></script>
<style>
#searchMatzip {
	background-img: url('');
	background-repeat: no-repeat;
	backgroupd-size: 13px;
}
</style>
</head>
<body>
	<header>
		<!-- header -->
		<%
		pageContext.include("/WEB-INF/views/include/header.jsp");
		%>
	</header>
	<div class="job">
		<div class="wrapper">


			<form id="search" action="recommand.restaurant" method="GET">
				<input id="field" onfocus="clicked()" onblur="normal()" type="text"
					name="value" value="${value }" /> <img
					src="images/pngwing.com.png">
			</form>
			<div class="container">


				<div class="main-container">
					<div class="searched-jobs">
						<div class="searched-bar">
							<div class="searched-show"></div>
						</div>

						<a href="recommandChicken.restaurant?">
							<div class="job-cards">
								<!-- 내 근처 맛집 -->
								<div class="job-card">
									<div class="job-card-header"></div>
									<div class="job-card-title">서울시 치킨 맛집</div>
									<img id="matzip" src="images/치킨.jpg" alt="">
									<div class="job-card-subtitle"></div>
									<div class="job-card-buttons">

										<button class="search-buttons card-buttons">보러가기</button>
									</div>
								</div>
						</a>
						<!-- 내 근처 맛집 -->
						<!-- 내 근처 맛집 -->
						<a href="recommandPizza.restaurant">
							<div class="job-card">
								<div class="job-card-header"></div>
								<div class="job-card-title">내가 찜한 맛집</div>
								<img id="matzip"
									src="https://ldb-phinf.pstatic.net/20210809_123/1628489870455uLydz_JPEG/Z1BdXNv-dMoIzASYz24TlofA.jpg"
									alt="">
								<div class="job-card-subtitle"></div>
								<div class="job-card-buttons">
									<button class="search-buttons card-buttons">보러가기</button>
								</div>
							</div>
						</a>
						<!-- 내 근처 맛집 -->
						<!-- 내 근처 맛집 -->
						<a href="recommand.restaurant?&value=맛집" alt="한식"><div
								class="job-card">
								<div class="job-card-header"></div>
								<div class="job-card-title">가까운 맛집</div>
								<img id="matzip"
									src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNy4kGeqX1rpCvL7y9IzEkDuKGQjPHEz9b4g&usqp=CAU"
									alt="" class="foodimages">

								<div class="job-card-subtitle"></div>
								<div class="job-card-buttons">
									<button class="search-buttons card-buttons">보러가기</button>
								</div>
							</div> </a>
						<!-- 내 근처 맛집 -->

						<div class="job-card">
							<a href="recommand.restaurant?&value=한식" alt="한식"><img
								src="images/m_main_icon_hansik.jpg" border="0" width="100%"></a>
						</div>
						<div class="job-card">
							<a href="recommand.restaurant?&value=중식" alt="중식"><img
								src="images/m_main_icon_china.jpg" border="0" width="100%"></a>
						</div>
						<div class="job-card">
							<a href="recommand.restaurant?&value=양식" alt="양식"><img
								src="images/m_main_icon_wfood.jpg" border="0" width="100%"></a>
						</div>
						<div class="job-card">
							<a href="recommand.restaurant?&value=일식" alt="일식"><img
								src="images/m_main_icon_sushi.jpg" border="0" width="100%"></a>
						</div>
						<div class="job-card">
							<a href="recommand.restaurant?&value=분식" alt="분식"><img
								src="images/m_main_icon_bunsik.jpg" border="0" width="100%"></a>
						</div>
						<div class="job-card">
							<a href="recommand.restaurant?&value=술집" alt="주점"><img
								src="images/m_main_icon_hof.jpg" border="0" width="100%"></a>
						</div>

					</div>

				</div>
			</div>
			</tr>
			<!--
                <tr>
              <td width="25%" align="center" bgcolor="#FFFFFF" style="vertical-align:top;">&nbsp;</td>
              <td width="25%" align="center" bgcolor="#FFFFFF" style="vertical-align:top;">&nbsp;</td>
              
              </td>
              </tr>-->
			</table>
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