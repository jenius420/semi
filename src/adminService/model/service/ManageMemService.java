package adminService.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageMemDao;
import empService.model.vo.Emp;

import static common.JDBCTemplate.*;
import ownerService.model.vo.Owner;

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
	
	public int deleteEmp(int eNum) {
		
		Connection conn = getConnection();
			
		int result = new ManageMemDao().deleteEmp(conn, eNum);
	
		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
		
	}
	
	public int restoreEmp(int eNum) {
		
		Connection conn = getConnection();
		
		int result = new ManageMemDao().restoreEmp(conn, eNum);
	
		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}
	
	public int deleteOwner(int oNum) {
		
		Connection conn = getConnection();
		
		int result = new ManageMemDao().deleteOwner(conn, oNum);
	
		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
		
	}
	
	public int restoreOwner(int oNum) {
		
		Connection conn = getConnection();
		
		int result = new ManageMemDao().restoreOwner(conn, oNum);
	
		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
		
	}
	
	public int certifyOwner(String oNumArr) {
		
		Connection conn = getConnection();
		
		int count = 0;
		int result = 0;
		
		String[] list = oNumArr.split(",");
		
		for(int i=0; i<list.length; i++) {
			
			if(!list[i].equals("") && list[i]!= null) {
				result = new ManageMemDao().certifyOwner(conn, Integer.parseInt(list[i]));

				if (result > 0) {
					commit(conn);
					count++;
		
				} else {
					rollback(conn);
				}
			}
		}

		close(conn);

		return count;
	}
	
	


}
