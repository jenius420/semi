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
	 * 개인 회원 로그인
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
				loginUser = new Member(rset.getInt("enum"),
						rset.getString("eid"),
						rset.getString("epwd"),
						rset.getString("eName"),
						rset.getString("ecnum"),
						rset.getInt("dongnum"),
						rset.getInt("roadnum"),
						rset.getString("eaddress"),
						rset.getString("phone"),
						rset.getString("email"),
						rset.getString("mailaccept"),
						rset.getString("smsaccept"),
//						rset.getString("roadName"),
//						rset.getInt("roadMain"),
//						rset.getInt("roadSub"),
						rset.getString("invalidid"),
						rset.getInt("warningcount")
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
	 * 사업자 회원 로그인
	 * @param conn
	 * @param id
	 * @param pwd
	 * @return
	 */
//	public Member loginOwn(Connection conn, String id, String pwd) {
//		
//		Member loginUser = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String sql = prop.getProperty("loginOwn");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, pwd);
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				loginUser = new Member(rset.getInt("onum"),
//									   rset.getString("oid"),
//									   rset.getString("opwd"),
//									   rset.getString("opname"),
//									   rset.getInt("opnum"),
//									   rset.getInt("dongnum"),
//									   rset.getInt("roadnum"),
//									   rset.getString("opaddress"),
//									   rset.getString("oName"),
//									   rset.getString("oTel"),
//									   rset.getString("ocnum"),
//									   rset.getString("phone"),
//									   rset.getString("email"),
//									   rset.getInt("typenum"),
//									   rset.getString("mailaccept"),
//									   rset.getString("smsaccept"),
//									   rset.getString("roadName"),
//									   rset.getInt("roadMain"),
//									   rset.getInt("roadSub"),
//									   rset.getString("invalidid"),
//									   rset.getString("checkonum")
//									  );
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		return loginUser;
//	}


	/**
	 * 개인 회원 가입
	 * @param conn
	 * @param mem
	 * @return
	 */
	public int insertEmp(Connection conn, Member mem) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.geteId());
			pstmt.setString(2, mem.getePwd());
			pstmt.setString(3, mem.geteName());
			pstmt.setString(4, mem.getEcNum());
			
			pstmt.setString(5, mem.getRoadName());
			pstmt.setInt(6, mem.getRoadMain());
			pstmt.setInt(7, mem.getRoadSub());
			pstmt.setString(8, mem.geteAddress());
			pstmt.setString(9, mem.getPhone());
			pstmt.setString(10, mem.getEmail());
			/*
			pstmt.setString(12, mem.getMailAccept());
			pstmt.setString(13, mem.getSmsAccept());
			*/
			
			if(mem.getMailAccept() == null || mem.getMailAccept().equals("")) {
				pstmt.setString(11, "N");
			}else {
				pstmt.setString(11, "Y");
			}
			if(mem.getSmsAccept() == null || mem.getSmsAccept( ).equals("")) {
				pstmt.setString(12, "N");
			}else {
				pstmt.setString(12, "Y");
			}
			
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 사업자 회원 가입
	 * @param conn
	 * @param mem
	 * @return
	 */
	public int insertOwn(Connection conn, Member mem) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/**
	 * 개인 회원 탈퇴
	 * @param conn
	 * @param id
	 * @return
	 */
	public int deleteEmp(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 사업자 회원 탈퇴
	 * @param conn
	 * @param id
	 * @return
	 */
	public int deleteOwn(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteOwn");
		
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 개인 아이디 체크
	 * @param conn
	 * @param eId
	 * @return
	 */
	public int idCheckEmp(Connection conn, String eId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheckEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		
		
		
		return result;
	}


	public Member loginOwn(Connection conn, String id, String pwd) {
		
		
		
		return null;
	}




	
	
	
	
	
	
}
