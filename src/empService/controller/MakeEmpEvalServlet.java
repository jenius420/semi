package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.EmpEvalService;
import empService.model.vo.EmpEvaluation;

/**
 * Servlet implementation class MakeEmpEvalServlet
 */
@WebServlet("/makeEmpEval.es")
public class MakeEmpEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeEmpEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int applyNum = Integer.parseInt(request.getParameter("applyNum"));
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		
		ArrayList<EmpEvaluation> list = new EmpEvalService().selectEmpEvalList(oNum);
		
			request.setAttribute("applyNum", applyNum);
			request.setAttribute("oNum", oNum);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/empService/makeEmpEval.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
