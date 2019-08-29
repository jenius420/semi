package empService.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.model.vo.Attachment;
import common.model.vo.MyFileRenamePolicy;
import empService.model.vo.Emp;
import empService.model.service.ResumeService;
import empService.model.vo.Resume;

/**
 * Servlet implementation class ResumeServlet
 */
@WebServlet("/submitResume.es")
public class SubmitResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)(request.getSession().getAttribute("emp"));

		
		if(ServletFileUpload.isMultipartContent(request)) {

			int maxSize = 1024 * 1024 * 10;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			
			String savePath = resources + "/uploadFiles/";
		
			MultipartRequest multiRequest =  new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			Enumeration<String> files= multiRequest.getFileNames();
			
			String changeName = "";
			String originName = "";
			
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();	// files에 담겨있는 파일 하나씩 뽑아내기
				
				if(multiRequest.getFilesystemName(name) != null) {
					
					changeName = multiRequest.getFilesystemName(name);
					originName = multiRequest.getOriginalFileName(name);

				}
				
			}
	
		
			int empNum = emp.getEmpNum();
			int districtNum = Integer.parseInt(multiRequest.getParameter("districtNum"));
			int typeNum = Integer.parseInt(multiRequest.getParameter("typeNum"));
			String edu =multiRequest.getParameter("edu");
			String desireForm = multiRequest.getParameter("desireForm");
			int desireIncome = Integer.parseInt(multiRequest.getParameter("desireIncome"));
			String comment = multiRequest.getParameter("comment");
			String openSet = (multiRequest.getParameter("openSet").equals("Y")) ? "Y":"N";
			
			Resume resume = new Resume();
			
			resume.setEmpNum(empNum);
			resume.setDistrictNum(districtNum);
			resume.setTypeNum(typeNum);
			resume.setEdu(edu);
			resume.setDesireForm(desireForm);
			resume.setDesireIncome(desireIncome);
			resume.setComment(comment);
			resume.setOpenSet(openSet);
			
			Attachment at = new Attachment();

			at.setOriginName(originName);
			at.setChangeName(changeName);
			
			int result = new ResumeService().enrollResume(resume, at);
			
		
			if(result > 0) {
				response.sendRedirect("manageResume.es");
				
			}else {
				
				File failedFile = new File(changeName);
				failedFile.delete();
				
				request.setAttribute("msg", "이력서 등록을 실패했습니다");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
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
