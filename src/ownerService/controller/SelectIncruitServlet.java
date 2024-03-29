package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageIncruitService;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.IncruitProduct;

/**
 * Servlet implementation class SelectIncruitServlet
 */
@WebServlet("/selectIncruit.os")
public class SelectIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		
		Incruit incruit = new IncruitService().selectIncruit(wNum);
		ArrayList<IncruitProduct> list = new ManageIncruitService().selectProductList();
		
		if(incruit != null) {
			request.setAttribute("incruit", incruit);	
			request.setAttribute("list", list);	
			request.getRequestDispatcher("views/ownerService/SelectIncruit.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "페이지 요청을 실패했습니다.");
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
