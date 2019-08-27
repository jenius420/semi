package empService.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import emp.model.vo.Emp;

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
		
		ArrayList<Emp> list = new ArrayList<>();

		// json으로 넘기는 방법
		// https://code.google.com/archive/p/json-simple/downloads  json 쓰려면 라이브러리 다운 받아야함
		
		JSONArray jsonArr = new JSONArray();
	
		for(Emp e : list) {
			JSONObject jsonUser = new JSONObject();
			
			jsonUser.put("num", e.geteName());
			jsonUser.put("name", e.geteName());
			jsonUser.put("str2", str2);
			
			jsonArr.add(jsonUser);
		}
		
		response.setContentType("application/json, charset=UTF-8");
		
		response.getWriter().print(jsonArr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
