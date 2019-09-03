package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Owner;
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
		
		String keyword = "";
		
		if(request.getParameter("keyword") == null) {
			return;
		}else {
			keyword = request.getParameter("keyword"); 
		}
		
		Filter filter = new Filter();
		
		filter.setDistrictNum(Integer.parseInt(request.getParameter("districtNum")));
		filter.setTypeNum(Integer.parseInt(request.getParameter("typeNum")));
		if(request.getParameter("edu") == null) {
			filter.setFinalEdu(null);
		}else {
			filter.setFinalEdu(request.getParameter("edu"));
		}
		if(request.getParameter("desireForm") == null) {
			filter.setDesireForm(null);
			filter.setDesireIncome(999999999);
		}else {
			filter.setDesireForm(request.getParameter("desireForm"));
			filter.setDesireIncome(Integer.parseInt(request.getParameter("desireIncome")));
		}


		
		ArrayList<Resume> list = new IncruitService().selectSearchResumeList(keyword, filter);
		
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
