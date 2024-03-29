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
 * Servlet implementation class CateSubServlet
 */
@WebServlet("/cateSub.se")
public class CateSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateSubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] cate = {request.getParameter("cate")};
		ArrayList<IncruitInfo> list = new SearchService().categorySearch(cate, 1, 20);
		int listCount = new SearchService().getCateListCount(cate);
		request.setAttribute("incruitList", list);
		request.setAttribute("maxPage", (listCount-1)/20+1);
		request.setAttribute("cate", cate[0]);
		request.getRequestDispatcher("views/search/searchCategoryList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
