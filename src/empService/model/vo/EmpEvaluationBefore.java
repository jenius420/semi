package empService.model.vo;

import java.sql.Date;

public class EmpEvaluationBefore {
	
	private int applyNum; // key
	private int eNum; // 구직자key
	private int wNum; // 공고key
	private String wTitle; // 공고명
	private String opName; // 사업자명
	private Date workStartTerm; // 근무시작일
	private Date workEndTerm; // 근무종료일
	
	public EmpEvaluationBefore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpEvaluationBefore(int applyNum, int eNum, int wNum, String wTitle, String opName, Date workStartTerm,
			Date workEndTerm) {
		super();
		this.applyNum = applyNum;
		this.eNum = eNum;
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.opName = opName;
		this.workStartTerm = workStartTerm;
		this.workEndTerm = workEndTerm;
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

	public int getwNum() {
		return wNum;
	}

	public void setwNum(int wNum) {
		this.wNum = wNum;
	}

	public String getwTitle() {
		return wTitle;
	}

	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
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

	
	

}
