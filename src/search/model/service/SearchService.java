package search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import search.model.dao.SearchDao;
import search.model.vo.IncruitInfo;

import static common.JDBCTemplate.*;


public class SearchService {
	
	public int getCateListCount(String[] cates) {
		Connection conn = getConnection();
		int result = new SearchDao().getCateListCount(conn,cates);
		close(conn);
		return result;
	}

	public ArrayList<IncruitInfo> categorySearch(String[] cates, int startPage, int endPage) {
		Connection conn =getConnection();
		ArrayList<IncruitInfo> list = new SearchDao().getCateListCount(conn, cates,startPage, endPage);
		close(conn);
		
		return list;
	}

	public ArrayList<IncruitInfo> allList(int start, int end) {
		Connection conn = getConnection();
		ArrayList<IncruitInfo> list = new SearchDao().getAllList(conn,start,end);
		close(conn);
		return list;
	}

	public int listCount() {
		Connection conn = getConnection();
		int result = new SearchDao().listCount(conn);
		close(conn);
		return result;
	}

	public int getDistrictListCount(String[] district) {
		Connection conn = getConnection();
		int result = new SearchDao().districtListCount(conn,district);
		close(conn);
		return result;
	}

	public ArrayList<IncruitInfo> districtSearch(String[] district, int start, int end) {
		Connection conn = getConnection();
		ArrayList<IncruitInfo> list = new SearchDao().districtSearch(conn,district,start,end);
		close(conn);
		return list;
	}

	public ArrayList<IncruitInfo> searchDetail(String[] details, int start, int end) {
		Connection conn = getConnection();
		ArrayList<IncruitInfo> list = new SearchDao().searchDetail(conn,details,start,end);
		close(conn);
		
		return list;
	}

	public int detailListCount(String[] details) {
		Connection conn = getConnection();
		int result = new SearchDao().detailListCount(conn,details);
		close(conn);
		
		return result;
	}



	

	
	
}
