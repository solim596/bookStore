<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판 - 수정하기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<link href="css/boardStyle.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/bdbf8af6b1.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<h2>문의 게시판 - 수정하기</h2>
	<div class="sub-box2">
		<form name="frm" action="boardUpdate.do?boardID=${ board.boardID }" method="post" enctype="multipart/form-data" onsubmit="return valfn(this);">
			<table>
				<tr>
					<td class="txt">번호</td>
					<td>${board.boardID}</td>
				</tr>
				<tr>
					<td class="txt">제목</td>
					<td><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td class="txt">내용</td>
					<td>
						<textarea name="content" cols="50" rows="5" placeholder="200자 이내로 작성해 주세요.">${board.content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="txt">작성자</td>
					<td><input type=text" name="userID" value="${board.userID}" readonly style="border: none; background: transparent; outline:none"></td>
				</tr>
				<tr>
					<td class="txt">첨부파일(200MB 이하)</td>
					<td>
						<input type="file" name="ofile">
						<c:if test="${ not empty board.ofile }">
							${ board.ofile }
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="txt">비밀번호</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td colspan="2" class="center-box">
						<button type="submit">수정완료</button>
						<button type="button" onclick="location.href='boardList.do'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function valfn(form) {
			if(form.title.value == "") {
				alert("제목을 입력해 주세요.");
				form.title.focus();
				return false;
			}
			if(form.content.value == "") {
				alert("내용을 입력해 주세요.");
				form.content.focus();
				return false;
			}
			if(form.userID.value == "") {
				alert("작성자를 입력해 주세요.");
				form.userID.focus();
				return false;
			}
			if(form.pass.value == "") {
				alert("비밀번호를 입력해 주세요.");
				form.pass.focus();
				return false;
			}
		}
	</script>
</body>
</html>