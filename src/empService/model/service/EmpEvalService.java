package empService.model.service;

import empService.model.dao.EmpEvalDao;
import empService.model.dao.ResumeDao;
import empService.model.vo.EmpEvaluation;
import empService.model.vo.EmpEvaluationBefore;
import empService.model.vo.Resume;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class EmpEvalService {
	
	
	/**
	 * 작성된 구직자 평가
	 * @param empNum
	 * @return 세션유저가 작성했었던 알바 평가 리스트
	 */
	public ArrayList<EmpEvaluation> selectEmpEval(int empNum){
		
		Connection conn = getConnection();
		
		ArrayList<EmpEvaluation> list = new EmpEvalDao().selectEmpEval(conn, empNum);
		
		close(conn);
		
		return list;
		
	}
	
	/**
	 * 작성 가능한(미작성) 구직자 평가
	 * @param empNum
	 * @return 세션유저가 작성 가능한 평가 리스트
	 */
	public ArrayList<EmpEvaluationBefore> selectEmpEvalBefore(int empNum){
		
		Connection conn = getConnection();
		
		ArrayList<EmpEvaluationBefore> list = new EmpEvalDao().selectEmpEvalBefore(conn, empNum);
		
		close(conn);
		
		return list;
		
	}
	
	public int submitEmpEval(EmpEvaluation empEval) {
		
		Connection conn = getConnection();

		int result = new EmpEvalDao().submitEmpEval(conn, empEval);

		if (result > 0) {
			
			int result2 = new EmpEvalDao().appliantAddSevalNum(conn, empEval.getApplyNum());
			
			if(result2 > 0) {
				commit(conn);
			}

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	public int deleteEval(int sevalNum) {
		
		Connection conn = getConnection();

		int result = new EmpEvalDao().deleteEval(conn, sevalNum);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	public ArrayList<EmpEvaluation> selectEmpEvalList(int oNum) {
		
		Connection conn = getConnection();
		
		ArrayList<EmpEvaluation> list = new EmpEvalDao().selectEmpEvalList(conn, oNum);
		
		close(conn);
		
		return list;
		
		
	}

}
