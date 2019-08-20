package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class EmpMemberDao {
	
	private Properties prop = new Properties();

	public EmpMemberDao() {
		
		String fileName = EmpMemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Member LoginEmpMember(Connection conn, String eId, String ePwd) {
		
	
		
	}
	
	public int insertEmpMember(Connection conn, Member mem) {
		
		
	}
	
	public Member findId(Connection conn, String eName, int phone) {
		
	}
	
	public Member FindPwd(Connection conn, String eId, int phone) {
		
	}
	
	
	public Member updateEmpMember(Connection conn, String eId) {
		
		
	}
	
	public Member updateEmpPwd(Connection conn, String eId, String ePwd, String newPwd) {
		
		
	}
	
	public int deleteMember(Connection conn, String eId) {
		
	}
	
	
	
}
