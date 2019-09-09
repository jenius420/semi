package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;
import search.model.service.SearchService;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/address.me")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		String address[] = new String[3];
		address = new MemberService().searchAddress(rNum);
		
		

			JSONObject jsonUser = new JSONObject();
			jsonUser.put("hopeBtn", hopeBtn);

			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(jsonUser);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
