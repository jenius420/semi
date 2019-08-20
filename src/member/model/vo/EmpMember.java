package member.model.vo;

import java.sql.Date;

public class EmpMember implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2845427768252133333L;
	
	private int eNum;
	private String eId;
	private String ePwd;
	private String eName;
	private int ecNum;
	private int dongNum;
	private String eAddress;
	private int phone;
	private String email;
	private String mailAccept;
	private String smsAccept;
	private String invalidId;
	private int waringCount;
	private int oNum1;
	private int oNum2;
	private int oNum3;
	private int oNum4;
	private int oNum5;
	
	
	public EmpMember() {
		super();
	}

	
	// 회원가입
	public EmpMember(String eId, String ePwd, String eName, int ecNum, int dongNum, String eAddress, int phone,
			String email, String mailAccept, String smsAccept) {
		super();
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.dongNum = dongNum;
		this.eAddress = eAddress;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
	}


	public EmpMember(int eNum, String eId, String ePwd, String eName, int ecNum, int dongNum, String eAddress,
			int phone, String email, String mailAccept, String smsAccept, String invalidId, int waringCount, int oNum1,
			int oNum2, int oNum3, int oNum4, int oNum5) {
		super();
		this.eNum = eNum;
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.dongNum = dongNum;
		this.eAddress = eAddress;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.waringCount = waringCount;
		this.oNum1 = oNum1;
		this.oNum2 = oNum2;
		this.oNum3 = oNum3;
		this.oNum4 = oNum4;
		this.oNum5 = oNum5;
	}


	public int geteNum() {
		return eNum;
	}


	public void seteNum(int eNum) {
		this.eNum = eNum;
	}


	public String geteId() {
		return eId;
	}


	public void seteId(String eId) {
		this.eId = eId;
	}


	public String getePwd() {
		return ePwd;
	}


	public void setePwd(String ePwd) {
		this.ePwd = ePwd;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public int getEcNum() {
		return ecNum;
	}


	public void setEcNum(int ecNum) {
		this.ecNum = ecNum;
	}


	public int getDongNum() {
		return dongNum;
	}


	public void setDongNum(int dongNum) {
		this.dongNum = dongNum;
	}


	public String geteAddress() {
		return eAddress;
	}


	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
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


	public int getWaringCount() {
		return waringCount;
	}


	public void setWaringCount(int waringCount) {
		this.waringCount = waringCount;
	}


	public int getoNum1() {
		return oNum1;
	}


	public void setoNum1(int oNum1) {
		this.oNum1 = oNum1;
	}


	public int getoNum2() {
		return oNum2;
	}


	public void setoNum2(int oNum2) {
		this.oNum2 = oNum2;
	}


	public int getoNum3() {
		return oNum3;
	}


	public void setoNum3(int oNum3) {
		this.oNum3 = oNum3;
	}


	public int getoNum4() {
		return oNum4;
	}


	public void setoNum4(int oNum4) {
		this.oNum4 = oNum4;
	}


	public int getoNum5() {
		return oNum5;
	}


	public void setoNum5(int oNum5) {
		this.oNum5 = oNum5;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "EmpMember [eNum=" + eNum + ", eId=" + eId + ", ePwd=" + ePwd + ", eName=" + eName + ", ecNum=" + ecNum
				+ ", dongNum=" + dongNum + ", eAddress=" + eAddress + ", phone=" + phone + ", email=" + email
				+ ", mailAccept=" + mailAccept + ", smsAccept=" + smsAccept + ", invalidId=" + invalidId
				+ ", waringCount=" + waringCount + ", oNum1=" + oNum1 + ", oNum2=" + oNum2 + ", oNum3=" + oNum3
				+ ", oNum4=" + oNum4 + ", oNum5=" + oNum5 + "]";
	}
	
	
	
	
	
	
	
	
}
