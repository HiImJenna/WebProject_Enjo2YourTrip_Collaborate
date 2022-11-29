<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>

<script src="https://cdn.tiny.cloud/1/pxajvm3one4o060slmbwd9ubxhaxyqd9zz33p5tro5ks92rt/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

<link href="style/header-Footer.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/culture-gathering.css" rel="stylesheet"
	type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/write.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<div class="list-gathering-detail">
		<!-- <div class="back-btn-gathering">
      <iconify-icon icon="bx:arrow-back" width="30" height="30"></iconify-icon>
    </div> -->

		<div class="culture-sub-heading-container">
			<span class="culture-sub-heading">글쓰기</span>
		</div>

		<div class="list-gathering gathering-post">
			<div class="list-summary-top">
				<div class="person-information post-gap">
					<img src='images/man2.svg' class="profile">
					<div class="nickname-date">
						<span class="nickname"><b>${nickName} 님</b></span>
					</div>
				</div>
			</div>
			<div class="post">

			 	<form name="bw" id="gathering-form" action="${pageContext.request.contextPath}/noticeWriteOk.do" method="POST">
					<div class="text-size text-size-margin">제목</div>
					<input type = "text;" style="resize: none; width: 920px; height: 30px;" name="title" form="gathering-form" maxlength="" class="post-gap" value = "${requestScope.title}"/>
					<div class="text-size text-size-margin">내용</div>
					<textarea style="resize: none;" name="content" form="gathering-form" cols="135" rows="25"
						maxlength="" class="post-gap"></textarea>
					<div class="right">
						<input type="submit" value="작성완료" class="culture-btn" style = "height: 30px">
					</div>
				</form>
			</div>
		</div>

	</div>
<script>
    tinymce.init({
      selector: 'textarea',
      plugins: 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tinycomments tableofcontents footnotes mergetags autocorrect',
      toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
      tinycomments_mode: 'embedded',
      tinycomments_author: 'Author name',
      mergetags_list: [
        { value: 'First.Name', title: 'First Name' },
        { value: 'Email', title: 'Email' },
      ]
    });
  </script>

	<footer>
		<!-- footer -->
		<%
		pageContext.include("/WEB-INF/views/include/footer.jsp");
		%>
	</footer>
</body>
</html>