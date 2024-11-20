package DAO;

import model.DBCon;
import model.Member;

public class MemberDAO extends DBCon {
	// 생성자
	public MemberDAO() {
		// 부모 클래스의 생성자 호출(DB접속)
		super();
	}

	// 회원가입 메서드
	public int register(Member member) {
		int result = 0;
		String sql = "insert into member (userID, password, email) values (?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 로그인 했는지 검사하는 메서드
	public boolean validateLogin(String userID, String password) {
		boolean isValid = false;
		String sql = "select * from member where userID=? and password=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				isValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	// 아이디 중복 확인 검사
	public int idCheckfn(String userID) {
		int dbCheck = 0;
		String sql = "select userID from member where userID = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbCheck = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbCheck;
	}
	// 로그인 검사
	public int login(String userID, String password) {
		int result = 0;
		String sql = "select * from member where userID = ? and password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
