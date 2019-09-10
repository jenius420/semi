package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.service.CommonService;
import common.model.vo.District;
import common.model.vo.JobType;
import empService.model.vo.Emp;
import ownerService.model.vo.Owner;
import ownerService.model.service.IncruitService;

/**
 * Servlet implementation class SearchResumeServlet
 */
@WebServlet("/searchResume.os")
public class SearchResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<District> dList = new CommonService().selectDistrictList();
		ArrayList<JobType> tList = new CommonService().selectTypeList();

		request.setAttribute("dList", dList);
		request.setAttribute("tList", tList);
		
		request.getRequestDispatcher("/views/ownerService/SearchResume.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
