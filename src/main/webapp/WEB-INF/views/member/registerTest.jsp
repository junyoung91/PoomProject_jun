<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../include/header.jsp"></jsp:include>

<table cellpadding="0" cellspacing="0" class="member_form"
	style="position: relative; z-index: 1;">
	<tbody>
		<tr>
			<th>본인인증</th>
			<td id="jqIdCertBtn">
				<button type="button" class="btnMedium btnBlack"
					onclick="PopSelfIpin(); return false;" tabindex="12">이메일 인증</button>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" class="input_comm" name="id"
				id="member_id" style="width: 200px;" tabindex="1"
				onkeypress="if(event.keyCode == 13){check_id('global_form','member_id'); return false;}">
				<input type="hidden" name="id_overlap_chk" id="id_overlap_chk"
				value="0">&nbsp;
				<button type="button" class="btnMedium btnGray"
					onclick="check_id('global_form','member_id'); return false;"
					tabindex="9">중복확인</button>
				<span class="subtxt" style="margin-left: 5px;">※ 영문자/숫자 6~12자
					(한글과 여백은 사용하실 수 없습니다.)</span></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"
				id="member_password" class="input_comm" style="width: 200px;"
				autocomplete="off" tabindex="2"> &nbsp;
				<button type="button" class="btnMedium btnGray" id="PasswordGuide"
					tabindex="10">비밀번호 생성안내</button> <label class="error"
				for="member_password" generated="true"
				style="display: none; color: #f24638; cursor: pointer; margin: 10px 0 0 0; float: none;"></label>

			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="pwd"
				id="member_password1" class="input_comm" style="width: 200px;"
				tabindex="3"> <label class="error" for="member_password1"
				generated="true"
				style="display: none; color: #f24638; cursor: pointer; margin: 10px 0 0 0; float: none;"></label>
			</td>
		</tr>
		<tr>
			<th>휴대폰 번호</th>
			<td>
				<input
				type="text" class="input_comm" style="width: 150px;"
				name="tel" id="member_hp_3" maxlength="4" tabindex="6">
			</td>
		</tr>
		<tr>
			<th>이메일 주소</th>
			<td><input type="text" class="input_comm" style="width: 150px;"
				name="email" id="mail" tabindex="7"> <span class="Sblack14">@</span>
				<input type="text" class="input_comm" style="width: 150px;"
				name="mail2" id="mail2" tabindex="8">
				<div class="select_comm"
					style="float: none; vertical-align: inherit;">
					<select name="mailselect" id="mailselect" style="width: 150px;"
						onchange="change_email(this.value)";="">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>

						<option value="nate.com">nate.com</option>

						<option value="gmail.com">gmail.com</option>

						<option value="hotmail.com">hotmail.com</option>

						<option value="dreamwiz.com">dreamwiz.com</option>

						<option value="lycos.co.kr">lycos.co.kr</option>

						<option value="korea.com">korea.com</option>

					</select>
				</div> <input type="hidden" name="check_email" id="check_email" value="">
				&nbsp;
				<button type="button" class="btnMedium btnGray"
					onclick="email_chk(); return false;" tabindex="11">중복확인</button> <br>
				<span class="subtxt" style="margin-top: 10px;">※ daum.net /
					hanmail.net / hotmail.com의 경우 이메일이 정상 수신되지 않을 수 있습니다.</span></td>
		</tr>

	</tbody>
</table>


<jsp:include page="../include/footer.jsp"></jsp:include>