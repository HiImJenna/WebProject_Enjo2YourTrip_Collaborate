<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- ********* main css ************* -->
<link rel="stylesheet" href="style/flight/flight_main.css">
<!-- <link rel="stylesheet" href="flight_main.js"> -->


<!-- ********* JQuery datepicker css ************* -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="datepickerCss.css"> -->

<!-- ********* codepen ************* -->
<!-- <script type="text/javascript" src="codepen.js"></script> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

<title>항공권 검색</title>
</head>

<!-- ().datepicker -->
<script>
    $(function(){
        $('#dp').datepicker({
            lang:'ko',
            dateFormat: 'yy-mm-dd',
            monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //달력의 월 부분 텍스트
            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //달력의 월 부분 Tooltip
            dayNamesMin: ['일','월','화','수','목','금','토'], //달력의 요일 텍스트
            dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'], //달력의 요일 Tooltip
            buttonText: "선택",
            minDate: "-0D", //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
           maxDate: "+2M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
        });
        
        //초기값을 오늘 날짜로 설정
        $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후) 
    })
    $(function(){
        $('#dp1').datepicker({
            lang:'ko',
            dateFormat: 'yy-mm-dd',
            monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //달력의 월 부분 텍스트
            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'], //달력의 월 부분 Tooltip
            dayNamesMin: ['일','월','화','수','목','금','토'], //달력의 요일 텍스트
            dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'], //달력의 요일 Tooltip
            buttonText: "선택",
            minDate: "-0D", //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
           maxDate: "+5M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
        });
        
        //초기값을 오늘 날짜로 설정
        $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후) 
    })   
</script>

<body>
	<!-- 배경 -->
	<div class="mainbackground">
		<div class="intro">
			<h1 class="intromessage">
				<b>설레는 제주 여행의 시작!</b>
			</h1>
			<br>
			<h2 class="intromessage">
				<b>Enjo2</b>
			</h2>
		</div>
	</div>

	<!-- 예약 폼 -->
	<div class="booking">
		<div class="dest-airport">

			<div class="final-airport">
				<div class="eng-airportname">
					<h1 class="eng-airportdiv">
						<b>ICN</b>
					</h1>
				</div>
				<h4 class="kor-airportdiv">인천</h4>
			</div>

			<i class="fa-solid fa-plane-departure fa-2x"
				style="margin-top: 60px; margin-left: 10px;"></i>

			<div class="final-airport2">
				<div class="eng-airportname">
					<h1 class="eng-airportdiv">
						<b>CJU</b>
					</h1>
				</div>
				<h4 class="kor-airportdiv">제주</h4>
			</div>

		</div>

		<div class="booking-input date">
			<input type="button" class="datebutton" name="dp" id="dp"
				value="  가는 날  " autocomplete="off"></input> <i
				class="fa-regular fa-calendar-days"></i>
		</div>

		<div class="booking-input date">
			<input type="button" class="datebutton" name="dp" id="dp1"
				value="  오는 날  " autocomplete="off"></input> <i
				class="fa-regular fa-calendar-days"></i>
		</div>

		<button href="#" class="booking-submit"
			onclick="location.href='../second/second.html'">항공권 검색</button>
	</div>

	<!-- 광고 -->
	<div class="ad">

		<div class="admat">
			<h4 style="text-align: center;">#제주도 맛집 보러가기</h4>
			<img src="/main/food.png" alt="맛집카테고리" class="adimg"
				onclick="location.href='../second/second.html'">
		</div>

		<div class="adfev">
			<h4 style="text-align: center;">#제주도 문화 행사 보러가기</h4>
			<img src="/main/food.png" alt="문화카테고리" class="adimg"
				onclick="location.href='../second/second.html'">
		</div>
	</div>
</body>
</html>