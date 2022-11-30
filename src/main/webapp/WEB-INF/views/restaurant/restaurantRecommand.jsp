<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <!-- kakao Map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d357e5d2dcf9e6683d44f9bceb4b4612&libraries=services"></script>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
    <!-- Bootstrap -->
<link href="style/restaurant/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/restaurant/common.css" rel="stylesheet" type="text/css" />
<link href="style/restaurant/culture-place.css" rel="stylesheet" type="text/css" />
<!--     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
 -->    <script src="basic.js" type="module"></script>
    <script src="basic.js" type="text/javscript"></script>
    <title>키워드로 장소검색하기</title>
    <style>

        #searchArea {
          width: 80%;
          display: flex;
          margin: 10px auto;
        }
        #result {
          width: 80%;
          margin: 20px auto;
          /* border: 1px solid; */
        }
        #favorite {
          width: 80%;
          margin: 20px auto;
          /* border: 1px solid; */
        }
        #footer {
          border: 1px solid;
          margin: 0 auto;
        }
        td{
        text-align :center;
        }
    </style>

</head>
<body>
   <header>
      <!-- header -->
      <%
      pageContext.include("/WEB-INF/views/include/header.jsp");
      %>
   </header>
  <div id="main">
    <!-- 지도 -->
    <div id="map" style="width:80%; height: 500px; margin: 10px auto;"></div>

    <!-- 검색 -->
    <div id="searchArea" style="visibility: hidden">
      <input type="text" class="form-control col-9" id="keyword" placeholder="검색어를 입력해주세요" value='${param.value}'>
      <button type="submit" id="" class="btn btn-primary col-1" onclick="searchByKeyword()">검색</button>
      <button type="submit" class="btn btn-danger col" onclick="initMap()">초기화</button>
    </div>

    <!-- 결과 -->
    <div id="result">
      <table class="culture-table" style="80%">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">상호명</th>
            <th scope="col">주소</th>
            <th scope="col">나와의 거리</th>
          </tr>
        </thead>
        <tbody id="resultTable">
        </tbody>
      </table>
         <div id="pagination"></div>
    </div>

   

  </div>

   <footer>
      <!-- footer -->
      <%
      pageContext.include("/WEB-INF/views/include/footer.jsp");
      %>
   </footer>
</body>
<script type="text/javascript"> 

</script>
</html>