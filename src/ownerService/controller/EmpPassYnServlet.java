package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import owner.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Appliant;

/**
 * Servlet implementation class EmpPassYnServlet
 */
@WebServlet("passYn.os")
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
		
		String passYn = (String)request.getAttribute("passYn");
		int applyNum = (int)request.getAttribute("applyNum");
		
		int result = new IncruitService().empPassYn(applyNum, passYn);
		
		if(result > 0) {
			request.setAttribute("msg", "성공적으로 처리했습니다");	
//			request.getRequestDispatcher("/views/ownerService/ManageEmp.jsp").forward(request, response);
//			response.sendRedirect("manageEmp.os");
		}else {
			request.setAttribute("msg", "처리에 실패했습니다");
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
