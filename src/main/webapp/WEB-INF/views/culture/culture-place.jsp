<%@page import="kr.co.enjo2.dto.culture.MeetBoardDto"%>
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
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
  <script src="${pageContext.request.contextPath}/js/culture/culture-place.js" type="module"></script>

  <link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  
</head>
<body>
  <!-- header -->
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  <%
   List<MeetBoardDto> list = (List)request.getAttribute("list");
  %>
  <div class="culture-container"> 
    <div class="culture-information">
      <span class="culture-sub-heading">문화공간</span>
      <ul class="gu">
      <!-- 
        <li class="gu-selected">중랑구</li>
        <li>동대문구</li>
        <li>성북구</li>
        <li>노원구</li>
        <li>광진구</li>
        <li>강남구</li>
        <li>서초구</li>
       -->

      </ul>
      <table class="culture-table">
        <thead>
          <tr>
            <th>문화 시설명</th>
            <th>주소</th>
            <th>주제분류</th>
            <th>무료구분</th>
            <th>휴관일</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody>
          
        </tbody>
      </table>
    </div>
    <div class="culture-sub-bar">
      <span class="culture-sub-heading">모임</span> 
      <a class="more gathering-more" href="culture-gathering.culture">더보기</a>
    </div>
    <div class="list">
  
     <c:forEach var="board" items="${list}" begin="0" end="4" step="1">
	     <c:set var="members" value="${board.meetMemberList}"></c:set>
		 <div class="list-summary">
			<div class="list-summary-top">
		        <div class="person-information">
		          <img src='${board.memPro}' onerror=this.src='images/man2.svg' class="profile">
		          <div class="nickname-date">
		            <div class="nickname">${board.memNic}</div>
		            <div class="date">${board.mbCreatedAt}</div>
		          </div> 
		        </div> 
		      <%--  <a class="culture-btn" href="culture-gathering-join-from-culture-place.culture?memId=MEM_ID1&mbNo=${board.mbNo}">참여하기</a>   <!-- memId sesstion 값으로 바꾸기 --> --%>
		      <c:if test="${sessionScope.userid ne null}">
		         <a class="culture-btn" href="culture-gathering-join-from-culture-place.culture?mbNo=${board.mbNo}">참여하기</a>   <!-- memId sesstion 값으로 바꾸기 -->
		      </c:if>
		       <%-- <a class="culture-btn" href="culture-gathering-detail.culture?mbNo=${board.mbNo}">참여하기</a>  --%>
	       </div>
	       <a href="culture-gathering-detail.culture?mbNo=${board.mbNo}">
	          <div class="list-context">
	              <div href="culture-gathering-detail.culture?mbNo=${board.mbNo}">
			          <div class="list-title">${board.mbTitle}</div>
			          <p class="list-gathering-body">${board.mbContent}</p>
		          </div> 
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
  
    <div class="culture-sub-bar">
      <span class="culture-sub-heading">후기</span>
 <%--      <form action="${request.getContextPath}culture-review.culture" method="post" class="review-form">
         <input type="submit" class="more review-more" value="더보기">
      </form> --%>
      <a class="more review-more">더보기</a> 
      
    </div>
  
    <div class="list review-list">
      <!-- <div class="list-summary-review">      
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
          </div> -->
       </div>
       
        
      </div>   <!--list-summary-->
      
     <!--   <div class="list-summary">       
          <div class="review-culture-place-name">경희대학교</div>
  
          <p class="review-address">
            서울특별시 동대문구 경희대로 26
          </p>
         <div class="comment-container">
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
          <hr class="hr-margin">
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
      </div>   list-summary -->
  </div>  <!--list-->
  
  </div>
    
   <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
	</footer>
</body>
</html>