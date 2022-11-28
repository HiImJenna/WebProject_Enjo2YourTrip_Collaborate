<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확정 페이지</title>
<link rel="stylesheet" href="style/flight/confirm.css">    

</head>
<body>

    <!-- 배경 -->
    <div class = "mainbackground">
        <div class = "intro">
            <h1 class = "intromessage"><b>고객님의 예약이 확정되었습니다.</b></h1><br>
            <h2 class = "intromessage"><b>Enjo2 your trip!</b></h2> 
        </div>
        
		<div id = "flight-search" class="info-box-submit" >
	         <input type="button" value = "마이페이지" href="#" class="booking-submit" onclick="search()"/> 
        </div>
    </div>    

    <!-- 광고 -->
    <div class = "ad">

        <div class = "admat">
            <h4 style="text-align: center;"># 제주도 맛집 보러가기</h4>
            <a href="mainView.restaurant"><img src="style/flight/image/food.jpg" alt="맛집카테고리" class = "adimg"></a>
        </div>

        <div class = "adfev">
            <h4 style="text-align: center;"># 제주도 문화 행사 보러가기</h4>
            <a href="mainView.restaurant"><img src="/main/food.png" alt="맛집카테고리" class = "adimg"></a>
        </div>
    </div>


</body>
</html>