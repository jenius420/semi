package ownerService.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import owner.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class SubmitIncruitServlet
 */
@WebServlet("/submitIncruit.os")
public class SubmitIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Owner owner = (Owner)request.getSession().getAttribute("user");
		Incruit incruit = null;
		
		try {
			
			String wTitle = request.getParameter("wTitle");
			int oNum = owner.getoNum();
			Date workStartTerm = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("workStartTerm");
			Date workEndTerm = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("workEndTerm");
			String workDay = request.getParameter("workDay");
			String workStartTime = request.getParameter("workStartTime");
			String workEndTime = request.getParameter("workEndTime");
			int termNo = Integer.parseInt(request.getParameter("termNo"));
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			String edu = request.getParameter("edu");
			Date enrollDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("enrollDate");
			String status = request.getParameter("status");
			Date doneDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("doneDate");
			String salaryForm = request.getParameter("salaryForm");
			int salary = Integer.parseInt(request.getParameter("salary"));
			int pNum = Integer.parseInt(request.getParameter("pNum"));
			String description = request.getParameter("description");
			
			incruit = new Incruit(wTitle, oNum, workStartTerm, workEndTerm, workDay, workStartTime, workEndTime, termNo,
					gender, age, edu, enrollDate, status, doneDate, salaryForm, salary, pNum, description);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int result = new IncruitService().enrollIncruit(incruit);
		
		if(result > 0) {
			request.setAttribute("msg", "공고를 성공적으로 등록했습니다");	
//			request.getRequestDispatcher("/views/ownerService/ManageIncruit.jsp").forward(request, response);
//			response.sendRedirect("incruitList.os"); 
		}else {
			request.setAttribute("msg", "공고 등록에 실패했습니다");
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
