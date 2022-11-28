<%@page import="kr.co.enjo2.dto.notice.NoticeDto"%>
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
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
	type="text/css" />
<link href="style/review.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<!-- main -->
	<div class="list-gathering-detail">
		<!-- <div class="back-btn-gathering">
      <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
    </div> -->

		<div class="culture-sub-heading-container">
			<span class="culture-sub-heading"><b>공지사항</b></span>
		</div>
		<div class="list-gathering">
			<div class="list-context">
				<div class="list-title">${requestScope.title}</div>
				<span class="list-body">관리자</span><br /> <span class="date">${requestScope.date}</span><br />
				<hr />
				<p class="review-body">${requestScope.content}</p>
				<br /> 
				<br />
				<br /> 
			</div>
		</div>	
		
		<div class = "editButton">
				<form action="${request.getContextPath}noticeDelete.do" method="get">
					<input type="hidden" name="no" value="${requestScope.number}">
					<input type="submit" value="삭제하기" class="culture-btn" style = "float: right; margin-left: 7px;  height: 30px;" />
				</form>
		
				<a href="${request.getContextPath}noticeEdit.do?no=${requestScope.number}">
					<input type="button" value="수정하기" class="culture-btn" style = "float: right; margin-left: 7px;  height: 30px;" />
				</a> 
		
				
				<a href="${request.getContextPath}management.do?type=notice">
					<input type="button" value="목록가기" class="culture-btn" style = "float: left; margin-left: 7px; height: 30px;" `/>
				</a>
				
		 </div>	
				

	</div>

	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>
