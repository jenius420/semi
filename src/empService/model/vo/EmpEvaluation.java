package empService.model.vo;

import java.sql.Date;

public class EmpEvaluation {
	
	private int sevalNum;
	private int eNum;
	private int oNum;
	private String opName;
	private int sevalPoint;
	private String eComment;
	private Date enrollDate;
	private Date workStartTerm;
	private Date workEndTerm;
	
	public EmpEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpEvaluation(int sevalNum, int eNum, int oNum, String opName, int sevalPoint, String eComment,
			Date enrollDate, Date workStartTerm, Date workEndTerm) {
		super();
		this.sevalNum = sevalNum;
		this.eNum = eNum;
		this.oNum = oNum;
		this.opName = opName;
		this.sevalPoint = sevalPoint;
		this.eComment = eComment;
		this.enrollDate = enrollDate;
		this.workStartTerm = workStartTerm;
		this.workEndTerm = workEndTerm;
	}



	public Date getWorkStartTerm() {
		return workStartTerm;
	}

	public void setWorkStartTerm(Date workStartTerm) {
		this.workStartTerm = workStartTerm;
	}

	public Date getWorkEndTerm() {
		return workEndTerm;
	}

	public void setWorkEndTerm(Date workEndTerm) {
		this.workEndTerm = workEndTerm;
	}

	public int getSevalNum() {
		return sevalNum;
	}

	public void setSevalNum(int sevalNum) {
		this.sevalNum = sevalNum;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public int getSevalPoint() {
		return sevalPoint;
	}

	public void setSevalPoint(int sevalPoint) {
		this.sevalPoint = sevalPoint;
	}

	public String geteComment() {
		return eComment;
	}

	public void seteComment(String eComment) {
		this.eComment = eComment;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	
	
	

}
