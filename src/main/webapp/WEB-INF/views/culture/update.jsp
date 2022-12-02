<%@page import="kr.co.enjo2.dto.culture.MeetBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/culture/common.js" type="module"></script>
  <link href="${pageContext.request.contextPath}/header-footer.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/write.css" rel="stylesheet" type="text/css"/>
  <link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
</head> 
<body>
  <!-- header -->
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  
  <%
     MeetBoardDto oneGathering = (MeetBoardDto)request.getAttribute("oneGathering");
  %>
  
  <div class="list-gathering-detail">

   <div class="culture-sub-heading-container">
      <span class="culture-sub-heading">모임</span>
    </div>

    <div class="list-gathering gathering-post">
      <div class="list-summary-top">
        <div class="person-information post-gap">
          <img src='${oneGathering.memPro}' onerror="this.src= 'images/man2.svg'" class="profile">
          <div class="nickname-date">
            <span class="nickname">${oneGathering.memNic}</span> 
          </div> 
        </div> 
      </div>
      <div class="post">
        <div class="text-size text-size-margin">제목</div>
        <textarea name="title" form="gathering-form" cols="51" rows="1" maxlength="" class="post-gap">${oneGathering.mbTitle}</textarea>
        <div class="text-size text-size-margin">내용</div>
        <textarea name="context" form="gathering-form" cols="51" rows="20" maxlength="" class="post-gap">${oneGathering.mbContent}</textarea>
        <form action="culture-gathering-board-update.culture" id="gathering-form">
          <div class="right">
           <input type="hidden" name="mbNo" value="${oneGathering.mbNo}"> <!-- MEM_ID1 수정필요 -->
            <input type="submit" value="수정완료" class="culture-btn">
          </div>
        </form>
      </div>
    </div>

  </div>

  <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
  </footer>
  
</body>
</html>