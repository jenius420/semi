package adminService.model.dao;

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

import board.model.vo.Board;
import board.model.vo.Comment;
import ownerService.model.vo.Owner;
import ownerService.model.vo.Incruit;

public class ManageBoardDao {
	
	private Properties prop = new Properties();
	
	public ManageBoardDao() {
		
		String fileName = ManageBoardDao.class.getResource("/sql/adminService/adminService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Board> selectBoardReportList(Connection conn) {
		
		ArrayList<Board> list = new ArrayList<>();	
		Board board = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectBoardReportList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {

				board = new Board(
									rs.getInt("TNUM"),
									rs.getString("TITLE"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getDate("UPDATEDATE"),
									rs.getString("BBODY"),
									rs.getString("PHOTO"),
									rs.getInt("REPORT"),
									rs.getString("INVALIDPOST"),
									rs.getString("ISNOTICE"),
									rs.getInt("BOARDCOUNT")
									);
				list.add(board);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Comment> selectCommentReportList(Connection conn) {
		
		ArrayList<Comment> list = new ArrayList<>();	
		Comment comment = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectCommentReportList");
		
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				comment = new Comment(
									rs.getInt("COMMENTNUM"),
									rs.getString("COMMENTEXPLAIN"),
									rs.getInt("TNUM"),
									rs.getString("DELETEORNOT"),
									rs.getDate("ENROLLDATE"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getInt("WARNING")
									);
				list.add(comment);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return list;
		
	}
	
	public int deleteBoard(Connection conn, int tNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteBoard");

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
	
	
	public int deleteComment(Connection conn, int commentNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteComment");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}

}
