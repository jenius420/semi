package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageMemDao;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import emp.model.vo.Emp;

import static common.JDBCTemplate.*;

public class BoardService {
	
	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		
		Connection conn = getConnection();

		ArrayList<Board> list = new BoardDao().selectList(conn, currentPage, boardLimit);

		close(conn);

		return list;
		
	}
	
	public int getListCount() {
		
		사용할 sql문= SELECT COUNT(*) FROM TB WHERE절
		
	}

}
