package adminService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageBoardService;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deleteComment.as")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String[] cNumArr = request.getParameterValues("cNumArr");
		
		int count = new ManageBoardService().deleteComment(cNumArr);
		
		// 비동기 처리?
		request.setAttribute("msg", count + "개 댓글 삭제 완료");
		request.getRequestDispatcher("/views/adminService/CommentReportList.jsp").forward(request, response);

		response.sendRedirect("commentReportList.as?msg="+ count + "개 댓글 삭제 완료"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
