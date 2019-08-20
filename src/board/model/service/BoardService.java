package board.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDao().getListCount(conn);
		
		close(conn);
		return result;
	}

	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn, currentPage, boardLimit);
		close(conn);
		return list;
	}

	/**
	 * 게시글 작성용 서비스
	 * @param 
	 * @return
	 */
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDao().insertBoard(conn,b);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Board boardDetail(int bno) {
		Connection conn = getConnection();
		
		Board b = null;
		int result = new BoardDao().increaseCount(conn,bno);
		if(result>0) {
			commit(conn);
			b= new BoardDao().boardDetail(conn, bno);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return b;
	}

}
