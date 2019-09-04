package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.model.service.SearchService;
import search.model.vo.IncruitInfo;

/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/detailSearch.se")
public class DetailSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] details=new String[20];
		details=request.getParameter("detail").split(" ");
		
		ArrayList<IncruitInfo> list = new SearchService().searchDetail(details,1,20);
		int listCount = new SearchService().detailListCount(details);
		request.setAttribute("incruitList", list);
		request.setAttribute("detail", request.getParameter("detail"));
		request.getSession().setAttribute("maxPage", listCount);
		request.getRequestDispatcher("views/search/searchAllView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
