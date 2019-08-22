package ownerService.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import ownerService.model.vo.IncruitProduct;

public class IncruitProductDao {
	
	private Properties prop = new Properties();
	
	public IncruitProductDao() {
		
		String fileName = IncruitProductDao.class.getResource("/sql/ownerService/ownerService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<IncruitProduct> selectIncruitProduct(Connection conn) {
		
		ArrayList<IncruitProduct> list = null;
		IncruitProduct prod = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectIncruitProduct");
		
		try {	
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				prod = new IncruitProduct(
									rs.getInt("PCODE"),
									rs.getString("PTITLE"),
									rs.getString("PEXPLAIN"),
									rs.getInt("PPAY")
									);
				list.add(prod);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return list;
	}

}
