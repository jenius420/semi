package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminService.model.service.ManageIncruitService;
import common.model.vo.Attachment;
import empService.model.service.EmpEvalService;
import empService.model.service.EmpServiceService;
import empService.model.service.ResumeService;
import empService.model.vo.Emp;
import empService.model.vo.EmpEvaluation;
import empService.model.vo.Resume;
import ownerService.model.service.OwnerServiceService;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.Owner;

/**
 * Servlet implementation class WatchingIncruitServlet2
 */
@WebServlet("/watchingIncruit2.es")
public class WatchingIncruitServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WatchingIncruitServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		int wNum = Integer.parseInt(request.getParameter("wNum"));
		
		
		Incruit incruit = new ManageIncruitService().watchingIncruit(wNum);
		Attachment at = new EmpServiceService().selectAttachment(incruit.getoNum());
		Owner owner = new OwnerServiceService().selectOwner(incruit.getoNum());
		ArrayList<Resume> list = new ResumeService().selectResumeList(emp.getEmpNum());
		ArrayList<EmpEvaluation> eList = new EmpEvalService().selectEmpEvalList(incruit.getoNum());
		
		if(incruit != null) {
			request.setAttribute("incruit", incruit);
			request.setAttribute("at", at);	
			request.setAttribute("owner", owner);	
			request.setAttribute("list", list);	
			request.setAttribute("eList", eList);	
			request.getRequestDispatcher("/views/empService/WatchingIncruit2.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "페이지 요청에 실패했습니다. 다시 시도해주세요");
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
