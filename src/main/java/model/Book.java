package model;

import java.sql.Date;

public class Book {
	private String bookID; 		// 도서번호
	private String bookName; 	// 도서명
	private int price; 			// 가격
	private String author; 		// 저자명
	private String description; // 설명
	private String publisher; 	// 출판사
	private String category; 	// 도서분류
	private long unitsInStock; 	// 재고수
	private long totalPages; 	// 총 페이지수
	private Date releaseDate; 	// 출판일
	private String imageUrl; 	// 이미지 경로
	private String userID; 		// 사용자 아이디

	// 디폴트 생성자
	public Book() {
	}

	// 생성자 오버로딩
	public Book(String bookName, int price, String author, String description, String publisher, String category,
			long unitsInStock, long totalPages, Date releaseDate, String imageUrl, String userID) {
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.description = description;
		this.publisher = publisher;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.totalPages = totalPages;
		this.releaseDate = releaseDate;
		this.imageUrl = imageUrl;
		this.userID = userID;
	}

	public Book(String bookID, String bookName, int price, String author, String description, String publisher,
			String category, long unitsInStock, long totalPages, Date releaseDate, String imageUrl, String userID) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.description = description;
		this.publisher = publisher;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.totalPages = totalPages;
		this.releaseDate = releaseDate;
		this.imageUrl = imageUrl;
		this.userID = userID;
	}

	// getter and setter
	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
