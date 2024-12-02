package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import model.Book;

@WebServlet("/BookStore/bookDetail.do")
public class BookDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// BookDAO클래스를 사용하여 dao인스턴스 생성
		BookDAO dao =  new BookDAO();
		// bookList.jsp페이지에서 매개변수로 넘긴 bookID변수의 값을 정수형으로 형변환하여 bookID변수에 저장
		int bookID = Integer.parseInt(req.getParameter("bookID"));
		// bookID값을 dao인스턴스의 selectOne메서드의 매개변수로 넘기고, selectOne메서드의 결과값을 받아옴.
		Book dto = dao.selectOne(bookID);
		// dto의 결과값을 view(bookDetail.jsp)로 넘기기 위해 속성 지정
		req.setAttribute("dto", dto);
		// request, response내장객체를 가지고 view(bookDetail.jsp)로 이동
		req.getRequestDispatcher("bookDetail.jsp").forward(req, res);
		
	}
}
