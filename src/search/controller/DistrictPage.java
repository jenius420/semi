package search.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.model.service.SearchService;

/**
 * Servlet implementation class DistrictPage
 */
@WebServlet("/districtPage.se")
public class DistrictPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistrictPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("currentPage"));
		String[] district=new String[25]; 
		district=request.getParameter("result").split("!");
		
		int listCount;
		if(district[0]=="") {
			listCount=new SearchService().listCount();
		}else {			
			listCount= new SearchService().getDistrictListCount(district);
		}
		int maxPage = listCount/20+1;
		response.getWriter().print(maxPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
