package photo.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import photo.model.dao.PlatinumDao;
import photo.model.vo.Photo;

public class PlatinumService {

	/**
	 *  플래티넘 상품 조회용 서비스
	 * @return
	 */
	public ArrayList<Photo> selectPlatinum(){
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new PlatinumDao().selectPlatinum(conn);
		
		close(conn);
		
		return list;
	}
}
