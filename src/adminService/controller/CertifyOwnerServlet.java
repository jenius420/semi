package adminService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageMemService;
import ownerService.model.vo.Owner;

/**
 * Servlet implementation class CertifyOwnerServlet
 */
@WebServlet("/certifyOwner.as")
public class CertifyOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertifyOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String oNumArr = request.getParameter("oNumArr");
		
		int result = new ManageMemService().certifyOwner(oNumArr);
		
		ArrayList<Owner> ownerList = new ManageMemService().selectOwnerList();
		

		if(result > 0) {
			request.setAttribute("ownerList", ownerList);
			request.getRequestDispatcher("/views/adminService/OwnerList.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "사업자 인증 요청을 실패했습니다");
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
