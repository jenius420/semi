package empService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.vo.Emp;

import empService.model.dao.EmpServiceDao;
import owner.model.vo.Owner;
import ownerService.model.vo.Appliant;

public class EmpServiceService {

	/**
	 * 알바 지원 현황
	 * @param emp
	 * @return 세션유저가 지원한 알바 리스트
	 */
	public ArrayList<Appliant> selectApplicationState(int empNum) {

		Connection conn = getConnection();

		ArrayList<Appliant> list = new EmpServiceDao().selectApplicationState(conn, empNum);

		close(conn);

		return list;
	}
	
	public int cancleAppliant(String[] applyArr) {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		for(String s: applyArr) {
			
			result = new EmpServiceDao().cancleAppliant(conn, Integer.parseInt(s));
			
			if(result == 0) {
				break;
			}
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public ArrayList<Owner> selectInterestOwner(int empNum){
		
		Connection conn = getConnection();

		int[] listNum = new EmpServiceDao().selectInterestOwnerNum(conn, empNum);
		ArrayList<Owner> iList = new EmpServiceDao().selectInterestOwner(conn, listNum);
		
		

		close(conn);

		return iList;
		
	}

}
