package common.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.model.vo.District;
import common.model.vo.JobType;
import empService.model.dao.EmpEvalDao;
import empService.model.vo.EmpEvaluation;

public class CommonDao {
	
private Properties prop = new Properties();
	
	public CommonDao() {
		
		String fileName = CommonDao.class.getResource("/sql/common/common_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<District> selectDistrictList(Connection conn) {
		
		ArrayList<District> list = new ArrayList<>();	
		District d = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectDistrictList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				d = new District();
				
				d.setDistrictNum(rs.getInt("DistrictNum"));
				d.setDistrictName(rs.getString("DistrictName"));
			
				list.add(d);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return list;
		
	}
	
	public ArrayList<JobType> selectTypeList(Connection conn) {
		
		ArrayList<JobType> list = new ArrayList<>();	
		JobType j = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectTypeList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				j = new JobType();
				
				j.setTypeNum(rs.getInt("TypeNum"));
				j.setTypeName(rs.getString("TypeName"));
				j.setCategoryName(rs.getString("CategoryName"));
			
				list.add(j);
				
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
