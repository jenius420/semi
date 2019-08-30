package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.service.EmpServiceService;
import ownerService.model.vo.Owner;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class DeleteInterestOwnerServlet
 */
@WebServlet("/deleteInterestOwnerServlet.es")
public class DeleteInterestOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInterestOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");

		int hNo = Integer.parseInt(request.getParameter("hNo"));
		
		int result = new EmpServiceService().deleteInterestOwner(hNo);
		
		if(result > 0) {
			response.sendRedirect("interestOwner.es");
		}else {
			request.setAttribute("msg", "요청을 실패했습니다");
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
