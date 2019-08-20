package ownerService.model.vo;

public class Filter {
	
	private int rNum; // key
	private int eNum; // 구직자key
	private String district; // 구
	private String type; // 업직종
	private String comment; // 하고싶은말
	private String desireForm; // 급여형태
	private int desireIncome; // 급여액수
	private String finalEdu; // 최종학력
	
	public Filter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filter(int rNum, int eNum, String district, String type, String comment, String desireForm, int desireIncome,
			String finalEdu) {
		super();
		this.rNum = rNum;
		this.eNum = eNum;
		this.district = district;
		this.type = type;
		this.comment = comment;
		this.desireForm = desireForm;
		this.desireIncome = desireIncome;
		this.finalEdu = finalEdu;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDesireForm() {
		return desireForm;
	}

	public void setDesireForm(String desireForm) {
		this.desireForm = desireForm;
	}

	public int getDesireIncome() {
		return desireIncome;
	}

	public void setDesireIncome(int desireIncome) {
		this.desireIncome = desireIncome;
	}

	public String getFinalEdu() {
		return finalEdu;
	}

	public void setFinalEdu(String finalEdu) {
		this.finalEdu = finalEdu;
	}

	
	
	
	

}
