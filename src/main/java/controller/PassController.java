package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import message.ShowMessage;
import model.Book;

@WebServlet("/BookStore/pass.do")
public class PassController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 매개변수 mode의 값을 문자열로 전달받아서 request내장객체의 mode속성으로 세팅
		req.setAttribute("mode", req.getParameter("mode"));
		// 세팅한 mode속성을 가지고 bookUpdate.jsp페이지로 이동
		req.getRequestDispatcher("pass.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 매개변수의 값 저장하기
		int bookID = Integer.parseInt(req.getParameter("bookID"));
		String mode = req.getParameter("mode");
		String pass = req.getParameter("password");
		
		// 비밀번호 확인하기 
		BookDAO dao = new BookDAO();
		boolean result = dao.confirmPass(pass);
		dao.close();
		// 만약 비밀번호가 일치하면 mode가 edit인지 delete인지 검사
		if(result) {
			if(mode.equals("edit")) {
				// session내장객체에 비밀번호를 pass속성으로 세팅
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				res.sendRedirect("bookUpdate.do?bookID=" + bookID);
				
			}else if(mode.equals("delete")) {
				dao = new BookDAO();
				Book dto = dao.selectOne(bookID);
				// session내장객체에 비밀번호를 pass속성으로 세팅
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				int deleted = dao.deletePosts(bookID);
				dao.close();
				// DB의 book테이블에서 도서번호가 bookID인 레코드 삭제 성공
				if(deleted == 1) {
					String saveFileName = dto.getImageUrl();
	            	dao.deleteFile(req, "/images", saveFileName);
					ShowMessage.alertLocation(res, "도서가 삭제되었습니다.", "bookList.do");
				// 파일 삭제 실패
				} else {
					ShowMessage.alertBack(res, "도서가 삭제되지 않았습니다.");
				}
			}
		} else {
			ShowMessage.alertBack(res, "비밀번호가 일치하지 않습니다.");
		}
		
	}
}
