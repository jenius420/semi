package empService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AjaxServlet3
 */
@WebServlet("/ajax4.es")
public class AjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String str = request.getParameter("input");
		String str2 = request.getParameter("input2");

		// json으로 넘기는 방법
		// https://code.google.com/archive/p/json-simple/downloads  json 쓰려면 라이브러리 다운 받아야함
	
		response.setContentType("application/json, charset=UTF-8");
		
		JSONObject jsonUser = new JSONObject();
		jsonUser.put("key", str);
		jsonUser.put("key2", str2);
		
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
