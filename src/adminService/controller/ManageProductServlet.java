package adminService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageIncruitService;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.IncruitProduct;

/**
 * Servlet implementation class ManageProductServlet
 */
@WebServlet("/manageProduct.as")
public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<IncruitProduct> list = new ManageIncruitService().selectProductList();
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/adminService/ManageProduct.jsp").forward(request, response);
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
