package member.model.vo;

public class Member {
	
	// 개인 회원
	private int eNum;			// 회원번호
	private String eId;			// 아이디
	private String ePwd;		// 비밀번호
	private String eName;		// 이름
	private String ecNum;		// 주민번호
	private String eAddress;	// 나머지 주소
	private int warningCount;	// 경고횟수


	// 사업자 회원
	private int oNum;			// 회원번호
	private String oId;			// 아이디
	private String oPwd;		// 비밀번호
	private String opName;		// 사업장 명
	private int opNum;			// 사업자 번호
	private String opAddress;	// 나머지 주소
	private String oName;		// 이름
	private String otel;		// 사업장 전화번호
	private String ocnum;			// 사업자 주민번호
	private int typeNum;		// 업직종 번호 
	private String checkoNum;	// 사업자번호 확인 여부
	
	
	// 공통
	
	private int dongNum;		// 동 번호
	private int roadNum;		// 도로명 번호
	private String phone;		// 폰번호
	private String email;		// 이메일
	private String mailAccept;	// 메일 수신 동의
	private String smsAccept;	// sms수신동의
	private String invalidId;	// 탈퇴 유무
	//private int dongNum;		
	//private String phone;		
	//private String email;		
	//private String mailAccept;
	//private String smsAccept;	
	//private String invalidId;	
	
	
	
	
		
	public Member() {
		super();
	}
	

	// 개인
	public Member(int eNum, String eId, String ePwd, String eName, String ecNum, int dongNum, int roadNum, String eAddress,
			String phone, String email, String mailAccept, String smsAccept, String invalidId, int warningCount) {
		super();
		this.eNum = eNum;
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.dongNum = dongNum;
		this.roadNum = roadNum;
		this.eAddress = eAddress;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.warningCount = warningCount;
	}
	
	
	// 개인 회원 가입
	public Member(String eId, String ePwd, String eName, String ecNum, String eAddress, String phone,
			String email, String mailAccept, String smsAccept) {
		super();
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.eAddress = eAddress;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		
	}

	// 사장
	public Member(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, int roadNum,
			String opAddress, String oName, String otel, String ocnum, String phone, String email, int typeNum,
			String mailAccept, String smsAccept, String invalidId, String checkoNum) {
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


	public String getEcNum() {
		return ecNum;
	}


	public void setEcNum(String ecNum) {
		this.ecNum = ecNum;
	}


	public String geteAddress() {
		return eAddress;
	}


	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}


	public int getWarningCount() {
		return warningCount;
	}


	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
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


	public String getOcnum() {
		return ocnum;
	}


	public void setOcnum(String ocnum) {
		this.ocnum = ocnum;
	}


	public int getTypeNum() {
		return typeNum;
	}


	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}


	public String getCheckoNum() {
		return checkoNum;
	}


	public void setCheckoNum(String checkoNum) {
		this.checkoNum = checkoNum;
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


	@Override
	public String toString() {
		return "Member [eNum=" + eNum + ", eId=" + eId + ", ePwd=" + ePwd + ", eName=" + eName + ", ecNum=" + ecNum
				+ ", eAddress=" + eAddress + ", warningCount=" + warningCount + ", oNum=" + oNum + ", oId=" + oId
				+ ", oPwd=" + oPwd + ", opName=" + opName + ", opNum=" + opNum + ", opAddress=" + opAddress + ", oName="
				+ oName + ", otel=" + otel + ", ocnum=" + ocnum + ", typeNum=" + typeNum + ", checkoNum=" + checkoNum
				+ ", dongNum=" + dongNum + ", roadNum=" + roadNum + ", phone=" + phone + ", email=" + email
				+ ", mailAccept=" + mailAccept + ", smsAccept=" + smsAccept + ", invalidId=" + invalidId + "]";
	}
	
	




	
	
	


	
	
	
	
	
	
	
	
	
	
	
	

}