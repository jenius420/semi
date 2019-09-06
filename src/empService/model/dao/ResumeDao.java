package empService.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import common.model.vo.Attachment;
import empService.model.vo.Resume;
import ownerService.model.vo.Filter;
import ownerService.model.vo.Incruit;

public class ResumeDao {
	
	private Properties prop = new Properties();
	
	public ResumeDao() {
		
		String fileName = ResumeDao.class.getResource("/sql/empService/empService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int enrollResume(Connection conn, Resume resume) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("enrollResume");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resume.getEmpNum());
			pstmt.setInt(2, resume.getDistrictNum());
			pstmt.setInt(3, resume.getTypeNum());
			pstmt.setString(4, resume.getComment());
			pstmt.setString(5, resume.getDesireForm());
			pstmt.setInt(6, resume.getDesireIncome());
			pstmt.setString(7, resume.getOpenSet());
			pstmt.setString(8, resume.getEdu());
//			

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int enrollAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("enrollAttachment");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}   
	
	public int updateAttachment(Connection conn, Attachment at, int rNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAttachment");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteAttachment(Connection conn, int rNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAttachment");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Resume selectResume(Connection conn, int rNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Resume resume = null;
		
		String sql = prop.getProperty("selectResume");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resume = new Resume(
									rs.getInt("RNUM"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getString("EADDRESS"),
									rs.getString("PHONE"),
									rs.getString("EMAIL"),
									rs.getInt("DISTRICTNum"),
									rs.getString("DISTRICTNAME"),
									rs.getInt("TYPENUM"),
									rs.getString("TYPENAME"),
									rs.getString("CATEGORYNAME"),
									rs.getString("ECOMMENT"),
									rs.getDate("UPDATEDATE"),
									rs.getString("INVALIDRESUME"),
									rs.getString("DESIREFORM"),
									rs.getInt("DESIREINCOME"),
									rs.getString("OPENSET"),
									rs.getString("FINALEDUNUM")
				);
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resume;
		
	}
	
	public Attachment selectAttachment(Connection conn, int rNum) {
		
		Attachment at = new Attachment();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				at.setChangeName(rset.getString("SAVENAME"));
				at.setfId(rset.getInt("PNUM"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
	}
	
	public int updateResume(Connection conn, Resume resume) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateResume");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resume.getDistrictNum());
			pstmt.setInt(2, resume.getTypeNum());
			//pstmt.setInt(3, resume.getEduNum());
			pstmt.setString(4, resume.getDesireForm());
			pstmt.setInt(5, resume.getDesireIncome());
			pstmt.setString(6, resume.getComment());
			pstmt.setString(7, resume.getOpenSet());
			//pstmt.setString(8, resume.getSaveName());
			
			pstmt.setInt(8, resume.getrNum());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int deleteResume(Connection conn, int rNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteResume");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rNum);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public ArrayList<Resume> selectResumeList(Connection conn, int eNum){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Resume> list = new ArrayList<>();	
		Resume resume = null;
		
		String sql = prop.getProperty("selectResumeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				resume = new Resume(
									rs.getInt("RNUM"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getString("EADDRESS"),
									rs.getString("PHONE"),
									rs.getString("EMAIL"),
									rs.getInt("DISTRICTNum"),
									rs.getString("DISTRICTNAME"),
									rs.getInt("TYPENUM"),
									rs.getString("TYPENAME"),
									rs.getString("CATEGORYNAME"),
									rs.getString("ECOMMENT"),
									rs.getDate("UPDATEDATE"),
									rs.getString("INVALIDRESUME"),
									rs.getString("DESIREFORM"),
									rs.getInt("DESIREINCOME"),
									rs.getString("OPENSET"),
									rs.getString("FINALEDUNUM")
				);
				
				list.add(resume);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

//	디컴
//	public ArrayList<Incruit> selectSuitableIncruit(Connection conn, Resume resume) {
//		
//		ArrayList<Incruit> list = new ArrayList<>();	
//		Incruit incruit = null;
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = prop.getProperty("selectSuitableIncruit");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, resume.getDistrict());
//			pstmt.setString(2, resume.getType());
//			pstmt.setString(3, resume.getEdu());
//			pstmt.setString(4, resume.getDesireForm());
//			pstmt.setInt(5, resume.getDesireIncome());
//			
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				incruit = new Incruit(
//										rs.getInt("WNUM"),
//										rs.getString("WTITLE"),
//										rs.getInt("ONUM"),
//										rs.getString("OPNAME"),
//										rs.getDate("WORKSTARTTERM"),
//										rs.getDate("WORKENDTERM"),
//										rs.getString("WORKDAY"),
//										rs.getString("WORKSTARTTIME"),
//										rs.getString("WORKENDTIME"),
//										rs.getString("TERMNAME"),
//										rs.getString("WORKGENDER"),
//										rs.getInt("WORKAGE"),
//										rs.getString("WORKEDU"),
//										rs.getDate("STARTDATE"),
//										rs.getString("INCRUITSTATUS"),
//										rs.getDate("ENDDATE"),
//										rs.getString("WORKFORM"),
//										rs.getInt("SALARY"),
//										rs.getString("PTITLE"),
//										rs.getString("REXPLAIN"),
//										rs.getInt("PEOPLECOUNT"),
//										rs.getString("DONGNAME"),
//										rs.getString("DISTRICTNAME"),
//										rs.getString("TYPENAME")
//					);
//				
//				list.add(incruit);
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
//	}
	
	// 디컴?
//	public ArrayList<Incruit> selectSuitableRecruitList(Connection conn, Filter filter) {
//		
//		ArrayList<Incruit> list = null;	
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = prop.getProperty("selectApplicationState");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			//pstmt.setInt(1, filter);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				list.add(new Incruit(
//									rs.getInt("APPLYNUM"),
//									rs.getInt("ENUM"),
//									rs.getInt("WNUM"),
//									rs.getString("WTITLE"),
//									rs.getString("OPNAME"),
//									rs.getDate("APPLYDATE"),
//									rs.getString("PASSORFAIL")
//									));
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
	
//	public Resume choiceResume(Connection conn, int rNum) {
//		
//		Resume resume = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = prop.getProperty("choiceResume");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, rNum);
//			
//			rs = pstmt.executeQuery();
//			
//			
//			resume = new Resume(
////									rs.getInt("APPLYNUM"),
////									rs.getInt("ENUM"),
////									rs.getInt("WNUM"),
////									rs.getString("WTITLE"),
////									rs.getString("OPNAME"),
////									rs.getDate("APPLYDATE"),
////									rs.getString("PASSORFAIL")
//									);
//		
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		
//		return resume;
//		
//	}

}
