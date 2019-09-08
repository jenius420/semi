package empService.model.vo;

import java.sql.Date;
import java.util.Calendar;

public class Resume {
	
	private int rNum; // key
	private int empNum; // 구직자key
	private String eName;
	private String address;
	private String phone;
	private String email;
	private int districtNum;
	private String district;
	private int typeNum;
	private String type;
	private String category;
	private String comment;
	private Date updateDate;
	private String invalid;
	private String desireForm;
	private int desireIncome;
	private String openSet;
	private String edu;
	private int pNum;
	private String saveName;
	private int dongNum;
	private int roadNum;
	private String roadName;
	private int roadMain;
	private int age;
	private String gender;
	private String ecNum;
	
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Resume(int rNum, int empNum, String eName, String address, String phone, String email, int districtNum,
			String district, int typeNum, String type, String category, String comment, Date updateDate, String invalid,
			String desireForm, int desireIncome, String openSet, String edu, int pNum, String saveName) {
		super();
		this.rNum = rNum;
		this.empNum = empNum;
		this.eName = eName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.districtNum = districtNum;
		this.district = district;
		this.typeNum = typeNum;
		this.type = type;
		this.category = category;
		this.comment = comment;
		this.updateDate = updateDate;
		this.invalid = invalid;
		this.desireForm = desireForm;
		this.desireIncome = desireIncome;
		this.openSet = openSet;
		this.edu = edu;
		this.pNum = pNum;
		this.saveName = saveName;
	}



	
	public Resume(int rNum, int empNum, String eName, String address, String phone, String email, int districtNum,
			String district, int typeNum, String type, String category, String comment, Date updateDate, String invalid,
			String desireForm, int desireIncome, String openSet, String edu, String ecNum, int roadNum) {
		super();
		this.rNum = rNum;
		this.empNum = empNum;
		this.eName = eName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.districtNum = districtNum;
		this.district = district;
		this.typeNum = typeNum;
		this.type = type;
		this.category = category;
		this.comment = comment;
		this.updateDate = updateDate;
		this.invalid = invalid;
		this.desireForm = desireForm;
		this.desireIncome = desireIncome;
		this.openSet = openSet;
		this.edu = edu;
		this.ecNum = ecNum;
		this.roadNum = roadNum;
		
	}


	public int getDongNum() {
		return dongNum;
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


	public void setAge(int age) {
		this.age = age;
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


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEcNum() {
		return ecNum;
	}


	public void setEcNum(String ecNum) {
		this.ecNum = ecNum;
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



	public int getrNum() {
		return rNum;
	}



	public void setrNum(int rNum) {
		this.rNum = rNum;
	}



	public int getDistrictNum() {
		return districtNum;
	}



	public void setDistrictNum(int districtNum) {
		this.districtNum = districtNum;
	}



	public int getTypeNum() {
		return typeNum;
	}



	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}


	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	public String getDesireForm() {
		return desireForm;
	}

	public void setDesireForm(String desireForm) {
		this.desireForm = desireForm;
	}

	public int getDesireIncome() {
		return desireIncome;
	}

	public void setDesireIncome(int desireIncome) {
		this.desireIncome = desireIncome;
	}

	public String getOpenSet() {
		return openSet;
	}

	public void setOpenSet(String openSet) {
		this.openSet = openSet;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
	

}
