package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.EmpEvalService;
import empService.model.vo.EmpEvaluation;
import search.model.service.SearchService;
import search.model.vo.IncruitInfo;
import search.model.vo.OPhoto;

/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/detail.se")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int oNum =Integer.parseInt(request.getParameter("oNum"));
		System.out.println(oNum);
		
		IncruitInfo i = new SearchService().detailView(num);
		ArrayList<OPhoto> list = new SearchService().incruitPhotos(num);
		OPhoto p = new SearchService().searchLogo(oNum);
		ArrayList<EmpEvaluation> eList = new EmpEvalService().selectEmpEvalList(oNum);
		
		
		request.setAttribute("info", i);
		request.setAttribute("logo", p);
		request.setAttribute("pList", list);
		request.setAttribute("eList", eList);
		request.getRequestDispatcher("views/search/IncruitDetail.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
