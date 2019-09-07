package empService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.EmpServiceService;
import empService.model.vo.Emp;

/**
 * Servlet implementation class ApplyServlet
 */
@WebServlet("/apply.es")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		int result = new EmpServiceService().apply(emp.getEmpNum(), wNum, rNum);
		
		response.sendRedirect("applicationState.es");
		
		// 디컴
//		if(result > 0) {
//			response.sendRedirect("applicationState.es");
//		}else if(result == -1){
//			request.setAttribute("msg", "이미 지원한 공고입니다. \n[알바 지원 현황] 메뉴에서 확인해주세요.");
//			request.getRequestDispatcher("/views/empService/WatchingIncruit2.jsp").forward(request, response);
//		}else {
//			request.setAttribute("msg", "요청에 실패했습니다");
//			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
