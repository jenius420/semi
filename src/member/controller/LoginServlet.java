package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import empService.model.service.EmpServiceService;
import empService.model.vo.Emp;
import member.model.service.MemberService;
import member.model.vo.Member;
import ownerService.model.service.OwnerServiceService;
import ownerService.model.vo.Owner;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.me")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String msg = (String) request.getAttribute("msg");
		int kind = Integer.parseInt(request.getParameter("kind"));
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");

		System.out.println("로그인정보. id:" + id + " pwd:" + pwd + " kind:" + kind);
		
		HttpSession session = request.getSession();

		Member loginUser = null;
		
		switch(kind) {
			
			case 1:
				loginUser = new MemberService().loginEmp(id, pwd);
				if(loginUser==null) {
					request.setAttribute("msg", "입력 정보가 맞지 않습니다");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}else {
					Emp emp = new EmpServiceService().selectEmp(loginUser.geteNum());
					session.setAttribute("emp", emp);
				}
				break;
			case 2:
				loginUser = new MemberService().loginOwn(id, pwd);
				if(loginUser==null) {
					request.setAttribute("msg", "입력 정보가 맞지 않습니다");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}else {
					Owner owner = new OwnerServiceService().selectOwner(loginUser.getoNum());
					session.setAttribute("owner", owner);
				}
				break;
			case 3:
				loginUser = new MemberService().loginEmp(id, pwd);
				loginUser.setKind(kind); break;
					
			default: request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		
		
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

//		if (kind == 1) {
//			// 개인 로그인
//			Member loginUser = new MemberService().loginEmp(id, pwd);
//			if (loginUser != null) {
//				HttpSession session = request.getSession();
//				// session.setMaxInactiveInterval(600);
//				session.setAttribute("loginUser", loginUser);
//				response.sendRedirect(request.getContextPath());
//			} else {
//				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//			}
//
//		} else {
//			// 사업자 로그인
//			Member loginUser = new MemberService().loginOwn(id, pwd);
//			System.out.println(loginUser);
//			if (loginUser != null) {
//				HttpSession session = request.getSession();
//				// session.setMaxInactiveInterval(600);
//				session.setAttribute("loginUser", loginUser);
//				response.sendRedirect(request.getContextPath());
//			} else {
//				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//			}
//
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
