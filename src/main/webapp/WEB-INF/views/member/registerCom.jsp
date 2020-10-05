<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../include/header.jsp"></jsp:include>
	<form action="com" method="post">
	아이디 : <input type="text" name='id'><button>중복확인</button><br>
	
	비밀번호 : <input type='password'><br>
	
	Pw확인 :  <input type="password" name='pwd'><button>일치확인</button><br>
	
	email : <input type="text" name='email'><button>중복확인</button><br>
	
	매장명 : <input type="text" name="name"><br>
	
	사업자 번호 : <input type="text" neme="brn"><br>
	
	위치(주소) :
	
	전화번호 : <input type="text" name="tel"><br>
	
	매장 사이트 :<input type="text" name='url_c'><br>
	
	매장 소개멘트 : <input type='text' name='ment'><br>
	
	프로필 사진 : <input type="image" name='prof'><br>
	
	프로필 사진 : <input type="file" name='prof'><br>
	<input type='submit' value='추가'>
	<input type='reset' value='취소'>
	<input type='button' onclick='location.href="/poom"' value='리스트로'>
	
	
	</form>
	

<jsp:include page="../include/footer.jsp"></jsp:include>