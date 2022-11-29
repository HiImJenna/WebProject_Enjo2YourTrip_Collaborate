<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>김포-제주행 항공편 검색</title>
    <link href="https://fonts.googleapis.com/css?family=Jockey+One" rel="stylesheet">


    <!-- ********* main css ************* -->
    <link rel="stylesheet" href="style/flight/departSearch.css">
    
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

<!-- 예약 부분 -->
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
      <th scope="row" style = "color: #f05542">가는 편</th>
      <td>${sdateM}</td>
      <td>${sairlineNm}</td>
      <td>김포</td>
      <td>제주</td>
      <td>${sdepPlandTime}</td>
      <td>${sarrPlandTime}</td>
      <td>${sprice}</td>
    </tr>  
  </tbody>
</table>
</div>


<!-- ********************************************************************************************************* -->

<div class="maincontent overlay ">
    <br />
    <br />

    <div class="flightList container">
      <div class="choosehead text-center">
        <h2 style = "color: #f38375; "><b>김포-제주행 비행기를 선택해주세요!</b></h2>             
      </div>


      <!-- Flight Header -->
      <div class="row flightHeader">
          <div class="col-sm-2">
            <h4 class="text-center"><b>항공사</b></h4>
          </div>

          <div class="col-sm-2">
            <h4 class="text-center"><b>출발지</b></h4>
          </div>

          <div class="col-sm-2">
            <h4 class="text-center"><b>도착지</b></h4>
          </div>

          <div class="col-sm-2">
            <h4 class="text-center"><b>출발시간</b></h4>
          </div>

          <div class="col-sm-2">
              <h4 class="text-center"><b>도착시간</b></h4>
            </div>
    
          <div class="col-sm-2">
            <h4 class="text-center"><b>가격</b></h4>
           </div>  
 
      </div>

      <!-- Flight List -->
      <div class="flightsMain">

        <!--리스트 감싸는 큰 네모-->
	      <div class="allFlights" id="allFlights">
	      </div>
	      
	  </div>
  	</div>
  	
<div class = "pageNm" id = "pages">
	<input type = "button" name = "page1" value = "1" style = "background-color: #ef6351; color: white; width: 20px;" onclick = "showFlight(1)" />
	<input type = "button" name = "page2" value = "2" style = "background-color: #ef6351; color: white; width: 20px;" onclick = "showFlight(2)"/>
	<input type = "button" name = "page3" value = "3" style = "background-color: #ef6351; color: white; width: 20px;" onclick = "showFlight(3)"/>
	<input type = "button" name = "page4" value = "4" style = "background-color: #ef6351; color: white; width: 20px;" onclick = "showFlight(4)"/>
	<input type = "button" name = "page5" value = "5" style = "background-color: #ef6351; color: white; width: 20px;" onclick = "showFlight(3)"/>

</div>
<footer>
<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>


</footer>
</body>

<script>


$(function(){
	showFlight(1);
 });

function showFlight(num){
	$.ajax(
	        {
	          type : "GET",
	          url: "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getFlightOpratInfoList",
	          data: {
	              serviceKey: "GQQu2jLNiimD9+JTylo+hYUp/3Xf2JUEu4OtbZ/FdMQB78YGVo5XWjdQbUlEatM1k8lUQGrzcMtXRwmuJtY7dQ==",
	              _type : "json",
	              depAirportId: "NAARKSS",
	              arrAirportId: "NAARKPC",
	              depPlandTime: "${sdateF}",
	              numOfRows: 10,
	              pageNo: num,
	              
	          },
	          success: function (responsetext) {//응답이 왔고 .. 그 응답이 정상건이라면 자동호출 콜백
				
	        	  console.log(responsetext);
	              const list = responsetext.response.body.items.item;
	             
	              $('#allFlights').empty();

	              for(let i = 0; i < list.length; ++i) {
	                const item = list[i];

	        		/* action="returnSearch.flight?name=${item.airlineNm}" 
	        		   board_content.jsp 참고
	        		*/
	        		const dep = changeTime(item.depPlandTime);
	        		const arr = changeTime(item.arrPlandTime);
	        		const tempPrice = 50300 + 980*i

	        		const price = tempPrice.toString()
	        		  .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	        		
	                let tempHtml = `
	                				<form class="row flight 4563" name = "flightList" action="returnSearch.flight" method="GET">
		                	
		                				<div class="air-container">
		                					<div class="col-sm-2">
		                				  	  <input type = "text" name = "sairlineNm" value = \${item.airlineNm} readonly style = "background: transparent; text-align:center; font-size: 22px;">
		                					</div>
		                					
		                					<div class="col-sm-2">
		                				   	 <input type = "text" name = "sdepAirportNm" value = \${item.depAirportNm} readonly style = "background: transparent; text-align:center; font-size: 22px;">
		                				   	</div>
		                				   	
		                				   	<div class="col-sm-2">
		                				   	 <input type = "text" name = "sarrAirportNm" value = \${item.arrAirportNm} readonly style = "background: transparent; text-align:center; font-size: 22px;">
		                				   	</div>
		                				   	
		                				   	<div class="col-sm-2">
		                				   	 <input type = "text" name = "sdepPlandTime" value = \${dep} readonly style = "background: transparent; text-align:center; font-size: 22px;">
		                				   	</div>
		                				   	
		                				   	<div class="col-sm-2">
		                				    	<input type = "text" name = "sarrPlandTime" value = \${arr} readonly style = "background: transparent; text-align:center; font-size: 22px; ">
		                				    </div>
		                				    
		                				    <div class="col-sm-2">
		                				   	 	<input type = "text" name = "sprice" value = \${price}원 readonly style = "background: transparent; text-align:center; font-size: 22px; color: red;">
		                				   	</div>
		                				   	
		                				    <input type = "submit" value = "선택">
		                				</div>
		                				
		                				<input type = "hidden" id = "sdateM" name = "sdateM" value = "${sdateM}">
		                				<input type = "hidden" id = "edateM" name = "edateM" value = "${edateM}">
		                				
		                				<input type = "hidden" id = "sdateF" name = "sdateF" value = "${sdateF}">
		                				<input type = "hidden" id = "edate2" name = "edateF" value = "${edateF}">
			
		                				
		                             </form>
	                                `
	                            
	                 $('#allFlights').append(tempHtml);
	              }
	             

	              
	            },
	        }
    );
}

  
	function changeTime(obj) {
		const time = obj.toString();

		let result = time.substr(8, 8);

		timeresult = result.substr(0, 2) + ":" +  result.substr(2)
		
		return timeresult;
	}
	
</script>




</html>

