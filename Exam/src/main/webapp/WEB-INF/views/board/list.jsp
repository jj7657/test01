<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${result ne null}">
	<script type="text/javascript">
		let result = "${result}";
		alert(result);
	</script>
</c:if>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
}

tr {
	text-align: center;
}

tr:nth-child(2)>td:nth-child(1) {
	width: 20px;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2" style="width: 300px">제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list}" var="boardVO">
			<tr>
				<td>${boardVO.bno}</td>
				<td><a
					href="/Exam/board/read?bno=${boardVO.bno}&pageNum=${pageMaker.cri.pageNum}">${boardVO.title}</a></td>
				<td>${boardVO.writer}</td>
				<%-- <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td> --%>
				<td>${boardVO.regdate}</td>
				<td>${boardVO.viewcnt}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="5">
						<c:if test="${pageMaker.prev}">
							<a href="list?pageNum=${pageMaker.startPage -1}&keyword=${pageMaker.cri.keyword}&type=${pageMaker.cri.type}">&laquo;</a>
						</c:if>
						
						<c:forEach var="Num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<a href="/Exam/board/list?pageNum=${Num}&keyword=${pageMaker.cri.keyword}&type=${pageMaker.cri.type}">${Num}</a>&nbsp; 
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
							<a href="list?pageNum=${pageMaker.endPage +1}&keyword=${pageMaker.cri.keyword}&type=${pageMaker.cri.type}">&raquo;</a>
						</c:if>
						
<%-- 					<c:if test="${pageMaker.cri.keyword == null || pageMaker.cri.keyword.equals('')}">
						<c:if test="${pageMaker.prev}">
							<a href="list?pageNum=${pageMaker.startPage -1}">&laquo;</a>
						</c:if>
	
						<c:forEach var="Num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<a href="/Exam/board/list?pageNum=${Num}">${Num}</a>&nbsp; 
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<a href="list?pageNum=${pageMaker.endPage +1}">&raquo;</a>
						</c:if>
					</c:if> --%>
				</td>
		</tr>
		<tr>
			<td colspan="5" align="right"><a href="register"><input
					type="button" value="글쓰기"></a> <!-- 	<form action="register"><input type="submit" value="글쓰기"></form> -->
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<form action="/Exam/board/list" method="get">
					<input type="hidden" name="pageNum"
						value="${pageMaker.cri.pageNum}"> 
						<select name="type">
						<option value="t" <c:out value="${pageMaker.cri.type eq 't'?'selected':''}"/>>Title</option>
						<option value="w" <c:out value="${pageMaker.cri.type eq 'w'?'selected':''}"/>>Writer</option>
						<option value="c" <c:out value="${pageMaker.cri.type eq 'c'?'selected':''}"/>>Content</option>
						<option value="tc" <c:out value="${pageMaker.cri.type eq 'tc'?'selected':''}"/>>Title OR Content</option>
						<option value="cw" <c:out value="${pageMaker.cri.type eq 'cw'?'selected':''}"/>>Content OR Writer</option>
						<option value="tcw" <c:out value="${pageMaker.cri.type eq 'tcw'?'selected':''}"/>>Title OR Content OR Writer</option>
						</select> <input type="text" name="keyword" /> <input type="submit"
						value="검색" />
				</form> 
			</td>
		</tr>

	</table>
</body>
</html>
