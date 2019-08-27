package main.model.service;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import main.model.dao.MainDao;
import main.model.vo.Main;

public class MainService {

	
	/**
	 *  id�� �ּҸ� ������� �� ��õ ����Ʈ
	 * @param id
	 * @return
	 */
	public ArrayList<Main> selectRecomendList(String id){
		Connection conn = getConnection(); 
		
		int dong = new MainDao().getAddress(conn,id);
		
		ArrayList<Main> list = new MainDao().selectRecomendList(conn, dong);
		
		close(conn);
		return list;
		
	}
	
	
	/**
	 * primium ������� ������ ��µ�
	 * @return
	 */
	public ArrayList<Main> selectPrimiumList(){
		Connection conn = getConnection();
		
		ArrayList<Main> list = new MainDao().selectPrimiumList(conn);
		
		close(conn);
		return list;
	}
}