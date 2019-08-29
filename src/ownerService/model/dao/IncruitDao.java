package ownerService.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import ownerService.model.vo.Filter;
import empService.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;


public class IncruitDao {
	
	private Properties prop = new Properties();
	
	public IncruitDao() {
		
		String fileName = IncruitDao.class.getResource("/sql/ownerService/ownerService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int enrollIncruit(Connection conn, Incruit incruit) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("enrollIncruit");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, incruit.getwTitle());
			pstmt.setInt(2, incruit.getoNum());
			pstmt.setDate(3, incruit.getWorkStartTerm());
			pstmt.setDate(4, incruit.getWorkEndTerm());
			pstmt.setString(5, incruit.getWorkDay());
			pstmt.setString(6, incruit.getWorkStartTime());
			pstmt.setString(7, incruit.getWorkEndTime());
			pstmt.setInt(8, incruit.getTermNo());
			pstmt.setString(9, incruit.getGender());
			pstmt.setInt(10, incruit.getAge());
			pstmt.setString(11, incruit.getEdu());
			pstmt.setDate(12, incruit.getEnrollDate());
			pstmt.setString(13, incruit.getStatus());
			pstmt.setDate(14, incruit.getDoneDate());
			pstmt.setString(15, incruit.getSalaryForm());
			pstmt.setInt(16, incruit.getSalary());
			pstmt.setInt(17, incruit.getpNum());
			pstmt.setString(18, incruit.getDescription());
			pstmt.setInt(19, incruit.getPeopleCount());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public Incruit selectIncruit(Connection conn, int wNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Incruit incruit = null;
		
		String sql = prop.getProperty("selectIncruit");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
										rs.getString("PTITLE"),
										rs.getString("REXPLAIN"),
										rs.getInt("PEOPLECOUNT"),
										rs.getString("DONGNAME"),
										rs.getString("DISTRICTNAME"),
										rs.getString("TYPENAME")
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
	
	public int updateIncruit(Connection conn, Incruit incruit) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateIncruit");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, incruit.getwTitle());
			pstmt.setDate(2, incruit.getWorkStartTerm());
			pstmt.setDate(3, incruit.getWorkEndTerm());
			pstmt.setString(4, incruit.getWorkDay());
			pstmt.setString(5, incruit.getWorkStartTime());
			pstmt.setString(6, incruit.getWorkEndTime());
			pstmt.setInt(7, incruit.getTermNo());
			pstmt.setString(8, incruit.getGender());
			pstmt.setInt(9, incruit.getAge());
			pstmt.setString(10, incruit.getEdu());
			pstmt.setString(11, incruit.getSalaryForm());
			pstmt.setInt(12, incruit.getSalary());
			pstmt.setInt(13, incruit.getpNum());
			pstmt.setString(14, incruit.getDescription());
			pstmt.setInt(15, incruit.getPeopleCount());
			
			pstmt.setInt(16, incruit.getwNum());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
	
	public int closeIncruit(Connection conn, int wNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("closeIncruit");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public ArrayList<Incruit> selectIncruitList(Connection conn, int oNum) {
		
		ArrayList<Incruit> list = new ArrayList<>();
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
										rs.getString("PTITLE"),
										rs.getString("REXPLAIN"),
										rs.getInt("PEOPLECOUNT"),
										rs.getString("DONGNAME"),
										rs.getString("DISTRICTNAME"),
										rs.getString("TYPENAME")
									);
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
	
	public ArrayList<Appliant> selectManageEmp(Connection conn, int oNum){
		
		ArrayList<Appliant> list = new ArrayList<>();
		Appliant appliant = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectManageEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				appliant = new Appliant(
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
	
	public int deleteIncruit(Connection conn, int incruitNum) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteIncruit");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, incruitNum);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int empPassYn(Connection conn, int applyNum, String passOrFail) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("empPassYn");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applyNum);
			pstmt.setString(2, passOrFail);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
	
	public ArrayList<Resume> selectSearchResumeList(Connection conn, String keyword, Filter filter) {
		
		ArrayList<Resume> list = new ArrayList<>();
		Resume resume = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectSearchResumeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, '%'+keyword+'%');
			pstmt.setString(2, filter.getDistrict());
			pstmt.setString(3, filter.getType());
			pstmt.setString(4, filter.getDesireForm());
			pstmt.setInt(5, filter.getDesireIncome());
			pstmt.setString(6, filter.getFinalEdu());

			
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
									rs.getString("COMMENT"),
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
	
	public Resume selectResume(Connection conn, int rNum) {
		
		Resume resume = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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
									rs.getString("COMMENT"),
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
	
	public int checkResume(Connection conn, int rNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("checkResume");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}

}
