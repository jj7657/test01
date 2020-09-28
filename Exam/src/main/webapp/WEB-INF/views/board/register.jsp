<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/register.css">
</head>
<body>
	<h1>게시판 글쓰기 화면.</h1>
	${result}
	<form role="form" action="/Exam/board/register" method="post">
		<input type="text" name="title" placeholder="글제목"><br>
		<textarea rows="5" cols="22" name="content" placeholder="글내용"></textarea>
		<br> <input type="text" name="writer" placeholder="작성자"><br>


		<input type="submit" value="글쓰기">

	</form>
	<div class="fileDrop">드랍영역</div>
	<div class="uploadedList">
		<ul>
		</ul>
	</div>


	<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="../resources/js/register.js"></script>
</body>
</html>