package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.me")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int kind = Integer.parseInt(request.getParameter("kind"));
		String id = request.getParameter("userId");
		
		if(kind == 1) {
			
			// 개인회원 탈퇴
			int result =  new MemberService().deleteEmp(id);
			
			if(result > 0) {
				request.getSession().removeAttribute("loginUser");
				request.getSession().setAttribute("msg", "회원 탈퇴 되였습니다.");
				response.sendRedirect(request.getContextPath());
			}
			
		}else {
			
			// 사업자회원 탈퇴
			int result = new MemberService().deleteOwn(id);
			
			if(result > 0) {
				request.getSession().removeAttribute("loginUser");
				request.getSession().setAttribute("msg", "회원 탈퇴 되였습니다.");
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
