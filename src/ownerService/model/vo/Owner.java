package ownerService.model.vo;

public class Owner {
	
	private int oNum;
	private String oId;
	private String oPwd;
	private String opName;
	private int opNum;
	private int dongNum;
	private int roadNum;
	private String opAddress;
	private String oName;
	private String oTel;
	private String ocNum;
	private String phone;
	private String email;
	private int typeNum;
	private String mailAccept;
	private String smsAccept;
	private String invalidId;
	private String checkONum;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, int roadNum,
			String opAddress, String oName, String oTel, String ocNum, String phone, String email, int typeNum,
			String mailAccept, String smsAccept, String invalidId, String checkONum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.roadNum = roadNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.checkONum = checkONum;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getoPwd() {
		return oPwd;
	}

	public void setoPwd(String oPwd) {
		this.oPwd = oPwd;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public int getOpNum() {
		return opNum;
	}

	public void setOpNum(int opNum) {
		this.opNum = opNum;
	}

	public int getDongNum() {
		return dongNum;
	}

	public void setDongNum(int dongNum) {
		this.dongNum = dongNum;
	}

	public int getRoadNum() {
		return roadNum;
	}

	public void setRoadNum(int roadNum) {
		this.roadNum = roadNum;
	}

	public String getOpAddress() {
		return opAddress;
	}

	public void setOpAddress(String opAddress) {
		this.opAddress = opAddress;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public String getoTel() {
		return oTel;
	}

	public void setoTel(String oTel) {
		this.oTel = oTel;
	}

	public String getOcNum() {
		return ocNum;
	}

	public void setOcNum(String ocNum) {
		this.ocNum = ocNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}

	public String getMailAccept() {
		return mailAccept;
	}

	public void setMailAccept(String mailAccept) {
		this.mailAccept = mailAccept;
	}

	public String getSmsAccept() {
		return smsAccept;
	}

	public void setSmsAccept(String smsAccept) {
		this.smsAccept = smsAccept;
	}

	public String getInvalidId() {
		return invalidId;
	}

	public void setInvalidId(String invalidId) {
		this.invalidId = invalidId;
	}

	public String getCheckONum() {
		return checkONum;
	}

	public void setCheckONum(String checkONum) {
		this.checkONum = checkONum;
	}

	
	

}
