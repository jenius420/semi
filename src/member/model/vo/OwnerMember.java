package member.model.vo;

public class OwnerMember implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6947653002263837721L;
	
	
	private int oNum;
	private String oId;
	private String oPwd;
	private String opName;
	private int opNum;
	private int dongNum;
	private String opAddress;
	private String oName;
	private int oTel;
	private int ocNum;
	private int phone;
	private String email;
	private int typeNum;
	private String mailAccept;
	private String smsAccept;
	private String einvalidId;
	private String checkoNum;
	
	public OwnerMember() {
		super();
	}
	
	
	
	// 회원가입
	public OwnerMember(String oId, String oPwd, String opName, int opNum, int dongNum, String opAddress, String oName,
			int oTel, int ocNum, int phone, String email, int typeNum, String mailAccept, String smsAccept,
			String checkoNum) {
		super();
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.checkoNum = checkoNum;
	}




	public OwnerMember(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, String opAddress,
			String oName, int oTel, int ocNum, int phone, String email, int typeNum, String mailAccept,
			String smsAccept, String einvalidid, String checkoNum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.einvalidId = einvalidid;
		this.checkoNum = checkoNum;
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

	public String getEinvalidId() {
		return einvalidId;
	}

	public void setEinvalidId(String einvalidId) {
		this.einvalidId = einvalidId;
	}

	public String getCheckoNum() {
		return checkoNum;
	}

	public void setCheckoNum(String checkoNum) {
		this.checkoNum = checkoNum;
	}

	@Override
	public String toString() {
		return "OwnerMember [oNum=" + oNum + ", oId=" + oId + ", oPwd=" + oPwd + ", opName=" + opName + ", opNum="
				+ opNum + ", dongNum=" + dongNum + ", opAddress=" + opAddress + ", oName=" + oName + ", oTel=" + oTel
				+ ", ocNum=" + ocNum + ", phone=" + phone + ", email=" + email + ", typeNum=" + typeNum
				+ ", mailAccept=" + mailAccept + ", smsAccept=" + smsAccept + ", einvalidId=" + einvalidId
				+ ", checkoNum=" + checkoNum + "]";
	}
	
	
	
	
	

}
