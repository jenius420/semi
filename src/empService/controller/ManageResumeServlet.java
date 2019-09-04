package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import empService.model.vo.Emp;
import empService.model.service.EmpServiceService;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import ownerService.model.service.OwnerServiceService;

/**
 * Servlet implementation class ManageResumeServlet
 */
@WebServlet("/manageResume.es")
public class ManageResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//Emp emp = (Emp)request.getSession().getAttribute("loginUser");
		
		//샘플 데이터
		//Emp emp = new EmpServiceService().selectEmp(6);
		Emp emp = new EmpServiceService().selectEmp(1);
		
		HttpSession session = request.getSession();
		session.setAttribute("emp", emp);
		
		ArrayList<Resume> list = new ResumeService().selectResumeList(emp.getEmpNum());

		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/empService/ManageResume.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
