<!-- 관리자 페이지 통계 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
   src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<script src="js/macgyver.js" type="module"></script>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>


<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/chart.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
   type="text/css" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
   /* ============================================================================================================== */
   
   $(function() {
      $.ajax({
         type : "GET",
         url : "chart.do",
         data : {},
         success : function(data) {
            console.log(data);
             makeChart(data.categories, data.data);
            makeChart2(data.genderList);
            makeChart3(data.airline);
         },
         error : function() {
            alert("실패2");
         }
      })
   })

    function makeChart(list1, list2) {
      var chart1 = new Highcharts.chart('container2', {
         colors: ['#F05542', '#fc9292', '#555555', '#777777', '#dddddd'],
         chart1 : {
            type : 'line'
         },
         title : {
            text : '< 월별 항공편 예약 총 건수 >'
         },

         xAxis : {
            categories : list1
         },
         yAxis : {
            title : {
               text : '건수 (건)'
            }
         },
         plotOptions : {
            line : {
               dataLabels : {
                  enabled : true
               },
               enableMouseTracking : false,
               responsive: false,
            }
         },
         series : [ {
            name : '예약건수',
            data : list2

         } ]
      })
   }; 

    function makeChart2(genderList) {
      var chart2 = new Highcharts.chart(
            'container1',
            {
               colors: ['#829bed', '#fc9292', '#555555', '#777777', '#dddddd'],
               chart : {
                  plotBackgroundColor : null,
                  plotBorderWidth : null,
                  plotShadow : false,
                  type : 'pie'
               },
               title : {
                  text : '< 항공권 예약 남녀비율 >'
               },
               tooltip : {
                  pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
               },
               accessibility : {
                  point : {
                     valueSuffix : '%'
                  }
               },
               plotOptions : {
                  pie : {
                     allowPointSelect : true,
                     cursor : 'pointer',
                     dataLabels : {
                        enabled : true,
                        format : '<b>{point.name}</b>: {point.percentage:.1f} %'
                     }
                  }
               },
               series : [ {
                  name : '비율',
                  colorByPoint : true,
                  data : genderList
               } ]
               
               
            


            });
   } 
   
   function makeChart3(airline) {
      var chart3 = new Highcharts.chart('container', {
           colors: ['#6274EC', '#9562EC', '#DA62EC', '#EC62B9', '#EC6274', '#EC9562'],

           chart: {
                type: 'column'
              },
              title: {
                align: 'left',
                text: '항공사별 총 예매건 수'
              },
              subtitle: {
                align: 'center',
                text: ''
              },
              accessibility: {
                announceNewData: {
                  enabled: true
                }
              },
              xAxis: {
                type: 'category'
              },
              yAxis: {
                title: {
                  text: '항공사별 총 예매건 수'
                }

              },
              legend: {
                enabled: false
              },
              plotOptions: {
                series: {
                  borderWidth: 0,
                  dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}건'
                  }
                }
              },

              tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}건</b> of total<br/>'
              },

              series: [
                {
                  name: "항공사",
                  colorByPoint: true,
                  data: airline
                  }
              ],
             
            });
   }
   
   
   
</script>

</head>
<body>
   <!-- header -->
   <%
   pageContext.include("/WEB-INF/views/include/header.jsp");
   %>

	<!-- main -->
	<div class="culture-container"></div>
	<div class="information-frame">
		<span class="culture-sub-heading">서비스정보</span>
		<ul class="page-category">
			<a href="${request.getContextPath}management.do?type=notice">
				<li>공지사항</li>
			</a>
			<a href="${request.getContextPath}management.do?type=qna">
				<li>문의사항</li>
			</a>
			<c:choose>
				<c:when test="${sessionScope.userid eq 'admin'}">
					<a href="${request.getContextPath}management.do?type=chart">
						<li class="sub-heading">통계</li>
					</a>
					<a href="${request.getContextPath}management.do?type=flight">
						<li>예매관리</li>
					</a>
				</c:when>
			</c:choose>
		</ul>

       <section>
         <div id="chartwrapper1">
            <figure class="highcharts-figure1">
               <div id="container1"></div>
               
            </figure>
         </div>
      </section>
      
      <section>
         <div id="chartwrapper2">
            <figure class="highcharts-figure2">
               <div id="container2"></div>
            </figure>
         </div>
      </section>
      
      <section>
         <div id="chartwrapper3">
            <figure class="highcharts-figure">
                 <div id="container"></div>
                 <p class="highcharts-description"> </p>
            </figure>
         </div>
      </section>
   

   </div>

   <footer>
      <!-- footer -->
      <%
      pageContext.include("/WEB-INF/views/include/footer.jsp");
      %>
   </footer>
</body>
</html>