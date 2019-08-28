package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	
	
	/**
	 * 1. �α���
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginMember(String id, String pwd) {

		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, id, pwd);
		
		close(conn);
		
		return loginUser;
	}

	/**
	 * ���� �α���
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginEmp(String id, String pwd) {
		
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginEmp(conn, id, pwd);
		
		close(conn);
		
		return loginUser;
	}

	
	/**
	 * ���� �α���
	 * @param id
	 * @param pwd
	 * @return
	 */
	public Member loginOwn(String id, String pwd) {
		
		Connection conn = getConnection();
		
		Member loginUser = new MemberDao().loginOwn(conn, id, pwd);
		
		close(conn);
		
		return loginUser;
	}
	
	

}
