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
import ownerService.model.vo.Incruit;
import ownerService.model.vo.IncruitProduct;

public class ManageIncruitDao {
	
	private Properties prop = new Properties();
	
	public ManageIncruitDao() {
		
		String fileName = ManageIncruitDao.class.getResource("/sql/adminService/adminService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Incruit> selectIngIncruitList(Connection conn) {
		
		ArrayList<Incruit> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectIngIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				list.add(new Incruit(
									rs.getInt("WNUM"),
									rs.getString("WTITLE"),
									rs.getInt("ONUM"),
									rs.getString("OPNAME"),
									rs.getDate("WORKSTARTTERM"),
									rs.getDate("WORKENDTERM"),
									rs.getString("WORKDAY"),
									rs.getString("WORKSTARTTIME"),
									rs.getString("WORKENDTIME"),
									rs.getString("TERMNAME"),
									rs.getString("WORKGENDER"),
									rs.getInt("WORKAGE"),
									rs.getString("WORKEDU"),
									rs.getDate("STARTDATE"),
									rs.getString("INCRUITSTATUS"),
									rs.getDate("ENDDATE"),
									rs.getString("WORKFORM"),
									rs.getInt("SALARY"),
									rs.getInt("APPLYPRODUCT"),
									rs.getString("PTITLE"),
									rs.getString("REXPLAIN")
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
	
	public ArrayList<Incruit> selectDoneIncruitList(Connection conn) {
		
		ArrayList<Incruit> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectDoneIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				list.add(new Incruit(
									rs.getInt("WNUM"),
									rs.getString("WTITLE"),
									rs.getInt("ONUM"),
									rs.getString("OPNAME"),
									rs.getDate("WORKSTARTTERM"),
									rs.getDate("WORKENDTERM"),
									rs.getString("WORKDAY"),
									rs.getString("WORKSTARTTIME"),
									rs.getString("WORKENDTIME"),
									rs.getString("TERMNAME"),
									rs.getString("WORKGENDER"),
									rs.getInt("WORKAGE"),
									rs.getString("WORKEDU"),
									rs.getDate("STARTDATE"),
									rs.getString("INCRUITSTATUS"),
									rs.getDate("ENDDATE"),
									rs.getString("WORKFORM"),
									rs.getInt("SALARY"),
									rs.getInt("APPLYPRODUCT"),
									rs.getString("PTITLE"),
									rs.getString("REXPLAIN")
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
	
	public ArrayList<IncruitProduct> selectProductList(Connection conn) {
		
		ArrayList<IncruitProduct> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProductList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				list.add(new IncruitProduct(
									rs.getInt("PCODE"),
									rs.getString("PTITLE"),
									rs.getString("PEXPLAIN"),
									rs.getInt("PPAY")
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
	
	public Incruit watchingIncruit(Connection conn, int wNum) {
		
		Incruit incruit = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("watchingIncruit");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, wNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				incruit = new Incruit(
										rs.getInt("WNUM"),
										rs.getString("WTITLE"),
										rs.getInt("ONUM"),
										rs.getString("OPNAME"),
										rs.getDate("WORKSTARTTERM"),
										rs.getDate("WORKENDTERM"),
										rs.getString("WORKDAY"),
										rs.getString("WORKSTARTTIME"),
										rs.getString("WORKENDTIME"),
										rs.getString("TERMNAME"),
										rs.getString("WORKGENDER"),
										rs.getInt("WORKAGE"),
										rs.getString("WORKEDU"),
										rs.getDate("STARTDATE"),
										rs.getString("INCRUITSTATUS"),
										rs.getDate("ENDDATE"),
										rs.getString("WORKFORM"),
										rs.getInt("SALARY"),
										rs.getInt("APPLYPRODUCT"),
										rs.getString("PTITLE"),
										rs.getString("REXPLAIN")
										);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return incruit;
		
	}
	
	public int InsertProduct(Connection conn, IncruitProduct prod) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, prod.getpTitle());
			pstmt.setString(2, prod.getpExplain());
			pstmt.setInt(3, prod.getpPay());
			
			result = pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public IncruitProduct selectProduct(Connection conn, int pCode) {
		
		IncruitProduct prod = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pCode);
			
			rs = pstmt.executeQuery();
			
			prod = new IncruitProduct(
								rs.getInt("PCODE"),
								rs.getString("PTITLE"),
								rs.getString("PEXPLAIN"),
								rs.getInt("PPAY")
								);
	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return prod;
	}
	
	public int updateProduct(Connection conn, IncruitProduct prod) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, prod.getpTitle());
			pstmt.setString(2, prod.getpExplain());
			pstmt.setInt(3, prod.getpPay());
			pstmt.setInt(4, prod.getpCode());
			
			result = pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
