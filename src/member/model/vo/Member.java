package member.model.vo;

public class Member {
	
	private int eNum;			// ����ȸ����ȣ
	private String eId;			// ���� ���̵�
	private String ePwd;		// ���� ���
	private String eName;		// ���� �̸�
	private int ecNum;			// �����ֹ�
	private int eAddress;		// ���γ������ּ�
	private int warningCount;	// ���Ƚ��
	private int oNum1;			// ������1
	private int oNum2;			// ������2
	private int oNum3;			// ������3
	private int oNum4;			// ������4
	private int oNum5;			// ������5
	
	
	private int oNum;			// �����ȸ����ȣ
	private String oId;			// ����� ���̵�
	private String oPwd;		// ����� ���
	private String opName;		// ������
	private int opNum;			// ������ȣ
		
	
	private String opAddress;	// ����峪�����ּ�
	private String oName;		// ����� �̸�
	private String otel;		// ����� ��ȭ��ȣ
	private int ocnum;			// ����� �ֹ�
	private int typeNum;		// ��������ȣ
	private String checkoNum;	// ����� ��ȣ Ȯ�� ����
	
	
	private int dongNum;		// ����ȣ(����)
	private String phone;		// ����ȣ(����)
	private String email;		// �̸���(����)
	private String mailAccept;	// ���� ���� ����(����)
	private String smsAccept;	// sms���ŵ���(����)
	private String invalidId;	// Ż������(����)
	
	
	
	
		
	public Member() {
		super();
	}
	
	
	// ���� ȸ�� ����
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


	// ����ȸ��
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

	// �����
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