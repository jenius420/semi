package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import search.model.service.SearchService;
import search.model.vo.IncruitInfo;

/**
 * Servlet implementation class DistrictSearchServlet
 */
@WebServlet("/districtSearch.se")
public class DistrictSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DistrictSearchServlet() {
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
//		System.out.println(request.getParameter("currentPage"));
		String[] district = new String[25];
		district= request.getParameter("result").split("!");
		
		String mPage = request.getParameter("movePage");
		int boardLimit = 20; // 한페이지에 보여질 게시글 최대 갯수
		int listCount;
		if (district[0]==""||district[0]==null) {
			listCount = new SearchService().listCount();
		}else {
			listCount= new SearchService().getDistrictListCount(district);
		}
		int maxPage = (listCount-1)/ boardLimit + 1;
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("currentPage:"+currentPage);
		int movePage;
		if (mPage.equals("<<")||mPage.equals("&lt&lt")) {
			movePage = 1;
		} else if (mPage.equals("<")||mPage.equals("&lt")) {
			
				if(currentPage!=1) {
					movePage = currentPage-1;
				}else {
					movePage=1;
				}
			
		} else if (mPage.equals(">")||mPage.equals("&gt")) {
			
			if (currentPage == maxPage) {
				movePage = maxPage;
			}else {
				movePage=currentPage+1;
			}
		} else if (mPage.equals(">>")||mPage.equals("&gt&gt")) {
			movePage = maxPage;
		} else {
			movePage = Integer.parseInt(mPage);
		}
		System.out.println("list movePage"+movePage);
//		for (int i = 0; i < district.length; i++) {
//			System.out.println(district[i]);
//		}
		ArrayList<IncruitInfo> list;

		// ------페이징 처리----------

		int pageLimit;// 한페이지 하단에 보여질 페이지수
		int startPage;// 한페이지 하단에 보여질 시작 페이지
		int endPage;// 한페이지 하단에 보여질 마지막 페이지

		// pageLimit : 한페이지 하단에 보여질 페이지수
		pageLimit = 10;

		// 현재페이지에보여지는 페이징 바의 시작수
		startPage = ((movePage - 1) / pageLimit) * pageLimit + 1;
		// (int)Math.floor((double)currentPage-1)/pageLimit)*pageLimit+1;
		// 현재페이지에보여지는 페이징 바의 마지막수
		endPage = ((movePage - 1) / pageLimit) * 10 + 10;
		// ex)maxPage =13, endPage=20
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		System.out.println("movePage :"+movePage);
		int start = (movePage - 1) * boardLimit + 1;
		int end = (movePage - 1) * boardLimit + 20;
		System.out.println("시작끝"+start+",,"+end);
		System.out.println("check12"+district[0]);
		if (district[0]=="") {
			System.out.println("확인");
			list =new SearchService().allList(start,end);
		} else {
			
			list = new SearchService().districtSearch(district, start, end);
		}
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());// 응답할 리스트, 응답할 스트림
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
