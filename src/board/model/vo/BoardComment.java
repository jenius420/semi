package board.model.vo;

import java.sql.Date;

public class BoardComment {

	private int commentNum;				// 댓글 번호
	private String commentExplain;		// 댓글 내용
	private int tNum;					// 댓글 있는 글 번호
	private String deleteOrNot;			// 삭제 유무
	private Date enrollDate;			// 등록일
	private int eNum;					// 작성자 번호
	private String eName;				// 작성자 이름
	
	
	public BoardComment() {}


	public BoardComment(int commentNum, String commentExplain, int tNum, String deleteOrNot, Date enrollDate, int eNum,
			String eName) {
		super();
		this.commentNum = commentNum;
		this.commentExplain = commentExplain;
		this.tNum = tNum;
		this.deleteOrNot = deleteOrNot;
		this.enrollDate = enrollDate;
		this.eNum = eNum;
		this.eName = eName;
	}


	public int getCommentNum() {
		return commentNum;
	}


	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}


	public String getCommentExplain() {
		return commentExplain;
	}


	public void setCommentExplain(String commentExplain) {
		this.commentExplain = commentExplain;
	}


	public int gettNum() {
		return tNum;
	}


	public void settNum(int tNum) {
		this.tNum = tNum;
	}


	public String getDeleteOrNot() {
		return deleteOrNot;
	}


	public void setDeleteOrNot(String deleteOrNot) {
		this.deleteOrNot = deleteOrNot;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public int geteNum() {
		return eNum;
	}


	public void seteNum(int eNum) {
		this.eNum = eNum;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	@Override
	public String toString() {
		return "BoardComment [commentNum=" + commentNum + ", commentExplain=" + commentExplain + ", tNum=" + tNum
				+ ", deleteOrNot=" + deleteOrNot + ", enrollDate=" + enrollDate + ", eNum=" + eNum + ", eName=" + eName
				+ "]";
	}
	
	
	
	
}
