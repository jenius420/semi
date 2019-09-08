																																																																																																																																																																								package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import empService.model.service.EmpServiceService;
import empService.model.service.ResumeService;
import empService.model.vo.Emp;
import empService.model.vo.Resume;
import member.model.vo.Member;

/**
 * Servlet implementation class ResumeCheck
 */
@WebServlet("/resumeCheck.se")
public class ResumeCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		ArrayList<Resume> list = new ResumeService().selectResumeList(emp.getEmpNum());
		request.setAttribute("wNum", wNum);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/search/searchResume.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
