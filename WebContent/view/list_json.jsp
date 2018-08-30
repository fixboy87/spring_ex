<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#table {
	border: solid, thin;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function() {
	$.getJSON("board_listing_json", function(data){
		
	alert("AJAX 호출 전");
		
		$.each(data, function(index, board) {
			$("#table").append('<tr><td>' + board.seq + '</td><td><a href=board_detail' + board.seq + '>' + board.title + '</a></td><td>' +
					board.writer + '</td><td>' + board.hitcount + '</td><td>' + board.regdate + '</td></tr>');
		});
	});
});
</script>
</head>
<body>
	<table id="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
	</table>
</body>
</html>