package member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberDao {
	
	private Properties prop = new Properties();

	public MemberDao() {
		
		String filName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 로그인
	 * @param conn
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginMember(Connection conn, String id, String pwd) {
		

		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt(""))
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 개인 로그인
	 * @param conn
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginEmp(Connection conn, String id, String pwd) {
			
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginEmp");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				loginUser = new Member(rset.getInt("onum"),
									   rset.getString("oid"),
									   rset.getString("opwd"),
									   rset.getString("eName"),
									   rset.getInt("ecnum"),
									   rset.getInt("dongnum"),
									   rset.getInt("eaddress"),
									   rset.getString("phone"),
									   rset.getString("email"),
									   rset.getString("mailaccept"),
									   rset.getString("smsaccept"),
									   rset.getString("invalidid"),
									   rset.getInt("warningcount"),
									   rset.getInt("onum1"),
									   rset.getInt("onum2"),
									   rset.getInt("onum3"),
									   rset.getInt("onum4"),
									   rset.getInt("onum5")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	/**
	 * 기업 로그인
	 * @param conn
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginOwn(Connection conn, String id, String pwd) {
		
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginOwn");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getInt("onum"),
									   rset.getString("oId"),
									   rset.getString("oPwd"),
									   rset.getString("opName"),
									   rset.getInt("opNum"),
									   rset.getInt("dongNum"),
									   rset.getString("opaddress"),
									   rset.getString("oName"),
									   rset.getString("otel"),
									   rset.getInt("ocnum"),
									   rset.getString("phone"),
									   rset.getString("email"),
									   rset.getInt("typenum"),
									   rset.getString("mailaccept"),
									   rset.getString("smsaccept"),
									   rset.getString("invalidid"),
									   rset.getString("checkonum")
									  );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

}
