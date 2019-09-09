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
import search.model.vo.PageInfo;

/**
 * Servlet implementation class DetailPagingBarServlet
 */
@WebServlet("/detailPagingBar.se")
public class DetailPagingBarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailPagingBarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String[] detail=new String[25]; 
		detail=request.getParameter("result").split(" ");
		
		int listCount;
		if(detail[0]=="") {
			listCount=new SearchService().listCount();
		}else {			
			listCount = new SearchService().detailListCount(detail);
		}
		String mPage = request.getParameter("movePage");
		int boardLimit = 20; // 한페이지에 보여질 게시글 최대 갯수
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
		
		maxPage = listCount/20+1;
		
		
		ArrayList<PageInfo> list = new ArrayList<>();
		PageInfo p1 = new PageInfo();
		p1.setMaxPage(maxPage);
		p1.setCurrentPage(movePage);
		System.out.println("maxPage"+maxPage);
		System.out.println(movePage);
		list.add(p1);
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
