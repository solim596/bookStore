package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import model.Board;
import page.Paging;

@WebServlet("/JSPBookShop/boardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		// boardList 페이지에 전달할 매개변수용 배열 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// 검색창의 입력된 데이터가 있으면 가져와서 각 변수에 저장
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		if (searchWord != null) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		// 정렬 처리
		String sortObj = req.getParameter("sortObj");
		String sortOrder = req.getParameter("sortOrder");
		// 기본값 설정(정렬기준과 방향이 없으면 게시글 번호를 기준으로 내림차순함)
		if(sortObj == null) { sortObj = "boardID"; }
		if(sortOrder == null) { sortOrder = "desc"; }
		
		// paging 처리
		// BoardDAO의 selectAll메서드를 호출해서 구한 결과를 total변수에 저장
		int total = dao.selectAll(map);
		// 한 페이지에 출력되는 게시글 수
		int pageSize = 10;
		// 한번에 출력되는 페이지 번호의 개수
		int blockPage = 5;
		// 현재 페이지 확인
		int pageNum = 1;
		// 매개변수로 페이지 번호를 전달받아서 pageTemp에 저장
		String pageTemp = req.getParameter("pageNum");
		// 만약 페이지 번호가 비어 있지 않으면 요청받은 페이지수(문자열)를 정수형으로 변환하여 pageNum에 다시 저장
		if(pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);
		}
		// 한 페이지에 표시되는 마지막 게시글 번호
		int start = (pageNum - 1) * pageSize + 1;
		// 한 페이지에 표시되는 처음 게시글 번호
		int end = pageNum * pageSize;
		// map객체에 start와 end추가
		map.put("start", start);
		map.put("end", end);
		map.put("sortObj", sortObj);
		map.put("sortOrder", sortOrder);
		
		// 게시글 목록 구하기
		List<Board> boardList = dao.selectList(map, sortObj, sortOrder);
		// boardList.jsp페이지에 전달할 매개변수 추가
		String pagingVar = Paging.pagingStr(total, pageSize, blockPage, pageNum, "boardList.do");
		map.put("pagingVar", pagingVar);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		map.put("total", total);
		// boardList.jsp에 map과 boardList 전달
		req.setAttribute("map", map);
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("boardList.jsp").forward(req, res);
	}
}
