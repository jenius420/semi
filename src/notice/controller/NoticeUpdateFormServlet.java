package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateFormServlet
 */
@WebServlet("/update.no")
public class NoticeUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int nno = Integer.parseInt(request.getParameter("nno"));
		String nTitle= request.getParameter("title");
		String content = request.getParameter("content");
		Notice n = new Notice();
		n.setnNo(nno);
		n.setnTitle(nTitle);
		n.setnContent(content);
		int result = new NoticeService().updateNotice(n);
		Notice notice = new NoticeService().selectNotice(nno);
		String page;
		if(result>0) {
			request.setAttribute("msg", "수정완료");
			request.setAttribute("notice", notice);
			page = "views/notice/noticeDetailView.jsp";
			
//			response.sendRedirect("detail.no?nno="+nno);
		}else {
			request.setAttribute("msg", "수정에 실패했습니다");
			page= "views/common/errorPage.jsp";
			
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
