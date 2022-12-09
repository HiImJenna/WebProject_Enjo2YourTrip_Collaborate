<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
  <script src="js/common.js" type="module"></script>
  <link href="css/menu.css" rel="stylesheet" type="text/css"/>
  <link href="css/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <div class = "menu-container">
    <a href="javascript:history.back();">
      <div class="back-btn">
        <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
      </div>
    </a>   
    <div class="user-information">
      <img src='images/big-man.svg' class="profile">
      <span>관리자님</span>
    </div>
  
    <div class="menu">
        <div><span class="sub-heading">카테고리</span></div>
        <div class="menu-btn">
           <div class="btn">
             <img src="btn-icon/airplane.svg">
             <span>항공</span>
           </div>
           <div class="btn">
            <img src="btn-icon/famous-restaurant.svg">
            <span>맛집</span>
          </div>
          <a href="culture-place.html">
            <div class="btn">
              <img src="btn-icon/culture-place.svg" width="45" height="45">
              <span>문화공간</span>
            </div>
          </a>   
        </div>
  
        <div><span class="sub-heading">나의활동</span></div>
        <div class="menu-btn">
          <a href="myaction.html">
            <div class="btn">
              <img src="btn-icon/reservation.svg">
              <span>예매</span>
            </div>
          </a>
  
          <a href="myaction.html">
            <div class="btn">
              <img src="btn-icon/gathering.svg">
              <span>모임</span>
             </div>
          </a>
       </div>
  
  
        <div>
          <span class="sub-heading">관리페이지</span>
        </div>
        <div class="menu-btn">
          <a href="management-page.html">
            <div class="btn">
              <img src="btn-icon/Megaphone.svg" width="45" height="45">
              <span>공지사항</span>
             </div>
          </a>
          <a href="management-page.html">
            <div class="btn">
              <img src="btn-icon/InformationFile.svg" width="45" height="45">
              <span>문의사항</span>
             </div>
          </a>
          <a href="management-page.html">
            <div class="btn">
              <img src="btn-icon/stats.svg" width="45" height="45">
              <span>통계</span>
            </div>
          </a>
          <a href="management-page.html">
            <div class="btn">
              <img src="btn-icon/reservation-management.svg" width="45" height="45">
              <span>예매관리</span>
            </div>
          </a>
        </div>

        <div><span class="sub-heading">마이페이지</span></div>
        <div class="menu-btn">
          <a href="mypage.html">
            <div class="btn">
              <img src="btn-icon/modify.svg" width="45" height="45">
              <span>수정</span>
             </div> 
          </a>
          <a href="mypage.html">
            <div class="btn">
              <img src="btn-icon/withdrawal.svg" width="45" height="45">
              <span>탈퇴</span>
            </div> 
          </a>
       </div>
        
    </div> 
  </div>

</body>
</html>