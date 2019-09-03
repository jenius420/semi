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
			pstmt.setString(3, incruit.getWorkDay());
			pstmt.setString(4, incruit.getWorkTime());
			pstmt.setInt(5, incruit.getTermNo());
			pstmt.setString(6, incruit.getGender());
			pstmt.setString(7, incruit.getAge());
			pstmt.setString(8, incruit.getEdu());
			pstmt.setDate(9, incruit.getDoneDate());
			pstmt.setString(10, incruit.getSalaryForm());
			pstmt.setInt(11, incruit.getSalary());
			pstmt.setInt(12, incruit.getpNum());
			pstmt.setString(13, incruit.getDescription());
			pstmt.setString(14, incruit.getPeopleCount());
			
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
	
	public int updateIncruit(Connection conn, Incruit incruit) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateIncruit");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, incruit.getwTitle());
			pstmt.setString(2, incruit.getWorkDay());
			pstmt.setString(3, incruit.getWorkTime());
			pstmt.setInt(4, incruit.getTermNo());
			pstmt.setString(5, incruit.getGender());
			pstmt.setString(6, incruit.getAge());
			pstmt.setString(7, incruit.getEdu());
			pstmt.setDate(8, incruit.getDoneDate());
			pstmt.setString(9, incruit.getSalaryForm());
			pstmt.setInt(10, incruit.getSalary());
			pstmt.setInt(11, incruit.getpNum());
			pstmt.setString(12, incruit.getDescription());
			pstmt.setString(13, incruit.getPeopleCount());
			
			pstmt.setInt(14, incruit.getwNum());
			
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
									rs.getString("CATEGORYNAME"),
									rs.getString("eCOMMENT"),
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
									rs.getString("CATEGORYNAME"),
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
