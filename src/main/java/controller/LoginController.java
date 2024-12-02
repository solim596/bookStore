package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import message.ShowMessage;

@WebServlet("/BookStore/login.do")
public class LoginController extends HttpServlet {
	public LoginController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// session내장객체에서 session정보를 가져와서 session변수에 저장
		HttpSession session = req.getSession();
		// 로그인 페이지로 오기 전에 사용자가 요청한 URL을 session에 저장
		String prevPage = req.getHeader("Referer");
		if(prevPage != null && !prevPage.contains("/login.do")) {
			session.setAttribute("prevPage", prevPage);
		}
		
		// 내장객체 request, response의 모든 속성을 login.jsp에 전달하면서 페이지 이동
		// req.getRequestDispatcher("login.jsp").forward(req, res);
		res.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userID = req.getParameter("userID");
		String password = req.getParameter("password");

		// MemberDAO클래스를 사용하여 dao인스턴스 생성
		MemberDAO dao = new MemberDAO();
		// dao인스턴스의 login메서드 호출하면서 userID과 password값을 매개변수로 전달
		// login메서드에서 반환한 결과값을 result변수에 저장
		int result = dao.login(userID, password);
		// 만약 result값이 1이면 로그인 성공이므로 세션에 사용자 아이디를 저장
		if (result == 1) {
			alert("로그인 성공");
			session.setAttribute("userID", userID);
			// 세션 내장객체에서 prevPage속성값을 가져와서 prevPage변수에 저장
			String prevPage = (String) session.getAttribute("prevPage");
			// 만약 prevPage가 null이 아니라면 prevPage속성값을 제거하고, prevPage로 이동
			if(prevPage != null) {
				session.removeAttribute("prevPage");
				res.sendRedirect(prevPage);
			// prevPage값이 null이면 index페이지로 이동
			} else { 
				res.sendRedirect("index.jsp");
			}
			// 로그인 하지 못했으면 메시지 표시하고 로그인 화면으로 돌아감
		} else {
			ShowMessage.alertBack(res, "아이디 또는 비밀번호가 맞지 않습니다.");
		}
	}

	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
}
