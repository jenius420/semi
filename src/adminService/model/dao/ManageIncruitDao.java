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
		
		ArrayList<Incruit> list = new ArrayList<>();
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectIngIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				incruit = new Incruit();
				
				incruit.setwNum(rs.getInt("WNUM"));
				incruit.setwTitle(rs.getString("WTITLE"));
				incruit.setoNum(rs.getInt("ONUM"));
				incruit.setOpName(rs.getString("OPNAME"));
				incruit.setWorkDay(rs.getString("WORKDAY"));
				incruit.setWorkTime(rs.getString("workTime"));
				incruit.setTermNo(rs.getInt("termNo"));
				incruit.setTermName(rs.getString("termName"));
				incruit.setTermBigName(rs.getString("termBigName"));
				incruit.setGender(rs.getString("workgender"));
				incruit.setAge(rs.getString("workage"));
				incruit.setEdu(rs.getString("workedu"));
				incruit.setEnrollDate(rs.getDate("startDate"));
				incruit.setStatus(rs.getString("incruitstatus"));
				incruit.setDoneDate(rs.getDate("endDate"));
				incruit.setSalaryForm(rs.getString("workForm"));
				incruit.setSalary(rs.getInt("salary"));
				incruit.setpNum(rs.getInt("applyproduct"));
				incruit.setProduct(rs.getString("ptitle"));
				incruit.setDescription(rs.getString("rexplain"));
				incruit.setPeopleCount(rs.getString("peopleCount"));
				incruit.setAddress(rs.getString("opaddress"));
				incruit.setTypeNum(rs.getInt("typeNum"));
				incruit.setType(rs.getString("typeName"));
				incruit.setCategory(rs.getString("categoryName"));
				
				list.add(incruit);
				
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
		
		ArrayList<Incruit> list = new ArrayList<>();	
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectDoneIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				incruit = new Incruit();
				
				incruit.setwNum(rs.getInt("WNUM"));
				incruit.setwTitle(rs.getString("WTITLE"));
				incruit.setoNum(rs.getInt("ONUM"));
				incruit.setOpName(rs.getString("OPNAME"));
				incruit.setWorkDay(rs.getString("WORKDAY"));
				incruit.setWorkTime(rs.getString("workTime"));
				incruit.setTermNo(rs.getInt("termNo"));
				incruit.setTermName(rs.getString("termName"));
				incruit.setTermBigName(rs.getString("termBigName"));
				incruit.setGender(rs.getString("workgender"));
				incruit.setAge(rs.getString("workage"));
				incruit.setEdu(rs.getString("workedu"));
				incruit.setEnrollDate(rs.getDate("startDate"));
				incruit.setStatus(rs.getString("incruitstatus"));
				incruit.setDoneDate(rs.getDate("endDate"));
				incruit.setSalaryForm(rs.getString("workForm"));
				incruit.setSalary(rs.getInt("salary"));
				incruit.setpNum(rs.getInt("applyproduct"));
				incruit.setProduct(rs.getString("ptitle"));
				incruit.setDescription(rs.getString("rexplain"));
				incruit.setPeopleCount(rs.getString("peopleCount"));
				incruit.setAddress(rs.getString("opaddress"));
				incruit.setTypeNum(rs.getInt("typeNum"));
				incruit.setType(rs.getString("typeName"));
				incruit.setCategory(rs.getString("categoryName"));
				
				list.add(incruit);
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
		
		ArrayList<IncruitProduct> list = new ArrayList<>();	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProductList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

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
			
			while(rs.next()) {
				
				incruit = new Incruit();
								
				incruit.setwNum(rs.getInt("WNUM"));
				incruit.setwTitle(rs.getString("WTITLE"));
				incruit.setoNum(rs.getInt("ONUM"));
				incruit.setOpName(rs.getString("OPNAME"));
				incruit.setWorkDay(rs.getString("WORKDAY"));
				incruit.setWorkTime(rs.getString("workTime"));
				incruit.setTermNo(rs.getInt("termNo"));
				incruit.setTermName(rs.getString("termName"));
				incruit.setTermBigName(rs.getString("termBigName"));
				incruit.setGender(rs.getString("workgender"));
				incruit.setAge(rs.getString("workage"));
				incruit.setEdu(rs.getString("workedu"));
				incruit.setEnrollDate(rs.getDate("startDate"));
				incruit.setStatus(rs.getString("incruitstatus"));
				incruit.setDoneDate(rs.getDate("endDate"));
				incruit.setSalaryForm(rs.getString("workForm"));
				incruit.setSalary(rs.getInt("salary"));
				incruit.setpNum(rs.getInt("applyproduct"));
				incruit.setProduct(rs.getString("ptitle"));
				incruit.setDescription(rs.getString("rexplain"));
				incruit.setPeopleCount(rs.getString("peopleCount"));
				incruit.setAddress(rs.getString("opaddress"));
				incruit.setTypeNum(rs.getInt("typeNum"));
				incruit.setType(rs.getString("typeName"));
				incruit.setCategory(rs.getString("categoryName"));
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
			
			while(rs.next()) {
				prod = new IncruitProduct(
									rs.getInt("PCODE"),
									rs.getString("PTITLE"),
									rs.getString("PEXPLAIN"),
									rs.getInt("PPAY")
									);
			}
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
