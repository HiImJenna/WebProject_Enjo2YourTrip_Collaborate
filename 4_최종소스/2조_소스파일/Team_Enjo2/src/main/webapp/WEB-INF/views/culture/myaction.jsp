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
  <script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/culture/common.js" type="module"></script>
  <link href="${pageContext.request.contextPath}/style/header-Footer.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/common.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-place.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/culture-gathering.css" rel="stylesheet" type="text/css"/>
  <link href="${pageContext.request.contextPath}/style/culture/management-page.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 <!--  <div class="modal">
    <div><img src="images/close.svg" style="cursor: pointer;"></div>
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
            <iconify-icon inline icon="bx:message" style="color: #8e8e8e;" width="15" height="15"></iconify-icon>
            <span class="comment-number">10</span>
          </div>
          <div class="participant-list">
              <img src='images/man3.svg' class="profile">
              <img src='images/man4.svg' class="profile participant-1">
              <img src='images/man5.svg' class="profile participant-2">
              <span class="participant-number">+3</span>
          </div>
        </div>
        <div class="comment-section">
          <span>댓글</span>
          <textarea name="comment" form="comment-form" cols="40" rows="1" maxlength=""></textarea>
          <form action="" id="comment-form">
            <input type="submit" value="완료" class="culture-btn">
          </form>
        </div>
        <div class="comment-list">
          <div class="person-information">
            <img src='images/man2.svg' class="profile">
            <div class="nickname-date">
              <span class="nickname">마이클</span>
              <span class="date">2022/12/01</span>
            </div> 
          </div>  
          <p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
          <hr>
          <div class="person-information">
            <img src='images/man2.svg' class="profile">
            <div class="nickname-date">
              <span class="nickname">마이클</span>
              <span class="date">2022/12/01</span>
            </div> 
          </div>  
          <p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
          <hr>
          <div class="person-information">
            <img src='images/man2.svg' class="profile">
            <div class="nickname-date">
              <span class="nickname">마이클</span>
              <span class="date">2022/12/01</span>
            </div> 
          </div>  
          <p class="comment-body">안녕하세요? 모임 참여하기 눌렀습니다.</p>
        </div>
     </div>
  </div> -->

  <!-- header -->
  <% pageContext.include("/WEB-INF/views/include/header.jsp"); %>
  <div class="culture-container">
    <div class="information-frame">
      <span class="culture-sub-heading">나의 활동</span>
      <ul class="page-category">
        <li>예매</li>
        <li class="sub-heading">모임</li>
      </ul>
      <table class="management-table">
        <thead>
          <tr>
            <td>게시판 제목</td>
            <td>내용</td>
            <td>게시일</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="board" items="${list}">
	          <tr>
	            <td>${board.title}</td>
	            <td>${board.content}</td>
	            <td>${board.time}</td>
	            <td class="management-table-btn">
	              <!-- 수정 필요 -->
	              <a href="culture-join-list-delete.culture?meNo=${board.meNo}&memId=MEM_ID1"><button class="reject">취소</button></a>
	            </td>
	          </tr>
          </c:forEach>
  
        </tbody>
      </table>
    </div>
  </div>
 <footer>
		<!-- footer -->
		<% pageContext.include("/WEB-INF/views/include/footer.jsp"); %>
</footer>
  
</body>
</html>