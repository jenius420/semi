package owner.model.vo;

public class Owner {
	
	private int oNum;
	private String oId;
	private String oPwd;
	private String opName;
	private int opNum;
	private String dong;
	private String opAddress;
	private String oName;
	private int oTel;
	private int ocNum;
	private int phone;
	private String email;
	private String type;
	private String mailAccept;
	private String smsAccept;
	private String invalidId;
	private String checkONum;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(int oNum, String oId, String oPwd, String opName, int opNum, String dong, String opAddress,
			String oName, int oTel, int ocNum, int phone, String email, String type, String mailAccept,
			String smsAccept, String invalidId, String checkONum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dong = dong;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.type = type;
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

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
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

	public int getoTel() {
		return oTel;
	}

	public void setoTel(int oTel) {
		this.oTel = oTel;
	}

	public int getOcNum() {
		return ocNum;
	}

	public void setOcNum(int ocNum) {
		this.ocNum = ocNum;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
