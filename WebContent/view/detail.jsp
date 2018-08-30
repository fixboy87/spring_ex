<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board_update" method="post" <%-- commandName="boardCommand" --%>>
		<ul>
			<li>번호: <input type="text" path="seq" value="${board.seq }" readonly/>
			<li>제목: <input type="text" path="title" value="${board.title }" readonly/>
			<li>작성자: <input type="text" path="writer" value="${board.writer }" readonly/>
			<li>파일: <a href="board_download?filename=${board.fname}">${board.fname }</a></li>
			<li>내용: <input type="textarea" rows="6" cols="70" path="contents" value="${board.contents }"/>
				<%-- <br><form:errors path="contents" cssClass="error"></form:errors> --%></li>
		</ul>
		<span><a href="board_list">돌아가기</a></span> &nbsp&nbsp <span><a
			href="board_delete${board.seq }">삭제하기</a></span> &nbsp&nbsp 
			<span><input type="submit" value="수정"></span>
	</form>
</body>
</html>










