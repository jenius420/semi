package emp.model.vo;


public class Emp {
	
	private int empNum;
	private String eId;
	private String ePwd;
	private String eName;
	private int ecNum;
	private int dongNum;
	private String address;
	private int phone;
	private String email;
	private String mailAccept;
	private String smsAccept;
	private String invalid;
	private int warningCount;
	private int hopeCorp;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empNum, String eId, String ePwd, String eName, int eCNum, int dongNum, String address, int phone,
			String email, String mailAccept, String smsAccept, String invalid, int warningCount, int hopeCorp) {
		super();
		this.empNum = empNum;
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = eCNum;
		this.dongNum = dongNum;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalid = invalid;
		this.warningCount = warningCount;
		this.hopeCorp = hopeCorp;
	}
	
	
	public int getEcNum() {
		return ecNum;
	}
	public void setEcNum(int ecNum) {
		this.ecNum = ecNum;
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
	public int getecNum() {
		return ecNum;
	}
	public void setecNum(int ecNum) {
		this.ecNum = ecNum;
	}
	public int getDongNum() {
		return dongNum;
	}
	public void setDongNum(int dongNum) {
		this.dongNum = dongNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getHopeCorp() {
		return hopeCorp;
	}
	public void setHopeCorp(int hopeCorp) {
		this.hopeCorp = hopeCorp;
	}
	
	
	

}
