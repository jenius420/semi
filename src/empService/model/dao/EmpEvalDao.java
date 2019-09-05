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

import empService.model.vo.EmpEvaluation;
import empService.model.vo.EmpEvaluationBefore;

public class EmpEvalDao {
	
	private Properties prop = new Properties();
	
	public EmpEvalDao() {
		
		String fileName = EmpEvalDao.class.getResource("/sql/empService/empService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<EmpEvaluation> selectEmpEval(Connection conn, int empNum) {
		
		ArrayList<EmpEvaluation> list = new ArrayList<>();	
		EmpEvaluation eval = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectEmpEval");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				eval = new EmpEvaluation();
				
				eval.setSevalNum(rs.getInt("SEVALNUM"));
				eval.seteNum(rs.getInt("ENUM"));
				eval.setoNum(rs.getInt("ONUM"));
				eval.setOpName(rs.getString("OPNAME"));
				eval.setSevalPoint(rs.getInt("SEVALPOINT"));
				eval.seteComment(rs.getString("ECOMMENT"));
				eval.setEnrollDate(rs.getDate("ENROLLDATE"));
				
				list.add(eval);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<EmpEvaluationBefore> selectEmpEvalBefore(Connection conn, int empNum) {
		
		ArrayList<EmpEvaluationBefore> list = new ArrayList<>();	
		EmpEvaluationBefore eval = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectEmpEvalBefore");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNum);
			
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					
					eval = new EmpEvaluationBefore();
				
					eval.setApplyNum(rs.getInt("APPLYNUM"));
					eval.seteNum(rs.getInt("ENUM"));
					eval.setrNum(rs.getInt("RNUM"));
					eval.setoNum(rs.getInt("ONUM"));
					eval.setwNum(rs.getInt("WNUM"));
					eval.setwTitle(rs.getString("WTITLE"));
					eval.setOpName(rs.getString("OPNAME"));
					
					list.add(eval);
		
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int submitEmpEval(Connection conn, EmpEvaluation empEval) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("submitEmpEval");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empEval.geteNum());
			pstmt.setInt(2, empEval.getoNum());
			pstmt.setInt(3, empEval.getSevalPoint());
			pstmt.setString(4, empEval.geteComment());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int appliantAddSevalNum(Connection conn, int applyNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("appliantAddSevalNum");

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
	
	public int deleteEval(Connection conn, int sevalNum) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteEval");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sevalNum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public ArrayList<EmpEvaluation> selectEmpEvalList(Connection conn, int oNum) {
		
		ArrayList<EmpEvaluation> list = new ArrayList<>();	
		EmpEvaluation eval = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectEmpEvalList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					
					eval = new EmpEvaluation();
				
					eval.setSevalNum(rs.getInt("SEVALNUM"));
					eval.seteNum(rs.getInt("ENUM"));
					eval.setoNum(rs.getInt("ONUM"));
					eval.setOpName(rs.getString("OPNAME"));
					eval.setSevalPoint(rs.getInt("SEVALPOINT"));
					eval.seteComment(rs.getString("ECOMMENT"));
					eval.setEnrollDate(rs.getDate("ENROLLDATE"));
					
					list.add(eval);
		
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
