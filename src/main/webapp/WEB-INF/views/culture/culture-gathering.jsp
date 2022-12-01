<%@page import="kr.co.enjo2.dto.culture.MeetMemberListDto"%>
<%@page import="kr.co.enjo2.dto.culture.MeetBoardDto"%>
<%@page import="kr.co.enjo2.dto.culture.MeetJoinDto"%>
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
  <script src="${pageContext.request.contextPath}/js/culture/common.js" type="module"></script>
  <script src="${pageContext.request.contextPath}/js/culture/macgyver.js" type="module"></script>
  <link href="${pageContext.request.contextPath}/style/header-Footer.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/reviewList.css" rel="stylesheet" type="text/css"/>
</head>
  <script>

  </script>
<body>
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  
  <%
    List<MeetBoardDto> list = (List)request.getAttribute("list");
    /// String userid = (String)request.getSession().getAttribute("");
    String userid = (String)request.getSession().getAttribute("userid");
  %>
    <div class="culture-common-container">
       
       <div class="list-gathering-detail">
    <a class="back-btn-gathering" href="mainView.culture">
      <iconify-icon icon="bx:arrow-back" width="30" height="30" class="test"></iconify-icon>
    </a>
    <div class="culture-sub-heading-container">
      <span class="culture-sub-heading">모임</span>
    </div>
    <div class="review-list">
    <c:forEach var="board" items="${list}">
	     <c:set var="members" value="${board.meetMemberList}"></c:set>
		 <div class="list-gathering">
			<div class="list-summary-top">
		        <div class="person-information">
		          <img src='images/man2.svg' class="profile">
		          <div class="nickname-date">
		            <div class="nickname">${board.memNic}</div>
		            <div class="date">${board.mbCreatedAt}</div>
		          </div> 
		        </div> 
		        <c:if test="${sessionScope.userid ne null}">
		          <a class="culture-btn" href="culture-gathering-join-from-list.culture?&mbNo=${board.mbNo}">참여하기</a>   <!-- memId sesstion 값으로 바꾸기 -->
		        </c:if> 
	       </div>
	       <a href="culture-gathering-detail.culture?mbNo=${board.mbNo}">
	          <div class="list-context">
		          <div class="list-title">${board.mbTitle}</div>
		          <p class="list-gathering-body">${board.mbContent}</p>
		      </div>   
	       </a> 
	       <hr>
	        <div class="list-summary-button">
	          <a href="culture-gathering-detail.culture?mbNo=${board.mbNo}" class="detail-anchor">
		          <div class="comment">
		            <iconify-icon inline icon="bx:message" style="color: #8e8e8e;" width="15" height="15"></iconify-icon>
		            <span class="comment-number">${board.comNum}</span>
		          </div>
	          </a> 
	          <div class="participant-list">
	              <c:forEach items="${members}" var="member" varStatus="order">
	                <c:if test="${order.index == 0}"> 
	                   <div class="tooltip">
	                     <img src="${member.memPro}" onerror=this.src='images/man3.svg' class="profile participant-0">
	                     <span class="tooltiptext">${member.memNic}</span>
	                   </div>
	                   
	                </c:if>
	                <c:if test="${order.index == 1}">
	                   <div class="tooltip">
	                     <img src="${member.memPro}" onerror=this.src='images/man4.svg' class="profile participant-1">
	                     <span class="tooltiptext">${member.memNic}</span>
	                   </div> 
	            
	                </c:if>
	                <c:if test="${order.index  == 2}">
	                   <div class="tooltip">
	                     <img src="${member.memPro}" onerror=this.src='images/man5.svg' class="profile participant-2">
	                     <span class="tooltiptext">${member.memNic}</span>
	                   </div>         
	                </c:if>
	                <c:if test="${order.index > 2}">
	                  <div class="tooltip">
	                   <span class="participant-number" style="z-index : ${order.index}">+${order.index}</span>
	                   <span class="tooltiptext">${board.meetMemberList}</span>
	                  </div>     
	                </c:if>
				  </c:forEach>
	          </div>
           </div>
	 	</div>
	</c:forEach>
    </div>
  </div>
      
    </div>
     
  
  <footer>
	<!-- footer -->
	<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
  </footer>
  <c:if test="${sessionScope.userid ne null}">
   <ul class="macgyver-btn">
    <li>
      <img src="${pageContext.request.contextPath}/icon/plus-btn.svg" style="background-color: #ffff; border-radius: 50%;">
    </li>
    <li>
		<!-- <iconify-icon icon="iconoir:edit-pencil" style="color: #ef6351;" width="30" height="30"></iconify-icon> -->
      <a href="writePage.culture"><iconify-icon icon="iconoir:edit-pencil" style="color: #ef6351;" width="30" height="30"></iconify-icon></a>
    </li>
   </ul>
  </c:if>
</body>
</html>
