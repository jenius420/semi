package photo.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import photo.model.vo.Photo;
import sort.model.dao.RecruitDao;
import sort.model.vo.Recruit;

public class PlatinumDao {
	
	private Properties prop = new Properties();
	
	public PlatinumDao() {
		String fileName = RecruitDao.class.getResource("/sql/photo/photo-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public ArrayList<Photo> selectPlatinum(Connection conn){
		ArrayList<Photo> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPlatinum");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Photo(rset.getInt(1),
									rset.getString(2),
									rset.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
}
