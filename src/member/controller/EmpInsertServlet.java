package member.controller;

import java.io.IOException;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EmpInser
 */
@WebServlet("/empInsert.me")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");						// 아이디
		String pwd = request.getParameter("pwd");					// 비밀번호
		String name = request.getParameter("name");					// 이름
		String ecNum1 = request.getParameter("ecNum1"); 			// 주민번호 앞자리
		String ecNum2 = request.getParameter("ecNum2"); 			// 주민번호 뒷자리
		String ecNum = ecNum1 + ecNum2;								// 주민번호 결합
		String phone1 = request.getParameter("phone1"); 			// 전화번호 010
		String phone2 = request.getParameter("phone2"); 			// 휴대전화 앞자리
		String phone3 = request.getParameter("phone3"); 			// 휴대전화 뒷자리
		String phone = phone1 + phone2 + phone3;					// 휴대전화 결합
		String email1 = request.getParameter("email1");				// 이메일1
		String email2 = request.getParameter("email2");				// 이메일2
		String email = email1 + email2;								// 이메일 결합
		String maileAccept = request.getParameter("mailAccept");	// 메일수신
		String smsAccept = request.getParameter("smsAccept");		// 문자수신
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
