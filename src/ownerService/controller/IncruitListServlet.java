package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import owner.model.vo.Owner;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class IncruitListServlet
 */
@WebServlet("/incruitList.os")
public class IncruitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncruitListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
//		Owner owner = (Owner)request.getSession().getAttribute("loginUser");
		Owner owner = new Owner();
		owner.setoNum(1);
		
		//ArrayList<Incruit> list = new IncruitService().selectIncruitList(owner.getoNum());
		ArrayList<Incruit> list = new ArrayList<>();
		

		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/ownerService/IncruitList.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
