package empService.model.vo;


public class Emp {
	
	private int empNum;
	private String eId;
	private String ePwd;
	private String eName;
	private String ecNum;
	private int dongNum;
	private int roadNum;
	private String address;
	private String phone;
	private String email;
	private String mailAccept;
	private String smsAccept;
	private String invalid;
	private int warningCount;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empNum, String eId, String ePwd, String eName, String ecNum, int dongNum, int roadNum, String address,
			String phone, String email, String mailAccept, String smsAccept, String invalid, int warningCount) {
		super();
		this.empNum = empNum;
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.dongNum = dongNum;
		this.roadNum = roadNum;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalid = invalid;
		this.warningCount = warningCount;
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}
	
	
	
	
	
	

}
