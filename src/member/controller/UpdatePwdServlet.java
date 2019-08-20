package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

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
		
		//현재비밀번호, 새로운 비밀번호
		String userPwd = request.getParameter("userPwd");
		String newPwd=request.getParameter("newPwd");
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		Member updateMem = new MemberService().updatePwd(userId,userPwd,newPwd); 
		RequestDispatcher view = request.getRequestDispatcher("views/member/pwdUpdateForm.jsp");
		if(updateMem!=null) {
			request.getSession().setAttribute("loginUser", updateMem);
			request.setAttribute("msg", "비밀번호 변경 성공");
		}else {//수정에 실패했을경우
			request.setAttribute("msg", "비밀번호 변경 실패");
		}
		view.forward(request, response);
		
		
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
