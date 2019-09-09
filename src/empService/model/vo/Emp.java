package empService.model.vo;

import java.util.Calendar;

import org.eclipse.jdt.internal.compiler.lookup.Scope.Substitutor;

public class Emp {
	
	private int empNum;
	private String eId;
	private String ePwd;
	private String eName;
	private String ecNum;
	private int dongNum;
	private int roadNum;
	private String roadName;
	private int roadMain;
	private int roadSub;
	private String district;
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

	
	
	public Emp(int empNum, String eId, String ePwd, String eName, String ecNum, int dongNum, int roadNum,
			String roadName, int roadMain, int roadSub, String district, String address, String phone, String email,
			String mailAccept, String smsAccept, String invalid, int warningCount) {
		super();
		this.empNum = empNum;
		this.eId = eId;
		this.ePwd = ePwd;
		this.eName = eName;
		this.ecNum = ecNum;
		this.dongNum = dongNum;
		this.roadNum = roadNum;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.district = district;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalid = invalid;
		this.warningCount = warningCount;
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



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public int getAge() {
		
		String n = this.ecNum;
		
		int year2 = Integer.parseInt(n.substring(0, 2));
		int year4 = 0;
		
		if(year2 >= 20 && year2 <=99) {
			year4 = 1900 + year2;
		}else {
			year4 = 2000 + year2;
		}
		
		int age = Calendar.getInstance().get(Calendar.YEAR) - year4;

		return age;
	}
	
	public String getGender() {
		
		String n = this.ecNum;
		
		String gender = "ㅋ";
		
		int flag = n.substring(6, 7).equals("-") ? Integer.parseInt(n.substring(7, 8)) : Integer.parseInt(n.substring(6, 7));
		
		if(flag == 1 || flag == 3) {
			gender= "남";
		}else {
			gender= "여";
		}
		
		return gender;
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
