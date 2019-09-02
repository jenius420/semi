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
 * Servlet implementation class AddHopeEntServlet
 */
@WebServlet("/addHopeEnt.es")
public class AddHopeEntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHopeEntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		
		int result = new EmpServiceService().addHopeEnt(emp.getEmpNum(), oNum);
		
		//json으로 처리?
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
