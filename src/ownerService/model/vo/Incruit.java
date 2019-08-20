package ownerService.model.vo;

import java.sql.Date;

public class Incruit {
	
	private int wNum; // KEY
	private String wTitle; // 제목
	private int oNum; // 사업자KEY
	private String opName; // 사업장명+
	private Date workStartTerm; // 시작일
	private Date workEndTerm; // 종료일
	private String workDay; // 근무요일
	private String workStartTime; // 시작시간
	private String workEndTime; // 종료시간
	private String termName; // 근무기간+
	private String gender; // 성별
	private int age; // 나이
	private String edu; // 학력
	private Date enrollDate; // 등록일
	private String status; // 진행중/마감
	private Date doneDate; // 마감일
	private String salaryForm; // 급여형태
	private int salary; // 급여
	private int pNum; // 상품코드
	private String product; // 상품명+
	private String description; // 상세내역
	
	public Incruit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Incruit(int wNum, String wTitle, int oNum, String opName, Date workStartTerm, Date workEndTerm,
			String workDay, String workStartTime, String workEndTime, String termName, String gender, int age,
			String edu, Date enrollDate, String status, Date doneDate, String salaryForm, int salary, int pNum,
			String product, String description) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.oNum = oNum;
		this.opName = opName;
		this.workStartTerm = workStartTerm;
		this.workEndTerm = workEndTerm;
		this.workDay = workDay;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
		this.termName = termName;
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

	public Date getWorkStartTerm() {
		return workStartTerm;
	}

	public void setWorkStartTerm(Date workStartTerm) {
		this.workStartTerm = workStartTerm;
	}

	public Date getWorkEndTerm() {
		return workEndTerm;
	}

	public void setWorkEndTerm(Date workEndTerm) {
		this.workEndTerm = workEndTerm;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	
	
	
	

}
