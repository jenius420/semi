package ownerService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.vo.Resume;
import ownerService.model.service.IncruitService;

/**
 * Servlet implementation class DeleteIncruitServlet
 */
@WebServlet("/closeIncruit.os")
public class CloseIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int wNum = (int)request.getAttribute("wNum");
		
		int result = new IncruitService().closeIncruit(wNum);
		
		// 비동기 처리?
		request.setAttribute("msg", "마감 완료");
		request.getRequestDispatcher("/views/ownerService/IncruitList.jsp").forward(request, response);

		response.sendRedirect("incruitList.as?msg=마감 완료"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
