package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class FindId
 */
@WebServlet("/findId.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int kind = Integer.parseInt(request.getParameter("kind"));
		String name = request.getParameter("name");
		String cNum1 = request.getParameter("cNum1");
		String cNum2 = request.getParameter("cNum2");
		String cNum = cNum1 + "-" + cNum2;
		
		System.out.println(kind);
		System.out.println(name);
		System.out.println(cNum);
		
		if(kind == 1) {
			
			Member userId = new MemberService().findIdEmp(name, cNum);
			
			
			//response.sendRedirect(request.getContextPath());
			
			if(userId != null) {
				request.setAttribute("userId", userId);
				request.getRequestDispatcher("returnId.jsp").forward(request, response);				
			}else {
				
				request.getRequestDispatcher("errorPage.jsp").forward(request, response);
			}
			
			
			
		}else {
			
			Member userId = new MemberService().fidIdOwn(name, cNum);
			
			
			if(userId != null) {
				request.setAttribute("userId", userId);
				request.getRequestDispatcher("views/member/returnId.jsp").forward(request, response);
			}else {
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
