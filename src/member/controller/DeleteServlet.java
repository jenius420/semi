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
		int no = Integer.parseInt(request.getParameter("no"));
		int result=0;
		
		if(kind == 1) {
			
			// 개인회원 탈퇴
			result =  new MemberService().deleteEmp(no);
			
		}else {
			
			// 사업자회원 탈퇴
			result = new MemberService().deleteOwn(no);
		}
		
		if(result > 0) {
			request.getSession().removeAttribute("loginUser");
			request.getSession().setAttribute("msg", "회원 탈퇴가 완료되었습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원탈퇴에 실패 했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
