<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<link href="style/header-Footer.css" rel="stylesheet" type="text/css"/>
  <link href="style/common.css" rel="stylesheet" type="text/css"/>
<div class="header">
	<a href="${request.getContextPath}myMenu.do"> 
	<iconify-icon icon="akar-icons:text-align-justified" width="30" heigth="30"></iconify-icon>
	</a>

	<a href="${pageContext.request.contextPath}"> <span class="title">
			<span>ENJO2 YOUR</span> <span class="to-place">TRIP</span>
	</span>
	</a>
	<div class="icon-container">
		<c:choose>
			<c:when test="${sessionScope.userid eq null}">
				<a href="loginView.do">
					<iconify-icon icon="fe:login" class="icon" width="30" heigth="30">
					</iconify-icon>
				</a>
			</c:when>
			<c:otherwise>
				<img src='images/man2.svg' class="profile">
				<a href="logout.do">
					<iconify-icon icon="fe:logout" class="icon" width="30" heigth="30">
					</iconify-icon>
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>