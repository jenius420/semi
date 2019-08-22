package empService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.model.vo.Emp;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;

/**
 * Servlet implementation class UpdateResumeServlet
 */
@WebServlet("/updateResume.es")
public class UpdateResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		String districtNum = request.getParameter("districtNum");
		String typeNum = request.getParameter("typeNum");
		String eduNum = request.getParameter("eduNum");
		String desireForm = request.getParameter("desireForm");
		int desireIncome = Integer.parseInt(request.getParameter("desireIncome"));
		String comment = request.getParameter("comment");
		String openSet = (request.getParameter("openSet")=="Y") ? "Y":"N";
		String picture = request.getParameter("");
		
		Resume resume = new Resume();
		
		resume.setrNum(rNum);
		resume.setDistrict(districtNum);
		resume.setType(typeNum);
		resume.setEdu(eduNum);
		resume.setDesireForm(desireForm);
		resume.setDesireIncome(desireIncome);
		resume.setComment(comment);
		resume.setOpenSet(openSet);
		
		int result = new ResumeService().updateResume(resume);
		
		if(result > 0) {
			request.setAttribute("msg", "이력서 수정 성공");	
			request.getRequestDispatcher("views/empService/ManageResume.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "이력서 수정에 실패했습니다");
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
