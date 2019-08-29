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
		System.out.println("로그1");
		request.setCharacterEncoding("UTF-8");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		System.out.println("로그2");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("로그3");
			int maxSize = 1024 * 1024 * 10;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			System.out.println("로그4");
			String savePath = resources + "/uploadFiles/";
			System.out.println("savePath:" + savePath);
			MultipartRequest multiRequest =  new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			Enumeration<String> files= multiRequest.getFileNames();
			
			String changeName = "";
			String originName = "";
			
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();	// files에 담겨있는 파일 하나씩 뽑아내기
				System.out.println(name);
				if(multiRequest.getFilesystemName(name) != null) {
					
					changeName = savePath + multiRequest.getFilesystemName(name);
					originName = multiRequest.getOriginalFileName(name);

				}
				
			}
			System.out.println(multiRequest.getParameter("districtNum"));
		
			int empNum = emp.getEmpNum();
			int districtNum = Integer.parseInt(multiRequest.getParameter("districtNum"));
			int typeNum = Integer.parseInt(multiRequest.getParameter("typeNum"));
			String edu =multiRequest.getParameter("edu");
			String desireForm = multiRequest.getParameter("desireForm");
			int desireIncome = Integer.parseInt(multiRequest.getParameter("desireIncome"));
			String comment = multiRequest.getParameter("comment");
			String openSet = (multiRequest.getParameter("openSet")=="Y") ? "Y":"N";
			String picture = multiRequest.getParameter("");
			
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
			
			System.out.println("result:"+result);
			if(result > 0) {
				request.getRequestDispatcher("views/empService/ManageResume.jsp").forward(request, response);
				
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
