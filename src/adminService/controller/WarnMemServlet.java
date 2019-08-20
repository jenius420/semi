package adminService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageMemService;

/**
 * Servlet implementation class WarnMemServlet
 */
@WebServlet("warnMem.as")
public class WarnMemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarnMemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int flag = Integer.parseInt(request.getParameter("flag")); // 1구직자 2사업자
		String[] memArr = request.getParameterValues("memArr");
		
		int count = 0;
		
		if(flag == 1) {
			count = new ManageMemService().warnEmp(memArr);
		}else {
			//count = new ManageMemService().warnOwner(memArr); 사업자는 경고 없었는지?
		}
		
		// 비동기 처리?
		request.setAttribute("msg", count + "명 경고 완료");
		request.getRequestDispatcher("/views/adminService/MemList.jsp").forward(request, response);

		response.sendRedirect("memList.as?msg="+ count + "명 경고 완료"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
