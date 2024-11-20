package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import model.Book;

@WebServlet("/BookStore/bookList.do")
public class BookListController extends HttpServlet	 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// BookDAO클래스를 사용하여 dao 인스턴스 생성
		BookDAO dao = new BookDAO();
		// dao인스턴스의 bookList()메서드를 호출하고,
		// 호출한 결과값을 bookList에 저장
		List<Book> bookList = dao.bookList();
		// dao인스턴스에서 book목록의 총 개수를 구해서 totalCount에 저장
		int totalCount = dao.selectCount();
		// 가져온 도서목록을 request내장객체에 저장하여 jsp페이지로 전달
		req.setAttribute("bookLists", bookList);
		req.setAttribute("totalCount", totalCount);
		req.getRequestDispatcher("bookList.jsp").forward(req, res);
	}
}
