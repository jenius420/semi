package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.ResumeService;
import empService.model.vo.Resume;
import ownerService.model.vo.Incruit;

/**
 * Servlet implementation class ChoiceResumeServlet
 */
@WebServlet("/selectSuitableIncruit.es")
public class SelectSuitableIncruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSuitableIncruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		
		ArrayList<Incruit> list = new ResumeService().selectSuitableIncruit(rNum);
		
		// 팝업에서 결정된 list를 어떻게 원래 창으로 가져올지?
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
