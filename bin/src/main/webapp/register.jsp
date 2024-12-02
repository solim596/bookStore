<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마니도서-회원가입</title>
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
	<h2>회원 가입하기</h2>
	<div class="sub-box">
		<div class="sectionCenter">
			<form name="frm" action="register.do" method="post"
				onsubmit="return valfn(this);">
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="username">
							<button type="button" name="idCheck" onclick="return idCheckfn()">중복확인</button>
							<input type="hidden" name="idDoubleCheck" value="idUnCheck">
							</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="email"></td>
					</tr>
					<tr>
						<td colspan="2" class="center-btn">
							<button type="submit">가입</button>
							<button type="reset">취소</button>
							<button class="main-loc" type="button" onclick="location.href='index.jsp'">메인</button>
						</td>
					</tr>
				</table>
			</form>
			<table border="1">
				<td><button class="user-loc" type="button" onclick="location.href='login.jsp'">로그인</button></td>
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
			if (form.email.value == "") {
				alert("이메일을 입력해주세요.");
				form.email.focus();
				return false;
			}
			// 만약 아이디 중복 확인을 하지 않으면 메시지 출력
			if(form.idDoubleCheck.value != "idCheck") {
				alert("아이디 중복 확인을 해 주세요");
				return false;
			}
		}
		// 아이디 중복 검사
		function idCheckfn() {
			let form = document.frm;
			let id = form.username.value;
			if(id.length == 0 || id == "") {
				alert("아이디를 입력해주세요.");
				form.username.focus();
			} else {
				 // 작은 팝업창 띄우기
				 window.open("idCheck.do?username=" + id, "", "width=300, height=150, left=800, top=200");
			}
		}
	</script>
</body>
</html>