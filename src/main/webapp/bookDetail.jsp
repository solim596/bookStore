<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마니도서-도서 상세 보기</title>
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
	<h2>도서 상세 보기</h2>
	<div class="sub-box4">
		<table class="bookTb">
			<tr>
				<td>도서번호</td>
				<td>${ dto.bookID }</td>
			</tr>
			<tr>
				<td>도서명</td>
				<td>${ dto.bookName }</td>
			</tr>
			<tr>
				<td>도서가격</td>
				<td><fmt:formatNumber value="${ dto.price }" pattern="#,###" />원</td>
			</tr>
			<tr>
				<td>저자명</td>
				<td>${ dto.author }</td>
			</tr>
			<tr>
				<td>상세정보</td>
				<td>${ dto.description }</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>${ dto.publisher }</td>
			</tr>
			<tr>
				<td>도서분류</td>
				<td>${ dto.category }</td>
			</tr>
			<tr>
				<td>재고량</td>
				<td>${ dto.unitsInStock }</td>
			</tr>
			<tr>
				<td>총페이지수</td>
				<td>${ dto.totalPages }페이지</td>
			</tr>
			<tr>
				<td>출판일</td>
				<td><fmt:formatDate value="${ dto.releaseDate }"
						pattern="yyyy년 MM월 dd일" /></td>
			</tr>
			<tr>
				<td>도서표지(이미지)</td>
				<td><img src="images/${ dto.imageUrl }" alt="${ dto.bookName }"></td>
			</tr>
			<tr>
				<td colspan="2" class="center-btn" style="text-align:center;">
					<!-- 로그인 하면 장바구니에 추가 버튼 보이고, 로그인 안하면 안보임 --> 
					<c:choose>
						<c:when test="${ not empty sessionScope.userID }">
							<!-- 장바구니에 추가 버튼 -->
							<form action="addCart.do" method="post"
								onsubmit="return confirmFn();">
								<input type="hidden" name="bookID" value="${ dto.bookID }">
								<input type="hidden" name="bookName" value="${ dto.bookName }">
								<input type="hidden" name="imageUrl" value="${ dto.imageUrl }">
								<input type="hidden" name="price" value="${ dto.price }">
								<button type="submit" class="cart-btn">장바구니 담기</button>
							</form>
						</c:when>
						<c:otherwise>
							<button style="width: 20%;">
								<a href="login.do">장바구니 추가</a>
							</button>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr class="adBtn">
				<td colspan="2" class="center-btn">
				<c:choose>
						<c:when test="${ not empty sessionScope.userID && sessionScope.userID == dto.userID }">
							<button type="button"
								onclick="location.href='pass.do?mode=edit&bookID=${ dto.bookID }'">수정하기</button>
							<button type="button"
								onclick="location.href='pass.do?mode=delete&bookID=${ dto.bookID }'">삭제하기</button>
						</c:when>
						<c:otherwise>
							<!-- <button><a href="login.jsp">로그인 후 수정, 삭제</a></button> -->
						</c:otherwise>
					</c:choose>
					<button type="button" onclick="location.href='bookList.do'"
						class="main-btn">도서목록</button></td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function confirmFn() {
			let result = confirm("장바구니에 추가하시겠습니까?");
			return result;
		}
	</script>
</body>
</html>