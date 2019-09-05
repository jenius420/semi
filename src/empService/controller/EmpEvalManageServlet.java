package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.service.EmpEvalService;
import empService.model.vo.EmpEvaluation;
import empService.model.vo.EmpEvaluationBefore;

/**
 * Servlet implementation class EmpEvalManageServlet
 */
@WebServlet("/empEvaluationManagement.es")
public class EmpEvalManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpEvalManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		ArrayList<EmpEvaluation> empEval = new EmpEvalService().selectEmpEval(emp.getEmpNum());
		ArrayList<EmpEvaluationBefore> empEvalBf = new EmpEvalService().selectEmpEvalBefore(emp.getEmpNum());
		

		request.setAttribute("empEvalBf", empEvalBf);
		request.setAttribute("empEval", empEval);
		request.getRequestDispatcher("/views/empService/EmpEvalManage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
