package empService.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import empService.model.vo.*;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.*;

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
										rs.getString("eCOMMENT"),
										rs.getInt("ENUM"),
										rs.getString("ENAME"),
										rs.getInt("WNUM"),
										rs.getString("WTITLE"),
										rs.getInt("ONUM"),
										rs.getString("OPNAME"),
										rs.getString("INCRUITSTATUS"),
										rs.getDate("ENDDATE"),
										rs.getDate("APPLYDATE"),
										rs.getString("PASSORFAIL"),
										rs.getInt("sevalNum")
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
	
	public int addHopeEnt(Connection conn, int eNum, int oNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("addHopeEnt");

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
					he.setPhone(rs.getString("PHONE"));
					he.setType(rs.getString("TYPENAME"));
					he.setCategory(rs.getString("CATEGORYNAME"));
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
	

	public ArrayList<HopeEnt> addDong(Connection conn, ArrayList<HopeEnt> iList) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("addDong");
		
		try {
				
				for(HopeEnt hs: iList) {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, hs.getoNum());
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
					
						hs.setOpName(rs.getString("OPNAME"));
						hs.setOpAddress(rs.getString("OPADDRESS"));
						hs.setDong(rs.getString("DONG"));
						hs.setRoadName(rs.getString("RoadName"));
	
					}
				}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return iList;
	}
	
	public ArrayList<Incruit> addDong2(Connection conn, ArrayList<Incruit> iList) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("addDong");
		
		try {
				
				for(Incruit hs: iList) {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, hs.getoNum());
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
					
						hs.setOpName(rs.getString("OPNAME"));
						hs.setAddress(rs.getString("OPADDRESS"));
						hs.setDong(rs.getString("DONG"));
						hs.setRoadName(rs.getString("RoadName"));
	
					}
				}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return iList;
	}
	
	public int deleteInterestOwner(Connection conn , int hNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteInterestOwner");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, hNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public ArrayList<Incruit> selectInterestIncruit(Connection conn, ArrayList<HopeEnt> hList) {
		
		ArrayList<Incruit> list = new ArrayList<>();	
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = prop.getProperty("selectInterestIncruit");
		
		try {
			
			for(int i=0; i<hList.size(); i++) {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hList.get(i).getoNum());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					incruit = new Incruit();
					
					incruit.setwNum(rs.getInt("WNUM"));
					incruit.setwTitle(rs.getString("WTITLE"));
					incruit.setOpName(rs.getString("OPNAME"));
					incruit.setTermName(rs.getString("TERMNAME"));
					incruit.setWorkDay(rs.getString("WORKDAY"));
					incruit.setWorkTime(rs.getString("WORKTIME"));
					incruit.setCategory(rs.getString("CATEGORYNAME"));
					incruit.setType(rs.getString("TYPENAME"));
					incruit.setSalaryForm(rs.getString("WORKFORM"));
					incruit.setSalary(rs.getInt("SALARY"));
					incruit.setDoneDate(rs.getDate("ENDDATE"));
					incruit.setAddress(rs.getString("OPADDRESS"));
				
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
	
	public int applyDuplicationCheck(Connection conn, int wNum, int rNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("applyDuplicationCheck");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			pstmt.setInt(2, wNum);
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	
	public int apply(Connection conn, int wNum, int rNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("apply");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			pstmt.setInt(2, wNum);
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public Emp selectEmp(Connection conn, int eNum) {
		
		Emp emp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = prop.getProperty("selectEmp");
		
		try {
						
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, eNum);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					emp = new Emp();
					
					emp.setEmpNum(rs.getInt("ENUM"));
					emp.seteId(rs.getString("EID"));
					emp.setePwd(rs.getString("EPWD"));
					emp.seteName(rs.getString("ENAME"));
					emp.setEcNum(rs.getString("ECNUM"));
					emp.setDongNum(rs.getInt("DONGNUM"));
					emp.setRoadNum(rs.getInt("ROADNUM"));
					emp.setAddress(rs.getString("EADDRESS"));
					emp.setPhone(rs.getString("PHONE"));
					emp.setEmail(rs.getString("EMAIL"));
					emp.setMailAccept(rs.getString("MAILACCEPT"));
					emp.setSmsAccept(rs.getString("SMSACCEPT"));
					emp.setInvalid(rs.getString("INVALIDID"));
					emp.setWarningCount(rs.getInt("WARNINGCOUNT"));

				}
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return emp;
		
	}
	

}
