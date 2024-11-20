package model;

import java.sql.Date;

public class Cart {
	private int cartID;			// 장바구니 번호
	private String userID;		// 사용자 아이디
	private int bookID;			// 도서 번호
	private int num;			// 장바구니에 추가된 도서 수량
	private Date addDate;		// 장바구니에 추가된 날짜
	private String bookName;		// 도서 제목
	private String imageUrl;	// 도시 이미지
	private double price;		// 도서 가격
	
	
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
