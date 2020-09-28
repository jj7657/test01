<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false"%> --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<P>	${login.username}님 환영합니다 </P>

<p> ${str}</p>

<p> ${msg}</p>
<br>
<!-- <a href="/board/doD.jsp">doD</a><br>
<a href="doM.jsp">doM</a><br>
<a href="doR.jsp">doR</a><br>
<a href="doW.jsp">doW</a><br> -->



<a href="/Exam/member/login">로그인 화면</a>
<a href="/Exam/board/list">게시글 목록</a>
<a href="/Exam/board/test">테스트</a>

</body>
</html>
