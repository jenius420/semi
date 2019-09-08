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
import search.model.vo.OPhoto;

import static common.JDBCTemplate.*;


public class SearchDao {
	private Properties prop =new Properties();
	
	public SearchDao(){
		String fileName=SearchDao.class.getResource("/sql/search/search-query.properties").getPath();
//		System.out.println(fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		sql+="ORDER BY STARTDATE DESC))WHERE RNUM BETWEEN ? AND ? ";
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
						rset.getString(27), rset.getString(28), rset.getString(29),rset.getString(30),rset.getString(31),rset.getString(32),rset.getString(33),rset.getInt(34)));
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


	public ArrayList<IncruitInfo> getAllList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<IncruitInfo> list = new ArrayList<>();
		String sql = prop.getProperty("allList");
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new IncruitInfo(rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getString(8), 
						rset.getString(9), rset.getString(10), rset.getString(11), rset.getString(12), 
						rset.getString(13), rset.getString(14), rset.getString(15), rset.getString(16), rset.getDate(17), 
						rset.getDate(18), rset.getString(19),  rset.getString(20), rset.getInt(21), 
						rset.getInt(22), rset.getString(23), rset.getString(24), rset.getString(25), rset.getString(26), 
						rset.getString(27), rset.getString(28), rset.getString(29),rset.getString(30),rset.getString(31),rset.getString(32),rset.getString(33),rset.getInt(34)));
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

	public int listCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result =0;
		String sql = prop.getProperty("listCount");
		try {
			pstmt= conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result =rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int districtListCount(Connection conn, String[] district) {
		int result=0;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		String sql = prop.getProperty("districtListCount");
		for (int i = 0; i < district.length; i++) {
			if(i==district.length-1) {
				sql+="?";
				break;
			}
			sql+="? OR DISTRICTNAME=";
		}
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			for (int i = 0; i < district.length; i++) {
				pstmt.setString(i+1, district[i]);
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

	public ArrayList<IncruitInfo> districtSearch(Connection conn, String[] district, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<IncruitInfo> list = new ArrayList<>();
		System.out.println(start+"....."+end);
		String sql = prop.getProperty("districtSearch");
		for (int i = 0; i < district.length; i++) {
			if(i==district.length-1) {
				sql+="?)";
				break;
			}
			sql+="? OR DISTRICTNAME=";
		}
		sql+="ORDER BY STARTDATE DESC))WHERE RNUM BETWEEN ? AND ? ";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < district.length; i++) {
				pstmt.setString(i+1, district[i]);
			}
			pstmt.setInt(district.length+1, start);
			pstmt.setInt(district.length+2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new IncruitInfo(rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getString(8), 
						rset.getString(9), rset.getString(10), rset.getString(11), rset.getString(12), 
						rset.getString(13), rset.getString(14), rset.getString(15), rset.getString(16), rset.getDate(17), 
						rset.getDate(18), rset.getString(19),  rset.getString(20), rset.getInt(21), 
						rset.getInt(22), rset.getString(23), rset.getString(24), rset.getString(25), rset.getString(26), 
						rset.getString(27), rset.getString(28), rset.getString(29),rset.getString(30),rset.getString(31),rset.getString(32),rset.getString(33),rset.getInt(34)));
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

	public ArrayList<IncruitInfo> searchDetail(Connection conn, String[] details, int start, int end) {
		ArrayList<IncruitInfo> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchDetail");
		for (int i = 0; i < details.length; i++) {
			if(i==details.length-1) {
				sql += "? ORDER BY STARTDATE DESC))";
				break;
			}
			sql+= "? AND TOTALINFO LIKE";
		}
		sql += " WHERE RNUM BETWEEN "+ start+ " AND " + end;
		System.out.println(sql);
		
		try {
			pstmt= conn.prepareStatement(sql);
			for (int i = 0; i < details.length; i++) {
				pstmt.setString(i+1, "%"+details[i]+"%");
			}
			rset =pstmt.executeQuery();
			while(rset.next()) {
				list.add(new IncruitInfo(rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getString(8), 
						rset.getString(9), rset.getString(10), rset.getString(11), rset.getString(12), 
						rset.getString(13), rset.getString(14), rset.getString(15), rset.getString(16), rset.getDate(17), 
						rset.getDate(18), rset.getString(19),  rset.getString(20), rset.getInt(21), 
						rset.getInt(22), rset.getString(23), rset.getString(24), rset.getString(25), rset.getString(26), 
						rset.getString(27), rset.getString(28), rset.getString(29),rset.getString(30),rset.getString(31),rset.getString(32),rset.getString(33),rset.getInt(34)));

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

	public int detailListCount(Connection conn, String[] details) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result =0;
		String sql = prop.getProperty("detailListCount");
		for (int i = 0; i < details.length; i++) {
			if(i==details.length-1) {
				sql+="?";
				break;
			}
			sql+="? AND TOTALINFO LIKE";
		}
		try {
			pstmt =conn.prepareStatement(sql);
			for (int i = 0; i < details.length; i++) {
				pstmt.setString(i+1, "%"+details[i]+"%");
			}
			rset = pstmt.executeQuery();
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
		
		
		return result;
	}

	public IncruitInfo detailView(Connection conn, int num) {
		IncruitInfo i = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("detailView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				i=	new IncruitInfo(rset.getInt(1), rset.getString(2), rset.getString(3), 
						rset.getInt(4), rset.getInt(5), rset.getString(6), rset.getString(7), 
						rset.getString(8), rset.getString(9), rset.getString(10), rset.getString(11), 
						rset.getString(12), rset.getString(13), rset.getString(14), rset.getString(15), rset.getDate(16), 
						rset.getDate(17), rset.getString(18),  rset.getString(19), rset.getInt(20), 
						rset.getInt(21), rset.getString(22), rset.getString(23), rset.getString(24), rset.getString(25), 
						rset.getString(26), rset.getString(27), rset.getString(28),rset.getString(29),rset.getString(30),rset.getString(31),rset.getString(32),rset.getInt(33));
			System.out.println(i);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return i;
	}

	public OPhoto searchLogo(Connection conn, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchLogo");
		OPhoto p =null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p=new OPhoto(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return p;
	}

	public ArrayList<OPhoto> incruitPhotos(Connection conn, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OPhoto> list = new ArrayList<>();
		String sql = prop.getProperty("incruitPhoto");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				list.add(new OPhoto(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4)));
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

	public int checkHopeEnt(Connection conn, int oNum, int eId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkHopeEnt");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.setInt(2, eId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result =rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	
	public int checkHopeEnt2(Connection conn, int oNum, int eId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("checkHopeEnt2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.setInt(2, eId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result =rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateHopeEnt(Connection conn, int oNum, int eId) {
		int  result =-1;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("updateHopeEnt");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.setInt(2, eId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertHopeEnt(Connection conn, int oNum, int eId) {
		int  result =-1;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("insertHopeEnt");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eId);
			pstmt.setInt(2, oNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteHopeEnt(Connection conn, int oNum, int eNum) {
		int result =-1;
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("deleteHopeEnt");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			pstmt.setInt(2, eNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	
	
}
