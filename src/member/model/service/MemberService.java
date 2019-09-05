package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Category;
import member.model.vo.Member;

public class MemberService {
	

	/**
	 * 개인 회원 로그인
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
	 * 사업자 회원 로그인
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


	/**
	 * 개인 회원 가입
	 * @param mem
	 * @return
	 */
	public int insertEmp(Member mem) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertEmp(conn, mem);
		
		if(result > 0) {
			commit(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 사업자 회원가입
	 * @param mem
	 * @return
	 */
	public int insertOwn(Member mem) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertOwn(conn, mem);
		
		if(result > 0) {
			commit(conn);
		}else {
			commit(conn);
		}
		
		close(conn);
		
		return result;
	}
	

	/**
	 * 개인 회원 탈퇴
	 * @param id 
	 * @return
	 */
	public int deleteEmp(String id) {	
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteEmp(conn, id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}	
		close(conn);
		
		return result;
	}


	/**
	 * 사업자 회원 탈퇴
	 * @return
	 */
	public int deleteOwn(String id) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteOwn(conn, id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return result;
	}

	/**
	 * 개인 회원 아이디 중복체크
	 * @param eId
	 * @return
	 */
	public int idCheckEmp(String eId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheckEmp(conn, eId);
		
		close(conn);
		
		return result;
	}

	/**
	 * 개인 아이디 찾기
	 * @param id
	 * @param cNum
	 * @return
	 */
	public Member findIdEmp(String id, String cNum) {
		
		Connection conn = getConnection();
		
		Member userId = new MemberDao().findIdEmp(conn, id, cNum);
		
		close(conn);
		
		return userId;
	}

	public Member fidIdOwn(String id, String cNum) {

		Connection conn = getConnection();
		
		Member userId = new MemberDao().findIdOwn(conn, id, cNum);
		
		close(conn);
		
		return userId;
	}

	public ArrayList<Category> getBigcategory() {
		Connection conn =getConnection();
		ArrayList<Category> list = new MemberDao().getBigCategory(conn);
		close(conn);
		return list;
	}

	public ArrayList<Category> getSubcategory(String bigCategoryName) {
		Connection conn = getConnection();
		ArrayList<Category> list = new MemberDao().getSubCategory(conn,bigCategoryName);
		close(conn);
		return list;
	}


	
	

}
