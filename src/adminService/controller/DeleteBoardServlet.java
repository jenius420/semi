package adminService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageBoardService;
import adminService.model.service.ManageMemService;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard.as")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String[] tNumArr = request.getParameterValues("tNumArr");
		
		int count = new ManageBoardService().deleteBoard(tNumArr);
		
		// 비동기 처리?
		request.setAttribute("msg", count + "개 게시글 삭제 완료");
		request.getRequestDispatcher("/views/adminService/BoardReportList.jsp").forward(request, response);

		response.sendRedirect("boardReportList.as?msg="+ count + "개 게시글 삭제 완료"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
