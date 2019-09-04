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
    	
    	System.out.println("test1");
		request.setCharacterEncoding("utf-8");
		
		//String title = request.getParameter("title");
		
		// 폼 전송을 multipart/form-data 로 전송하는 경우 다른 방식으로 값 추출
		// 파일 업로드를 위한 라이브러리 : cos.jar    (com.orelilly.servlet의 약자)
		// http://www.servlets.com
		
		
		// enctype이 multipart/form-data로 전송되었는지 확인!
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1. 전송된 파일들을 가지고 작업할내용(전송파일 용량 제한, 저장될 경로)
			
			// 1_1. 전송파일 용량 제한 : 10Mbyte로 제한 한 경우
			//		1kbyte = 1024byte
			//		1mbyte = 1024kbyte = 1024 * 1024 byte
			//		10mbyte = 1024 * 1024 * 10 byte
			int maxSize = 1024 * 1024 * 10;
			
			// 1_2. 웹 서버 컨테이너 경로(WebContent)/resources 경로 추출
			String photo = request.getSession().getServletContext().getRealPath("/photo");
			
//			System.out.println(resources);
			
			// 한 폴더에는 총 65000개까지의 파일만 저장 가능하다.
			// 폴더별로 구분을 해놓는게 좋음
			
			// 1_3. 파일이 실제로 저장될 경로(resources/uploadFiles/)
			String savePath = photo + "/attachment/";
			
//			System.out.println(savePath);
			
			
			
			/*
			 * 2. 파일명 수정 및 저장 작업
			 * 
			 * HttpServletRequest --> MultipartRequest로 변경
			 * 
			 * MultipartRequest multiRequest 
			 * 		= new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			 * 
			 * 위의 MultipartRequest 객체 생성과 동시에 업로드한 파일들이 서버에 업로드 된다.
			 * --> 즉, 문제가 있든 없든 간에 우선 서버에 업로드 된다.
			 * --> 만약에 문제가 있을 경우 업로드된 파일을 삭제시켜야됨
			 * 
			 * 사용자가 올린 파일명 그대로 저장하지 않는게 일반적!!!
			 * - 같은 파일명이 있을 경우 덮어씌워질 수도 있다.
			 * - 한글로 된 파일명, 특수기호나 띄어쓰기 등은 서버에 따라 문제가 생길수도 있다.
			 * 
			 * 
			 * DefaultFileRenamePolicy 는 cos.jar안에 존재하는 클래스
			 * 위의 multiRequest객체 생성 시 DefaultFileRenamePolicy클래스의 rename메소드가 실행되면서 파일명 수정 됨
			 * 같은 파일명이 존재하면 파일명 뒤에 카운팅된 숫자를 붙여준다. 
			 * ex)  aaa.zip, aaa1.zip, aaa2.zip
			 * 
			 * 
			 * 우리는 직접 rename 할거임 
			 * --> common패키지에 MyFileRenamePolicy 클래스 만들자!!
			 * 
			 */
			
			// 2_1. MultipartRequest 객체 생성하기
			MultipartRequest multiRequest =  new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			// --> 이순간 서버에 파일 업로드 됨
			
			// 2_2. DB에 저장하기 위해 change_name과 origin_name 각각의 ArrayList 만들어줄꺼임 --> 다중파일이기 때문
			
			// 실제로 저장된 파일의 이름(수정명)을 저장할 ArrayList
			ArrayList<String> changeFiles = new ArrayList<>();
			// 원본 파일의 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<>();
			
			
			// 폼에서 전송된 파일 리스트들 받아오기
			Enumeration<String> files= multiRequest.getFileNames(); // 전송된 역순으로 담겨있다.
			
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();	// files에 담겨있는 파일 하나씩 뽑아내기
				
				if(multiRequest.getFilesystemName(name) != null) { // 파일이 null이 아닐 경우
					
					// 수정명  : getFilesystemName()
					String changeName = multiRequest.getFilesystemName(name);
					// 원본명 : getOriginalFileName()
					String originName = multiRequest.getOriginalFileName(name);
					
					changeFiles.add(changeName);
					originFiles.add(originName);
				}
				
			}
			
			
			// 3_1. 파일 외에 게시판 제목, 내용, 작성자 회원번호 받아오기 --> Board 객체 생성
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			int eNum = 1;
			//int eNum = request.getSession().getAttribute("loginUser").geteNum();
			/*String bWriter = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).geteNum());*/
			
			Board b = new Board();
			b.setTitle(title);
			b.setbBody(content);
			/*b.seteName(bWriter);*/
			b.seteNum(eNum);
			
			// 3_2. Attachment 테이블에 값 삽입할 것들 작업하기 --> Attachment 객체들을 담을 리스트
			ArrayList<Attachment> fileList = new ArrayList<>();
			
			// 전송순서 역순으로 담겨 있기 때문에 마지막 인덱스부터 접근하게끔
			for(int i=originFiles.size()-1; i>=0; i--) {
				
				Attachment at = new Attachment();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(changeFiles.get(i));
				
				fileList.add(at);
			}
			// 4. 사진 게시판 작성용 서비스 요청(board 객체, 첨부파일 리스트 전달)
			int result = new BoardService().insertBoard(b, fileList);
			
			if(result > 0) {
				response.sendRedirect("list.bo");
			}else {
				
				// 저장된 사진 삭제
				for(int i=0; i<changeFiles.size(); i++) {
					
					// 삭제할 파일 객체 생성
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
