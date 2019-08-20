package ownerService.model.vo;

import java.sql.Date;

public class Appliant {
	
	private int applyNum; // KEY
	private int rNum; // 이력서key
	private String comment; // 하고싶은말
	private int eNum; // 지원자key
	private String eName; // 지원자명
	private int wNum; // 공고key
	private String wTitle; // 공고명
	private int oNum; // 사업자key
	private String opName; // 사업자명
	private String incruitStatus; // 마감상태
	private Date endDate; // 마감일
	private Date applyDate; // 지원일
	private String passOrFail; // 합불여부
	
	public Appliant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appliant(int applyNum, int rNum, String comment, int eNum, String eName, int wNum, String wTitle, int oNum,
			String opName, String incruitStatus, Date endDate, Date applyDate, String passOrFail) {
		super();
		this.applyNum = applyNum;
		this.rNum = rNum;
		this.comment = comment;
		this.eNum = eNum;
		this.eName = eName;
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.oNum = oNum;
		this.opName = opName;
		this.incruitStatus = incruitStatus;
		this.endDate = endDate;
		this.applyDate = applyDate;
		this.passOrFail = passOrFail;
	}

	public int getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getIncruitStatus() {
		return incruitStatus;
	}

	public void setIncruitStatus(String incruitStatus) {
		this.incruitStatus = incruitStatus;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getPassOrFail() {
		return passOrFail;
	}

	public void setPassOrFail(String passOrFail) {
		this.passOrFail = passOrFail;
	}

	

	
	
	

}
