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

import empService.model.vo.Emp;
import empService.model.dao.EmpEvalDao;
import empService.model.vo.EmpEvaluation;
import ownerService.model.vo.Owner;

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
		
		ArrayList<Emp> list = new ArrayList<>();	
		Emp emp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMemList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				emp = new Emp();
				
				emp.setEmpNum(rs.getInt("ENUM"));
				emp.seteId(rs.getString("EID"));
				emp.seteName(rs.getString("ENAME"));
				emp.setEcNum(rs.getInt("ECNUM"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setInvalid(rs.getString("INVALIDID"));
				emp.setWarningCount(rs.getInt("WARNINGCOUNT"));

				list.add(emp);
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
		
		ArrayList<Owner> list = new ArrayList<>();	
		Owner owner = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOwnerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				owner = new Owner();
				
				owner.setoNum(rs.getInt("ONUM"));
				owner.setoId(rs.getString("OID"));
				owner.setOpName(rs.getString("OPNAME"));
				owner.setOpNum(rs.getInt("OPNUM"));
				owner.setoName(rs.getString("ONAME"));
				owner.setoTel(rs.getString("OTEL"));
				owner.setPhone(rs.getString("PHONE"));
				owner.setEmail(rs.getString("EMAIL"));
				owner.setInvalidId(rs.getString("INVALIDID"));
				owner.setCheckONum(rs.getString("CHECKONUM"));
				
				list.add(owner);
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
