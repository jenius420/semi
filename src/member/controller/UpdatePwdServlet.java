package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int kind = Integer.parseInt(request.getParameter("kind"));
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		
		int result;
		
		if(kind == 1) {
			result = new MemberService().updateEmpPwd(newPwd, id, pwd);
		}else {
			result = new MemberService().updateOwnPwd(newPwd, id, pwd);
		}
		
		if(result > 0) {
			
			request.setAttribute("msg", "비밀번호가 변경 되였습니다.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "비밀번호 변경에  실패했습니다.");
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
