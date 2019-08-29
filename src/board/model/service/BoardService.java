package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageMemDao;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import empService.model.vo.Emp;

import static common.JDBCTemplate.*;

public class BoardService {
	
	/**
	 * 게시판 리스트 조회용 서비스
	 * @param currentPage
	 * @param boardLimit
	 * @return
	 */
	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
		
	}
	
	/**
	 * 게시판 리스트 갯수 조회용 서비스
	 * @return
	 */
	public int getListCount() {
		
		int result = 0;
		
		//사용할 sql문= SELECT COUNT(*) FROM TB WHERE절
		return result;
	}
	
	
	/**
	 * 해당 게시글 조회용 서비스 
	 * @param tNum
	 * @return
	 */
	public Board selectBoard(int tNum) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, tNum);
		
		Board b = null;
		
		if(result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, tNum);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}

}
