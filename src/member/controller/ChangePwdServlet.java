package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class ChangePwdServlet
 */
@WebServlet("/changePwd.me")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int kind = Integer.parseInt(request.getParameter("kind"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String cNum = request.getParameter("cNum");
		String pwd = request.getParameter("pwd");
		int result;
		if(kind==1) {
			result = new MemberService().changeEmpPwd(id,name,cNum,pwd);
		}else {
			result = new MemberService().changeOwnPwd(id,name,cNum,pwd);
		}
		
		if (result>0) {
			
			request.setAttribute("msg", "비밀번호변경에 성공하였습니다. 변경된 비밀번호로 로그인해주세요");
			request.getRequestDispatcher("views/member/successChangePwd.jsp").forward(request, response);
			
		} else {
			request.setAttribute("msg", "비밀번호 변경에 실패하셨습니다");
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
