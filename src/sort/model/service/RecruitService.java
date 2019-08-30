package sort.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import sort.model.dao.RecruitDao;
import sort.model.vo.Recruit;

public class RecruitService {

	/**
	 * 1. 등록일순 조회 서비스
	 * @return
	 */
	public ArrayList<Recruit> selectRecently() {
		Connection conn = getConnection();
		
		ArrayList<Recruit> list = new RecruitDao().selectRecently(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 2. 시급순 조회 서비스
	 * @param workform
	 * @return
	 */
	public ArrayList<Recruit> selectHourly(String workform){
		Connection conn = getConnection();
		
		ArrayList<Recruit> list = new RecruitDao().selectHourly(conn, workform);
		
		close(conn);
		
		return list;
		
	}
}
