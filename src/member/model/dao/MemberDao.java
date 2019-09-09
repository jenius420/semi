package member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import member.model.vo.Category;
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
				loginUser = new Member(rset.getInt(1),
									   rset.getString(2),
									   rset.getString(3),
									   rset.getString(4),
									   rset.getString(5),
									   rset.getInt(6),
									   rset.getInt(7),
									   rset.getString(8),
									   rset.getString(9),
									   rset.getString(10),
									   rset.getString(11),
									   rset.getString(12),
									   rset.getString(13),
									   rset.getInt(14),
									   rset.getString(15),
									   rset.getString(16),
									   rset.getString(17),
									   rset.getString(18)
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
		String sql = prop.getProperty("insertOwn");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getoId());
			pstmt.setString(2, mem.getoPwd());
			pstmt.setString(3, mem.getOpName());
			pstmt.setString(4, mem.getOpNum());
			
			pstmt.setString(5, mem.getRoadName());
			pstmt.setInt(6, mem.getRoadMain());
			pstmt.setInt(7, mem.getRoadSub());
			pstmt.setString(8, mem.getOpAddress());
			pstmt.setString(9, mem.getoName());
			pstmt.setString(10, mem.getoTel());
			pstmt.setString(11, mem.getOcNum());
			pstmt.setString(12, mem.getPhone());
			pstmt.setString(13, mem.getEmail());
			pstmt.setString(14, mem.getSubCategory());
		
			pstmt.setString(15, mem.getMailAccept());
			
			pstmt.setString(16, mem.getSmsAccept());
			
			
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
	 * @param no
	 * @return
	 */
	public int deleteEmp(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
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
	public int deleteOwn(Connection conn, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteOwn");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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


	/**
	 * 개인 아이디 찾기
	 * @param conn
	 * @param id
	 * @param cNum
	 * @return
	 */
	public String findIdEmp(Connection conn, String name, String cNum) {
		
		String userId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findIdEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, cNum);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userId=rset.getString(1);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		
		return userId;
	}

	
	/**
	 * 사업자 아이디 찾기
	 * @param conn
	 * @param name
	 * @param cNum
	 * @return
	 */
	public String findIdOwn(Connection conn, String name, String cNum) {
		
		String userId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findIdEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, cNum);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				userId=(rset.getString(1));
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		
		return userId;
		
	}


	public ArrayList<Category> getBigCategory(Connection conn) {
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String sql = prop.getProperty("getBigCategory");
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Category c =new Category();
				c.setBigCategory(rset.getString(1));
				list.add(c);
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


	public ArrayList<Category> getSubCategory(Connection conn, String bigCategoryName) {
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String sql = prop.getProperty("getSubCategory");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bigCategoryName);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Category c =new Category();
				c.setSubCategory(rset.getString(1));
				list.add(c);
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


	public String findEmpPwd(Connection conn, String id, String name, String cNum) {
		String pwd =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findEmpPwd");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, cNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pwd=rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pwd;
	}


	public String findOwnPwd(Connection conn, String id, String name, String cNum) {
		String pwd =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findOwnPwd");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, cNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				pwd=rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pwd;
	}


	public int changeEmpPwd(Connection conn, String id, String name, String cNum, String pwd) {
		
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("changeEmpPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			pstmt.setString(4, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int changeOwnPwd(Connection conn, String id, String name, String cNum, String pwd) {
		
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("changeOwnPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.setString(3, name);
			pstmt.setString(4, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateEmpPwd(Connection conn, String newPwd, String id, String pwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateEmpPwd");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int updateOwnPwd(Connection conn, String newPwd, String id, String pwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateOwnPwd");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}






	
	
	
	
	
	
}
