package ownerService.model.dao;
import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import empService.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Incruit;
import ownerService.model.vo.Owner;

public class OwnerServiceDao {
	
	private Properties prop = new Properties();
	
	public OwnerServiceDao() {
		
		String fileName = OwnerServiceDao.class.getResource("/sql/ownerService/ownerService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Owner selectOwner(Connection conn, int oNum) {
		
		Owner owner = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = prop.getProperty("selectOwner");
		
		try {
						
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, oNum);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					owner = new Owner();
					
					owner.setoNum(rs.getInt("ONUM"));
					owner.setoId(rs.getString("OID"));
					owner.setoPwd(rs.getString("OPWD"));
					owner.setOpName(rs.getString("OPNAME"));
					owner.setOpNum(rs.getString("OPNUM"));
					owner.setRoadNum(rs.getInt("ROADNUM"));
					owner.setOpAddress(rs.getString("OPADDRESS"));
					owner.setoName(rs.getString("ONAME"));
					owner.setoTel(rs.getString("OTEL"));
					owner.setOcNum(rs.getString("OCNUM"));
					owner.setPhone(rs.getString("PHONE"));
					owner.setEmail(rs.getString("EMAIL"));
					owner.setTypeNum(rs.getInt("TYPENUM"));
					owner.setType(rs.getString("TYPENAME"));
					owner.setCategory(rs.getString("CATEGORYNAME"));
					owner.setMailAccept(rs.getString("MAILACCEPT"));
					owner.setSmsAccept(rs.getString("SMSACCEPT"));
					owner.setInvalidId(rs.getString("INVALIDID"));
					owner.setCheckONum(rs.getString("CHECKONUM"));

				}
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return owner;
		
	}
	
	public Owner addRoad(Connection conn, Owner owner) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("addRoad");
		
		try {
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, owner.getoNum());

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				owner.setRoadName(rs.getString("RoadName"));
				owner.setRoadMain(rs.getInt("RoadMAIN"));
				owner.setRoadSub(rs.getInt("RoadSUB"));
				owner.setDistrict(rs.getString("districtname"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return owner;
		
	}
	
	public Resume selectResume(Connection conn, int rNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Resume resume = null;
		
		String sql = prop.getProperty("selectResume");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resume = new Resume(
									rs.getInt("RNUM"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getString("EADDRESS"),
									rs.getString("PHONE"),
									rs.getString("EMAIL"),
									rs.getInt("DISTRICTNum"),
									rs.getString("DISTRICTNAME"),
									rs.getInt("TYPENUM"),
									rs.getString("TYPENAME"),
									rs.getString("CATEGORYNAME"),
									rs.getString("ECOMMENT"),
									rs.getDate("UPDATEDATE"),
									rs.getString("INVALIDRESUME"),
									rs.getString("DESIREFORM"),
									rs.getInt("DESIREINCOME"),
									rs.getString("OPENSET"),
									rs.getString("FINALEDUNUM"),
									rs.getString("ECNUM"),
									rs.getInt("ROADNUM")
				);
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return resume;
	}

}
