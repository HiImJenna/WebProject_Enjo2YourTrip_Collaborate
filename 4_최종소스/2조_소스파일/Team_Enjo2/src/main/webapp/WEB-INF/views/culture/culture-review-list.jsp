<%@page import="kr.co.enjo2.dto.culture.CultureReviewDetailDto"%>
<%@page import="java.util.List"%>
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
  <script src="js/common.js" type="module"></script>
  <script src="${pageContext.request.contextPath}/js/culture/review-list.js" type="module"></script>
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  <!-- <link href="css/header-footer.css" rel="stylesheet" type="text/css"/> -->
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/review.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/reviewList.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/header-Footer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <!-- header -->
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  <%-- <div class="gu"><%=request.getAttribute("gu")%></div> --%>
  <div class="list-gathering-detail">
    <a class="back-btn-gathering" href="mainView.culture">
      <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
    </a>
   <div class="culture-sub-ba culture-sub-container">
      <span class="gu" style="display : hidden"><%=request.getAttribute("gu")%></span>
      <span class="culture-sub-heading">&nbsp;문화 공간 후기</span>
   </div>
 </div>
 
   <div class="review-list">
     <!--  <div class="list-summary-review">      
        <div class="review-culture-info">
          <div class="review-culture-place-name">경희대학교</div> 
          <p class="review-address">서울특별시 동대문구 경희대로 26</p>
        </div> 
       
       <div class="review-comment">
          <p class="review-body">
             경희대학교에서 넓고 좋네요 ㅎㅎㅎ
          </p>
          <div class="list-summary-top">
            <div class="person-information">
              <img src='images/man2.svg' class="profile">
              <div class="nickname-date">
                <span class="nickname">마이클</span>
                <span class="date">2022/12/01</span>
              </div> 
            </div>     
          </div>
       </div>
      </div>    -->
   </div>  <!--review-list-->
   <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
   </footer>
</body>
</html>