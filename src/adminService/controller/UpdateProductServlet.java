package adminService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageIncruitService;
import ownerService.model.vo.IncruitProduct;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/updateProduct.as")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int pCode = Integer.parseInt(request.getParameter("pCode"));
		String pTilte = request.getParameter("pTilte");
		String pExplain = request.getParameter("pExplain");
		int pPay = Integer.parseInt(request.getParameter("pPay"));
		
		IncruitProduct prod = new IncruitProduct(pCode, pTilte, pExplain, pPay);
		
		int result = new ManageIncruitService().updateProduct(prod);
		
		if(result > 0) {
			response.sendRedirect("manageProduct.as");
		}else {
			request.setAttribute("msg", "상품정보 수정에 실패했습니다");
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
