<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/common.js" type="module"></script>
<script src="js/macgyver.js" type="module"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet" type="text/css" />
</head>


<body>

	<div class="modal">
		<!-- <div><img src="images/close.svg" style="cursor: pointer;"></div> -->
		<div class="list-gathering" style="background-color: #ffff;">
			<div class="list-summary-top">
				<div class="person-information">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<div class="nickname">마이클</div>
						<div class="date">2022/12/01</div>
					</div>
				</div>
				<button class="culture-btn">참여하기</button>
			</div>
			<div class="list-context">
				<div class="list-title">제목</div>
				<p class="list-gathering-body">안녕하세요? 모임 게시판 본문입니다.</p>
			</div>
			<hr>
			<div class="list-summary-button">
				<div class="comment">
					<iconify-icon inline icon="bx:message" style="color: #8e8e8e;"
						width="15" height="15"></iconify-icon>
					<span class="comment-number">10</span>
				</div>
				<div class="participant-list">
					<img src='images/man3.svg' class="profile"> <img
						src='images/man4.svg' class="profile participant-1"> <img
						src='images/man5.svg' class="profile participant-2"> <span
						class="participant-number">+3</span>
				</div>
			</div>
			<div class="comment-section">
				<span>댓글</span>
				<textarea name="comment" form="comment-form" cols="40" rows="1"
					maxlength=""></textarea>
				<form action="" id="comment-form">
					<input type="submit" value="완료" class="culture-btn">
				</form>
			</div>
			<div class="comment-list">
				<div class="person-information">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<span class="nickname">마이클</span> <span class="date">2022/12/01</span>
					</div>
				</div>
				<p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
				<hr>
				<div class="person-information">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<span class="nickname">마이클</span> <span class="date">2022/12/01</span>
					</div>
				</div>
				<p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
				<hr>
				<div class="person-information">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<span class="nickname">마이클</span> <span class="date">2022/12/01</span>
					</div>
				</div>
				<p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
			</div>
		</div>
	</div>

	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<!-- main -->
	<div class="culture-container">
		<div class="information-frame">
			<span class="culture-sub-heading">나의 활동</span>
			<ul class="page-category">
				<a href="${request.getContextPath}myFlight.do">
					<li class="sub-heading">예매</li>
				</a>
				</a>
				<a href="${request.getContextPath}myMeeting.do">
					<li>모임</li>
				</a>
			</ul>
			<table class="culture-table" id = "flightBox">
				<thead>
					<tr>
						<td>예약번호</td>
						<td>ID</td>
						<td>예약일시</td>
						<td>승객 이름</td>
						<td>승객 성</td>
						<td>생년월일</td>
						<td>가격</td>
					</tr>
				</thead>
				<tbody id ="flightTable">
				</tbody>
			</table>
			<ul class="paging-btn" id = "pages">
			</ul>
			
		</div>
	</div>

	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>

</body>

<script type="text/javascript">
	/////onload/////
	$(function(){
		showNotice(1);
	});
	
	function showNotice(num){
		$.ajax(
			{
				type: "get",
				url: "myFlightList.flight",
				dataType: "json",
				data:{
					page : num
				},
				success: function(data){
					const flightList = data.flightList;
					console.log(data);
					
					if(noticeList.length > 0){
						$('#flightBox').show();
					} else{
						$('#flightBox').hide();
						return;
					}
					
					$('#flightTable').empty();
					
					for(const flight of flightList){
						let tempHtml = `<tr>
											<td>\${flight.number}</td>
											<td><a href="noticeContent.do?no=\${notice.number}">\${notice.title}</a></td>
											<td>\${flight.writer}</td>
											<td>\${flight.date}</td>
											<td>\${flight.count}</td>
										</tr>`
						$('#flightTable').append(tempHtml);
					}
					
					// 페이징 처리 시작
					$('#pages').empty();	//페이지 리셋
					
					const pageInfo = data.pageInfo;
					// 이전 붙이기
					const start = Number(pageInfo.start)-1;
					if (pageInfo.prev == 1){
						let tempHtml = `<li onclick = "showNotice(\${start})"> 이전 </li>`
						$('#pages').append(tempHtml);
					}
					// 페이지 번호 붙이기
					for(let i = pageInfo.start; i <= pageInfo.end; i++) {
						let tempHtml = `<li onclick = "showNotice(\${i})">\${i}</li>`;
						$('#pages').append(tempHtml);
					}
					// 이후 붙이기
					const end = Number(pageInfo.end) + 1;
					if (pageInfo.next == 1){
						let tempHtml = `<li onclick = "showNotice(\${end})">다음</li>`
						$('#pages').append(tempHtml);
					}
					// 페이징 처리 끝
				},
				error:function (request, status, error){
					console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error)
				}
			}
		)		
	}
</script>

</html>