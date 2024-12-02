<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마니도서-비밀번호 확인</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/bdbf8af6b1.js"
	crossorigin="anonymous"></script>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<h2>도서 수정 전 비밀번호 확인</h2>
	<div class="container-pass">
		<form name="frm" method="post" action="pass.do"
			onsubmit="return valfn(this);">
			<input type="hidden" name="bookID" value="${ param.bookID }">
			<input type="hidden" name="mode" value="${ param.mode }">
			<div class="passConfirm">
				<table border="1">
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" class="center-btn">
							<button type="submit">확인</button>
							<button type="button" onclick="location.href='bookList.do'">도서목록</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function valfn(form) {
			if (form.password.value == "") {
				alert("비밀번호를 입력해 주세요");
				form.password.focus();
				return false;
			}
		}
	</script>
</body>
</html>