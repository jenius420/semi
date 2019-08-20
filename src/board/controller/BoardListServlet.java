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
import board.model.vo.PageInfo;

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
		//총 게시글 갯수
		int listCount = new BoardService().getListCount();
		//------페이징 처리----------
		int currentPage;//현재페이지
		int pageLimit;//한페이지 하단에 보여질 페이지수
		int maxPage;//전체페이지에서 가장 마직막 페이지
		int startPage;// 한페이지 하단에 보여질 시작 페이지
		int endPage;//한페이지 하단에 보여질 마지막 페이지
		int boardLimit = 10; //한페이지에 보여질 게시글 최대 갯수
		
		//currentPage : 현재페이지
		currentPage =1;
		//페이지 전환시 전달받은 현재 페이지가 있을 경우 전달받은 페이지를 currentPage로
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		//pageLimit : 한페이지 하단에 보여질 페이지수
		pageLimit =10;
		
		
		//maxPage:총페이지수
		maxPage = (int) Math.ceil((double)(listCount/boardLimit))+1;
		//현재페이지에보여지는 페이징 바의 시작수
		startPage =((currentPage-1)/pageLimit)*pageLimit+1;
		//(int)Math.floor((double)currentPage-1)/pageLimit)*pageLimit+1;
		//현재페이지에보여지는 페이징 바의 마지막수
		endPage=((currentPage-1)/pageLimit)*10+10;
		//ex)maxPage =13, endPage=20
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		System.out.println("현재페이지" + currentPage);
		System.out.println("pageLimit" + pageLimit);
		System.out.println("maxP" + maxPage);
		System.out.println("startP" + startPage);
		System.out.println("endP" + endPage);
		System.out.println("listCount" + listCount);
		ArrayList<Board> list = new BoardService().selectList(currentPage, boardLimit);
		PageInfo pi = new PageInfo(currentPage, pageLimit, maxPage, startPage, endPage, boardLimit);
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