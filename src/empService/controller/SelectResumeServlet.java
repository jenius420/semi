package empService.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.vo.Attachment;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;

/**
 * Servlet implementation class SelectResumeServlet
 */
@WebServlet("/selectResume.es")
public class SelectResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		Resume resume = new ResumeService().selectResume(rNum);
		Attachment at = new ResumeService().selectAttachment(rNum);
		
		if(resume != null) {
			request.setAttribute("resume", resume);	
			request.setAttribute("at", at);	
			request.getRequestDispatcher("views/empService/SelectResume.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "요청하신 페이지에 접속 실패했습니다");
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
