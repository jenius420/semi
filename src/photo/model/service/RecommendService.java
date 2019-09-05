package photo.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import photo.model.dao.RecommendDao;
import photo.model.vo.Photo;

public class RecommendService {
	/**
	 *  플래티넘 상품 조회용 서비스
	 * @return
	 */
	public ArrayList<Photo> selectRecommend(int eNum){
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new RecommendDao().selectRecommend(conn, eNum);
		
		close(conn);
		
		return list;
	}
}
