<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>
</head>
<body>
	<h1>회원가입 폼</h1>
	<form action="/Exam/member/member" method="post" onsubmit="return checkmem()">
		<table>
			<tr>
				<td>
				<label>아이디</label><br>
				<input type="text" name="userid" id="userid"><br>
				<p id="idmsg"></p>		
				<button type="button" id="idbtn">아이디찾기</button>	
				<p id="idcheck"></p>		
				</td>
			</tr>
			<tr>
				<td>
				<label>패스워드</label><br> <input type="password" name="userpw" id="userpw">
				<p id="pwmsg"></p>	
				</td>
			</tr>
			<tr>
				<td>
				<label>패스워드 확인</label><br> 
				<input type="password"
					name="re_userpw" id="re_userpw">
					<p id="re_pwmsg"></p>	
					</td>
			</tr>
			<tr>
				<td><label>이름</label><br> <input type="text" name="username" id="username">
				</td>
			</tr>
			<tr>
				<td><label>이메일</label><br> <input type="text" name="email" id="email">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="가입하기"></td>
			</tr>
		</table>
	</form>

</body>
</html>