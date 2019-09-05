package member.controller;

import java.io.IOException;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EmpInser
 */
@WebServlet("/insertEmp.me")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eId = request.getParameter("eId");					// 아이디
		String pwd = request.getParameter("pwd");					// 비밀번호
		String name = request.getParameter("eName");				// 이름
		String ecNum1 = request.getParameter("ecNum1"); 			// 주민번호 앞자리
		String ecNum2 = request.getParameter("ecNum2"); 			// 주민번호 뒷자리
		String ecNum = ecNum1 + "-" + ecNum2;						// 주민번호
		String phone1 = request.getParameter("phone1"); 			// 전화번호 010
		String phone2 = request.getParameter("phone2"); 			// 휴대전화 앞자리
		String phone3 = request.getParameter("phone3"); 			// 휴대전화 뒷자리
		String phone = phone1 + "-" + phone2 + "-" + phone3;		// 휴대전화
		String email1 = request.getParameter("email1");				// 이메일1
		String email2 = request.getParameter("email2");				// 이메일2
		String email = email1 + email2;								// 이메일 결합
		String mailAccept = request.getParameter("mailAccept");		// 메일수신
		String smsAccept = request.getParameter("smsAccept");		// 문자수신
		String address = request.getParameter("address");			// 주소
		String eAddress = request.getParameter("eAddress");			// 나머지주소
		
		
		String[] splitAddress = new String[4];
		splitAddress=address.split(" ");
		String roadName = splitAddress[2];// 도로명
		
		String[] road =new String[2]; 
		road=(splitAddress[3]).split("-");			// 도로명 본번
		int roadMain = Integer.parseInt(road[0]);
		int roadSub;
		
		if(road[0] == null || road[0].equals("")) {
			roadSub = 0;
		}else {
			if(road.length==1) {
				roadSub = 0;
			}else {
				roadSub = Integer.parseInt(road[1]);
			}
		}
					
		
		
		
		Member mem = new Member(eId, pwd, name, ecNum, eAddress, phone, email, mailAccept, smsAccept, roadName, roadMain, roadSub);
		
		int result = new MemberService().insertEmp(mem);
		
		if(result > 0) {
			

			//request.setAttribute("msg", "회원가입성공");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
