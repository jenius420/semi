package empService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


import empService.model.dao.EmpServiceDao;
import empService.model.vo.*;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;

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
	
	public int cancleAppliant(int applyNum) {
		
		Connection conn = getConnection();
		
		int result = 0;
	
		result = new EmpServiceDao().cancleAppliant(conn, applyNum);
			
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public int addHopeEnt(int eNum, int oNum) {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		result = new EmpServiceDao().addHopeEnt(conn, eNum, oNum);
			
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public ArrayList<HopeEnt> selectInterestOwner(int empNum){
		
		Connection conn = getConnection();

		ArrayList<HopeEnt> iList = new EmpServiceDao().selectInterestOwner(conn, empNum);
		ArrayList<HopeEnt> hList = new EmpServiceDao().addDong(conn, iList);
		
		close(conn);

		return hList;
		
	}
	
	public int deleteInterestOwner(int hNum) {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		result = new EmpServiceDao().deleteInterestOwner(conn, hNum);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public ArrayList<Incruit> selectInterestIncruit(ArrayList<HopeEnt> hList) {
		
		Connection conn = getConnection();

		ArrayList<Incruit> iList = new EmpServiceDao().selectInterestIncruit(conn, hList);
		ArrayList<Incruit> iList2 = new EmpServiceDao().addDong2(conn, iList);
		
		close(conn);

		return iList2;
	}
	
	public int apply(int wNum, int rNum) {
		
		Connection conn = getConnection();
		
		int check = 0;
		int result = 0;
		
		check = new EmpServiceDao().applyDuplicationCheck(conn, wNum, rNum);
		
		if(check == 0) {
			result = new EmpServiceDao().apply(conn, wNum, rNum);
	
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}else {
			result = -1;
		}
		
		return result;
		
	}
	
	public Emp selectEmp(int eNum) {
		
		Connection conn = getConnection();
		
		Emp emp = new EmpServiceDao().selectEmp(conn, eNum);
		
		close(conn);

		return emp;
		
	}
	
	

}
