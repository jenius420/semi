package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Category;
import member.model.vo.Member;
import search.model.dao.SearchDao;

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
	public String findIdEmp(String name, String cNum) {
		
		Connection conn = getConnection();
		
		String userId = new MemberDao().findIdEmp(conn, name, cNum);
		
		close(conn);
		
		return userId;
	}

	public String fidIdOwn(String name, String cNum) {

		Connection conn = getConnection();
		
		String userId = new MemberDao().findIdOwn(conn, name, cNum);
		
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

	public String findEmpPwd(String id, String name, String cNum) {
		Connection conn = getConnection();
		String findEmpPwd=new MemberDao().findEmpPwd(conn,id,name,cNum);
		close(conn);
		return findEmpPwd;
	}

	public String findOwnPwd(String id, String name, String cNum) {
		Connection conn = getConnection();
		String findOwnPwd=new MemberDao().findOwnPwd(conn,id,name,cNum);
		close(conn);
		return findOwnPwd;
	}

	public int changeEmpPwd(String id, String name, String cNum, String pwd) {
		Connection conn = getConnection();
		int result = new MemberDao().changeEmpPwd(conn,id,name,cNum,pwd);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int changeOwnPwd(String id, String name, String cNum, String pwd) {
		Connection conn = getConnection();
		int result = new MemberDao().changeOwnPwd(conn,id,name,cNum,pwd);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateEmpPwd(String newPwd, String id, String pwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updateEmpPwd(conn, newPwd, id, pwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateOwnPwd(String newPwd, String id, String pwd) {
		Connection conn = getConnection();
		int result = new MemberDao().updateOwnPwd(conn, newPwd, id, pwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public String[] searchAddress(int rNum) {
		Connection conn =getConnection();
		String[] result = new SearchDao().searchAddress(conn,rNum);
		close(conn);
		return result;
	}


	
	

}
