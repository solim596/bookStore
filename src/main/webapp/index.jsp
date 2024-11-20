<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 쇼핑몰 - 마니도서</title>
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
	<div class="wrap">
		<jsp:include page="nav.jsp"></jsp:include>
		<div class="main">
			<!-- Carousel -->
			<div id="demo" class="carousel slide" data-bs-ride="carousel">

				<!-- 페이지네이션 -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
						class="active"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="4"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="5"></button>
				</div>

				<!-- 케로우셀 이미지 -->
				<div class="carousel-inner carousel-fade">
					<div class="carousel-item cr1 active">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>토익시험 기출이 답이다!!</p>
									<h1>
										한권으로 마스터하는<br>토익 최신개정판 <br>
									</h1> <span>예약판매 10% 할인</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"> <span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book1.jpg" alt="토익기출" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
					<div class="carousel-item cr2">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>수험 최적화 버전으로 개편</p>
									<h1>
										2025 필수<br>행정법총론 총집합!
									</h1> <span>5만원 이상 구매 시 2천원 할인</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"> <span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book2.jpg" " alt="행정법총론기출" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
					<div class="carousel-item cr3">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>또 다른 사피엔스를 소개합니다.</p>
									<h1>
										쉽고 재밌는 또 다른<br>『사피엔스』의 탄생!
									</h1> <span>3만원 이상 구매 시 2천원 할인</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"> <span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book3.jpg" alt="사피엔스" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
					<div class="carousel-item cr4">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>양귀자 장편소설</p>
									<h1>베스트셀러 1위 등극</h1> <span>토스페이로 결제시 10% 할인</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"> <span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book4.jpg" alt="모순" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
					<div class="carousel-item cr5">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>또 다른 사피엔스를 소개합니다.</p>
									<h1>2025 행정법총론 핵심집약</h1> <span>기간한정 최대 15% 할인</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"> <span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book5.jpg" alt="행정법총론핵심" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
					<div class="carousel-item cr6">
						<div
							class="carousel-in d-flex justify-content-around align-items-center">
							<div class="des">
								<a href="#">
									<p>당신은 왜 부자가 되지 못했는가</p>
									<h1>
										돈의심리학<br>(30만 부 기념 스페셜 에디션)
									</h1> <span>추천인 입력시 최대 15% 할인쿠폰 증정</span>
								</a>
							</div>
							<div class="book-img">
								<a href="#"><span><i class="fa-regular fa-circle"></i></span>
									<img src="img/book6.jpg" alt="돈의심리학" class="d-block w-100">
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- carousel -->
			<div class="main-banner">
				<div class="banner1">
					<a href="#">
						<div class="banner-img">
							<img alt="한가위" src="img/banner1.png">
						</div>
						<div class="banner-des">
							<span>#추석#가족#한가위#읽기좋은책</span>
							<h4>추석에 읽기 좋은 책</h4>
							<p>
								<i class="fa-solid fa-arrow-right-long"></i>
							</p>
						</div>
					</a>
				</div>
				<div class="banner2">
					<a href="#">
						<div class="banner-img">
							<img alt="노벨문학상" src="img/banner2.png">
						</div>
						<div class="banner-des">
							<span>#2024년#10월#최고#영예#주인공</span>
							<h4>세계 최고 권위의 노벨문학상</h4>
							<p>
								<i class="fa-solid fa-arrow-right-long"></i>
							</p>
						</div>
					</a>
				</div>
			</div><!-- main-banner -->
		</div><!-- main -->
		<div class="field">
			<div class="center">
				<h2>분야별 도서</h2>
				<p>찾으시는 분야의 도서를 골라보세요.</p>
				<div class="field-box">
					<ul>
						<li>
							<a href="#">
								<img src="img/best.svg" alt="베스트셀러">
								<p>베스트셀러</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/science.svg" alt="과학">
								<p>과학</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/law.svg" alt="법학">
								<p>법학</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/statistics.svg" alt="통계학">
								<p>통계학</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/management.svg" alt="경영학">
								<p>경영학</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/economy.svg" alt="경제학">
								<p>경제학</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/accounting.svg" alt="회계/세무회계">
								<p>회계/세무회계</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/health.svg" alt="보건/교양">
								<p>보건/교양</p>
							</a>
						</li>
						<li>
							<a href="#">
								<img src="img/society.svg" alt="인문학">
								<p>인문학</p>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div><!-- field -->
		<div class="new">
			<div class="center">
				<h2>지금 이 책!</h2>
				<p>주목해 주세요!! 새로 나왔어요!</p>
				<div class="new-box">
					<ul>
						<li>
							<a href="#">
								<div class="new-img">
									<b><i>61가지 성공 비밀</i></b>
									<div class="new-img-ani">
										<img src="img/new1.jpg" alt="타이탄의 도구들">
									</div>
								</div>
								<div class="new-des">
									<span>세계 최고들은 1등이 아니다.</span>
									<p>그들은 1등과 싸워 이긴 사람들이다!</p>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="new-img">
									<b><i>멋지게 살아가기</i></b>
									<div class="new-img-ani">
										<img src="img/new2.jpg" alt="그래도 인생은 살아볼 만해">
									</div>
								</div>
								<div class="new-des">
									<span>행복은 한 가지 모양이 아니니까!</span>
									<p>불안의 시대, 방황하는 청년들에게 전하는 희망의 메시지</p>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="new-img">
									<b><i>개발자 필수 도구</i></b>
									<div class="new-img-ani">
										<img src="img/new3.jpg" alt="그림과 실습으로 배우는 깃 & 깃허브 입문">
									</div>
								</div>
								<div class="new-des">
									<span>Git, GitHub 입문.</span>
									<p>처음부터 제대로 배우는 개발자 필수 도구</p>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="new-img">
									<b><i>교양 반전 과학</i></b>
									<div class="new-img-ani">
										<img src="img/new4.jpg" alt="이과형의 그런데 이것은 과학책입니다 ①고전과학 편">
									</div>
								</div>
								<div class="new-des">
									<span>그런데 이것은 틀렸습니다</span>
									<p>탄탄한 과학적 사실에 따뜻한 위로를 담은 말랑말랑한 과학 교양서!</p>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div><!-- new -->
		<div class="new-more">새로운 도서 더 보기</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div><!-- wrap -->
</body>
</html>