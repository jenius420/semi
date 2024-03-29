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
	 *  해당 게시글의 파일 리스트들 조회용 서비스
	 * @param tNum
	 * @return
	 */
	public ArrayList<Attachment> selectAttachment(int tNum){
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new BoardDao().selectAttachment(conn, tNum);
		
		close(conn);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 사진을 포함한 게시글 작성용 서비스
	 * @param b
	 * @param fileList
	 * @return
	 */
	public int insertBoard(Board b, ArrayList<Attachment> fileList ) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertBoard(conn, b);
		int result2 = new BoardDao().insertAttachment(conn, fileList, b);
		
		if(result1 > 0 || result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
		
	}
	
	
	
	/**
	 * 공지 작성용 서비스
	 * @param b
	 * @param fileList
	 * @return
	 */
	public int insertPostBoard(Board b, ArrayList<Attachment> fileList ) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertPostBoard(conn, b);	
		int result2 = new BoardDao().insertAttachment(conn, fileList, b);
		
		if(result1 > 0 || result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
		
	}
	
	
	
	

	/**
	 * 글만 있는 게시글 작성용 서비스
	 * @param b
	 * @return
	 */
	public int onlyInsertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}
	
	
	/**
	 *  게시판 수정용 서비스
	 * @param board
	 * @param fileList
	 * @return
	 */
	public int updateBoard(Board board, ArrayList<Attachment> fileList) {
		
		Connection conn = getConnection();
		
		int result1 = new BoardDao().updateBoard(conn, board);
		int result2 = new BoardDao().updateAttachment(conn, fileList, board);
		
		System.out.println("수정용service1 :"+result1);
		System.out.println("수정용service2 :"+result2);
		

		
		if(result1 > 0 || result2 > 0) {
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
	public int updateBoard(Board board) {
		
		Connection conn = getConnection();
		
		int result1 = new BoardDao().updateBoard(conn, board);
		
		System.out.println("수정용service1 :"+result1);
		
		
		
		if(result1 > 0) {
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
	
	
	
	/**
	 * 게시글 찾기 서비스
	 * @param category
	 * @param search
	 * @return
	 */
	public ArrayList<Board> boardSearch(String category, String sText){
		Connection conn = getConnection();
				
		ArrayList<Board> list = new BoardDao().selectSearchList(conn, category, sText);
		
		System.out.println("service" + list);
		
		close(conn);

		return list;
		
	}
	
	
	
	
	/**
	 * 찾은 게시글 갯수 확인 서비스
	 * @return
	 */
	public int getSearchListCount(String category, String sText) {
		
		Connection conn = getConnection();
		
		int result = new BoardDao().getSearchListCount(conn, category, sText);
		
		
		return result;
	}

}
