package photo.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import photo.model.vo.Photo;
import sort.model.dao.RecruitDao;

public class RecommendDao {
	
	private Properties prop = new Properties();
	
	public RecommendDao() {
		String fileName = RecruitDao.class.getResource("/sql/photo/photo-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public ArrayList<Photo> selectRecommend(Connection conn, int eNum){
		ArrayList<Photo> list = new ArrayList<>();
		
		/*Statement stmt = null;*/
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRecommend");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eNum);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				list.add(new Photo(rset.getInt(1),
									rset.getString(2),
									rset.getString(3),
									rset.getInt(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
}
