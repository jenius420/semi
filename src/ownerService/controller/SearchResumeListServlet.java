package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import empService.model.vo.Resume;
import owner.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Filter;

/**
 * Servlet implementation class SearchResumeListServlet
 */
@WebServlet("/searchResumeListServlet")
public class SearchResumeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResumeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword"); 
		
		String district = request.getParameter("district");
		String type = request.getParameter("type"); 
		String desireForm = request.getParameter("desireForm");
		int desireIncome = Integer.parseInt(request.getParameter("desireIncome"));
		String finalEdu = request.getParameter("finalEdu");
		
		Filter filter = new Filter();
		filter.setDistrict(district);
		filter.setType(type);
		filter.setDesireForm(desireForm);
		filter.setDesireIncome(desireIncome);
		filter.setFinalEdu(finalEdu);
		
		ArrayList<Resume> list = new IncruitService().selectSearchResumeList(keyword, filter);
		

		//비동기 처리??

		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/ownerService/searchResume.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
