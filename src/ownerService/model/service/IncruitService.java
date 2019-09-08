package ownerService.model.service;

import ownerService.model.dao.IncruitDao;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Filter;
import ownerService.model.vo.Incruit;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import empService.model.vo.Emp;
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
	
	public Incruit selectIncruit(int wNum) {
		
		Connection conn = getConnection();

		Incruit incruit = new IncruitDao().selectIncruit(conn, wNum);

		close(conn);

		return incruit;
		
	}
	
	public int updateIncruit(Incruit incruit) {
		
		Connection conn = getConnection();

		int result = new IncruitDao().updateIncruit(conn, incruit);

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
		
		ArrayList<Resume> rlist = new ArrayList<>();
		
		for(Resume r : list) {
			
			if(filter.getAgeType().equals("무관") || filter.getAgeType() == null || filter.getAgeType().equals("")) {		
				rlist.add(r);
			}else {
			
				int agetype = Integer.parseInt(filter.getAgeType().substring(0, 2)); 
				
				if(r.getAge() >= agetype && r.getAge() < agetype+10) {
					rlist.add(r);
				}
			
			}
			
		}
		
		ArrayList<Resume> rlist2 = new ArrayList<>();
		
		for(Resume r : rlist) {
			
			if(filter.getGender().equals("무관") || filter.getGender() == null || filter.getGender().equals("")) {		
				rlist2.add(r);
			}else if(r.getGender().equals(filter.getGender())){
				rlist2.add(r);
			}else {
				break;
			}
			
		}
		
		close(conn);

		return rlist2;
		
	}
	
	public Resume selectResume(int rNum) {
		
		Connection conn = getConnection();
		
		Resume resume = new IncruitDao().selectResume(conn, rNum);
		Resume resume2 = new IncruitDao().addRoad3(conn, resume);

		close(conn);

		return resume;
		
	}
	
	public int checkResume(int rNum) {
		
		Connection conn = getConnection();
		
		int result = new IncruitDao().checkResume(conn, rNum);
		
		close(conn);

		return result;
		
	}
	
	public int reCheckResume(int rNum) {
		
		Connection conn = getConnection();
		
		int result = new IncruitDao().reCheckResume(conn, rNum);
		
		close(conn);

		return result;
		
	}
	
	public Appliant selectAppliant(int rNum) {
		
		Connection conn = getConnection();
		
		Appliant ap = new IncruitDao().selectAppliant(conn, rNum);
		
		close(conn);

		return ap;
		
	}


}
