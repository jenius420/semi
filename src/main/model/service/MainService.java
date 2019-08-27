package main.model.service;


import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import main.model.dao.MainDao;
import main.model.vo.Main;

public class MainService {

	
	/**
	 *  id의 주소를 기반으로 한 추천 리스트
	 * @param id
	 * @return
	 */
	public ArrayList<Main> selectRecomendList(String id){
		Connection conn = getConnection(); 
		
		ArrayList<Main> list = new MainDao().selectRecomendList(conn, id);
		
		close(conn);
		return list;
		
	}
	
	
	/**
	 * primium 사업장의 정보가 출력됨
	 * @return
	 */
	public ArrayList<Main> selectPrimiumList(){
		Connection conn = getConnection();
		
		ArrayList<Main> list = new MainDao().selectPrimiumList(conn);
		
		close(conn);
		return list;
	}
}
