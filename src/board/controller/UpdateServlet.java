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
@WebServlet("/test.bo")
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

	System.out.println("확인"+request.getParameter("tNum"));
		
		String tNum2 = request.getParameter("tNum");
		System.out.println(tNum2);
		String title = request.getParameter("title");
		System.out.println(title);
		int eNum = Integer.valueOf(((Member)request.getSession().getAttribute("loginUser")).geteNum());
		String bBody = request.getParameter("bBody");
		
		int tNum = Integer.valueOf(tNum2);
		Board b = new Board();
		b.settNum(tNum);
		b.setTitle(title);
		b.seteNum(eNum);
		b.setbBody(bBody);
		
		int result = new BoardService().updateBoard(b);
		
		if(result > 0) {
			response.sendRedirect("detail.bo?tNum=" + tNum);
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
