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
		
		Owner owner = (Owner)request.getSession().getAttribute("loginUser");
		
		ArrayList<Incruit> list = new IncruitService().selectIncruitList(owner.getoNum());
		
		if(!list.isEmpty()) {
			request.setAttribute("incruitList", list);
			request.getRequestDispatcher("/views/ownerService/IncruitList.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "페이지 요청에 실패했습니다. 다시 시도해주세요");
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
