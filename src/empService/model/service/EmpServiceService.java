package empService.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

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
	
	public ArrayList<Owner> selectInterestOwner(int empNum){
		
		Connection conn = getConnection();

		int[] listNum = new EmpServiceDao().selectInterestOwnerNum(conn, empNum);
		ArrayList<Owner> iList = new EmpServiceDao().selectInterestOwner(conn, listNum);
		
		

		close(conn);

		return iList;
		
	}

}
