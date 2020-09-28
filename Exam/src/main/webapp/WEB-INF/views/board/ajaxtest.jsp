<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>Ajax Test Page</h2>
	<ul id="replies">
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














</body>
</html>