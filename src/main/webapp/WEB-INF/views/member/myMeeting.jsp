<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/header-footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
	type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="modal">
		<!-- <div><img src="images/close.svg" style="cursor: pointer;"></div> -->
		<div class="list-gathering" style="background-color: #ffff">
			<div class="list-summary-top">
				<div class="person-information">
					<img src="images/man2.svg" class="profile" />
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
			<hr />
			<div class="list-summary-button">
				<div class="comment">
					<iconify-icon inline icon="bx:message" style="color: #8e8e8e"
						width="15" height="15"></iconify-icon>
					<span class="comment-number">10</span>
				</div>
				<div class="participant-list">
					<img src="images/man3.svg" class="profile" /> <img
						src="images/man4.svg" class="profile participant-1" /> <img
						src="images/man5.svg" class="profile participant-2" /> <span
						class="participant-number">+3</span>
				</div>
			</div>
			<div class="comment-section">
				<span>댓글</span>
				<textarea name="comment" form="comment-form" cols="40" rows="1"
					maxlength=""></textarea>
				<form action="" id="comment-form">
					<input type="submit" value="완료" class="culture-btn" />
				</form>
			</div>
			<div class="comment-list">
				<div class="person-information">
					<img src="images/man2.svg" class="profile" />
					<div class="nickname-date">
						<span class="nickname">마이클</span> <span class="date">2022/12/01</span>
					</div>
				</div>
				<p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
				<hr />
				<div class="person-information">
					<img src="images/man2.svg" class="profile" />
					<div class="nickname-date">
						<span class="nickname">마이클</span> <span class="date">2022/12/01</span>
					</div>
				</div>
				<p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
				<hr />
				<div class="person-information">
					<img src="images/man2.svg" class="profile" />
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
					<li>예매</li>
				</a>
				<a href="${request.getContextPath}myMeeting.do">
					<li class="sub-heading">모임</li>
				</a>

			</ul>
			<table class="culture-table">
				<thead>
					<tr>
						<td>문화 시설명</td>
						<td>주소</td>
						<td>주제분류</td>
						<td>무료구분</td>
						<td>전화번호</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>경희대학교</td>
						<td>서울특별시 동대문구 경희대로 26</td>
						<td>기타</td>
						<td></td>
						<td>02)961-0114</td>
					</tr>
					<tr>
						<td>경희대학교</td>
						<td>서울특별시 동대문구 경희대로 26</td>
						<td>기타</td>
						<td></td>
						<td>02)961-0114</td>
					</tr>
					<tr>
						<td>경희대학교</td>
						<td>서울특별시 동대문구 경희대로 26</td>
						<td>기타</td>
						<td></td>
						<td>02)961-0114</td>
					</tr>
					<tr>
						<td>경희대학교</td>
						<td>서울특별시 동대문구 경희대로 26</td>
						<td>기타</td>
						<td></td>
						<td>02)961-0114</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>
