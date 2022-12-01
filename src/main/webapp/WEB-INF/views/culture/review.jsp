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
  <script src="${pageContext.request.contextPath}/js/culture/review.js" type="module"></script>
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  <!-- <link href="css/header-footer.css" rel="stylesheet" type="text/css"/> -->
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/review.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/header-Footer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <!-- header -->
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  <%
     int culNo = (int)request.getAttribute("culNo");   
  %>
  <div class="list-gathering-detail">
    <a class="back-btn-gathering" href="mainView.culture">
      <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
    </a>
    <%--     <p>${list}</p> --%>
    <p class="placeNum" style="display : none;">${culNo}</p>
    <%-- <p class="placeNum" style="display:none">${list[0].placeNum}</p> --%>
    <div class="culture-sub-heading-container">
      <span class="culture-sub-heading">후기</span>
    </div>
    <div class="list-gathering">
        <div class="list-context2">
          <div class="review-title"></div>
          <p class="review-body"></p>
        </div>
        <hr>
        <c:if test="${sessionScope.userid ne null}">
	        <div class="comment-section review-margin">
	          <span>댓글</span>
	          <textarea name="comment" form="comment-form" cols="40" rows="1" maxlength=""></textarea>
	          <form action="culture-review-write.culture" id="comment-form">
	            <input type="submit" value="완료" class="culture-btn">
	            <input type="hidden" value="${culNo}" name="culNo">
	            <!-- <input type="hidden" value="MEM_ID1" name="memId"> 수정 필요 -->
	          </form>
	        </div>
        </c:if>

        <%-- <div class="comment-list">
          <c:forEach items="${list }" var="rm">
              <p class="comment-body">${rm.cm }</p>
	          <div class="person-information">
	            <img src="${rs.profile}" class="profile" onerror=this.src='images/man3.svg'>
	            <div class="nickname-date">
	              <span class="nickname">${rm.nickName }</span>
	              <span class="date">${rm.time }</span>
	            </div> 
	          </div>  
          <hr>
          </c:forEach> 
        </div> --%>
          <c:forEach items="${list }" var="rm">
           <div class="review-comment">
              <p class="comment-body">${rm.cm }</p>
              <div class="list-summary-top">
	              <div class="person-information">
		            <img src="${rs.profile}" class="profile" onerror=this.src='images/man3.svg'>
		            <div class="nickname-date">
		              <span class="nickname">${rm.nickName }</span>
		              <span class="date">${rm.time }</span>
		            </div> 
		          </div>  
              </div>
            </div>  
          </c:forEach> 
     </div>
  </div>   

    <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
	</footer>
</body>
</html>