package empService.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.model.vo.Attachment;
import common.model.vo.MyFileRenamePolicy;
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
		
		Emp emp = (Emp)request.getSession().getAttribute("loginUser");
		
		
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
					
					changeName = savePath + multiRequest.getFilesystemName(name);
					originName = multiRequest.getOriginalFileName(name);

				}
				
			}
			
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
			
			Attachment at = new Attachment();

			at.setOriginName(originName);
			at.setChangeName(changeName);
			
			int result = new ResumeService().updateResume(resume, at);
			
			
			
			if(result > 0) {
				request.setAttribute("msg", "이력서 수정 성공");	
				request.getRequestDispatcher("views/empService/ManageResume.jsp").forward(request, response);
				
			}else {
				
				File failedFile = new File(changeName);
				failedFile.delete();
				
				request.setAttribute("msg", "이력서 수정을 실패했습니다");
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
