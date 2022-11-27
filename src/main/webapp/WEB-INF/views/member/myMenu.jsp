<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/menu.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>
	<!-- main -->
	<div class="menu-container">
		<a href="javascript:history.back();">
			<div class="back-btn">
				<iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
			</div>
		</a>
		<div class="user-information">
			<img src="images/big-man.svg" class="profile" /> <span>${nickName} 님</span>
		</div>

		<div class="menu">
			<div>
				<span class="sub-heading">카테고리</span>
			</div>

			<a href="mainView.flight">
				<div class="menu-btn">
					<div class="btn">
						<img src="btn-icon/airplane.svg" /> <span>항공</span>
					</div>
			</a> <a href="mainView.restaurant">
				<div class="btn">
					<img src="btn-icon/famous-restaurant.svg" /> <span>맛집</span>
				</div>
			</a> <a href="${request.getContextPath}       .do">
				<div class="btn">
					<img src="btn-icon/culture-place.svg" width="45" height="45" /> <span>문화공간</span>
				</div>
			</a>
		</div>

		<c:choose>
			<c:when test="${sessionScope.userid ne null}">
				<div>
					<span class="sub-heading">나의활동</span>
				</div>
				<div class="menu-btn">
					<a href="${request.getContextPath}myFlight.do">
						<div class="btn">
							<img src="btn-icon/reservation.svg" /> <span>예매</span>
						</div>
					</a> <a href="${request.getContextPath}myMeeting.do">
						<div class="btn">
							<img src="btn-icon/gathering.svg" /> <span>모임</span>
						</div>
					</a>
				</div>

				<div>
					<span class="sub-heading">관리페이지</span>
				</div>

				<div class="menu-btn">
					<a href="${request.getContextPath}management.do?type=notice">
						<div class="btn">
							<img src="btn-icon/Megaphone.svg" width="45" height="45" /> <span>공지사항</span>
						</div>
					</a> <a href="${request.getContextPath}management.do?type=qna">
						<div class="btn">
							<img src="btn-icon/InformationFile.svg" width="45" height="45" />
							<span>문의사항</span>
						</div>
					</a>
					<c:choose>
						<c:when test="${sessionScope.userid eq 'admin'}">
							<a href="${request.getContextPath}management.do?type=statistics">
								<div class="btn">
									<img src="btn-icon/stats.svg" width="45" height="45" /> <span>통계</span>
								</div>
							</a>
							<a href="${request.getContextPath}management.do?type=flight">
								<div class="btn">
									<img src="btn-icon/reservation-management.svg" width="45"
										height="45" /> <span>예매관리</span>
								</div>
							</a>
						</c:when>
					</c:choose>
				</div>

				<div>
					<span class="sub-heading">마이페이지</span>
				</div>
				<div class="menu-btn">
					<a href="${request.getContextPath}memberEdit.do">
						<div class="btn">
							<img src="btn-icon/modify.svg" width="45" height="45" /> <span>수정</span>
						</div>
					</a><a href="${request.getContextPath}memberUnregister.do">
						<div class="btn">
							<img src="btn-icon/withdrawal.svg" width="45" height="45" /> <span>탈퇴</span>
						</div>
					</a>
				</div>
			</c:when>
		</c:choose>
	</div>
	</div>

	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>

</body>
</html>
