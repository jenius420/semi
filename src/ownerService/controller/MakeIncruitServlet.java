package ownerService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageIncruitService;
import common.model.service.CommonService;
import common.model.vo.District;
import common.model.vo.JobType;
import ownerService.model.vo.IncruitProduct;

/**
 * Servlet implementation class MakeIncruitServlet
 */
@WebServlet("/makeIncruit.os")
public class MakeIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<IncruitProduct> list = new ManageIncruitService().selectProductList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/ownerService/MakeIncruit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
