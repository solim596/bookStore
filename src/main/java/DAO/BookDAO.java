package DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import model.Book;
import model.DBCon;

public class BookDAO extends DBCon {
	public BookDAO() {
		// 부모 클래스의 생성자 호출(DB연동)
		super();
	}

	// 도서 등록
	public int addBook(Book book) {
		int result = 0;
		String sql = "insert into book (bookName, price, author, description, publisher, category, unitsInStock, totalPages, releaseDate, imageUrl, userID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setInt(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getDescription());
			pstmt.setString(5, book.getPublisher());
			pstmt.setString(6, book.getCategory());
			pstmt.setLong(7, book.getUnitsInStock());
			pstmt.setLong(8, book.getTotalPages());
			pstmt.setDate(9, book.getReleaseDate());
			pstmt.setString(10, book.getImageUrl());
			pstmt.setString(11, book.getUserID());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 도서 목록
	public List<Book> bookList() {
		// Book클래스의 형식을 가진 books 인스턴스 배열 생성
		List<Book> books = new ArrayList<>();
		String sql = "select * from book order by bookID desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBookName(rs.getString("bookName"));
				book.setPrice(rs.getInt("price"));
				book.setAuthor(rs.getString("author"));
				book.setDescription(rs.getString("description"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setUnitsInStock(rs.getLong("unitsInStock"));
				book.setTotalPages(rs.getLong("totalPages"));
				book.setReleaseDate(rs.getDate("releaseDate"));
				book.setImageUrl(rs.getString("imageUrl"));
				book.setUserID(rs.getString("userID"));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	// 도서 수정
	public int updateBook(Book book) {
		int result = 0;
		String sql = "update book set bookName=?, price=?, author=?, description=?, publisher=?, category=?, unitsInStock=?, totalPages=?, releaseDate=?, imageUrl=? where bookID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setInt(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getDescription());
			pstmt.setString(5, book.getPublisher());
			pstmt.setString(6, book.getCategory());
			pstmt.setLong(7, book.getUnitsInStock());
			pstmt.setLong(8, book.getTotalPages());
			pstmt.setDate(9, book.getReleaseDate());
			pstmt.setString(10, book.getImageUrl());
			pstmt.setString(11, book.getBookID());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 도서 삭제
	public int deletePosts(int bookID) {
		int result = 0;
		String sql = "delete from book where bookID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 도서 목록의 총 개수 구하기
	public int selectCount() {
		int total = 0;
		String sql = "select count(*) from book";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

	// 도서 상세 보기
	public Book selectOne(int bookID) {
		// Biik클래스를 사용하여 dto인스턴스 생성
		Book dto = new Book();
		String sql = "select * from book where bookID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBookID(rs.getString(1));
				dto.setBookName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setAuthor(rs.getString(4));
				dto.setDescription(rs.getString(5));
				dto.setPublisher(rs.getString(6));
				dto.setCategory(rs.getString(7));
				dto.setUnitsInStock(rs.getLong(8));
				dto.setTotalPages(rs.getLong(9));
				dto.setReleaseDate(rs.getDate(10));
				dto.setImageUrl(rs.getString(11));
				dto.setUserID(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 비밀번호 검증하기
	public boolean confirmPass(String pass) {
		boolean result = true;
		String sql = "select count(*) from member where password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			// ResultSet(rs)객체에 질의어(sql) 실행한 결과값을 저장
			rs = pstmt.executeQuery();
			// 만약 rs객체에서 가져온 정수값이 0이면(실행결과가 없으면)
			// result변수에 false를 저장
			rs.next();
			if (rs.getInt(1) == 0) {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 카테고리 목록 가져오기 메서드
	public List<String> cateList() {
		List<String> cateList = new ArrayList<>();
		String sql = "select cateName from category";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cateList.add(rs.getString("cateName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cateList;
	}

	// 첨부이미지 삭제하는 메서드
	public void deleteFile(HttpServletRequest req, String dir, String fileName) {
		// 파일이 업로드 되어있는 폴더의 절대경로를 sDiir변수에 저
		String sDir = req.getServletContext().getRealPath(dir);
		// 매개변수로 전달받은 파일명을 가진 파일을 찾아서 file변수에 저장
		File file = new File(sDir + File.separator + fileName);
		// 만약 파일이 존재하면 그 파일을 sDir(/upload) 폴더에서 삭제
		if (file.exists()) {
			file.delete();
		}
	}
}
