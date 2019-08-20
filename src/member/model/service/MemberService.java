package member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDao;
import member.model.vo.Member;

//Service : Connection 객체 생성 , conn 객체와 Controller로 부터 받아온 데이터값 Dao단에 넘김, 그처리결과 받음 트랜잭션 처리
public class MemberService {

	/**
	 * 1.로그인용 서비스
	 * @param userId
	 * @param userPwd
	 * @return 로그인한 회원객체
	 */
	public Member loginMember(String userId, String userPwd) {
		Connection conn= getConnection();
		
		Member m = null;
		m = new MemberDao().loginMember(conn,userId,userPwd);
		
		close(conn);
		
		
		return m;
	}

	/**
	 * 회원가입 서비스
	 * @param mem
	 * @return
	 */
	public int insertMember(Member mem) {
		int  result =0;
		
		Connection conn =getConnection();
		result = new MemberDao().insertMember(conn,mem);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	/**
	 * 3.회원정보 수정 서비스
	 * @param mem-->수정할 내용이 담겨있는 객체
	 * @return updateMem--> 수정완료후 다시 조회된 회원객체
	 */
	public Member updateMember(Member mem) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(conn,mem);
		Member updateMem = null;
		if(result>0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, mem.getUserId());
			
		}else {
			rollback(conn);
			
		}
		
		
		close(conn);
		
		return updateMem;
	}

	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Member updateMem =null;
		Connection conn = getConnection();
		int result = new MemberDao().updatePwd(conn,userId,userPwd,newPwd);
		if(result>0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId);
		}else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}

	public int deleteMember(String userId) {
		int result = 0;
		Connection conn =getConnection();
		result = new MemberDao().deleteMember(conn,userId);
		if (result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
