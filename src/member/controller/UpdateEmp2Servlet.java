package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empService.model.service.EmpServiceService;
import empService.model.vo.Emp;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateEmp2Servlet
 */
@WebServlet("/updateEmp2.me")
public class UpdateEmp2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eNum=Integer.parseInt(request.getParameter("eNum"));
		String eId = request.getParameter("eId");					// 아이디
		String pwd = request.getParameter("pwd");					// 비밀번호
		String name = request.getParameter("name");				// 이름
		String phone1 = request.getParameter("phone1"); 			// 전화번호 010
		String phone2 = request.getParameter("phone2"); 			// 휴대전화 앞자리
		String phone3 = request.getParameter("phone3"); 			// 휴대전화 뒷자리
		String phone = phone1 + "-" + phone2 + "-" + phone3;		// 휴대전화
		String email = request.getParameter("email");				// 이메일1
		String mailAccept = request.getParameter("mailaccept");		// 메일수신
		String smsAccept = request.getParameter("smsaccept");		// 문자수신
		String address = request.getParameter("address");			// 주소
		String eAddress = request.getParameter("eAddress");			// 나머지주소
		
		if(mailAccept==null) {
			mailAccept="N";
		}
		if(smsAccept==null) {
			smsAccept="N";
		}
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
					
		
		
		
		
		int result = new MemberService().changeEmp(eNum,eId,pwd,name,phone,email,mailAccept,smsAccept,roadName,roadMain,roadSub, eAddress);
		
		if(result > 0) {
			Member loginUser = new MemberService().loginEmp(eId, pwd);
			Emp emp = new EmpServiceService().selectEmp(loginUser.geteNum());
			request.getSession().setAttribute("emp", emp);
			System.out.println(emp);
			request.setAttribute("msg", "회원수정성공");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원수정실패!");
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
