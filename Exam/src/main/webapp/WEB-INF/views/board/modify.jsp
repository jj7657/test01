<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
	<h1>게시글 수정 화면</h1>
	<form role="form" method="post" action="/Exam/board/modify">
		<input type="hidden" name="pageNum" value="${cri.pageNum}">
		<input type="hidden" name="bno" value="${modify.bno}">
		<input type="text" name="title" placeholder="글제목" value="${modify.title}"><br>
		<textarea rows="5" cols="22" name="content" placeholder="글내용" >${modify.content}</textarea><br>
		<input type="text" name="writer" value="${modify.writer}" readonly="readonly"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>