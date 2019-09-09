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
 * Servlet implementation class BoardSearchServlet
 */
@WebServlet("/search.bo")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		System.out.println(category);
		String sText = request.getParameter("sText");
		System.out.println(sText);
		ArrayList<Board> list = new BoardService().boardSearch(category,sText);
		System.out.println(list);
		int listCount = new BoardService().getSearchListCount(category,sText);
		
		
		
		
		int currentPage;   		
		int pageLimit;			
		int maxPage;			
		int startPage;			
		int endPage;			
		
		int boardLimit = 10;			
		
		currentPage=1;
		

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		
		maxPage = (int)Math.ceil((double) listCount/boardLimit);
			
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit -1;
		

		if(maxPage < endPage) {
			endPage = maxPage; 
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		

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
