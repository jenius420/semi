package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 총 게시글 갯수
		int listCount = new BoardService().getListCount();
		
		// ----------- 페이징 처리 -------------
		int currentPage;		// 현재 페이지
		int pageLimit; 			// 한 페이지 하단에 보여질 페이지 수
		int maxPage;			// 전체 페이지에서 가장 마지막 페이지
		int startPage; 			// 한 페이지 하단에 보여질 시작 페이지
		int endPage;			// 한 페이지 하단에 보여질 마지막 페이지
		
		int boardLimit = 10;	// 한 페이지에 보여질 게시글 최대 갯수
		
		
		// * currentPage : 현재페이지
		currentPage = 1;
		
		// 페이지 전환시 전달받은 현재 페이지가 있을 경우 전달받은 페이지를 currentPage로!
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		// * pageLimit : 한 페이지 하단에 보여질 페이지 수
		pageLimit = 10;
		
		// * maxPage : 총 페이지 수 
		// ex) boardLimit : 10
		// 100.0 / 10 = 10.0 = 10.0 	=> 10페이지
		// 101.0 / 10 = 10.1 = 11.0		=> 11페이지
		// 105.0 / 10 = 10.5 = 11.0		=> 11페이지
		// 109.0 / 10 = 10.9 = 11.0		=> 11페이지
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		
		// * startPage : 현재 페이지에 보여지는 페이징바의 시작 수
		// ex) pageLimit : 10
		// 1, 11, 21, 31, .... 		=> n * 10 + 1
		// currentPage = 1			=> 0 * 10 + 1	=> 1
		// currentPage = 5			=> 0 * 10 + 1	=> 1
		// currentPage = 10			=> 0 * 10 + 1 	=> 1
		
		// currentPage = 11			=> 1 * 10 + 1	=> 11
		// currentPage = 15			=> 1 * 10 + 1	=> 11
		// currentPage = 20			=> 1 * 10 + 1	=> 11
		
		// currentPage = 1~10		=> n=0
		// currentPage = 11~20		=> n=1
		// 				n= (int)Math.floor(((double)currentPage - 1) / pageLimit)
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		
		// * endPage : 현재 페이지에서 보여질 마지막 페이지 수
		endPage = startPage + pageLimit - 1;
		
		// ex) maxPage = 13, endPage = 20
		if(maxPage < endPage) {
			endPage = maxPage;	// maxPage = 13, endPage = 13
		}
		
		
		// 현재 페이지(currentPage)에 따른 게시글 리스트 조회하기
		ArrayList<Board> list = new BoardService().selectList(currentPage, boardLimit);
		
		// 페이지 정보들 PageInfo 객체에 담아주기
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		// request에 전달값 담기
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/board/boardListViewTemp.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
