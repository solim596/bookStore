package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import model.Cart;

@WebServlet("/JSPBookShop/cartView.do")
public class CartViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 세션에서 사용자 아이디 가져오기
		String userID = (String) session.getAttribute("userID");
		// 만약 userID가 없으면 로그인 페이지로 이동
		if (userID == null) {
			session.setAttribute("prevPage", "cartView.do");
			res.sendRedirect("login.jsp");
		} else {
			// CartDAO를 사용하여 장바구니의 데이터 가져오기
			CartDAO cartDao = new CartDAO();
			List<Cart> cartList = cartDao.cartList(userID);
			// 총 금액 계산
			double totalAmount = 0;
			for(Cart cart : cartList) {
				totalAmount += cart.getPrice() * cart.getNum();
			}
			// request내장객체에 cart를 세팅
			req.setAttribute("cartList", cartList);
			req.setAttribute("totalAmount", totalAmount);
			// 장바구니 페이지로 이동
			req.getRequestDispatcher("cartView.jsp").forward(req, res);
		}
	}
}
