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
 * Servlet implementation class CategorySearchServlet
 */
@WebServlet("/categorySearch.se")
public class CategorySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySearchServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("넘어오나?");
		String[] cates= request.getParameterValues("result");
		if(cates==null) {
			request.setAttribute("msg", "리스트조회에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp");
		}else {
		//총 게시글 갯수
				int listCount = new SearchService().getCateListCount(cates);
				//------페이징 처리----------
				int currentPage;
				if (request.getParameter("currentPage")!=null) {
					currentPage= Integer.parseInt(request.getParameter("currentPage"));//현재페이지
				} else {
					currentPage=1;
				}
				currentPage= Integer.parseInt(request.getParameter("currentPage"));//현재페이지
				int pageLimit;//한페이지 하단에 보여질 페이지수
				int maxPage;//전체페이지에서 가장 마직막 페이지
				int startPage;// 한페이지 하단에 보여질 시작 페이지
				int endPage;//한페이지 하단에 보여질 마지막 페이지
				int boardLimit = 20; //한페이지에 보여질 게시글 최대 갯수
				
				//currentPage : 현재페이지
				currentPage =1;
				//페이지 전환시 전달받은 현재 페이지가 있을 경우 전달받은 페이지를 currentPage로
				if(request.getParameter("currentPage")!=null) {
					currentPage=Integer.parseInt(request.getParameter("currentPage"));
				}
				//pageLimit : 한페이지 하단에 보여질 페이지수
				pageLimit =10;
				
				
				//maxPage:총페이지수
				maxPage = (int) Math.ceil((double)(listCount/boardLimit))+1;
				//현재페이지에보여지는 페이징 바의 시작수
				startPage =((currentPage-1)/pageLimit)*pageLimit+1;
				//(int)Math.floor((double)currentPage-1)/pageLimit)*pageLimit+1;
				//현재페이지에보여지는 페이징 바의 마지막수
				endPage=((currentPage-1)/pageLimit)*10+10;
				//ex)maxPage =13, endPage=20
				if(endPage>maxPage) {
					endPage=maxPage;
				}
				System.out.println("현재페이지" + currentPage);
				System.out.println("pageLimit" + pageLimit);
				System.out.println("maxP" + maxPage);
				System.out.println("startP" + startPage);
				System.out.println("endP" + endPage);
				System.out.println("listCount" + listCount);
				int start =(currentPage-1)*boardLimit+1;
				int end = currentPage*boardLimit;
				ArrayList<IncruitInfo> list= new SearchService().categorySearch(cates,start,end);
				response.setContentType("application/json; charset=utf-8");
				Gson gson = new Gson();
				gson.toJson(list,response.getWriter());// 응답할 리스트, 응답할 스트림
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
