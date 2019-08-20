package notice.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDao;
import notice.model.vo.Notice;

public class NoticeDao {

	private Properties prop=new Properties();
	public NoticeDao() {
		String fileName = MemberDao.class.getResource("/sql/notice/notice-query.properties").getPath();
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
	
	
	public ArrayList<Notice> selectList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt= conn.prepareStatement(sql);
			rset= pstmt.executeQuery();
			for (int i = 0; true; i++) {
				if(rset.next()) {
					list.add(new Notice(rset.getInt(1),
							rset.getString(2), 
							rset.getString(3), 
							rset.getString(4), 
							rset.getInt(5), 
							rset.getDate(6), 
							rset.getString(7)));
				}else {
					break;
				}
				
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


	public int insertNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnContent());
			pstmt.setString(3, n.getnWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public Notice selectNotice(Connection conn, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		Notice n = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n= new Notice(rset.getInt(1), 
						rset.getString(2), 
						rset.getString(3), 
						rset.getString(4), 
						rset.getInt(5), 
						rset.getDate(6), 
						rset.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}


	public int increaseCount(Connection conn, int nno) {
		PreparedStatement pstmt =null;
		int result = 0;
		String sql = prop.getProperty("increaseCount");
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.setInt(2, nno);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnContent());
			pstmt.setInt(3, n.getnNo());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int deleteNotice(Connection conn, int bno) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
