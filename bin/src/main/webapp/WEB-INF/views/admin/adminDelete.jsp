<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 </title>
<jsp:include page="../include/inHead.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


</head>
<jsp:include page="../include/header.jsp"></jsp:include>
<h1>회원 삭제</h1>
	
	<form action="eachpageDelete" method="post">
		<input type="hidden" name="mno" value="${myInfo.mno}">
		정말 삭제하시겠습니까?<br />
		<input type="submit" value="삭제하기">
	</form>
	
	<a href="admin">회원 목록으로 돌아가기</a>

<jsp:include page="../include/footer.jsp"></jsp:include>