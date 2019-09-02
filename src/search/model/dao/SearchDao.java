package search.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import search.model.vo.IncruitInfo;

import static common.JDBCTemplate.*;


public class SearchDao {
	private Properties prop;
	
	public SearchDao(){
		String fileName=SearchDao.class.getResource("/sql/search/search-query.properties").getPath();
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

	/**
	 * @param conn
	 * @param 선택한 업종들 배열
	 * @return 카테고리 같은거 찾아서 갯수 반환
	 */
	public int getCateListCount(Connection conn, String[] cates) {
		int result=0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("cateListCount");
		for (int i = 0; i < cates.length; i++) {
			if(i==cates.length-1) {
				sql+="?";
				break;
			}
			sql+="? OR CATEGORYNAME=";
		}
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i < cates.length; i++) {
				pstmt.setString(i+1, cates[i]);
			}
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<IncruitInfo> getCateListCount(Connection conn, String[] cates, int startPage, int endPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<IncruitInfo> list = new ArrayList<>();
		String sql = prop.getProperty("cateList");
		for (int i = 0; i < cates.length; i++) {
			if(i==cates.length-1) {
				sql+="?)";
				break;
			}
			sql+="? OR CATEGORYNAME=";
		}
		sql+="AND ROWNUM BETWEEN ? AND ? ORDER BY STARTDATE DESC)";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < cates.length; i++) {
				pstmt.setString(i+1, cates[i]);
			}
			pstmt.setInt(cates.length+1, startPage);
			pstmt.setInt(cates.length+2, endPage);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new IncruitInfo(rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getString(8), 
						rset.getString(9), rset.getString(10), rset.getString(11), rset.getString(12), 
						rset.getString(13), rset.getString(14), rset.getString(15), rset.getString(16), rset.getDate(17), 
						rset.getDate(18), rset.getString(19),  rset.getString(20), rset.getInt(21), 
						rset.getInt(22), rset.getString(23), rset.getString(24), rset.getString(25), rset.getString(26), 
						rset.getString(27), rset.getString(28), rset.getString(29),rset.getString(30),rset.getString(31)));
//				i 1,4,5,20,21 d16,17			
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
	
	
	
}
