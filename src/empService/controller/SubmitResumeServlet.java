package empService.controller;

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
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.model.vo.Attachment;
import common.model.vo.MyFileRenamePolicy;
import emp.model.vo.Emp;
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
		
		Emp emp = (Emp)request.getSession().getAttribute("user");
		
		String resumeTitle = request.getParameter("resumeTitle");
		int empNum = emp.getEmpNum();
		String district = request.getParameter("district");
		String type = request.getParameter("type");
		String picture = request.getParameter("type");
		String edu = request.getParameter("edu");
		String desireForm = request.getParameter("desireForm");
		int desireIncome = Integer.parseInt(request.getParameter("desireIncome"));
		String comment = request.getParameter("comment");
		String openSet = (request.getParameter("openSet")=="Y") ? "Y":"N";
		
		// multipart/form-data 로 전송됏는지 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024 * 1024 * 10;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			
			String savePath = resources + "/uploadFiles/";
			
			MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			//db에 저장
			ArrayList<String> changeFiles = new ArrayList<>();
			ArrayList<String> originFiles = new ArrayList<>();
			
			Enumeration<String> files = mr.getFileNames();
			
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();
				
				if(mr.getFilesystemName(name) != null) {
					String changeName = mr.getFilesystemName(name);
					String originName = mr.getOriginalFileName(name);
					
					changeFiles.add(changeName);
					originFiles.add(originName);
				}
			}
			
			ArrayList<Attachment> fileList = new ArrayList<>();
			
			for(int i=changeFiles.size()-1; i>=0; i--) {
				Attachment at = new Attachment();
//				at.setFilePath(savePath);
//				at.setOriginName(originFiles.get(i));
//				at.setChangeName(changeFiles.get(i));
				
				fileList.add(at);
			}
			
			//int result = new ResumeService().enrollResume(resume, fileList);
			// INSERT INTO PHOTO VALUES(PHOTO_SEQ.NEXTVAL, )
			// INSERT INTO 처리테이블 VALUES(... PHOTO_SEQ.CURRVAL,....)
		}
		
		//Resume resume = new Resume(resumeTitle, empNum, district, type, comment, picture, desireForm, desireIncome, openSet, edu);
		
		//int result = new ResumeService().enrollResume(resume);
//		
//		if(result > 0) {
//			request.setAttribute("msg", "이력서를 성공적으로 등록했습니다");	
//			
//			request.getRequestDispatcher("views/empService/ManageResume.jsp").forward(request, response);
//			
//		}else {
//			request.setAttribute("msg", "이력서 등록에 실패했습니다. 다시 시도해주세요");
//			
//			response.sendRedirect("makeResume.es");
//			// 여기서 에러페이지로 가야하는지?		
//		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
