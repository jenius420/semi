package main.model.dao;

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

import main.model.vo.Main;

public class MainDao {

	private Properties prop = new Properties();
		
		public MainDao() {
			String fileName = MainDao.class.getResource("/sql/main/main-query.properties").getPath();
			
			try {
				prop.load(new FileReader(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		/**
		 *  id의 주소를 기반으로 한 추천 리스트
		 * @param conn, id
		 * @return
		 */
	public ArrayList<Main> selectRecomendList(Connection conn, String id){
		ArrayList<Main> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRecomendList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				list.add(new Main(rset.getString("logo"),
								rset.getString("title")));
				
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Main> selectPrimiumList(Connection conn){
		ArrayList<Main> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPrimiumList");
		
		
		try {
		stmt = conn.createStatement();
		
		rset = stmt.executeQuery(sql);
		
		while(rset.next()) {
			list.add(new Main(rset.getString("logo"),
							rset.getString("title")));
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
}
