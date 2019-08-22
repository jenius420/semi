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
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/insertProduct.as")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pTitle = request.getParameter("pTitle");
		int pPay = Integer.parseInt(request.getParameter("pPay"));
		String pExplain = request.getParameter("pExplain");
		
		IncruitProduct prod = new IncruitProduct(pTitle, pExplain, pPay);
		
		int result = new ManageIncruitService().InsertProduct(prod);
		
		if(result > 0) {
			response.sendRedirect("boardReportList.as");
		}else {
			request.setAttribute("msg", "상품 등록에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
