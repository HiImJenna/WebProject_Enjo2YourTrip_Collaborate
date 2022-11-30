<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확정 페이지</title>
<link rel="stylesheet" href="style/flight/confirm.css">    
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

    <!-- 배경 -->
    <div class = "mainbackground">
        <div class = "intro">
            <h1 class = "intromessage"><b>고객님의 예약이 확정되었습니다.</b></h1><br>
            <h2 class = "intromessage"><b>Enjo2 your trip!</b></h2> 
        </div>
        
		<div id = "flight-search" class="info-box-submit" >
	         <input type="button" value = "마이페이지" href="#" class="booking-submit"/> 
	         <input type="button" value = "메인페이지" href="index.jsp" class="booking-submit"/>
        </div>
    </div>    

    <!-- 광고 -->
    <div class = "ad">

        <div class = "admat">
            <h4 style="text-align: center;"># 제주도 맛집 보러가기</h4>
            <a href="mainView.restaurant"><img src="images/분식.jpg" alt="맛집카테고리" class = "adimg"></a>
        </div>

        <div class = "adfev">
            <h4 style="text-align: center;"># 제주도 문화 행사 보러가기</h4>
            <a href="mainView.restaurant"><img src="https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/40Qx/image/1e9xDGgVUa1Q4aYS63r68t3Vups.jpg" alt="맛집카테고리" class = "adimg"></a>
        </div>
    </div>
    
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>


</body>
</html>