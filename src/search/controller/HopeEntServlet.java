package search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.vo.Member;
import search.model.service.SearchService;

/**
 * Servlet implementation class HopeEntServlet
 */
@WebServlet("/hopeEnt.se")
public class HopeEntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HopeEntServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String hopeBtn = request.getParameter("hopeBtn");
		int oNum = Integer.parseInt(request.getParameter("oNum"));
		int eNum = ((Member) request.getSession().getAttribute("loginUser")).geteNum();
		System.out.println("eNum:"+eNum);
		int result;
		if (hopeBtn.equals("관심기업 추가")) {
			result = new SearchService().addHopeEnt(oNum,eNum);
			hopeBtn = "관심기업 제거";
		} else if (hopeBtn.equals("관심기업 제거")) {
			result = new SearchService().deleteHopeEnt(oNum,eNum);
			
			hopeBtn = "관심기업 추가";
		} else {
			result = new SearchService().checkHopeEnt(oNum,eNum);
			if(result>0) {
				hopeBtn = "관심기업 제거";
			}else {
				hopeBtn = "관심기업 추가";
			}
		}

		if(result>=0) {
			JSONObject jsonUser = new JSONObject();
			jsonUser.put("hopeBtn", hopeBtn);

			// 브라우저로 json객체 전송(응답)
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(jsonUser);
		}else {
			request.setAttribute("msg", "관심기업 정보를 조회하지 못하였습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
