<%@page import="kr.co.enjo2.dto.restaurant.RestaurantReviewDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3.0">
<title>product</title>
<!-- <link rel="stylesheet" href="product.css"> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <script type="text/javascript" src="product.js"></script> -->
<style type="text/css"></style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="	sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link href="style/restaurant/common.css" rel="stylesheet"
	type="text/css" />
<link href="style/restaurant/culture-place.css" rel="stylesheet"
	type="text/css" />
<link href="style/restaurant/culture-gathering.css" rel="stylesheet"
	type="text/css" />
<link href="style/restaurant/review.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="style/restaurant/detail.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "get",
			url : "searchjjim.restaurant",
			data : {
				name : "${name}"
			},
			success : function(data) {
				// 회원이 이미 좋아요를 했다면 이곳이 동작함
				favorites();
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
				// 회원이지만 즐겨찾기를 하지않았거나, 비회원인 경우
				// 비워진 하트 채우기
				Unfavorites();
			}
		})
	})
	function favorites() {
		var i = $(".Unfavorites").index($('#unfa')); // 같은 클래스 내 index 값을 가져옴
		document.getElementsByClassName('Unfavorites')[i].style.display = "none"; // 즐겨찾기 취소 버튼 비활성화
		document.getElementsByClassName('Favorites')[i].style.display = "inline"; // 즐겨찾기 추가 버튼 활성화
	}
	// 즐겨찾기 해제
	function Unfavorites() {
		var i = $(".Favorites").index($('#fa')); // 같은 클래스 내 index 값을 가져옴
		document.getElementsByClassName('Unfavorites')[i].style.display = "inline"; // 즐겨찾기 취소 버튼 비활성화
		document.getElementsByClassName('Favorites')[i].style.display = "none"; // 즐겨찾기 추가 버튼 활성화
	}

	function doFavorite() {
		$.ajax({
			type : "get",
			url : "addJjim.restaurant",
			data : {
				name : "${name}",
				addr : "${addr}"
			},
			success : function(data) {
				// 회원이 이미 좋아요를 했다면 이곳이 동작함
				swal("즐겨찾기가 추가되었습니다.", "", "success");
				favorites();
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
				// 좋아요 하기 실패, 잠시 후 다시 시도해주세요
			}
		})
	}

	function deleteFavorite() {
		$.ajax({
			type : "get",
			url : "deleteJjim.restaurant",
			data : {
				name : "${name}",
				addr : "${addr}"
			},
			success : function(data) {
				// 회원이 이미 좋아요를 했다면 이곳이 동작함
				swal("즐겨찾기가 취소되었습니다.", "", "success");
				Unfavorites();
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
				// 좋아요 삭제 실패 잠시 후 다시 시도해주세요
				alert("잠시후 다시 시도해주세요")
			}
		})
	}
</script>
</head>

<body>
   <header>
      <!-- header -->
      <%
      pageContext.include("/WEB-INF/views/include/header.jsp");
      %>
   </header>



	<article class="pro">
		<div class="product">
			<div class="view" style="background-image:url(${imageUrl})"></div>
		</div>
		<div class="col-md-6">
			<div class="product-dtl">
				<div class="product-info">
					<div class="product-name">
						<h2>${name }</h2>
						<div class="jjim">
							<span class="rating-star"> <span class="Unfavorites"
								value="Unfavorites" style="display: inline;" id="unfa"
								onclick="doFavorite()"> <img src="images/빈하트.png"></span>
								<span class="Favorites" value="Favorites" style="display: none;"
								id="fa" onclick="deleteFavorite()"><img
									src="https://cdn.pixabay.com/photo/2014/04/02/10/47/red-304570_1280.png">
							</span>
							</span>
						</div>
					</div>
					<div></div>

				</div>
				<p>
					<strong>주소 </strong>${ addr}<br> <strong>분류</strong>
					${category}<br> <strong>전화번호</strong> ${phone}
				</p>
				<div class="selectioncss">

		<%-- 			<div class="list-gathering">
						<div class="list-context">

						
							<div class="comment-section review-margin">
								<span>댓글</span>
								<textarea name="comment" form="comment-form" cols="40" rows="1"
									maxlength=""></textarea>
								<form action="restaurant-comment-write.restaurant"
									id="comment-form">
									<input type="submit" value="완료" class="culture-btn"> <input
										type="hidden" name="mbNo" value="${oneGathering.mbNo}">
									<input type="hidden" name="memid" value="MEM_ID1">
									<!-- 수정해야함 -->
								</form>
							</div>

							<div class="comment-list">
								<c:forEach items="${comment}" var="cm">
									<div class="person-information">
										<img src='images/man2.svg' class="profile">
										<div class="nickname-date">
											<span class="nickname">${cm.memNic}</span> <span class="date">${cm.mrCreatedAt}</span>
										</div>
									</div>
									<p class="comment-body">${cm.mrComment}</p>
									<hr>
								</c:forEach>
							</div>
						</div>
					</div> --%>

					<div class="product-count"></div>
				</div>
			</div>
		</div>
	</article>
	</article>

   <footer>
      <!-- footer -->
      <%
      pageContext.include("/WEB-INF/views/include/footer.jsp");
      %>
   </footer>
</body>
<!-- <script src="basic.js"></script> -->
</html>
