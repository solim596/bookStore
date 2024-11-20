package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import message.ShowMessage;
import model.Member;

@WebServlet("/BookStore/regester.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 기본 생성자(부모 클래스의 생성자 호출)
	public RegisterController() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		MemberDAO dao = new MemberDAO();
		Member member = new Member(userID, password, email);
		int result = dao.register(member);
		if(result != 0) {
			ShowMessage.alertLocation(res,"회원이 되신것을 축하합니다.", "login.jsp");
		}else {
			ShowMessage.alertBack(res,"회원가입에 실패하셨습니다.");			
		}
	}
}
