package ownerService.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import owner.model.vo.Owner;
import owner.model.vo.OwnerInfo;
import ownerService.model.service.IncruitService;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class SubmitIncruitServlet
 */
@WebServlet("/submitIncruit.os")
public class SubmitIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Owner owner = (Owner)request.getSession().getAttribute("user");
		
//		jsp에서 컬럼 확정되면 수정하기
//		String resumeTitle = request.getParameter("resumeTitle");
//		int empNum = emp.getEmpNum();
//		String district = request.getParameter("district");
//		String type = request.getParameter("type");
//		String picture = request.getParameter("type");
//		String edu = request.getParameter("edu");
//		String desireForm = request.getParameter("desireForm");
//		int desireIncome = Integer.parseInt(request.getParameter("desireIncome"));
//		String comment = request.getParameter("comment");
//		String openSet = (request.getParameter("openSet")=="Y") ? "Y":"N";
		
		Incruit incruit = new Incruit(컬럼컬럼);
		
		int result = new IncruitService().enrollIncruit(incruit);
		
		if(result > 0) {
			request.setAttribute("msg", "공고를 성공적으로 등록했습니다");	
//			request.getRequestDispatcher("/views/ownerService/ManageIncruit.jsp").forward(request, response);
//			response.sendRedirect("incruitList.os"); 
		}else {
			request.setAttribute("msg", "공고 등록에 실패했습니다");
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
