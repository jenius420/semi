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

import empService.model.vo.ApplicationState;
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
			
//			pstmt.setString(1, resume.getResumeTitle());
//			pstmt.setInt(2, resume.getEmpNum());
//			pstmt.setString(3, resume.getDistrict());
//			pstmt.setString(4, resume.getType());
//			pstmt.setString(5, resume.getComment());
//			pstmt.setString(6, resume.사진경로);
//			pstmt.setString(7, resume.getDesireForm());
//			pstmt.setInt(8, resume.getDesireIncome());
//			pstmt.setString(9, resume.getOpenSet());
//			pstmt.setString(10, resume.getEdu());
//			

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public ArrayList<Resume> selectResumeList(Connection conn, int empNum){
		
		ArrayList<Resume> list = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectResumeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Resume(
									rs.getInt(""),
									rs.getInt("ENUM"),
									rs.getInt("WNUM"),
									rs.getString("WTITLE"),
									rs.getString("OPNAME"),
									rs.getDate("APPLYDATE"),
									rs.getString("PASSORFAIL")
									rs.getString("PASSORFAIL")
									rs.getString("PASSORFAIL")
									rs.getString("PASSORFAIL")
									rs.getString("PASSORFAIL")
									rs.getString("PASSORFAIL")
									
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
	
	public ArrayList<Incruit> selectSuitableRecruitList(Connection conn, Filter filter) {
		
		ArrayList<Incruit> list = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectApplicationState");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filter);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Incruit(
									rs.getInt("APPLYNUM"),
									rs.getInt("ENUM"),
									rs.getInt("WNUM"),
									rs.getString("WTITLE"),
									rs.getString("OPNAME"),
									rs.getDate("APPLYDATE"),
									rs.getString("PASSORFAIL")
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
	
	public Resume choiceResume(Connection conn, int rNum) {
		
		Resume resume = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("choiceResume");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			
			rs = pstmt.executeQuery();
			
			
			resume = new Resume(
//									rs.getInt("APPLYNUM"),
//									rs.getInt("ENUM"),
//									rs.getInt("WNUM"),
//									rs.getString("WTITLE"),
//									rs.getString("OPNAME"),
//									rs.getDate("APPLYDATE"),
//									rs.getString("PASSORFAIL")
									);
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resume;
		
	}
	
	public ArrayList<Incruit> selectSuitableIncruit(Connection conn, Resume resume) {
		
		ArrayList<Incruit> list = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectSuitableIncruit");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, resume.getDistrict());
//			pstmt.setInt(2, resume.getDistrict());
//			pstmt.setInt(3, resume.getDistrict());
//			pstmt.setInt(4, resume.getDistrict());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Incruit(
//									rs.getInt("APPLYNUM"),
//									rs.getInt("ENUM"),
//									rs.getInt("WNUM"),
//									rs.getString("WTITLE"),
//									rs.getString("OPNAME"),
//									rs.getDate("APPLYDATE"),
//									rs.getString("PASSORFAIL")
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

}
