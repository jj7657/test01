<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read.jsp</title>
<style type="text/css">
table {
	width: 500px;
}

tr {
	text-align: center;
}
</style>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/readjs.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
</head>
<body>
	

	<form role="form" method="post">
		<input type="hidden" name="bno" id="bno" value="${read.bno}" readonly="readonly"> <input
			type="hidden" name="pageNum" value="${cri.pageNum}">

		<table border="1">
			<tr>
				<td colspan="2">${read.title}</td>
			</tr>
			<tr>
				<td>${read.writer}</td>
				<td>${read.viewcnt}</td>
			</tr>
			<tr>
				<td colspan="2">${read.content}</td>
			</tr>
			<tr>
				<td><input class="mod" type="submit" value="수정"> <input
					class="remove" type="submit" value="삭제"> <input
					class="list" type="submit" value="목록"></td>
			</tr>
		</table>
	<div class="uploadResult">
		<ul></ul>
	</div>
			
	</form>
	<ul id="replies">

	</ul>
	<ul id="replyPage">
	</ul>

	<div class="pagination"></div>
	<div>
		<div>
			작성자<input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			내 용<input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
	</div>
	<div id="modDiv">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">DELETE</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>

	<!-- 	<a href="/Exam/board/remove"><input type="button" value="삭제"></a>&nbsp;&nbsp;
	<a href="/Exam/board/mod"><input type="button" value="수정"></a>&nbsp;&nbsp;
	<a href="/Exam/board/list"><input type="button" value="목록"></a> -->
</body>
</html>