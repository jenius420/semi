package board.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/*import javax.smartcardio.CommandAPDU;*/
import board.model.vo.Board;
import board.model.vo.BoardComment;
import common.model.vo.Attachment;

public class BoardDao {
	
private Properties prop = new Properties();
	
	public BoardDao() {
		
		String fileName = BoardDao.class.getResource("/sql/board/board_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 게시판 리스트 조회용 호출
	 * @param conn
	 * @param currentPage
	 * @param boardLimit
	 * @return
	 */
	public ArrayList<Board> selectList(Connection conn/*, int currentPage, int boardLimit*/){
		
		ArrayList<Board> list = new ArrayList<>();	
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			/*int startRow = 1;
			int endRow = 100;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);*/
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Board( rset.getInt("tNum"),
									rset.getString("title"),
									rset.getInt("eNum"),
									rset.getString("eName"),
									rset.getDate("updateDate"),
									rset.getString("bBody"),
									rset.getString("invalidPost"),
									rset.getString("isNotice"),
									rset.getInt("boardCount")));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	/**
	 * 게시판 리스트 갯수 조회용 호출
	 * @param conn
	 * @return
	 */
	public int getListCount(Connection conn) {
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
		
	}

	
	
	/**
	 * 조회수 증가시키는 호출
	 * @param conn
	 * @param tnum
	 * @return
	 */
	public int increaseCount(Connection conn, int tNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * 해당 게시글 조회하는 호출
	 * @param tnum
	 * @return
	 */
	public Board selectBoard(Connection conn, int tNum) {
		
		Board b = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("tNum"),
							  rset.getString("title"),
							  rset.getInt("eNum"),
							  rset.getString("eName"),
							  rset.getDate("updateDate"),
							  rset.getString("bBody"),
							  rset.getString("invalidPost"),
							  rset.getString("isNotice"),
							  rset.getInt("boardCount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
		
		
	}
	
	
	
	/**
	 * 사진 조회용 호출
	 * @param conn
	 * @param tNum
	 * @return
	 */
	public ArrayList<Attachment> selectAttachment(Connection conn, int tNum){
		ArrayList<Attachment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setChangeName(rset.getString("SAVENAME"));
				at.setfId(rset.getInt("PNUM"));
				at.settNum(rset.getInt("tNum"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
	
/*	*//**
	 * 글만 있는 게시글 올리는 호출 
	 * @param conn
	 * @param b
	 * @return
	 *//*
	public int onlyInsertBoard(Connection conn, Board b) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("onlyInsertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getbTitle());
			pstmt.setString(3, b.getbContent());
			pstmt.setInt(4, Integer.parseInt(b.getbWriter()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}*/
	
	
	
	
	
	
	
	/**
	 *  게시글 작성하기
	 * @param conn
	 * @param b
	 * @return
	 */
	public int insertBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			/*pstmt.setInt(2, b.geteNum());*/
			pstmt.setString(2, b.getbBody());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * 	게시글 사진올리기
	 * @param conn
	 * @param fileList
	 * @return
	 */
	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			
			for(int i=0; i<fileList.size(); i++) {
				
				Attachment at = fileList.get(i);
				
				pstmt = conn.prepareStatement(sql);
				/*pstmt.setInt(1, b.geteNum());*/
				/*pstmt.setString(2, at.getFilePath());*/
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				
				result = pstmt.executeUpdate();
				
				if(result <= 0) {
					break;
				}
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	/**
	 *  게시판 수정용 호출
	 * @param conn
	 * @param fileList
	 * @param b
	 * @return
	 */
	public int updateBoard(Connection conn, Board b) {
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			/*pstmt.setInt(1, b.gettNum());*/
			pstmt.setString(1, b.getTitle());
			/*pstmt.setInt(3, b.geteNum());
			pstmt.setDate(4, b.getUpdateDate());*/
			pstmt.setString(2, b.getbBody());
			/*pstmt.setInt(6, b.getBoardCount());*/
			pstmt.setInt(3, b.gettNum());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	/**
	 * 사진 수정용 호출
	 * @param conn
	 * @param fileList
	 * @param b
	 * @return
	 */
	public int updateAttachment(Connection conn, ArrayList<Attachment> fileList, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachment");
		
		try {
			
			for(int i=0; i<fileList.size(); i++) {
				
				Attachment at = fileList.get(i);
				
				pstmt = conn.prepareStatement(sql);
				/*pstmt.setInt(1, b.geteNum());*/
				/*pstmt.setString(2, at.getFilePath());*/
				pstmt.setInt(1, b.gettNum());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				
				result = pstmt.executeUpdate();
				
				if(result <= 0) {
					break;
				}
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 *  게시글 삭제하는 호출
	 * @param conn
	 * @param tNum
	 * @return
	 */
	public int deleteBoard(Connection conn, int tNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tNum);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	
	
	}
	
	
	/**
	 * 댓글 조회용 
	 * @param conn
	 * @param tNum
	 * @return
	 */
	public ArrayList<BoardComment> selectRlist(Connection conn, int tNum){
		
		ArrayList<BoardComment> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRlist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new BoardComment(rset.getInt("commentNum"),
										  rset.getString("commentExplain"),
										  rset.getInt("tNum"),
										  rset.getString("deleteOrNot"),
										  rset.getDate("enrollDate"),
										  rset.getInt("eNum"),
										  rset.getString("eName")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	/**
	 *  댓글 입력용 호출
	 * @param conn
	 * @param c
	 * @return
	 */
	public int insertReply(Connection conn, BoardComment c) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCommentExplain());
			pstmt.setInt(2, c.gettNum());
			pstmt.setInt(3, c.geteNum());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 *  게시글 찾기용 호출
	 * @param conn
	 * @param category
	 * @param sText
	 * @return
	 */
	public ArrayList<Board> selectSearchList(Connection conn, String category, String sText/*, int currentPage, int boardLimit*/){
		
		ArrayList<Board> list = new ArrayList<>();	
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		if(category.equals("title")) {	
			sql = prop.getProperty("selectTitleSearchBoardList");
		}else if(category.equals("eName")) {
			sql = prop.getProperty("selecteNameSearchBoardList");
		}else if(category.equals("bBody")) {
			sql = prop.getProperty("selectbBodySearchBoardList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+sText+"%");
			System.out.println(sText);
			
			
			/*int startRow = 1;
			int endRow = 100;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);*/
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board( rset.getInt("tNum"),
									rset.getString("title"),
									rset.getInt("eNum"),
									rset.getString("eName"),
									rset.getDate("updateDate"),
									rset.getString("bBody"),
									rset.getString("invalidPost"),
									rset.getString("isNotice"),
									rset.getInt("boardCount")));
			}
			
			System.out.println("dao" + list);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	
	/**
	 *  찾은 게시판 리스트 갯수 조회용 호출
	 * @param conn
	 * @param category
	 * @param sText
	 * @return
	 */
	public int getSearchListCount(Connection conn, String category, String sText ) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("getSearchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category);
			pstmt.setString(2, "%"+sText+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	
	
	
}
