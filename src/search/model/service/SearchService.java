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

	
	
}
