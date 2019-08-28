package empService.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import emp.model.vo.Emp;
import empService.model.vo.EmpEvaluation;
import empService.model.vo.EmpEvaluationBefore;
import empService.model.vo.HopeEnt;
import empService.model.vo.Resume;
import owner.model.vo.Owner;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;

import static common.JDBCTemplate.*;

public class EmpServiceDao {

	private Properties prop = new Properties();
	
	public EmpServiceDao() {
		
		String fileName = EmpServiceDao.class.getResource("/sql/empService/empService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public ArrayList<Appliant> selectApplicationState(Connection conn, int empNum){
		
		ArrayList<Appliant> list = new ArrayList<>();	
		Appliant appliant = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectApplicationState");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				appliant =new Appliant(
										rs.getInt("APPLYNUM"),
										rs.getInt("RNUM"),
										rs.getString("COMMENT"),
										rs.getInt("ENUM"),
										rs.getString("ENAME"),
										rs.getInt("WNUM"),
										rs.getString("WTITLE"),
										rs.getInt("ONUM"),
										rs.getString("OPNAME"),
										rs.getString("INCRUITSTATUS"),
										rs.getDate("ENDDATE"),
										rs.getDate("APPLYDATE"),
										rs.getString("PASSORFAIL")
										);
				
				list.add(appliant);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int cancleAppliant(Connection conn, int applyNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("cancleAppliant");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, applyNum);
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
	
//	디컴
//	public ArrayList<Integer> selectInterestOwnerNum(Connection conn, int empNum){
//		
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = prop.getProperty("selectInterestOwnerNum");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, empNum);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				
//				list.add(rs.getInt("ONUM"));
//
//			}
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		
//		return list;
//		
//	}
	
	public ArrayList<HopeEnt> selectInterestOwner(Connection conn, int empNum){
		
		ArrayList<HopeEnt> list = new ArrayList<>();	
		HopeEnt he = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectInterestOwner");
		
		try {
			

				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, empNum);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					he = new HopeEnt();
					
					he.sethNum(rs.getInt("HNO"));
					he.seteNum(rs.getInt("ENUM"));
					he.setoNum(rs.getInt("ONUM"));
					he.setOpName(rs.getString("OPNAME"));
					he.setOpAddress(rs.getString("OPADDRESS"));
					he.setPhone(rs.getInt("PHONE"));
					he.setType(rs.getString("TYPENAME"));
					he.setDeleteornot(rs.getString("DELETEORNOT"));

					list.add(he);
				}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int deleteInterestOwnerServlet(Connection conn , int eNum, int oNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteInterestOwnerServlet");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eNum);
			pstmt.setInt(2, oNum);
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public ArrayList<Incruit> selectInterestIncruit(Connection conn, ArrayList<HopeEnt> oList) {
		
		ArrayList<Incruit> list = new ArrayList<>();	
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = prop.getProperty("selectInterestIncruit");
		
		try {
			
			for(int i=0; i<oList.size(); i++) {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, oList.get(i).getoNum());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					incruit = new Incruit();
					
					incruit.setwNum(rs.getInt("WNUM"));
					incruit.setwTitle(rs.getString("WTITLE"));
					incruit.setOpName(rs.getString("OPNAME"));
					incruit.setWorkStartTerm(rs.getDate("WORKSTARTTERM"));
					incruit.setWorkEndTerm(rs.getDate("WORKENDTERM"));
					incruit.setSalaryForm(rs.getString("WORKFORM"));
					incruit.setSalary(rs.getInt("SALARY"));
				
					list.add(incruit);
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int apply(Connection conn, int wNum, int rNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("apply");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, wNum);
			pstmt.setInt(2, rNum);
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	

}
