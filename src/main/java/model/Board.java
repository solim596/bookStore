package model;

import java.sql.Date;

public class Board {
	private int boardID; // 일련번호(자동증가)
	private String title; // 글제목
	private String content; // 글내용
	private String userID; // 글 작성자 아이디
	private Date postDate; // 글 작성 날짜
	private String ofile; // 원본 파일명
	private String sfile; // 사본 파일명
	private int downcount; // 파일 다운로드 수
	private String pass; // 비밀번호
	private int visitcount; // 글 조회 수
	
	// 디폴트 생성자
	public Board() {}
	public Board(int boardID, String title, String content, String userID, String ofile, String sfile, String pass) {
		this.boardID = boardID;
		this.title = title;
		this.content = content;
		this.userID = userID;
		this.ofile = ofile;
		this.sfile = sfile;
		this.pass = pass;
	}
	
	// 매개변수가 6개인 생성자 만들기
	public Board(String title, String content, String userID, String ofile, String sfile, String pass) {
		this.title = title;
		this.content = content;
		this.userID = userID;
		this.ofile = ofile;
		this.sfile = sfile;
		this.pass = pass;
	}
	
	// getter and setter
	public int getBoardID() {
		return boardID;
	}

	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getOfile() {
		return ofile;
	}

	public void setOfile(String ofile) {
		this.ofile = ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}

}
