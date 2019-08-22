package empService.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.vo.Attachment;
import empService.model.dao.ResumeDao;
import empService.model.vo.Resume;
import ownerService.model.vo.Filter;
import ownerService.model.vo.Incruit;

public class ResumeService {

	/**
	 * 이력서 등록
	 * @param resume
	 * @return 1-성공 0-실패
	 */
	public int enrollResume(Resume resume, Attachment at) {

		Connection conn = getConnection();

		int result1 = new ResumeDao().enrollResume(conn, resume);
//		int result2 = new ResumeDao().enrollAttachment(conn, at);

//		if (result1 > 0 && resule2 > 0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
//
//		close(conn);

		return result1;
	}
	
	public Resume selectResume(int rNum) {
		
		Connection conn = getConnection();

		Resume resume = new ResumeDao().selectResume(conn, rNum);

		close(conn);

		return resume;
	}
	
	public int updateResume(Resume resume) {
		
		Connection conn = getConnection();
		
		int result = new ResumeDao().updateResume(conn, resume);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public int deleteResume(int rNum) {
		
		Connection conn = getConnection();
		
		int result = new ResumeDao().deleteResume(conn, rNum);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
	}
	
	public ArrayList<Resume> selectResumeList(int empNum) {

		Connection conn = getConnection();

		ArrayList<Resume> list = new ResumeDao().selectResumeList(conn, empNum);

		close(conn);

		return list;
	}
	
	public ArrayList<Incruit> selectSuitableRecruitList(Filter filter) {

		Connection conn = getConnection();

		ArrayList<Incruit> list = new ResumeDao().selectSuitableRecruitList(conn, filter);

		close(conn);

		return list;
	}
	
	public ArrayList<Incruit> selectSuitableIncruit(int rNum) {
		
		Connection conn = getConnection();

		Resume resume = new ResumeDao().selectResume(conn, rNum);
		
		ArrayList<Incruit> list = new ResumeDao().selectSuitableIncruit(conn, resume);

		close(conn);

		return list;
		
	}
	
	

}
