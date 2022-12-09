<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>check</title>

    <!-- ********* main css ************* -->
    <link rel="stylesheet" href="style/flight/flightCheck.css">    
    <link href="style/common.css" rel="stylesheet" type="text/css" />
	<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
    
    <!-- ********* codepen ************* -->   
    <script type="text/javascript" src="codepen.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

</head>

<body>

	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

    <!-- 배경 -->
    <div class = "mainbackground">
        <div class = "intro">
            <h1 class = "intromessage"><b>고객님의 항공편 정보를<br> 확인해주세요!</b></h1><br>
        </div>
    </div>    

    <!-- 예약정보 -->
   <form name = flightCheck action = "passengerInfo.flight" method = "GET">
	    <div class = passticket>
	        <div class="cardWrap">
	          <div class="card cardLeft">
	          	
	          	<b>가는 편</b><input type = "text" name = "sdateM" value = "${sdateM}" readonly style = "background: transparent; text-align:left; color: white; border: 0; margin-left: 10px; outline: none; "/>
	            
	            <div class="title">
		            <input type = "text" name = "sairlineNm" value = "${sairlineNm}" readonly style = "background: transparent; text-align:left; border: 0; outline: none;  font-size: 30px; margin-bottom: 10px;"/>
	            </div>
	            
	            <div class="name">
	                <h2>GMP</h2>
	                <span>김포</span>
	                <h2>CJU</h2>
	                <span>제주</span>
	            </div>
	    
	            <div class="seat-time-container">
	
	                  <div class="seat">
	                  	<input type = "text" name = "sdepPlandTime" value = "${sdepPlandTime}" readonly style = "background: transparent; text-align:left; border: 0; width: 50px; outline: none;">
	                    <span>출발</span>
	                  </div>
	
	                  <div class="time">
	                  	<input type = "text" name = "sarrPlandTime" value = "${sarrPlandTime}" readonly style = "background: transparent; text-align:left; border: 0; width: 50px; outline: none;">
	                    <span>도착</span>
	                  </div>

		              <div class="time">
		                  	<input type = "text" name = "sprice" value = "${sprice}" readonly style = "background: transparent; text-align:right; border: 0; width: 200px; outline: none; color: red">
		              </div>
	            </div>
	            
	          </div>
	      </div>
	    
	        <div class="cardWrap">
	          <div class="card cardLeft">
	          	
	          	<b>오는 편</b><input type = "text" name = "edateM" value = "${edateM}" readonly style = "background: transparent; text-align:left; color: white; border: 0; margin-left: 10px; outline: none; "/>
	            
	            <div class="title">
		            <input type = "text" name = "eairlineNm" value = "${eairlineNm}" readonly style = "background: transparent; text-align:left; border: 0; outline: none;  font-size: 30px; margin-bottom: 10px;"/>
	            </div>
	            
	            <div class="name">

	                <h2>CJU</h2>
	                <span>제주</span>
	                <h2>GMP</h2>
	                <span>김포</span>
	            </div>
	    
	            <div class="seat-time-container">
	
	                  <div class="seat">
	                  	<input type = "text" name = "edepPlandTime" value = "${edepPlandTime}" readonly style = "background: transparent; text-align:left; border: 0; width: 50px; outline: none;">
	                    <span>출발</span>
	                  </div>
	
	                  <div class="time">
	                  	<input type = "text" name = "earrPlandTime" value = "${earrPlandTime}" readonly style = "background: transparent; text-align:left; border: 0; width: 50px; outline: none;">
	                    <span>도착</span>
	                  </div>

		              <div class="time">
		                  	<input type = "text" name = "eprice" value = "${eprice}" readonly style = "background: transparent; text-align:right; border: 0; width: 200px; outline: none; color: red">
		              </div>
	            </div>
	            
	          </div>
	      </div>



	    </div>
	    
	  
	
	    <!-- 버튼 -->
	    <div class = "button">
	        <button href="#" class="booking-submit">확인</button>    
    	</div>
   </form>
   <footer>
   
   	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
   </footer>
   
</body>
</html>