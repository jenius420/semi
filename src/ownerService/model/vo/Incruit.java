package ownerService.model.vo;

import java.sql.Date;

public class Incruit {
	
	private int wNum; // KEY
	private String wTitle; // 제목
	private int oNum; // 사업자KEY
	private String opName; // 사업장명+
	private String workDay; // 근무요일
	private String workTime; // 근무시간
	private int termNo; // 근무기간key
	private String termName; // 근무간명
	private String termBigName; // 근무기간분류
	private String gender; // 성별
	private String age; // 나이
	private String edu; // 학력
	private Date enrollDate; // 등록일
	private String status; // 진행중/마감
	private Date doneDate; // 마감일
	private String salaryForm; // 급여형태	
	private int salary; // 급여
	private int pNum; // 상품코드
	private String product; // 상품명+
	private String description; // 상세내역
	private String peopleCount; // 모집인원
	private int dongNum; // 동코드
	private String dong; 
	private String dongMain; 
	private String dongSub;
	private int roadNum; // 거리코드
	private String roadName;
	private int roadMain;
	private int roadSub;
	private int districtNum; // 구코드
	private String district; 
	private String address;
	private int typeNum; // 업직종코드
	private String type; 
	private String category; 
	
	public Incruit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Incruit(int wNum, String wTitle, int oNum, String opName, String workDay, String workTime, int termNo,
			String termName, String termBigName, String gender, String age, String edu, Date enrollDate, String status,
			Date doneDate, String salaryForm, int salary, int pNum, String product, String description, String peopleCount,
			int dongNum, String dong, String dongMain, String dongSub, int roadNum, String roadName, int roadMain,
			int roadSub, int districtNum, String district, String address, int typeNum, String type, String category) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.oNum = oNum;
		this.opName = opName;
		this.workDay = workDay;
		this.workTime = workTime;
		this.termNo = termNo;
		this.termName = termName;
		this.termBigName = termBigName;
		this.gender = gender;
		this.age = age;
		this.edu = edu;
		this.enrollDate = enrollDate;
		this.status = status;
		this.doneDate = doneDate;
		this.salaryForm = salaryForm;
		this.salary = salary;
		this.pNum = pNum;
		this.product = product;
		this.description = description;
		this.peopleCount = peopleCount;
		this.dongNum = dongNum;
		this.dong = dong;
		this.dongMain = dongMain;
		this.dongSub = dongSub;
		this.roadNum = roadNum;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.districtNum = districtNum;
		this.district = district;
		this.address = address;
		this.typeNum = typeNum;
		this.type = type;
		this.category = category;
	}

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getwNum() {
		return wNum;
	}

	public void setwNum(int wNum) {
		this.wNum = wNum;
	}

	public String getwTitle() {
		return wTitle;
	}

	public void setwTitle(String wTitle) {
		this.wTitle = wTitle;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getTermNo() {
		return termNo;
	}

	public void setTermNo(int termNo) {
		this.termNo = termNo;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getTermBigName() {
		return termBigName;
	}

	public void setTermBigName(String termBigName) {
		this.termBigName = termBigName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	public String getSalaryForm() {
		return salaryForm;
	}

	public void setSalaryForm(String salaryForm) {
		this.salaryForm = salaryForm;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(String peopleCount) {
		this.peopleCount = peopleCount;
	}

	public int getDongNum() {
		return dongNum;
	}

	public void setDongNum(int dongNum) {
		this.dongNum = dongNum;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getDongMain() {
		return dongMain;
	}

	public void setDongMain(String dongMain) {
		this.dongMain = dongMain;
	}

	public String getDongSub() {
		return dongSub;
	}

	public void setDongSub(String dongSub) {
		this.dongSub = dongSub;
	}

	public int getRoadNum() {
		return roadNum;
	}

	public void setRoadNum(int roadNum) {
		this.roadNum = roadNum;
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

	public int getDistrictNum() {
		return districtNum;
	}

	public void setDistrictNum(int districtNum) {
		this.districtNum = districtNum;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	

}
