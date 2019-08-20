package adminService.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import emp.model.vo.Emp;
import empService.model.dao.EmpEvalDao;
import empService.model.vo.EmpEvaluation;
import member.model.vo.PersonMember;
import owner.model.vo.Owner;

public class ManageMemDao {
	
	private Properties prop = new Properties();
	
	public ManageMemDao() {
		
		String fileName = ManageMemDao.class.getResource("/sql/adminService/adminService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Emp> selectEmpList(Connection conn) {
		
		ArrayList<Emp> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMemList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 회원vo 어떤거 쓸지 결정해야함. 컬럼은 전부 가져와야할듯
				list.add(new Emp(
									rs.getInt("ENUM"),
									rs.getString("EID"),
									rs.getString("ENAME"),
									rs.getInt("ECNUM"),
									rs.getInt("PHONE")
									rs.getString("EMAIL")
									rs.getString("INVALIDID")
									));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Owner> selectOwnerList(Connection conn) {
		
		ArrayList<Owner> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOwnerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 회원vo 어떤거 쓸지 결정해야함. 컬럼은 전부 가져와야할듯
				list.add(new Owner(
									rs.getInt("ENUM"),
									rs.getString("EID"),
									rs.getString("ENAME"),
									rs.getInt("ECNUM"),
									rs.getInt("PHONE")
									rs.getString("EMAIL")
									rs.getString("INVALIDID")
									));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public int warnEmp(Connection conn, int eNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("warnEmp");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int warnOwner(Connection conn, int oNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("warnOwner");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int deleteEmp(Connection conn, int eNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteEmp");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int deleteOwner(Connection conn, int oNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteOwner");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, oNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	
	
}
