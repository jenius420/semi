package empService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.ResumeService;

/**
 * Servlet implementation class DeleteResumeServlet
 */
@WebServlet("/deleteResume.es")
public class DeleteResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		int result = new ResumeService().deleteResume(rNum);
		
		if(result > 0) {
			request.setAttribute("msg", "이력서 삭제 성공");	
			request.getRequestDispatcher("views/empService/ManageResume.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "이력서 삭제에 실패했습니다");
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