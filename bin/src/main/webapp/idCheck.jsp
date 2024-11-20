<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>
	<h3>아이디 중복 확인</h3>
	<c:if test="${result == 1}">
		<p>${username}는 사용중인 아이디입니다.</p>
		<button type="button" onclick="nofn()">닫기</button>
	</c:if>
	<c:if test="${result == 0}">
		<p>${username}는 사용 가능합니다.</p>
		<button type="button" onclick="okfn()">닫기</button>
	</c:if>
	<script>
		function nofn() {
			// 현재 팝업창을 띄운 부모 페이지의 form의 username입력란 비우기
			opener.document.frm.username.value="";
			// 팝업창 닫기
			self.close();
		}
		function okfn() {
			// 현재 팝업창을 띄운 부모 페이지의 form의 idDoubleCheck값을 idCheck로 변경
			opener.document.frm.idDoubleCheck.value = "idCheck";
			self.close();
		}
	</script>
</body>
</html>