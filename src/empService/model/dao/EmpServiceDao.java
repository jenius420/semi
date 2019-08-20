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
import empService.model.vo.Resume;
import owner.model.vo.Owner;
import ownerService.model.vo.Appliant;

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
		
		ArrayList<Appliant> list = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectApplicationState");
		// 지원일 순으로 정렬. 지원취소한거는 포함 안 됨
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list.add(new Appliant(
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
	
	public int[] selectInterestOwnerNum(Connection conn, int empNum){
		
		int[] list = new int[5];	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectInterestOwnerNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				list[0] = rs.getInt("ONUM1");
				list[1] = rs.getInt("ONUM2");
				list[2] = rs.getInt("ONUM3");
				list[3] = rs.getInt("ONUM4");
				list[4] = rs.getInt("ONUM5");

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Owner> selectInterestOwner(Connection conn, int[] listNum){
		
		ArrayList<Owner> list = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectInterestOwner");
		
		try {
			
			for(int i=0; i<listNum.length; i++) {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, listNum[i]);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					// 필요한 기업정보 가져오기
//					list.add(new InterestOwner( 
//										rs.getInt("APPLYNUM"),
//										rs.getInt("ENUM"),
//										rs.getInt("WNUM"),
//										rs.getString("WTITLE"),
//										rs.getString("OPNAME"),
//										rs.getDate("APPLYDATE"),
//										rs.getString("PASSORFAIL")
//										));
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
	

}
