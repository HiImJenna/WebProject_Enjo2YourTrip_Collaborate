<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종 예약정보 확인</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="style/flight/totalCheck.css">    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body>
<%-- 
<form name = totalCheck22 action = "payment22.flight" method = "GET" > 
	[가는편]<br>
	날짜 : <input type = "text" name = "sdateM" value = "${sdateM}" readonly><br>
	항공 : <input type = "text" name = "sairlineNm" value = "${sairlineNm}" readonly><br>
	출발 : <input type = "text" name = "sdepPlandTime" value = "${sdepPlandTime}" readonly><br>
	도착 : <input type = "text" name = "sarrPlandTime" value = "${sarrPlandTime}" readonly><br>
	가격 : <input type = "text" name = "sprice" value = "${sprice}" readonly><br>
	<br>
	--------------------------------
	<br>
	[오는편]<br>
	날짜 : <input type = "text" name = "edateM" value = "${edateM}" ><br>
	항공 : <input type = "text" name = "eairlineNm" value = "${eairlineNm}" readonly><br>
	출발 : <input type = "text" name = "edepPlandTime" value = "${edepPlandTime}" readonly><br>
	도착 : <input type = "text" name = "earrPlandTime" value = "${earrPlandTime}" readonly><br>
	가격 : <input type = "text" name = "eprice" value = "${eprice}" readonly><br>
	<br>
	--------------------------------
	<br>
	[승객정보]<br>
	승객 성 : <input type = "text" name = "passSnm" value = "${passSnm}" readonly><br>
	승객 이름 : <input type = "text" name = "passLnm" value = "${passLnm}" readonly><br>
	생년월일 : <input type = "text" name = "bday" value = "${bday}" readonly><br>
	국적 : <input type = "text" name = "nation" value = "${nation}" readonly><br>
	성별 : <input type = "text" name = "gender" value = "${gender}" readonly><br>

	<input type="submit" name = "paySubmit" id="paySubmit" value = "예"/>
</form>

 --%>
 
     <!-- 배경 -->
    <div class = "mainbackground">
        <div class = "intro">
            <h2 class = "intromessage"><b>항공편 및 승객 정보를 확인하고 </b></h2><br>
            <h2 class = "intromessage"><b>결제를 원하시면 '예' 버튼을 눌러주세요.</b></h2> 
        </div>
    </div>    
 

<form name = totalCheck action = "payment.flight" method = "POST" > 
 
 	<div class = passticket>
		<table class="table">
		  <thead style = "color: #f05542">
			  <th scope="col"> </th>
			  <th scope="col">날짜</th>
		  	  <th scope="col">항공사</th>
		      <th scope="col">출발지</th>
		      <th scope="col">도착지</th>
		      <th scope="col">출발시간</th>
		      <th scope="col">도착시간</th>
		      <th scope="col">가격</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr style = "width: 50px;">
		      <th scope="row"style = "color: #f05542">가는 편</th>
		      <td>${sdateM}</td>
		      <td>${sairlineNm}</td>
		      <td>김포</td>
		      <td>제주</td>
		      <td>${sdepPlandTime}</td>
		      <td>${sarrPlandTime}</td>
		      <td>${sprice}</td>
		    </tr>
		     <tr style = "width: 50px;">
		      <th scope="row"style = "color: #f05542">오는 편</th>
		      <td>${edateM}</td>
		      <td>${eairlineNm}</td>
		      <td>제주</td>
		      <td>김포</td>
		      <td>${edepPlandTime}</td>
		      <td>${earrPlandTime}</td>
		      <td>${eprice}</td>
		    </tr>
		    
			</tbody>	  
		</table>
		
		<table class="table">
		  <thead style = "color: #f05542">
			  <tr>
				  <th scope="col"> </th>
				  <th scope="col">승객 성</th>
			  	  <th scope="col">승객 이름</th>
			      <th scope="col">생년월일</th>
			      <th scope="col">국적</th>
			      <th scope="col">성별</th>
			    </tr>
		  </thead>
		  		  <tbody>
		    <tr style = "width: 50px;">
		      <th scope="row" style = "color: #f05542">승객 정보</th>
		      <td>${passSnm}</td>
		      <td>${passLnm}</td>
		      <td>${bday}</td>
		      <td>${nation}</td>
		      <td>${gender}</td>
		    </tr>
		  </tbody>
		</table>
</div>
 	
	    <div class = "button">
	        <button href="#" class="booking-submit">확인</button>    
    	</div>
    	
	<input type = "hidden" id = "sdateM" name = "sdateM" value = "${sdateM}">
	<input type = "hidden" id = "sairlineNm" name = "sairlineNm" value = "${sairlineNm}">
	<input type = "hidden" id = "sdepPlandTime" name = "sdepPlandTime" value = "${sdepPlandTime}">
	<input type = "hidden" id = "sarrPlandTime" name = "sarrPlandTime" value = "${sarrPlandTime}">
	<input type = "hidden" id = "sprice" name = "sprice" value = "${sprice}">
	
	<input type = "hidden" id = "edateM" name = "edateM" value = "${edateM}">
	<input type = "hidden" id = "eairlineNm" name = "eairlineNm" value = "${eairlineNm}">
 	<input type = "hidden" id = "edepPlandTime" name = "edepPlandTime" value = "${edepPlandTime}">
	<input type = "hidden" id = "earrPlandTime" name = "earrPlandTime" value = "${earrPlandTime}">
 	<input type = "hidden" id = "eprice" name = "eprice" value = "${eprice}">
 	
	<input type = "hidden" id = "passSnm" name = "passSnm" value = "${passSnm}">
	<input type = "hidden" id = "passLnm" name = "passLnm" value = "${passLnm}">
	<input type = "hidden" id = "bday" name = "bday" value = "${bday}">
    <input type = "hidden" id = "nation" name = "nation" value = "${nation}">
    <input type = "hidden" id = "gender" name = "gender" value = "${gender}">	
    	
    	
</form>
 
</body>



</html>