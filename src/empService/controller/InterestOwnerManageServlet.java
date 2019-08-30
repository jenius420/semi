 package empService.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.service.EmpServiceService;
import empService.model.vo.HopeEnt;
import ownerService.model.vo.Owner;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class InterestOwnerManageServlet
 */
@WebServlet("/interestOwner.es")
public class InterestOwnerManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterestOwnerManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		ArrayList<HopeEnt> hList = new EmpServiceService().selectInterestOwner(emp.getEmpNum());
		ArrayList<Incruit> wList = new EmpServiceService().selectInterestIncruit(hList);

		
		request.setAttribute("hList", hList);
		request.setAttribute("wList", wList);
		request.getRequestDispatcher("/views/empService/InterestOwnerManage.jsp").forward(request, response);		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
