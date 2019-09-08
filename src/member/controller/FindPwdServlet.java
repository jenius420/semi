package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class FindPwd
 */
@WebServlet("/findPwd.me")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
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
		String cNum1 = request.getParameter("ecNum1");
		String cNum2 = request.getParameter("ecNum2");
		String cNum = cNum1 + "-" + cNum2;
		System.out.println("kind"+kind);
		String pwd =null;
		if (kind==1) {
			pwd = new MemberService().findEmpPwd(id,name,cNum);
		} else if(kind==2){
			pwd = new MemberService().findOwnPwd(id,name,cNum);
			
		}
		
		
		
		if(pwd != null) {
			
			request.setAttribute("kind", kind);
			request.setAttribute("name", name);
			request.setAttribute("cNum", cNum);
			request.setAttribute("id", id);
			System.out.println("일치");
			request.getRequestDispatcher("views/member/returnPwd.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "일치하는 정보가 없습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);				
			System.out.println("불일치");
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
