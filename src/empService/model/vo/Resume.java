package empService.model.vo;

import java.sql.Date;

public class Resume {
	
	private int rnum; // key
	private int empNum; // 구직자key
	private String eName;
	private int phone;
	private String email;
	private String district;
	private String type;
	private String comment;
	private Date updateDate;
	private String invalid;
	private String desireForm;
	private int desireIncome;
	private String openSet;
	private String edu;
	private String picture;
	
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resume(int rnum, int empNum, String eName, int phone, String email, String district, String type,
			String comment, Date updateDate, String invalid, String desireForm, int desireIncome, String openSet,
			String edu, String picture) {
		super();
		this.rnum = rnum;
		this.empNum = empNum;
		this.eName = eName;
		this.phone = phone;
		this.email = email;
		this.district = district;
		this.type = type;
		this.comment = comment;
		this.updateDate = updateDate;
		this.invalid = invalid;
		this.desireForm = desireForm;
		this.desireIncome = desireIncome;
		this.openSet = openSet;
		this.edu = edu;
		this.picture = picture;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	
	
	

}
