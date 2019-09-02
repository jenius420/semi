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

		Incruit incruit = new Incruit();
		
		incruit.setwNum(Integer.parseInt(request.getParameter("wNum")));
		incruit.setwTitle(request.getParameter("wTitle"));
		String workDay = request.getParameter("workDay");
		incruit.setDoneDate(java.sql.Date.valueOf(request.getParameter("endDate")));
		String[] workDayArr = request.getParameterValues("workDay");
		incruit.setWorkDay(String.join("", workDayArr));
		incruit.setTermNo(Integer.parseInt(request.getParameter("termNo")));
		incruit.setWorkTime(request.getParameter("workTime"));
		incruit.setGender(request.getParameter("workGender"));
		if(request.getParameter("workAgeCheck") != null && request.getParameter("workAgeCheck").equals("Y")){
			incruit.setAge("무관");
		}else {
			incruit.setAge(request.getParameter("workAge1") + "~" + request.getParameter("workAge2"));
		}
		incruit.setEdu(request.getParameter("workEdu"));
		incruit.setSalaryForm(request.getParameter("workForm"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		incruit.setPeopleCount(request.getParameter("peopleCount"));
		incruit.setpNum(Integer.parseInt(request.getParameter("applyProduct")));	
		incruit.setDescription(request.getParameter("rExplain"));

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
