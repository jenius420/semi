package board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/BoardUpdate.bo")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");

//	System.out.println("확인"+request.getParameter("tNum"));
		
//		int tNum = Integer.parseInt(request.getParameter("tNum"));
//		System.out.println(tNum);
		String title = request.getParameter("title");
		System.out.println(title);
		int eNum = Integer.valueOf(((Member)request.getSession().getAttribute("loginUser")).geteNum());
		Date updateDate = Date.valueOf(request.getParameter("updateDate"));
		String bBody = request.getParameter("bBody");
		int boardCount = Integer.parseInt(request.getParameter("boardCount"));
				
		Board b = new Board();
		b.settNum(tNum);
		b.setTitle(title);
		b.seteNum(eNum);
		b.setUpdateDate(updateDate);
		b.setbBody(bBody);
		b.setBoardCount(boardCount);
		
		int result = new BoardService().updateBoard(b);
		
		if(result > 0) {
			response.sendRedirect("detail.no?tNum=" + tNum);
		} else {
			request.setAttribute("msg", "게시글 수정에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
