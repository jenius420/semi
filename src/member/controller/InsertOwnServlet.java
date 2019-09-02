package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertOwnServlet
 */
@WebServlet("/insertOwn.me")
public class InsertOwnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOwnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");				// 아이디
		String pwd = request.getParameter("pwd");			// 비밀번호
		String opNmae = request.getParameter("opName");		// 사업장명
		String opNum1 = request.getParameter("opNum1");		// 사업자 번호1
		String opNum2 = request.getParameter("opNum2");		// 사업자 번호2
		String opNum3 = request.getParameter("opNum3");		// 사업자 번호3
		String opNum = opNum1 + opNum2 + opNum3;			// 사업자 번호
		/*
		 	사업자 주소
		  
		 */	
		String oName = request.getParameter("oName");				// 사업자 성명
		int tel1 = Integer.parseInt(request.getParameter("tel1"));	// 전화번호1
		int tel2 = Integer.parseInt(request.getParameter("tel2"));	// 전화번호2
		int tel3 = Integer.parseInt(request.getParameter("tel3"));	// 전화번호3
		String otel = ""+ tel1 + tel2 + tel3;							// 사업장전화번호
		String ocNum1 = request.getParameter("ocNum1");				// 사업자 주번1
		String ocNum2 = request.getParameter("ocNum2");				// 사업자 주번2
		String ocNum = ocNum1 + ocNum2;								// 사업자 주민번호
		String phone1 = request.getParameter("phone1");				// 휴대전화1
		String phone2 = request.getParameter("phone2");				// 휴대전화2
		String phone3 = request.getParameter("phone3");				// 휴대전화3
		String phone = phone1 + phone2 + phone3;					// 휴대전화
		String email1 = request.getParameter("email1");				// 이메일1
		String email2 = request.getParameter("email2");				// 이메일2
		String email = email1 + email2;								// 이메일
		String mailAccept = request.getParameter("mailAccept");		// 메일수신동의
		String smsAccept = request.getParameter("smsAccept");		// 문자수신동의
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
