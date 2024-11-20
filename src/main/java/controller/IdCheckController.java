package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

@WebServlet("/BookStore/idCheck.do")
public class IdCheckController extends HttpServlet{
	public IdCheckController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 회원가입 입력폼의 아이디 값을 가져와서 userID에 저장
		String userID = req.getParameter("userID");
		MemberDAO dao = new MemberDAO();
		int result = dao.idCheckfn(userID);
		// request내장객체에 userID속성으로 세팅
		req.setAttribute("userID", userID);
		req.setAttribute("result", result);
		// request내장객체의 모든 속성을 갖고 idCheck.jsp페이지 이동
		req.getRequestDispatcher("idCheck.jsp").forward(req, res);
	}
}
