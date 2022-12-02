<%@page import="kr.co.enjo2.dto.culture.MeetReply"%>
<%@page import="kr.co.enjo2.dto.culture.MeetBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/culture/common.js" type="module"></script>
  <link href="${pageContext.request.contextPath}/style/header-Footer.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <%
     MeetBoardDto oneGathering = (MeetBoardDto)request.getAttribute("oneGathering");
     List<MeetReply> comment = (List)request.getAttribute("comment");
     int cmNum = (int)request.getAttribute("cmNum");   
  %>
 <!-- header -->
 <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
	
  <c:set var="members" value="${oneGathering.meetMemberList}"></c:set>
 
  <div class="list-gathering-detail">
    <a class="back-btn-gathering" href="culture-gathering.culture">
      <iconify-icon icon="bx:arrow-back" width="30" height="30" class="test"></iconify-icon>
    </a>
    <div class="culture-sub-heading-container">
      <span class="culture-sub-heading">모임</span>
    </div>
    <div class="list-gathering">
      <div class="list-summary-top">
        <div class="person-information">
          <img src="${oneGathering.memPro}" onerror="this.src= 'images/man2.svg'" class="profile">
          <div class="nickname-date">
            <div class="nickname">${oneGathering.memNic}</div> <!-- 수정 필요 -->
            <div class="date">${oneGathering.mbCreatedAt}</div>
          </div> 
        </div>    
        <!-- memId sesstion 값으로 바꾸기 -->
         <div class="crud-btn"> 
	         <c:if test="${sessionScope.userid eq oneGathering.memId}">
		         <a class="crud" href="culture-gathering-board-update-page.culture?mbNo=${oneGathering.mbNo}">수정</a>
		         <a class="crud" href="culture-gathering-board-delete.culture?mbNo=${oneGathering.mbNo}">삭제</a>
		     </c:if>     
		     <c:if test="${sessionScope.userid ne null}">
		         <a class="culture-btn" href="culture-gathering-join.culture?memId=${oneGathering.memId}&mbNo=${oneGathering.mbNo}">참여하기</a>
		     </c:if>
	         <!-- /culture-gathering-detail-from-join.culture -->
          </div>
      </div>
        <div class="list-context">
          <div class="list-title">${oneGathering.mbTitle}</div>
          <p class="list-gathering-body">${oneGathering.mbContent}</p>
        </div>
        <hr>
        <div class="list-summary-button">
          <div class="comment">
            <iconify-icon inline icon="bx:message" style="color: #8e8e8e;" width="15" height="15"></iconify-icon>
            <span class="comment-number">${cmNum}</span>
          </div>
          <div class="participant-list">
              <c:forEach items="${members}" var="member" varStatus="order">
                <c:if test="${order.index == 0}"> 
                   <div class="tooltip">
                     <img src="${member.memPro}" onerror="this.src='images/man3.svg'" class="profile participant-0">
                     <span class="tooltiptext">${member.memNic}</span>
                   </div>
                   
                </c:if>
                <c:if test="${order.index == 1}">
                   <div class="tooltip">
                     <img src="${member.memPro}" onerror="this.src='images/man4.svg'" class="profile participant-1">
                     <span class="tooltiptext">${member.memNic}</span>
                   </div> 
            
                </c:if>
                <c:if test="${order.index  == 2}">
                   <div class="tooltip">
                     <img src="${member.memPro}" onerror="this.src='images/man5.svg'" class="profile participant-2">
                     <span class="tooltiptext">${member.memNic}</span>
                   </div>         
                </c:if>
                <c:if test="${order.index > 2}">
                  <div class="tooltip">
                   <span class="participant-number" style="z-index : ${order.index}">+${order.index}</span>
                   <span class="tooltiptext">${oneGathering.meetMemberList}</span>
                  </div>     
                </c:if>
			  </c:forEach>
          </div> 
        </div>
        <c:if test="${sessionScope.userid ne null}">
	         <div class="comment-section">
	          <span>댓글</span>
	          <textarea name="comment" form="comment-form" cols="40" rows="1" maxlength=""></textarea>
	          <form action="culture-gathering-comment-write.culture" id="comment-form" method="post">
	            <input type="submit" value="완료" class="culture-btn">
	            <input type="hidden" name="mbNo" value="${oneGathering.mbNo}">
	            <!-- <input type="hidden" name="memid" value="MEM_ID1"> 수정해야함 -->
	          </form>
	        </div>
        </c:if>

        <div class="comment-list">
          <c:forEach items="${comment}" var="cm">
           <div class="list-summary-top">
             <div class="person-information">
	            <img src= 'images/man2.svg' class="profile">
	            <div class="nickname-date">
	              <span class="nickname">${cm.memNic}</span>
	              <span class="date">${cm.mrCreatedAt}</span>
	            </div>
	         </div> 
	        <c:if test="${sessionScope.userid eq cm.memid}"> <!-- 수정 필요 -->
	           <div class="crud-btn">
		        <!--  <a class="crud">수정</a> -->
		         <a class="crud" href="culture-gathering-board-comment-delete.culture?mrNo=${cm.mrNo}&mbNo=${oneGathering.mbNo}">삭제</a>
	           </div>
           </c:if>
           </div>
	          <p class="comment-body">${cm.mrComment}</p>
	          <hr>
          </c:forEach>
        </div>
     </div>
  </div>   
  
  


  <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
  </footer>
</body>
</html>