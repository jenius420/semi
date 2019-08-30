package ownerService.model.dao;
import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import empService.model.vo.Emp;
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
					owner.setOpNum(rs.getInt("OPNUM"));
					owner.setDongNum(rs.getInt("DONGNUM"));
					owner.setDongName(rs.getString("DONGNAME"));
					owner.setDongMain(rs.getInt("DONGMAIN"));
					owner.setDongSub(rs.getInt("DONGSUB"));
					owner.setRoadNum(rs.getInt("ROADNUM"));
					owner.setRoadName(rs.getString("ROADNAME"));
					owner.setRoadMain(rs.getInt("ROADMAIN"));
					owner.setRoadSub(rs.getInt("ROADSUB"));
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

}
