package empService.model.vo;

import java.sql.Date;

public class EmpEvaluation {
	
	private int sevalNum;
	private int applyNum;
	private int eNum;
	private String eId;
	private int oNum;
	private String opName;
	private int sevalPoint;
	private String eComment;
	private Date enrollDate;
	private String eName;
	
	
	public EmpEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}





	public EmpEvaluation(int sevalNum, int applyNum, int eNum, String eId, int oNum, String opName, int sevalPoint,
			String eComment, Date enrollDate, String eName) {
		super();
		this.sevalNum = sevalNum;
		this.applyNum = applyNum;
		this.eNum = eNum;
		this.eId = eId;
		this.oNum = oNum;
		this.opName = opName;
		this.sevalPoint = sevalPoint;
		this.eComment = eComment;
		this.enrollDate = enrollDate;
		this.eName = eName;
	}





	public String geteId() {
		return eId;
	}



	public void seteId(String eId) {
		this.eId = eId;
	}



	public String geteName() {
		return eName;
	}



	public void seteName(String eName) {
		this.eName = eName;
	}



	public int getSevalNum() {
		return sevalNum;
	}



	public void setSevalNum(int sevalNum) {
		this.sevalNum = sevalNum;
	}



	public int getApplyNum() {
		return applyNum;
	}



	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
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
