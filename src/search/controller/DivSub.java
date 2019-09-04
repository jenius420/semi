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
 * Servlet implementation class DivSub
 */
@WebServlet("/districtSub.se")
public class DivSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivSub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] dis = {request.getParameter("dis")};
		System.out.println("dis"+dis[0]);
		ArrayList<IncruitInfo> list = new SearchService().districtSearch(dis, 1, 20);
		int listCount = new SearchService().getDistrictListCount(dis);
		request.setAttribute("incruitList", list);
		request.setAttribute("maxPage", (listCount-1)/20+1);
		request.getRequestDispatcher("views/search/searchDistrictView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
