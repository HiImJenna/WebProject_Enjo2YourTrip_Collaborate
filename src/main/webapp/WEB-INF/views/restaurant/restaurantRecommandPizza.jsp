<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="style/restaurant/ranking1.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 	<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script> -->
	<script type="text/javascript">
  	$(function(){
		showJjim(1);
	});
  	function showJjim(num){
  		$.ajax(
  		{
			type: "get",
			url: "jjimList.restaurant",
			dataType : "json",
			data:{
				page : num
			},
			success: function(data){
				const jjimList = data.jjimList;
				console.log(data);
				
				if( jjimList.length>0){
					$('.card').show();
					
				}else{
					$('.card').hide();
					return;
				}
				
				$('#jjimBox').empty();
				
				for(let i=0;i< jjimList.length; ++i){
					
					const jjim = jjimList[i];
	
				let tempHtml = `<div class="box"> <!-- #01 -->
										<!-- Number-->
										<div class="number">\${i+1}</div>
									
										<!-- Name -->
										<div class="name"><span><h2>\${jjim.name}<h2></span></div>
										<div class="name"><span>&nbsp&nbsp&nbsp\${jjim.addr}</span></div>
										<!-- Button -->
										<div  class="link"><a href="recommand.restaurant?&value=\${jjim.name}">상세보기</a></div>
										</div>`
			/* 		let tempHtml = `<tr>
										<td>\${notice.number}</td>
										<td><a href="noticeContent.do?no=\${notice.number}">\${notice.title}</a></td>
										<td>\${notice.writer}</td>
										<td>\${notice.date}</td>
										<td>\${notice.count}</td>
									</tr>` */
					$('#jjimBox').append(tempHtml);
				}
			}
  		}		
  		)
  	}
	</script>
</head>
<body>
   <header>
      <!-- header -->
      <%
      pageContext.include("/WEB-INF/views/include/header.jsp");
      %>
   </header>
  <!-- Card -->
<div class="card">
	<!-- Title -->
	<div class="title">
		<h1>즐겨찾기 목록</h1>
		<p>내가 고른 맛집 확인해보세요</p>
	</div>
	
	<div id="jjimBox">
	<!--Rancking -->
	<!-- <div class="box"> #01
		Number
		<div class="number">01</div>
		Cover
		<div class="cover"><img src="https://pup-review-phinf.pstatic.net/MjAyMjExMTdfMTY1/MDAxNjY4NjQ0MjI4MTc4.1H3tqquvU336gzqER9gusL0BSbNJqknMgOHwKiUY2IEg.x2N9VWVl6Xn1Bqv63Ps1H0j2jjUebry0Dm-ZhtgA-2gg.JPEG/43BECD80-F40B-4121-8A9E-729B9F45371D.jpeg" alt="01"></div>
		Name
		<div class="name"><span>보니스피자펍</span> 이태원 피자펍</div>
		Button
		<div  class="link"><a href="recommand.restaurant?&value=보니스피자법">상세보기</a></div>
	</div>
 </div> -->
 </div>
</div>
   <footer>
      <!-- footer -->
      <%
      pageContext.include("/WEB-INF/views/include/footer.jsp");
      %>
   </footer>
</body>
</html>