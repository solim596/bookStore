package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;

@WebServlet("/BookStore/download.do")
public class DownloadController extends HttpServlet {
	// 파일 다운로드 경로
	private static final String FiLES_DIR = "/upload";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// boardDetail.jsp 또는 boardList.jsp 페이지에서 넘겨주는
		// 매개변수를 각 변수에 저장
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		int boardID = Integer.parseInt(req.getParameter("boardID"));
		// 서버에 절대 경로 가져오기
		String filePath = req.getServletContext().getRealPath(FiLES_DIR);
		System.out.println(filePath);
		try {
			// 파일이 있는 폴더에서 파일을 가져와서 file에 저장
			File file = new File(filePath, ofile);
			// 만약 file변수가 비어 있으면(파일이 없으면) 콘솔에 에러 메시지 표시
			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다." + file.getAbsolutePath());
				res.sendError(HttpServletResponse.SC_NOT_FOUND, "파일을 찾을 수 없습니다.");
				return;
			}
			// 한글 깨짐 방지
			InputStream iStream = new FileInputStream(file);
			String client = req.getHeader("User-Agent");
			if (client.indexOf("WOW64") == -1) {
				ofile = new String(ofile.getBytes("UTF-8"), "ISO-8859-1");
			} else {
				ofile = new String(ofile.getBytes("KSC5601"), "ISO-8859-1");
			}
			// 파일 다운로드용 응답 헤더 설정
			res.reset();
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename=\"" + ofile + "\"");
			res.setHeader("Content-Length", "" + file.length());
			// response 내장객체로부터 새로운 출력 스트림 생성
			OutputStream oStream = res.getOutputStream();
			// 출력 스트림에 파일 내용 출력
			byte b [] = new byte[(int) file.length()];
			int readBuffer = 0;
			// 파일의 용량이 0보다 크면
			while((readBuffer = iStream.read(b)) > 0 ) {
				oStream.write(b, 0, readBuffer);
			}
			// 입력, 출력 스트림 닫음
			iStream.close();
			oStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		// 다운로드 수 증가
		BoardDAO dao = new BoardDAO();
		dao.downloadCount(boardID);
		dao.close();
	}
}
