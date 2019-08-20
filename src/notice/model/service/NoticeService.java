package notice.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {

	/**1.공지사항 리스트 조회용 서비스
	 * @return 
	 */
	public ArrayList<Notice> selectList() {
		Connection conn =getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(conn);
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn,n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int nno) {
		Connection conn = getConnection();
		int result = new NoticeDao().increaseCount(conn,nno);
		Notice n =null;
		if (result>0) {
			commit(conn);
			n = new NoticeDao().selectNotice(conn,nno);
		} else {
			rollback(conn);
		}
		
		
		close(conn);
		return n;
	}

	public Notice selectUpdateNotice(int nno) {
		Connection conn =getConnection();
		Notice n = new NoticeDao().selectNotice(conn, nno);
		
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().updateNotice(conn,n);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteNotice(int bno) {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn,bno);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
