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
@WebServlet(name="LoginServlet", urlPatterns="/login.me")
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
    	
    	int kind = Integer.parseInt(request.getParameter("kind"));
    	String id = request.getParameter("userId");
    	String pwd = request.getParameter("userPwd");
    	
    	System.out.println(kind);
    	System.out.println(id);
    	System.out.println(pwd);
    	
    	if(kind == 1) {
    		// 개인 로그인
    		Member loginUser = new MemberService().loginEmp(id, pwd);
    		if(loginUser != null) {
    			HttpSession session = request.getSession();
    			
    			//session.setMaxInactiveInterval(600);
    			
    			session.setAttribute("loginUser", loginUser);
    			
    			response.sendRedirect(request.getContextPath());		
    			
    		}
    		
    	}else {
    		// 사업자 로그인
    		Member loginUser = new MemberService().loginOwn(id, pwd);
    		if(loginUser != null) {
    			HttpSession session = request.getSession();
    			
    			//session.setMaxInactiveInterval(600);
    			
    			session.setAttribute("loginUser", loginUser);
    			
    			response.sendRedirect(request.getContextPath());				
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
