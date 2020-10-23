<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
<c:choose>
	<c:when test="${empty loginMember}">
			<body>
		
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			  <a class="navbar-brand" href="/poom">POOM</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="collapsibleNavbar">
			    <ul class="navbar-nav">
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/rehome/list">분양글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/community/list">소통글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/notice/list">공지글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/com">업체 회원가입</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/per">연동</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/new">개인 회원가입</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/login">로그인</a>
			      </li>
			    </ul>
			  </div>  
			</nav>
			<br /><br />
			
			  <!-- Page Wrapper -->
			  <div id="wrapper">
	</c:when>
	
	<c:otherwise>
		<body>
		
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			  <a class="navbar-brand" href="/poom">POOM</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="collapsibleNavbar">
			    <ul class="navbar-nav">
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/rehome/list">분양글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/community/list">소통글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/notice/list">공지글</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/com">업체 회원가입</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/per">연동</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/register/new">개인 회원가입</a>
			      </li>
			      <li class="nav-item">
			        <a href="/poom/mypage?mno=${loginMember.mno}" style="color: white;">${loginMember.name}</a>
			      </li>
			      <li class="nav-item">
			      	<a href="/poom/mypage?mno=${loginMember.mno}">
					  <img style="border-radius:20px" onerror="this.src='/resources/img/testImg.jpg'" src="${loginMember.dbSaveName}" width="40px" height="40px">
					</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="/poom/logout">로그아웃</a>
			      </li>
			    </ul>
			  </div>  
			</nav>
			<br /><br />
			  <!-- Page Wrapper -->
			  <div id="wrapper">

	</c:otherwise>
</c:choose>
