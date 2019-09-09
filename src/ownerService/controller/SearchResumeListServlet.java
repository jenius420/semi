package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.model.service.CommonService;
import common.model.vo.Attachment;
import common.model.vo.District;
import common.model.vo.JobType;
import empService.model.service.ResumeService;
import empService.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Filter;

/**
 * Servlet implementation class SearchResumeListServlet
 */
@WebServlet("/searchResumeList.os")
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
			
		}else {
			keyword = request.getParameter("keyword"); 
		}

		Filter filter = new Filter();

		filter.setDistrictNum(Integer.parseInt(request.getParameter("districtNum")));
		filter.setFinalEdu(request.getParameter("edu"));
//		filter.setSubCategory(request.getParameter("subCategory"));
//		filter.setBigCategory(request.getParameter("bigCategory"));
		filter.setGender(request.getParameter("gender"));
		filter.setAgeType(request.getParameter("ageType"));
		
		filter.setTypeNum(Integer.parseInt(request.getParameter("typeNum")));
		
		ArrayList<Resume> list = new IncruitService().selectSearchResumeList(keyword, filter);
		ArrayList<Resume> list2 = new ResumeService().selectAttachmentList(list); // 사진 추가
		
		ArrayList<District> dList = new CommonService().selectDistrictList();
		ArrayList<JobType> tList = new CommonService().selectTypeList();
		
		
		request.setAttribute("dList", dList);
		request.setAttribute("tList", tList);
		request.setAttribute("list", list2);
		request.setAttribute("filter", filter);
		request.setAttribute("keyword", keyword);
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
