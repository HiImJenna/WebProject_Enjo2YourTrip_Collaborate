<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>항공권 검색</title>

    <!-- ********* main css ************* -->
    <link rel="stylesheet" href="style/flight/flight_main.css">

    <!-- ********* JQuery datepicker css ************* -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400" rel="stylesheet">
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- ********* JQuery datepicker css ************* -->
<!--     <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="datepickerCss.css">
 -->
    <!-- ********* codepen ************* -->   
<!--      <script type="text/javascript" src="codepen.js"></script>
 -->    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>


</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

    <!-- 배경 -->
    <div class = "mainbackground">
        <div class = "intro">
            <h1 class = "intromessage"><b>설레는 제주 여행의 시작!</b></h1><br>
            <h2 class = "intromessage"><b>Enjo2</b></h2> 
        </div>
    </div>    
    

    <!-- 예약 폼 -->
    <div class = "booking">
        <div class = "dest-airport">

            <div class = "final-airport">
                <div class = "eng-airportname">
                    <h1 class = "eng-airportdiv"><b>GMP</b></h1>
                </div>
                <h4 class = "kor-airportdiv" >김포</h4>
            </div>

                <i class="fa-solid fa-plane-departure fa-2x" style="margin-top: 60px; margin-left: 10px;"></i>

            <div class = "final-airport2">
                <div class = "eng-airportname">
                    <h1 class = "eng-airportdiv"><b>CJU</b></h1>
                </div>
                <h4 class = "kor-airportdiv">제주</h4>
            </div>

        </div>
        <form name = "bookingform" action="${pageContext.request.contextPath}/departSearch.flight">
	         <div class="booking-input date">
	             <input type="text" class="datebutton" name="sdateM" id="sdateM" value = "가는 날" readonly/>
	             <i class="fa-regular fa-calendar-days"></i>
	         </div>
	
	         <div class="booking-input date">
	             <input type="text" class="datebutton" name="edateM" id="edateM" value = "오는 날" readonly/>
	             <i class="fa-regular fa-calendar-days"></i>
	         </div>
	         <input type="button" value = "항공권 검색" href="#" class="booking-submit" onclick="search()"/> 
	      </form>   
    </div>

    <!-- 광고 -->
<!--     <div class = "ad">

        <div class = "admat">
            <h4 style="text-align: center;"># 제주도 맛집 보러가기</h4>
            <a href="mainView.restaurant"><img src="/main/food.png" alt="맛집카테고리" class = "adimg"></a>
        </div>

        <div class = "adfev">
            <h4 style="text-align: center;"># 제주도 문화 행사 보러가기</h4>
            <a href="mainView.restaurant"><img src="/main/food.png" alt="맛집카테고리" class = "adimg"></a>
        </div>
    </div>
 -->
 
    <footer>
      <!-- footer -->
      <%
      pageContext.include("/WEB-INF/views/include/footer.jsp");
      %>
   </footer>
   
</body>



<script type="text/javascript">

															/* datepicker */ 
   $(document).ready(function(){    
        $( "#sdateM,#edateM" ).datepicker({
            changeMonth: true,
            changeYear: true,
            showMonthAfterYear: true,
            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
            dateFormat:'yy-mm-dd',
            minDate: new Date(),
            maxDate: "+2M",
            // showButtonPanel: true,
            closeText:'취소',
            onClose: function () {
                if ($(window.event.srcElement).hasClass('ui-datepicker-close')) {
                    $(this).val('');
                }
            }
    	});
    });

/* 날짜 선택 유효성 검사 */ 

function search() {
	
	console.log("function search()");
	
     let sdateM = $('#sdateM').val();
     let edateM =$('#edateM').val();
    
	//API 요청을 위해 가공 시작
	let sdateF = sdateM;
	let edateF = edateM;
	
	//숫자만 남기기 ('-'제거)
	sdateF = sdateF.replace(/\-/g, "");
	edateF = edateF.replace(/\-/g, "");

     
     console.log("sdateF : " + sdateF);
     console.log("edateF : " + edateF);
     console.log(sdateF - edateF);
    		
     if (sdateM == '가는 날') {
    	 console.log("if (sdateM == '가는 날')");
    	 swal ( "잠깐!" ,  "가는 날을 지정해주세요" ,  "error" )

    	 return ;
     } 
     if(edateM == '오는 날') {
    	 console.log("if(edateM == '오는 날')");
    	 swal ( "잠깐!" ,  "오는 날을 지정해주세요!" ,  "error" )
    	 return ;
     }
     
     if(sdateF-edateF >= 1 ) {
      	console.log("if((sdateM2-edateM2) >= 1 )");
      	swal ( "잠깐!" ,  "가는 날과 오는 날 날짜를 다시 선택해주세요!" ,  "error" )
      	return ;
      }
     
     
     document.bookingform.submit();
     
    
}
 
</script>


</html>