package adminService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageBoardDao;
import adminService.model.dao.ManageMemDao;
import board.model.vo.Board;
import board.model.vo.Comment;
import owner.model.vo.Owner;

public class ManageBoardService {
	
	public ArrayList<Board> selectBoardReportList() {
		
		Connection conn = getConnection();

		ArrayList<Board> list = new ManageBoardDao().selectBoardReportList(conn);

		close(conn);

		return list;
		
		
	}
	
	public ArrayList<Comment> selectCommentReportList() {
		
		Connection conn = getConnection();

		ArrayList<Comment> list = new ManageBoardDao().selectCommentReportList(conn);

		close(conn);

		return list;
		
	}
	
	public int deleteBoard(String[] tNumArr) {

		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<tNumArr.length; i++) {
			
			result = new ManageBoardDao().deleteBoard(conn, Integer.parseInt(tNumArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}
	
	
	public int deleteComment(String[] cNumArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<cNumArr.length; i++) {
			
			result = new ManageBoardDao().deleteComment(conn, Integer.parseInt(cNumArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}

}
