package empService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.vo.Attachment;
import empService.model.dao.EmpServiceDao;
import empService.model.dao.ResumeDao;
import empService.model.vo.*;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;

public class EmpServiceService {

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
		int check  = new EmpServiceDao().checkAddHopeEnt(conn, eNum, oNum); // 이미 관심기업으로 등록 돼있는지 검사
		
		if(check == 0 ) { // 등록 데이터가 없다면 추가
			result = new EmpServiceDao().addHopeEnt(conn, eNum, oNum);
		}
		
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
		ArrayList<HopeEnt> hList = new EmpServiceDao().addRoad(conn, iList);
		
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
		ArrayList<Incruit> iList2 = new EmpServiceDao().addRoad2(conn, iList);
		
		close(conn);

		return iList2;
	}
	
	public int apply(int eNum, int wNum, int rNum) {
		
		Connection conn = getConnection();
		
		int check = 0;
		int result = 0;
		
		check = new EmpServiceDao().applyDuplicationCheck(conn, eNum, wNum);
		
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
	
	public Attachment selectAttachment(int oNum) {
		
		Connection conn = getConnection();
		
		Attachment at = new EmpServiceDao().selectAttachment(conn, oNum);
		
		close(conn);
		
		return at;
	}
	
	

}
