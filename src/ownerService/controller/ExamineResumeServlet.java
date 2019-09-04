package ownerService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Resume;
import ownerService.model.service.IncruitService;

/**
 * Servlet implementation class ExamineResumeServlet
 */
@WebServlet("/examineResume.os")
public class ExamineResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamineResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		Resume resume = new IncruitService().selectResume(rNum);
		int result = new IncruitService().checkResume(rNum);
		
		if(resume != null) {
			request.setAttribute("resume", resume);
			request.getRequestDispatcher("/views/ownerService/ExamineResume.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "페이지 요청에 실패했습니다. 다시 시도해주세요");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
