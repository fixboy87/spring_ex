<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
</style>
</head>
<body>
<h3>${title }</h3>
<hr>
<form action="board_insert.do" method="post" <%-- commandName="boardCommand" --%>>
	작성자 : <input type="text" name="writer"/><br>
	제목 : <input type="text" name="title"/><br>	
			<!-- <errors path="title" cssClass="error"/>	 -->
	내용 <br>
	<textarea rows="6" cols="70" name></textarea>
	<br>
	<input type="submit" value="등록">
</form>

</body>
</html>








