package empService.model.vo;

import java.sql.Date;

public class EmpEvaluationBefore {
	
	private int applyNum; // key
	private int eNum; // 구직자key
	private int rNum; // 이력서key
	private int oNum; // 사업자key
	private int wNum; // 공고key
	private String wTitle; // 공고명
	private String opName; // 사업자명
	
	public EmpEvaluationBefore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpEvaluationBefore(int applyNum, int eNum, int rNum, int oNum, int wNum, String wTitle, String opName) {
		super();
		this.applyNum = applyNum;
		this.eNum = eNum;
		this.rNum = rNum;
		this.oNum = oNum;
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.opName = opName;
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

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
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

	
	

}
