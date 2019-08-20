package member.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static common.JDBCTemplate.*;

import member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		//항상 member-query.properties에서 값을 새로 가져올수 있도록
		//기본 생성자 안에서 properties 파일을 불러오는 작업수행
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
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
	
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member loginUser=null;
		PreparedStatement pstmt=null;
		ResultSet rset =null;
		String sql = prop.getProperty("loginMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("USER_NO"), rset.getString("user_id"),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),
						rset.getString(7),rset.getString(8),rset.getDate(9),rset.getDate(10),rset.getString(11));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;
	}


	public int insertMember(Connection conn, Member mem) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		System.out.println(sql);
		System.out.println(mem);
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getUserPwd());
			pstmt.setString(3, mem.getUserName());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getAddress());
			pstmt.setString(7, mem.getInterest());
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateMember(Connection conn, Member mem) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserName());
			pstmt.setString(2, mem.getPhone());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getAddress());
			pstmt.setString(5, mem.getInterest());
			pstmt.setString(6, mem.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public Member selectMember(Connection conn, String userId) {
		String sql = prop.getProperty("selectMember");
		Member mem = null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mem =new Member(rset.getInt(1), 
						rset.getString(2), 
						rset.getString(3), 
						rset.getString(4), 
						rset.getString(5), 
						rset.getString(6), 
						rset.getString(7), 
						rset.getString(8), 
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
		
		return mem;
	}


	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwd");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteMember(Connection conn, String userId) {
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
