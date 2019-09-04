package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.service.OwnerServiceService;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class ManageEmpServlet
 */
@WebServlet("/manageEmp.os")
public class ManageEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Owner owner = (Owner)request.getSession().getAttribute("owner");
		
		ArrayList<Appliant> alist = new IncruitService().selectManageEmp(owner.getoNum());
		ArrayList<Resume> rlist = new OwnerServiceService().selectResumeList(alist);
		ArrayList<Incruit> list = new IncruitService().selectIncruitList(owner.getoNum());


		request.setAttribute("alist", alist);
		request.setAttribute("rlist", rlist);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/ownerService/ManageEmp.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
