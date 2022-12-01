<!-- 관리자 페이지 문의사항 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/common.js" type="module"></script>
<script src="js/macgyver.js" type="module"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery.twbsPagination.js"></script>
<style>
.center {
  text-align: center;
}
.pagination {
  display: inline-block;
}

.pagination li {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination li.active {
  background-color: #F05400;
  color: white;
}

.pagination li:hover:not(.active) {background-color: #ddd;}
</style>
<script type="text/javascript">
	$(function() {
		showQna(1);
	});
	
	function showQna(num) {
		$.ajax(
				{
					type: "get",
					url: "qnaList.do",
					dataType: "json",
					data:{
						page : num
					},
					success: function(data){
						const qnaList = data.qnaList;
						console.log(data);
						
						if(qnaList.length > 0){
							$('#qnaTable').show();
						} else{
							$('#qnaTable').hide();
							return;
						}
						
						$('#qnaTable').empty();
						$('#qnaTable').append('<thead><tr><td>게시번호</td><td>제목</td><td>작성자</td><td>작성일자</td><td>조회수</td></tr></thead>');
						$('#qnaTable').append('<tbody id = "tbody-box"></tbody>');
						for(const qna of qnaList){
							const childList = qna.child;
							let tempHtml = '';
							if (childList.length > 0) {
								//const className = "child" + qna.no;
								tempHtml = `<tr>
												<td>\${qna.no}</td>
												<td>
													<a href="qnaContent.do?no=\${qna.no}">\${qna.title}&nbsp;</a>
													<font size="1em" color="tomato" onclick="showChild(\${qna.no})">
														[답글 보기]
													</font>
												</td>
												<td>\${qna.writer}</td>
												<td>\${qna.date}</td>
												<td>\${qna.count}</td>
											</tr>`;
								for(const child of childList) {
									tempHtml += `<tr class=\"\${qna.no}\" style="display:none;">
													<td>\${child.no}</td>
													<td> &nbsp;&nbsp;&nbsp;<a href="qnaContent.do?no=\${child.no}">└ \${child.title}</a></td>
													<td>\${child.writer}</td>
													<td>\${child.date}</td>
													<td>\${child.count}</td>
												</tr>`;
								}
							} else {
								tempHtml = `<tr>
												<td>\${qna.no}</td>
												<td><a href="qnaContent.do?no=\${qna.no}">\${qna.title}</a></td>
												<td>\${qna.writer}</td>
												<td>\${qna.date}</td>
												<td>\${qna.count}</td>
											</tr>`
							}
							$('#tbody-box').append(tempHtml);
						}
						
						// 페이징 처리 시작
						$('#page-box').empty();	//페이지 리셋
						
						const pageInfo = data.pageInfo;
						// 이전 붙이기
						const start = Number(pageInfo.start)-1;
						if (pageInfo.prev == 1){
							let tempHtml = `<li onclick = "showQna(\${start})">&laquo;</li>`
							$('#page-box').append(tempHtml);
						}
						// 페이지 번호 붙이기
						for(let i = pageInfo.start; i <= pageInfo.end; i++) {
							let tempHtml = `<li onclick = "showQna(\${i})">\${i}</li>`;
							
							if (num == i) {
								tempHtml = `<li class="active" onclick = "showQna(\${i})">\${i}</li>`;
							}
							$('#page-box').append(tempHtml);
						}
						// 이후 붙이기
						const end = Number(pageInfo.end) + 1;
						if (pageInfo.next == 1){
							let tempHtml = `<li onclick = "showQna(\${end})">&raquo;</li>`
							$('#page-box').append(tempHtml);
						}
						// 페이징 처리 끝
					},
					error:function (request, status, error){
						console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error)
					}
				}
			)
	}
	
	function showChild(childNo) {
		const className = "." + childNo;
		if ($(className).is(':visible')) {
			$(className).hide();
		} else {
			$(className).show();
		}
	}
	
</script>
<body>
	<!-- header -->
	<%
		pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<!-- main -->
	<div class="culture-container">
		<div class="information-frame">
			<span class="culture-sub-heading">서비스정보</span>
			<ul class="page-category">
				<a href="${request.getContextPath}management.do?type=notice">
					<li>공지사항</li>
				</a>
				<a href="${request.getContextPath}management.do?type=qna">
					<li class="sub-heading">문의사항</li>
				</a>
				<c:choose>
					<c:when test="${sessionScope.userid eq 'admin'}">
						<a href="${request.getContextPath}management.do?type=chart">
							<li>통계</li>
						</a>
						<a href="${request.getContextPath}management.do?type=flight">
							<li>예매관리</li>
						</a>
					</c:when>
				</c:choose>
			</ul>
			<table class="management-table2" id="qnaTable">
			</table>
			<div class="pagination center">
			<ul class="paging-btn" id="page-box">
			</ul>
			</div>
		</div>
	</div>

	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>

	<!-- 포지션 앱솔루트 -->
	<ul class="macgyver-btn">
		<li><img src="btn-icon/plus-btn.svg"
			style="background-color: #ffff; border-radius: 50%;"></li>
		<li><a href="${request.getContextPath}qnaWriteView.do"><iconify-icon icon="iconoir:edit-pencil"
				style="color: #ef6351;" width="30" height="30"></iconify-icon></a></li>
	</ul>
</body>
</html>