package message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ShowMessage {
	// 메시지 알림창 표시한 다음 해당 url로 이동하는 메서드
	public static void alertLocation(HttpServletResponse res, String msg, String url) throws ServletException, IOException {
		try {
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			String script = "<script>alert('" + msg + "'); location.href='" + url + "';</script>";
			writer.print(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 메시지 알림창 표시한 다음 이전 페이지로 이동하는 메서드
	public static void alertBack(HttpServletResponse res, String msg) { 
		try { 
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			String script = "<script>alert('" + msg + "'); history.back();</script>";
			writer.print(script);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
