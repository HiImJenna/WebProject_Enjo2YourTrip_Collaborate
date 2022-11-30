<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>승객 정보 입력</title>
    
    <link rel="stylesheet" href="style/flight/passengerInfo.css">    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

    <!-- ********* codepen ************* -->   
    <!-- <script type="text/javascript" src="codepen.js"></script> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="style/common.css" rel="stylesheet" type="text/css" />
	<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
</head>
<body>

	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>


<!-- 승객수 -->
<!-- <b>승객 수</b>
	 <form name = passNm action = "finalCheck.flight" method = "GET" > 
		<select style="width: 10%;">
		  <option value="0" name = "1">성인 1명</option>
		  <option value="1" name = "tadult" id = "tadult">성인 2명</option>
		  <option value="1" name = "sadult" id = "sadult">성인 3명</option>
		  <option value="1" name = "fadult" id = "fadult">성인 4명</option>
		</select>
	  </form>
 -->
 
<!-- 입력 폼 시작 -->
<div class = "whole">
 	 <form name = passInfo action = "totalCheck.flight" method = "GET"> 
		<div id="search-form">
		
		    <div id="header">
		      <h1><b>승객 정보 입력</b></h1>
		    </div>
		    
		    <section>
		      <div class="flight" id="flightbox">
		        
					<!-- 찐 입력란 -->        										
					  <div id="flight-depart">
					  
					    <div class="info-box">
					      <label for="passSnm">승객 성</label>
					      <input type="text" name="passSnm" id="passSnm" placeholder="SON" onfocus="this.placeholder=''" onblur="this.placeholder='SON'"  required  />
					    </div>
					    
					    <div class="info-box" id="arrive-box">
					      <label for="passLnm">승객 이름</label>
					      <input type="text" name="passLnm" id="passLnm" placeholder="JEONGWON" onfocus="this.placeholder=''" onblur="this.placeholder='JEONGWON'" required />
					    </div>
					    
					  </div>
					
					
					  <div id="flight-dates">
					    
						    <div class="info-box">
						      <label for="">생년월일 (YYYYMMDD)</label>
						      <input type="text" name="bday" id="bday" placeholder="19970279" onfocus="this.placeholder=''" onblur="this.placeholder='19970279'" required/>
						    </div>
						    
						    <div class="info-box" id="return-box">
						      <label for="nation">국적</label>
						      <select name="nation">
						        <option value="Republic of Korea, 대한민국">Republic of Korea, 대한민국</option>
						        <option value="UK, 영국">UK, 영국</option>
						        <option value="US, 미국">US, 미국</option>
						        <option value="Spain, 스페인">Spain, 스페인</option>
						      </select>
						    </div>
					  	</div>
		    
					  
					  <div id="flight-info">
					  
					
 					    <div class="gender-box">
					      <label for="class-type" style="color: #6B6A6A;">성별</label>
					       <input type="radio" id="male" name="gender" value="남" checked="checked" r>
					      <label >남</label><br>
					       <input type="radio" id="female" name="gender" value="여">
					      <label >여</label><br>
					    </div>
							
		
					  <div id="flight-search">
					    <div class="info-box-submit" >
					      <input type="button" id="submitPass" value="확인" onclick = "check(this.form)";/>
<!--  				      <input type="submit" id="submitPass" value="확인" onclick = "check(); return false;"/> -->
					      
					    </div>												
					  </div>
				 </div>
			 </section> 
		</div>	 

		 <!-- 가는 편 정보 들고있기  -->
		<input type = "hidden" id = "sdateM" name = "sdateM" value = "${sdateM}"/>
		<input type = "hidden" id = "sairlineNm" name = "sairlineNm" value = "${sairlineNm}"/>
		<input type = "hidden" id = "sdepPlandTime" name = "sdepPlandTime" value = "${sdepPlandTime}"/>
		<input type = "hidden" id = "sarrPlandTime" name = "sarrPlandTime" value = "${sarrPlandTime}"/>
		<input type = "hidden" id = "sprice" name = "sprice" value = "${sprice}"/>
	
		<!-- 오는 편 정보 들고있기 -->
		<input type = "hidden" id = "edateM" name = "edateM" value = "${edateM}"/>
		<input type = "hidden" id = "eairlineNm" name = "eairlineNm" value = "${eairlineNm}"/>
		<input type = "hidden" id = "edepPlandTime" name = "edepPlandTime" value = "${edepPlandTime}"/>
		<input type = "hidden" id = "earrPlandTime" name = "earrPlandTime" value = "${earrPlandTime}"/>
		<input type = "hidden" id = "eprice" name = "eprice" value = "${eprice}"/>

	</form> 	      
</div>
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>


</body>

<script type="text/javascript">



function check(form) {
	console.log("function check()");
	let passSnm = $('#passSnm').val();
	let passLnm = $('#passLnm').val();
	let bday = $('#bday').val();
	
	let checkBd = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/; 
	let checkNm = /^[A-Z]+$/; //이름 영문

	if(passSnm == "") {
	   	swal ( "잠깐!" ,  "승객 성을 입력해주세요.!" ,  "error" )
		return ;
	}

	if(passLnm == "") {
	   	swal ( "잠깐!" ,  "승객 이름을 입력해주세요.!" ,  "error" )
		return ;
	}
	
	if(bday == "") {
	   	swal ( "잠깐!" ,  "생년월일을 입력해주세요.!" ,  "error" )
		return ;
	}  

	if(!checkNm.test(passSnm)) {
	   	swal ( "잠깐!" ,  "승객 성은 영문 대문자만 입력 가능합니다.!" ,  "error" )
		return ;
	}
	
	if(!checkNm.test(passLnm)) {
	   	swal ( "잠깐!" ,  "승객 이름은 영문 대문자만 입력 가능합니다.!" ,  "error" )
		return ;
	}
	
	
	
	if(!checkBd.test(bday)) {
	   	swal ( "잠깐!" ,  "생년월일을 숫자 8자리로 재입력해주세요.!" ,  "error" )
		return true;
	}
	
	form.submit();

}

</script>




</html>