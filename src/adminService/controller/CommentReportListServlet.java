package adminService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageBoardService;
import board.model.vo.Board;
import board.model.vo.Comment;

/**
 * Servlet implementation class CommentWarningListServlet
 */
@WebServlet("/commentReportList.as")
public class CommentReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Comment> list = new ManageBoardService().selectCommentReportList();
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/adminService/CommentReportList.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "페이지 요청에 실패했습니다. 다시 시도해주세요");
			request.getRequestDispatcher("/views/common/ErrorPage.jsp").forward(request, response);
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
