package adminService.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageMemDao;
import emp.model.vo.Emp;

import static common.JDBCTemplate.*;
import owner.model.vo.Owner;

public class ManageMemService {
	
	public ArrayList<Emp> selectEmpList() {
		
		Connection conn = getConnection();

		ArrayList<Emp> list = new ManageMemDao().selectEmpList(conn);

		close(conn);

		return list;
		
	}
	
	public ArrayList<Owner> selectOwnerList() {
		
		Connection conn = getConnection();

		ArrayList<Owner> list = new ManageMemDao().selectOwnerList(conn);

		close(conn);

		return list;
		
	}
	
	public int warnEmp(String[] memArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<memArr.length; i++) {
			
			result = new ManageMemDao().warnEmp(conn, Integer.parseInt(memArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}
	
	public int warnOwner(String[] memArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<memArr.length; i++) {
			
			result = new ManageMemDao().warnOwner(conn, Integer.parseInt(memArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}
	
	public int deleteEmp(String[] memArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<memArr.length; i++) {
			
			result = new ManageMemDao().deleteEmp(conn, Integer.parseInt(memArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}
	
	public int deleteOwner(String[] memArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<memArr.length; i++) {
			
			result = new ManageMemDao().deleteOwner(conn, Integer.parseInt(memArr[i]));
	
			if (result > 0) {
				commit(conn);
				count++;
	
			} else {
				rollback(conn);
			}
		}

		close(conn);

		return count;
		
	}
	
	


}
