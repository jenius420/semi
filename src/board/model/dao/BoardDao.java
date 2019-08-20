package board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import board.model.vo.Board;

import static common.JDBCTemplate.*;

public class BoardDao {
	private Properties prop = new Properties();
	public BoardDao() {
		String fileName=BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getListCount(Connection conn) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("getListCount");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	public ArrayList<Board> selectList(Connection conn, int currentPage, int boardLimit) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (currentPage-1)*boardLimit+1);
			pstmt.setInt(2, currentPage*boardLimit);
			rset= pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Board(rset.getInt(2),
						rset.getInt(3),
						rset.getString(4),
						rset.getString(5),
						rset.getString(6),
						rset.getString(7),
						rset.getInt(8),
						rset.getDate(9),
						rset.getDate(10),
						rset.getString(11)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("insertBoard");
		int cid = Integer.parseInt(b.getcName());
		String title = b.getbTitle();
		String content=b.getbContent();
		int writer = Integer.parseInt(b.getUserName());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, writer);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public Board boardDetail(Connection conn, int bno) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("boardDetail");
		Board b = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rset=pstmt.executeQuery();
			if (rset.next()) {
				b= new Board(rset.getInt(1), 
						rset.getInt(2), 
						rset.getString(3), 
						rset.getString(4), 
						rset.getString(5), 
						rset.getInt(6)+","+rset.getString(7), 
						rset.getInt(8), 
						rset.getDate(9), 
						rset.getDate(10), 
						rset.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}
	public int increaseCount(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
