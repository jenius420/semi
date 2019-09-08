package search.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import search.model.dao.SearchDao;
import search.model.vo.IncruitInfo;
import search.model.vo.OPhoto;


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

	public IncruitInfo detailView(int num) {
		Connection conn = getConnection();
		IncruitInfo i = new SearchDao().detailView(conn,num);
		close(conn);
		return i;
	}

	public OPhoto searchLogo(int num) {
		Connection conn = getConnection();
		OPhoto p =new SearchDao().searchLogo(conn,num);
		close(conn);
		return p;
	}

	public ArrayList<OPhoto> incruitPhotos(int num) {
		Connection conn = getConnection();
		ArrayList<OPhoto> list = new SearchDao().incruitPhotos(conn,num);
		close(conn);
		return list;
	}

	/**
	 * 
	 * @param oNum 기업번호
	 * @param eId 회원번호
	 * @return 업데이트 성공했는지 확인
	 */
	public int addHopeEnt(int oNum, int eId) {
		Connection conn = getConnection();
		int check = new SearchDao().checkHopeEnt(conn,oNum,eId);
		int result;
		if(check>0) {
			result = new SearchDao().updateHopeEnt(conn,oNum,eId);
		}else {
			result = new SearchDao().insertHopeEnt(conn,oNum,eId);
		}
		
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteHopeEnt(int oNum, int eNum) {
		Connection conn = getConnection();
		int result = new SearchDao().deleteHopeEnt(conn,oNum,eNum);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int checkHopeEnt(int oNum, int eNum) {
		Connection conn = getConnection();
		int check = new SearchDao().checkHopeEnt2(conn,oNum,eNum);
		close(conn);
		return check;
	}



	

	
	
}
