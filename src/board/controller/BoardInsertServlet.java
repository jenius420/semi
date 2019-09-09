package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.model.vo.Attachment;
import common.model.vo.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/insert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**6
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		
			int maxSize = 1024 * 1024 * 10;
			
			String photo = request.getSession().getServletContext().getRealPath("/photo");
			
			String savePath = photo + "/attachment/";
			
			MultipartRequest multiRequest =  new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			ArrayList<String> changeFiles = new ArrayList<>();
			ArrayList<String> originFiles = new ArrayList<>();
			
			
			Enumeration<String> files= multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();	
				
				if(multiRequest.getFilesystemName(name) != null) { 
					
					String changeName = multiRequest.getFilesystemName(name);
					String originName = multiRequest.getOriginalFileName(name);
					
					changeFiles.add(changeName);
					originFiles.add(originName);
				}
				
			}
			
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String bWriter = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).geteNum());
			int eNum = ((Member)request.getSession().getAttribute("loginUser")).geteNum();
			
			Board b = new Board();
			b.setTitle(title);
			b.setbBody(content);
			b.seteNum(eNum);
			
			ArrayList<Attachment> fileList = new ArrayList<>();
			
			for(int i=originFiles.size()-1; i>=0; i--) {
				
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(changeFiles.get(i));
				
				fileList.add(at);
			}
			int result = new BoardService().insertBoard(b, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.bo");
			}else {
				
				for(int i=0; i<changeFiles.size(); i++) {
					
					File failedFile = new File(savePath + changeFiles.get(i));
					failedFile.delete();
					
				}
				
				request.setAttribute("msg", "사진 게시판 등록 실패!!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
