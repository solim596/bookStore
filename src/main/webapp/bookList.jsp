<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마니도서-도서목록</title>
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
	<div class="container">
		<div class="sub-box3">
			<h2>도서 목록</h2>
			<div class="book-tb">
				<table>
					<tr>
						<td colspan="6" class="right-box">Total : ${ totalCount }</td>
					</tr>
					<tr style="text-align: center">
						<th>도서번호</th>
						<th>도서명</th>
						<th>저자명</th>
						<th>출판사</th>
						<th>출판일</th>
						<th>도서표지</th>
					</tr>
					<c:choose>
						<c:when test="${ empty bookLists }">
							<tr>
								<td colspan="6" class="center-btn">등록된 도서 목록이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="book" items="${ bookLists }" varStatus="status">
								<!-- totalCount : book 목록의 총 개수 -->
								<!-- status.index : book 목록 1개의 인덱스 번호 -->
								<tr class="list-info" style="text-align: center;">
									<td style="text-align: center">${ totalCount-status.index }</td>
									<td><a href="bookDetail.do?bookID=${ book.bookID }">${ book.bookName }</a>
									</td>
									<td>${ book.author }</td>
									<td>${ book.publisher }</td>
									<td>${ book.releaseDate }</td>
									<td style="width: 100px; height: 100px;"><img
										src="images/${ book.imageUrl }" alt="${ book.bookName }"></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<tr>
						<td style="text-align: center;" colspan="6" class="center-box">
							<!-- 페이지 번호 표시 --> ${ map.pagingVar }
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>