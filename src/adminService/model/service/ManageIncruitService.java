package adminService.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import adminService.model.dao.ManageIncruitDao;
import adminService.model.dao.ManageMemDao;
import owner.model.vo.Owner;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.IncruitProduct;

public class ManageIncruitService {
	
	public ArrayList<Incruit> selectIngIncruitList() {
		
		Connection conn = getConnection();

		ArrayList<Incruit> list = new ManageIncruitDao().selectIngIncruitList(conn);

		close(conn);

		return list;
		
	}
	
	public ArrayList<Incruit> selectDoneIncruitList() {
		
		Connection conn = getConnection();

		ArrayList<Incruit> list = new ManageIncruitDao().selectDoneIncruitList(conn);

		close(conn);

		return list;
		
	}
	
	public ArrayList<IncruitProduct> selectProductList() {
		
		Connection conn = getConnection();

		ArrayList<IncruitProduct> list = new ManageIncruitDao().selectProductList(conn);

		close(conn);

		return list;
		
	}
	
	public Incruit watchingIncruit(int wNum) {
		
		Connection conn = getConnection();

		Incruit incruit = new ManageIncruitDao().watchingIncruit(conn, wNum);

		close(conn);

		return incruit;
		
	}
	
	public int InsertProduct(IncruitProduct prod) {
		
		Connection conn = getConnection();
		
		int result = new ManageIncruitDao().InsertProduct(conn, prod);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
	
	public IncruitProduct selectProduct(int pCode) {
		
		Connection conn = getConnection();

		IncruitProduct prod = new ManageIncruitDao().selectProduct(conn, pCode);

		close(conn);

		return prod;
	}
	
	public int updateProduct(IncruitProduct prod) {
		
		Connection conn = getConnection();
		
		int result = new ManageIncruitDao().updateProduct(conn, prod);

		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}
