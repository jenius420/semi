package ownerService.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import owner.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class UpdateIncruitServlet
 */
@WebServlet("/updateIncruit.os")
public class UpdateIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		
		Incruit incruit = new Incruit();;
		
		try {
			String wTitle = request.getParameter("wTitle");
			Date workStartTerm = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("workStartTerm");
			Date workEndTerm = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("workEndTerm");
			String workDay = request.getParameter("workDay");
			String workStartTime = request.getParameter("workStartTime");
			String workEndTime = request.getParameter("workEndTime");
			int termNo = Integer.parseInt(request.getParameter("termNo"));
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			String edu = request.getParameter("edu");
			String salaryForm = request.getParameter("salaryForm");
			int salary = Integer.parseInt(request.getParameter("salary"));
			int pNum = Integer.parseInt(request.getParameter("pNum"));
			String description = request.getParameter("description");
			int peopleCount = Integer.parseInt(request.getParameter("peopleCount"));
			
			incruit.setwNum(wNum);
			incruit.setwTitle(wTitle);
			incruit.setWorkStartTerm(workStartTerm);
			incruit.setWorkEndTerm(workEndTerm);
			incruit.setWorkDay(workDay);
			incruit.setWorkStartTime(workStartTime);
			incruit.setWorkEndTime(workEndTime);
			incruit.setTermNo(termNo);
			incruit.setGender(gender);
			incruit.setAge(age);
			incruit.setEdu(edu);
			incruit.setSalaryForm(salaryForm);
			incruit.setSalary(salary);
			incruit.setpNum(pNum);
			incruit.setDescription(description);
			incruit.setPeopleCount(peopleCount);

			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int result = new IncruitService().updateIncruit(incruit);
		
		if(result > 0) {
			request.setAttribute("msg", "공고를 성공적으로 수정했습니다");	
//			request.getRequestDispatcher("/views/ownerService/incruitList.os.jsp").forward(request, response);
			response.sendRedirect("incruitList.os"); 
		}else {
			request.setAttribute("msg", "공고 수정에 실패했습니다");
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
