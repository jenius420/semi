package board.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/update.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		
		
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
				
				
				int tNum = Integer.parseInt(multiRequest.getParameter("tNum"));
				String title = multiRequest.getParameter("title");
				int eNum = Integer.valueOf(((Member)request.getSession().getAttribute("loginUser")).geteNum());

				Date updateDate = Date.valueOf(multiRequest.getParameter("updateDate"));
				String bBody = multiRequest.getParameter("bBody");
				int boardCount = Integer.parseInt(multiRequest.getParameter("boardCount"));
			
			
				
				Board b = new Board();
				b.settNum(tNum);
				b.setTitle(title);
				b.seteNum(eNum);
				b.setUpdateDate(updateDate);
				b.setbBody(bBody);
				b.setBoardCount(boardCount);
				
				System.out.println("update서블렛"+eNum);

				
				ArrayList<Attachment> fileList = new ArrayList<>();
				
				for(int i=originFiles.size()-1; i>=0; i--) {
					
					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(originFiles.get(i));
					at.setChangeName(changeFiles.get(i));
					
					fileList.add(at);
					
					System.out.println("update서블렛" + i + changeFiles.get(i));
				}
				
				
				
				int result = new BoardService().updateBoard(b, fileList);
				System.out.println(result);
				
				
				if(result > 0) {
					/*response.sendRedirect("detail.bo");*/
					response.sendRedirect("detail.bo?tNum=" + tNum);
//
//					request.setAttribute("tNum", tNum);
//					request.getRequestDispatcher("detail.bo?tNum=" + tNum).forward(request, response);
				}else {
				
				
					for(int i=0; i<changeFiles.size(); i++) {
						
						// 삭제할 파일 객체 생성
						File failedFile = new File(savePath + changeFiles.get(i));
						failedFile.delete();
						
					}
			
/*					request.setAttribute("msg", "사진 게시판 수정 실패!!");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);*/
				}
					
					
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
