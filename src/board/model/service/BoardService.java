package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageMemDao;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardComment;
import common.model.vo.Attachment;
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
		
		Connection conn = getConnection();
		
		int result = new BoardDao().getListCount(conn);
		
		
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
	
	/**
	 * 사진을 포함한 게시글 작성용 서비스
	 * @param b
	 * @param fileList
	 * @return
	 */
	public int insertBoard(Board b, ArrayList<Attachment> fileList ) {
		System.out.println("test");
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertBoard(conn, b);
		int result2 = new BoardDao().insertAttachment(conn, fileList, b);
		
		System.out.println("서비스1" + result1);
		System.out.println("서비스2" + result2);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
		
	}
	
	
	
	
	/**
	 *  게시판 수정용 서비스
	 * @param board
	 * @param fileList
	 * @return
	 */
	public int updateBoard(Board board, ArrayList<Attachment> fileList) {
		
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertBoard(conn, board);
		int result2 = new BoardDao().insertAttachment(conn, fileList, board);
		

		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result1;
		
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 게시글 삭제용 서비스
	 * @param bId
	 * @return
	 */
	public int deleteBoard(int tNum) {
		Connection conn = getConnection();
		
		int result = new BoardDao().deleteBoard(conn, tNum);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	/**
	 *  댓글 조회용 서비스
	 * @param tNum
	 * @return
	 */
	public ArrayList<BoardComment> selectRlist(int tNum){
		Connection conn = getConnection();
		
		ArrayList<BoardComment> list = new BoardDao().selectRlist(conn, tNum);
		
		close(conn);
		
		return list;
	}
	
	
	/**
	 *  댓글 입력용 서비스
	 * @param c
	 * @return
	 */
	public int insertReply(BoardComment c) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
