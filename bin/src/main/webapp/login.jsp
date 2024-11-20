<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마니도서-로그인</title>
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
	<h2>로그인 하기</h2>
	<div class="sub-box">
		<div class="sectionCenter">
			<form name="frm" action="login.do" method="post"
				onsubmit="return valfn(this);">
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="username">
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" class="center-btn">
							<button type="submit">로그인</button>
							<button type="reset">취소</button>
							<button class="main-loc" type="button" onclick="location.href='index.jsp'">메인</button>
						</td>
					</tr>
				</table>
			</form>
			<table border="1">
				<tr>
					<td><button class="user-loc" type="button"
							onclick="location.href='register.jsp'">회원가입</button></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function valfn(form) {
			if (form.username.value == "") {
				alert("아이디를 입력해주세요.");
				form.username.focus();
				return false;
			}
			if (form.password.value == "") {
				alert("패스워드를 입력해주세요.");
				form.password.focus();
				return false;
			}
		}
	</script>
</body>
</html>