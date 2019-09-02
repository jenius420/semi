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

import ownerService.model.vo.Owner;
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
		
		Incruit incruit = new Incruit();
		
		
			String wTitle = request.getParameter("wTitle");
			String workDay = request.getParameter("workDay");
			int termNo = Integer.parseInt(request.getParameter("termNo"));
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String edu = request.getParameter("edu");
			String salaryForm = request.getParameter("salaryForm");
			int salary = Integer.parseInt(request.getParameter("salary"));
			int pNum = Integer.parseInt(request.getParameter("pNum"));
			String description = request.getParameter("description");
			String peopleCount = request.getParameter("peopleCount");
			
			incruit.setwNum(wNum);
			incruit.setwTitle(wTitle);
			incruit.setWorkDay(workDay);
			incruit.setTermNo(termNo);
			incruit.setGender(gender);
			incruit.setAge(age);
			incruit.setEdu(edu);
			incruit.setSalaryForm(salaryForm);
			incruit.setSalary(salary);
			incruit.setpNum(pNum);
			incruit.setDescription(description);
			incruit.setPeopleCount(peopleCount);

			
	

		int result = new IncruitService().updateIncruit(incruit);
		
		if(result > 0) {
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
