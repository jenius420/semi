package ownerService.model.service;

import ownerService.model.dao.IncruitDao;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Filter;
import ownerService.model.vo.Incruit;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import emp.model.vo.Emp;
import empService.model.vo.Resume;


public class IncruitService {
	
	public int enrollIncruit(Incruit incruit) {
		
		Connection conn = getConnection();

		int result = new IncruitDao().enrollIncruit(conn, incruit);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}
	
	public int closeIncruit(int wNum) {
		
		Connection conn = getConnection();

		int result = new IncruitDao().closeIncruit(conn, wNum);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	
	public ArrayList<Incruit> selectIncruitList(int oNum) {
		
		Connection conn = getConnection();

		ArrayList<Incruit> list = new IncruitDao().selectIncruitList(conn, oNum);

		close(conn);

		return list;
		
	}
	
	public ArrayList<Appliant> selectManageEmp(int oNum){
		
		Connection conn = getConnection();

		ArrayList<Appliant> list = new IncruitDao().selectManageEmp(conn, oNum);

		close(conn);

		return list;
		
	}
	
	public int deleteIncruit(int incruitNum) {
		
		Connection conn = getConnection();

		int result = new IncruitDao().deleteIncruit(conn, incruitNum);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}
	
	public int empPassYn(int applyNum, String passOrFail) {
		
		Connection conn = getConnection();

		int result = new IncruitDao().empPassYn(conn, applyNum, passOrFail);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}
	
	public ArrayList<Resume> selectSearchResumeList(String keyword, Filter filter) {
		
		Connection conn = getConnection();

		ArrayList<Resume> list = new IncruitDao().selectSearchResumeList(conn, keyword, filter);

		close(conn);

		return list;
		
	}
	
	public Resume selectResume(int rNum) {
		
		Connection conn = getConnection();
		
		Resume resume = new IncruitDao().selectResume(conn, rNum);
		checkResume(rNum);
		
		close(conn);

		return resume;
		
	}
	
	public int checkResume(int rNum) {
		
		Connection conn = getConnection();
		
		int result = new IncruitDao().checkResume(conn, rNum);
		
		close(conn);

		return result;
		
	}


}
