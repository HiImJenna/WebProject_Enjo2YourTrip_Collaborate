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
			
<!--  	         <input type="button" value = "마이페이지" href="#" onclick="location.href='/WEB-INF/views/member/myMenu.jsp'" class="booking-submit"/> 
 -->	         <input type="button" value = "메인페이지로" href="#" onclick="location.href='index.jsp'" class="booking-submit"/>
        </div>
    </div>    

    <!-- 광고 -->
    <div class = "ad">

    </div>
    
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>


</body>
</html>