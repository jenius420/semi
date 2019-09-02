package sort.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import sort.model.vo.Recruit;

public class RecruitDao {
	
	private Properties prop = new Properties();
	
	public RecruitDao() {
		String fileName = RecruitDao.class.getResource("/sql/sort/sort.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 1. 등록일순 조회용
	 * @param conn
	 * @return
	 */
	public ArrayList<Recruit> selectRecently(Connection conn){
		ArrayList<Recruit> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRecently");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Recruit(rset.getInt(1),
									 rset.getString(2),
									 rset.getString(3),
									 rset.getString(4),
									 rset.getString(5),
									 rset.getInt(6),
									 rset.getString(7),
									 rset.getDate(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
		
	}
	
	
	/**
	 * 2. 시급순 조회용
	 * @param conn
	 * @return
	 */
	public ArrayList<Recruit> selectHourly(Connection conn, String workform){
		ArrayList<Recruit> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHourly");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, workform);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recruit(rset.getInt(1),
									 rset.getString(2),
									 rset.getString(3),
									 rset.getString(4),
									 rset.getString(5),
									 rset.getInt(6),
									 rset.getString(7),
									 rset.getDate(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	/**
	 * 3. 일급순 조회용
	 * @param conn
	 * @param workform
	 * @return
	 */
	public ArrayList<Recruit> selectDayly(Connection conn, String workform){
		ArrayList<Recruit> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDayly");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, workform);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recruit(rset.getInt(1),
									 rset.getString(2),
									 rset.getString(3),
									 rset.getString(4),
									 rset.getString(5),
									 rset.getInt(6),
									 rset.getString(7),
									 rset.getDate(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	/**
	 * 4. 월급순 조회용
	 * @param conn
	 * @param workform
	 * @return
	 */
	public ArrayList<Recruit> selectMonthly(Connection conn, String workform){
		ArrayList<Recruit> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMonthly");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, workform);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recruit(rset.getInt(1),
									 rset.getString(2),
									 rset.getString(3),
									 rset.getString(4),
									 rset.getString(5),
									 rset.getInt(6),
									 rset.getString(7),
									 rset.getDate(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	/**
	 * 5. 연봉순 조회용
	 * @param conn
	 * @param workform
	 * @return
	 */
	public ArrayList<Recruit> selectYearly(Connection conn, String workform){
		ArrayList<Recruit> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectYearly");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, workform);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Recruit(rset.getInt(1),
									 rset.getString(2),
									 rset.getString(3),
									 rset.getString(4),
									 rset.getString(5),
									 rset.getInt(6),
									 rset.getString(7),
									 rset.getDate(8)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
}
