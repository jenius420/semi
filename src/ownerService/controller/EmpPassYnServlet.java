package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ownerService.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Appliant;

/**
 * Servlet implementation class EmpPassYnServlet
 */
@WebServlet("/passYn.os")
public class EmpPassYnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpPassYnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String passYn = (String)request.getParameter("passYn");
		int applyNum = Integer.parseInt(request.getParameter("applyNum"));
		
		int result = new IncruitService().empPassYn(applyNum, passYn);
		
		
		if(result > 0) {
			response.sendRedirect("manageEmp.os");
		}else {
			request.setAttribute("msg", "처리에 실패했습니다");
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
