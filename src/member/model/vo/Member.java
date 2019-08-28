package member.model.vo;

public class Member {
	
	private int eNum;			// 개인회원번호
	private String eId;			// 개인 아이디
	private String ePwd;		// 개인 비번
	private String eName;		// 개인 이름
	private int ecNum;			// 개인주번
	private int eAddress;		// 개인나머지주소
	private int warningCount;	// 경고횟수
	private int oNum1;			// 희망기업1
	private int oNum2;			// 희망기업2
	private int oNum3;			// 희망기업3
	private int oNum4;			// 희망기업4
	private int oNum5;			// 희망기업5
	
	
	private int oNum;			// 사업자회원번호
	private String oId;			// 사업자 아이디
	private String oPwd;		// 사업자 비번
	private String opName;		// 사업장명
	private int opNum;			// 사업장번호
		
	
	private String opAddress;	// 사업장나머지주소
	private String oName;		// 사업자 이름
	private String otel;		// 사업장 전화번호
	private int ocnum;			// 사업자 주번
	private int typeNum;		// 업직종번호
	private String checkoNum;	// 사업자 번호 확인 여부
	
	
	private int dongNum;		// 동번호(공통)
	private String phone;		// 폰번호(공통)
	private String email;		// 이메일(공통)
	private String mailAccept;	// 메일 수신 동의(공통)
	private String smsAccept;	// sms수신동의(공통)
	private String invalidId;	// 탈퇴유무(공통)
	
	
	
	
		
	public Member() {
		super();
	}
	
	
	// 개인 회원 가입
	public Member(int oNum, String oId, String oPwd, String eName, int ecNum, String phone, String email, String mailAccept,
			String smsAccept, String invalidId) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
	}


	// 개인회원
	public Member(int eNum, String eId, String ePwd, String eName, int ecNum, int dongNum, int eAddress, String phone,
			String email, String mailAccept, String smsAccept, String invalidId, int warningCount, int oNum1, int oNum2, int oNum3,
			int oNum4, int oNum5) {
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
		this.warningCount = warningCount;
		this.oNum1 = oNum1;
		this.oNum2 = oNum2;
		this.oNum3 = oNum3;
		this.oNum4 = oNum4;
		this.oNum5 = oNum5;
	}

	// 사업자
	public Member(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, String opAddress,
			String oName, String otel, int ocnum, String phone, String email, int typeNum, String mailAccept,
			String smsAccept, String invalidId, String checkoNum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.otel = otel;
		this.ocnum = ocnum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.checkoNum = checkoNum;
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


	public int geteAddress() {
		return eAddress;
	}


	public void seteAddress(int eAddress) {
		this.eAddress = eAddress;
	}


	public int getWarningCount() {
		return warningCount;
	}


	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
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


	public String getOtel() {
		return otel;
	}


	public void setOtel(String otel) {
		this.otel = otel;
	}


	public int getOcnum() {
		return ocnum;
	}


	public void setOcnum(int ocnum) {
		this.ocnum = ocnum;
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


	public String getCheckoNum() {
		return checkoNum;
	}


	public void setCheckoNum(String checkoNum) {
		this.checkoNum = checkoNum;
	}


	
	@Override
	public String toString() {
		return "Member [eNum=" + eNum + ", eId=" + eId + ", ePwd=" + ePwd + ", eName=" + eName + ", ecNum=" + ecNum
				+ ", eAddress=" + eAddress + ", warningCount=" + warningCount + ", oNum1=" + oNum1 + ", oNum2=" + oNum2
				+ ", oNum3=" + oNum3 + ", oNum4=" + oNum4 + ", oNum5=" + oNum5 + ", oNum=" + oNum + ", oId=" + oId
				+ ", oPwd=" + oPwd + ", opName=" + opName + ", opNum=" + opNum + ", opAddress=" + opAddress + ", oName="
				+ oName + ", otel=" + otel + ", ocnum=" + ocnum + ", typeNum=" + typeNum + ", checkoNum=" + checkoNum
				+ ", dongNum=" + dongNum + ", phone=" + phone + ", email=" + email + ", mailAccept=" + mailAccept
				+ ", smsAccept=" + smsAccept + ", invalidId=" + invalidId + "]";
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	

}