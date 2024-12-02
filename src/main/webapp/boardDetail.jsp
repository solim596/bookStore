<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판 - 상세보기</title>
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
	<h2>문의 게시판 - 상세 보기</h2>
	<div class="sub-box2">
		<table>
			<tr>
				<td>번호</td>
				<td>${ board.boardID }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${ board.userID }</td>
			</tr>
			<tr>
				<td>게시일</td>
				<td>${ board.postDate }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><c:if test="${ not empty board.ofile }">
						${ board.ofile }&nbsp&nbsp&nbsp
						<a
							href="download.do?ofile=${board.ofile}&sfile=${board.sfile}&boardID=${board.boardID}">다운로드</a>
					</c:if></td>
			</tr>
			<tr>
				<td>파일 다운로드 수</td>
				<td>${ board.downcount }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${ board.visitcount }</td>
			</tr>
			<tr class="detail-button-box">
				<td colspan="2" class="center-box"><c:choose>
						<c:when test="${ not empty sessionScope.userID && sessionScope.userID == board.userID }">
							<button type="button"
								onclick="location.href='checkPass.do?mode=edit&boardID=${board.boardID}'">수정</button>
							<button type="button"
								onclick="location.href='checkPass.do?mode=delete&boardID=${board.boardID}'">삭제</button>
						</c:when>
						<c:otherwise>
							<button type="button" onclick="location.href='login.do'">로그인 후 삭제</button>
						</c:otherwise>
					</c:choose>
					<button type="button" onclick="location.href='boardList.do'">게시글
						목록</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>