package board.model.vo;

import java.sql.Date;

public class Comment {
	
	private int commentNum;
	private String comment;
	private int tNum;
	private String deleteYn;
	private Date enrollDate;
	private int eNum;
	private String eName;
	private int report;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentNum, String comment, int tNum, String deleteYn, Date enrollDate, int eNum, String eName,
			int report) {
		super();
		this.commentNum = commentNum;
		this.comment = comment;
		this.tNum = tNum;
		this.deleteYn = deleteYn;
		this.enrollDate = enrollDate;
		this.eNum = eNum;
		this.eName = eName;
		this.report = report;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
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

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}
	
	

}
