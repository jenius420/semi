package empService.controller;

import java.io.File;
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
		String eComment = request.getParameter("eComment");
		int sevalPoint = Integer.parseInt(request.getParameter("sevalPoint"));
		
		EmpEvaluation eval = new EmpEvaluation();
		
		eval.setApplyNum(applyNum);
		eval.setoNum(oNum);
		eval.seteComment(eComment);
		eval.setSevalPoint(sevalPoint);
		
		int result = new EmpEvalService().submitEmpEval(eval);
		
		if(result > 0) {
			response.sendRedirect("empEvaluationManagement.es");
		}else {
			request.setAttribute("msg", "이력서 등록을 실패했습니다");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
