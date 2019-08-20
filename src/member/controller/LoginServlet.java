package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처라
		request.setCharacterEncoding("UTF-8");
		//전송값 꺼내서 변수에기록
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		//비즈니스로직을 처리하는 서비스 클래스의 메소드 실행 그처리 결과를 받는다.
		Member loginUser = new MemberService().loginMember(userId,userPwd);
		
		if(loginUser==null) {//로그인에 실패했을경우
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}else {//로그인에 성공한 경우
			/*
			 * 1)page : 해당 그페이지에서만 사용가능
			 * 2)request : 현재페이지 + 응답페이지
			 * 3)session : 브라우저가 종료되기 전까지 사용가능 어느페이지든 사용가능한 객체
			 * 4)application : 애플리케이션 전역다 쓸 수  있다.
			 */
			//해당 클라이언트에 대한 세션 객체
			HttpSession session = request.getSession();
			
//			session.setMaxInactiveInterval(600);// 10분뒤 자동로그아웃
			
			session.setAttribute("loginUser", loginUser);
			//세션에 로그인한 유저의 정보담기
			//로그인 완료 후 다시 메인 페이지로
			
			response.sendRedirect(request.getContextPath());// /jsp작성된것
			//forward 방식 : 내가 응답페이지에 전달 해 줘야하는 request, response 있을 경우
			//sendRedirect 방식 : 내가 전달해줘야하는 내용이 없을 경우하는 방식--> 해당 그곳에서 다시 request, response 객체 새로생성
			
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
