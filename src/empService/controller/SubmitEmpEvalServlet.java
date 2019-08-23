package empService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import empService.model.service.EmpEvalService;
import empService.model.service.EmpServiceService;
import empService.model.vo.EmpEvaluation;

/**
 * Servlet implementation class SubmitEmpEvalServlet
 */
@WebServlet("/submitEmpEval.es")
public class SubmitEmpEvalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitEmpEvalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("loginUser");
		
		int applyNum = Integer.parseInt(request.getParameter("applyNum"));
		int eNum = emp.getEmpNum();
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		int point = Integer.parseInt(request.getParameter("point"));
		String comment = request.getParameter("comment");
		
		EmpEvaluation eval = new EmpEvaluation();
		
		eval.setApplyNum(applyNum);
		eval.seteNum(eNum);
		eval.setoNum(oNum);
		eval.setSevalPoint(point);
		eval.seteComment(comment);
		
		int result = new EmpEvalService().submitEmpEval(eval);
		
		if(result > 0) {
			response.sendRedirect("empEvaluationManagement.es");
		}else {
			request.setAttribute("msg", "요청을 실패했습니다");
			request.getRequestDispatcher("/views/common/ErrorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
