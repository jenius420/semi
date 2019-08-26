package adminService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageMemService;
import emp.model.vo.Emp;
import member.model.vo.EmpMember;
import member.model.vo.OwnerMember;
import owner.model.vo.Owner;

/**
 * Servlet implementation class MemListServlet
 */
@WebServlet("/memList.as")
public class MemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArrayList<EmpMember> empList = new ManageMemService().selectEmpList();
//		ArrayList<OwnerMember> ownerList = new ManageMemService().selectOwnerList();
		
		ArrayList<EmpMember> empList = new ArrayList<>();
		ArrayList<OwnerMember> ownerList = new ArrayList<>();
		
		request.setAttribute("empList", empList);
		request.setAttribute("ownerList", ownerList);
		request.getRequestDispatcher("/views/adminService/MemList.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
