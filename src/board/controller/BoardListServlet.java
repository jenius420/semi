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
		
		
		int listCount = new BoardService().getListCount();
	

		
		
		
		
		// -------------- 페이징 처리 -------------------
				int currentPage;   		// 현재 페이지
				int pageLimit;			// 한 페이지 하단에 보여질 페이지 수
				int maxPage;			// 전체 페이지에서 가장 마지막 페이지
				int startPage;			// 한 페이지 하단에 보여질 시작 페이지
				int endPage;			// 한 페이지 하단에 보여질 마지막 페이지
				
				int boardLimit = 10;			// 한 페이지에 보여질 게시글 최대 갯수
				
				// * currentPage : 현재페이지
				currentPage=1;
				
				// 페이지 전환시 전달 받은 현재 페이지가 있을 경우 전달받은 페이지를 currentpage로!
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// * pageLimit : 한 체이지 하단에 보여질 페이지 수
				pageLimit = 10;
				
				// * maxPage : 총 페이지 수
				// ex) boardLimit : 10
				// 100/10 ==>  	10페이지
				// 101/10 ==>	11페이지
				// 105/10 ==>	11페이지
				
				maxPage = (int)Math.ceil((double) listCount/boardLimit);
					
				// * startPagge : 현재 페이지에 보여지는 페이지방비의 시작 수
				// ex) pageLimit : 10
				
				//currentPage = 1	=> 0 * 10 +1 ==> 1
				//correntPage = 5 	=> 0* 10 + 1 ==>1
				
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
				// * endPage : 현재 피이지에서 보여질 마지막 페이지 수
				endPage = startPage + pageLimit -1;
				
				// ex) maxPage = 13, endPage =20
				if(maxPage < endPage) {
					endPage = maxPage; // maxPage =13, endPage = 13;	
				}
				

				
				// 페이지 정보들 PageInfo 객체에 담아주기
				PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
				

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ArrayList<Board> list = new BoardService().selectList(currentPage, boardLimit);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
