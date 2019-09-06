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
	private String opNum;		// 사업자 번호
	private String opAddress;	// 나머지 주소
	private String oName;		// 이름
	private String oTel;		// 사업장 전화번호
	private String ocNum;		// 사업자 주민번호
	private int typeNum;		// 업직종 번호 
	private String checkoNum;	// 사업자번호 확인 여부
	private String subCategory;
	
	
	// 공통
	
	private int dongNum;		// 동 번호
	private int roadNum;		// 도로명 번호
	private String phone;		// 폰번호
	private String email;		// 이메일
	private String mailAccept;	// 메일 수신 동의
	private String smsAccept;	// sms수신동의
	private String roadName;	
	private int roadMain;		//
	private int roadSub;		//
	
	private String invalidId;	// 탈퇴 유무
	//private int dongNum;		
	//private String phone;		
	//private String email;		
	//private String mailAccept;
	//private String smsAccept;	
	//private String invalidId;	
	private int kind;			//1. 개인 2. 기업
	
	
	
		
	public Member() {
		super();
	}
	
	

	// 개인
	public Member(int eNum, String eId, String ePwd, String eName, String ecNum, int dongNum, int roadNum, String eAddress,
			String phone, String email, String mailAccept, String smsAccept, String roadName, int roadMain, int roadSub, String invalidId, int warningCount) {
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
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.invalidId = invalidId;
		this.warningCount = warningCount;
	}
	
	
	



	// 사업자
	public Member(int oNum, String oId, String oPwd, String opName, String opNum, int dongNum, int roadNum,
			String opAddress, String oName, String oTel, String ocNum, String phone, String email, int typeNum,
			String mailAccept, String smsAccept, String roadName, int roadMain, int roadSub, String invalidId, String checkoNum) {
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
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.invalidId = invalidId;
		this.checkoNum = checkoNum;
	}
	
	// 개인 회원 로그인
	public Member(int eNum, String eId, String ePwd, String eName, String ecNum, int dongNum, int roadNum,
			String eAddress, String phone, String email, String mailAccept, String smsAccept, String invalidId,
			int warningCount) {
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
		this.kind = 1;
	}
	
	
	// 사업자 로그인
	public Member(int oNum, String oId, String oPwd, String opName, String opNum, int dongNum, int roadNum,
			String opAddress, String oName, String oTel, String ocNum, String phone, String email, int typeNum,
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
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.checkoNum = checkoNum;
		
		this.kind = 2;
	}



	// 개인 회원 가입
	public Member(String eId, String ePwd, String eName, String ecNum, String eAddress, String phone,
			String email, String mailAccept, String smsAccept, String roadName, int roadMain, int roadSub) {
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
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
	}
	
	
	// 사업자 회원가입
	public Member(String oId, String oPwd, String opName, String opNum, String opAddress, String oName, String oTel,
			String ocNum, String phone, String email, String subCategory, String mailAccept, String smsAccept, String roadName,
			int roadMain, int roadSub) {
		super();
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.subCategory = subCategory;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
	}
	

	
	public String getSubCategory() {
		return subCategory;
	}



	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}



	public int getKind() {
		return kind;
	}



	public void setKind(int kind) {
		this.kind = kind;
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



	public String getOpNum() {
		return opNum;
	}



	public void setOpNum(String opNum) {
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



	public String getRoadName() {
		return roadName;
	}



	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}



	public int getRoadMain() {
		return roadMain;
	}



	public void setRoadMain(int roadMain) {
		this.roadMain = roadMain;
	}



	public int getRoadSub() {
		return roadSub;
	}



	public void setRoadSub(int roadSub) {
		this.roadSub = roadSub;
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
				+ oName + ", oTel=" + oTel + ", ocNum=" + ocNum + ", typeNum=" + typeNum + ", checkoNum=" + checkoNum
				+ ", dongNum=" + dongNum + ", roadNum=" + roadNum + ", phone=" + phone + ", email=" + email
				+ ", mailAccept=" + mailAccept + ", smsAccept=" + smsAccept + ", roadName=" + roadName + ", roadMain="
				+ roadMain + ", roadSub=" + roadSub + ", invalidId=" + invalidId + "]";
	}



	
	
	




	
	
	


	
	
	
	
	
	
	
	
	
	
	
	

}