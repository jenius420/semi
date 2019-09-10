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

	public ArrayList<EmpEvaluation> selectEmpEval(int empNum){
		
		Connection conn = getConnection();
		
		ArrayList<EmpEvaluation> list = new EmpEvalDao().selectEmpEval(conn, empNum);
		
		close(conn);
		
		return list;
		
	}
	
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
