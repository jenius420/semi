package ownerService.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import ownerService.model.vo.Owner;
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
		
		Owner owner = (Owner)request.getSession().getAttribute("owner");
		
		Incruit incruit = new Incruit();

		incruit.setwTitle(request.getParameter("wTitle"));
		incruit.setoNum(owner.getoNum());
		incruit.setDoneDate(java.sql.Date.valueOf(request.getParameter("endDate")));	
		String[] workDayArr = request.getParameterValues("workDay");
		incruit.setWorkDay(String.join("", workDayArr));
		incruit.setTermNo(Integer.parseInt(request.getParameter("termNo")));
		incruit.setWorkTime(request.getParameter("workTime"));
		incruit.setGender(request.getParameter("workGender"));
		if(request.getParameter("workAgeCheck") != null && request.getParameter("workAgeCheck").equals("Y")){
			incruit.setAge(request.getParameter("무관"));
		}else {
			incruit.setAge(request.getParameter("workAge1") + " ~ " + request.getParameter("workAge2"));
		}
		incruit.setAge(request.getParameter("workAge"));
		incruit.setEdu(request.getParameter("workEdu"));
		incruit.setSalaryForm(request.getParameter("workForm"));
		incruit.setSalary(Integer.parseInt(request.getParameter("salary")));
		incruit.setPeopleCount(request.getParameter("peopleCount"));
		incruit.setpNum(Integer.parseInt(request.getParameter("applyProduct")));	
		incruit.setDescription(request.getParameter("rExplain"));
			
		int result = new IncruitService().enrollIncruit(incruit);
		
		if(result > 0) {
			response.sendRedirect("incruitList.os"); 
		}else {
			request.setAttribute("msg", "공고 등록에 실패했습니다");
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
