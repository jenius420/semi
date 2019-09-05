package search.model.vo;

import java.sql.Date;

public class IncruitInfo {
	private int num;
	private String title;
	private String roadName;
	private int roadMain;
	private int roadSub;
	private String districtName;
	private String typeName;
	private String categoryName;
	private String logoSaveName;
	private String pValid;
	private String workDay;
	private String workTime;
	private String workGender;
	private String workAge;
	private String workEdu;
	private Date startDate;
	private Date endDate;
	private String iStatus;
	private String workForm;
	private int salary;
	private int applyProduct;
	private String rExplain;
	private String peopleCount;
	private String opName;
	private String opAddress;
	private String oName;
	private String oTel;
	private String oPhone;
	private String email;
	private String totalInfo;
	private String termName;
	private String termBigName;
	private int oNum;
	public IncruitInfo(int num, String title, String roadName, int roadMain, int roadSub, String districtName,
			String typeName, String categoryName, String logoSaveName, String pValid, String workDay, String workTime,
			String workGender, String workAge, String workEdu, Date startDate, Date endDate, String iStatus,
			String workForm, int salary, int applyProduct, String rExplain, String peopleCount, String opName,
			String opAddress, String oName, String oTel, String oPhone, String email, String totalInfo, String termName,
			String termBigName, int oNum) {
		this.num = num;
		this.title = title;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.districtName = districtName;
		this.typeName = typeName;
		this.categoryName = categoryName;
		this.logoSaveName = logoSaveName;
		this.pValid = pValid;
		this.workDay = workDay;
		this.workTime = workTime;
		this.workGender = workGender;
		this.workAge = workAge;
		this.workEdu = workEdu;
		this.startDate = startDate;
		this.endDate = endDate;
		this.iStatus = iStatus;
		this.workForm = workForm;
		this.salary = salary;
		this.applyProduct = applyProduct;
		this.rExplain = rExplain;
		this.peopleCount = peopleCount;
		this.opName = opName;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.oPhone = oPhone;
		this.email = email;
		this.totalInfo = totalInfo;
		this.termName = termName;
		this.termBigName = termBigName;
		this.oNum = oNum;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
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
	public IncruitInfo(int num, String title, String roadName, int roadMain, int roadSub, String districtName,
			String typeName, String categoryName, String logoSaveName, String pValid, String workDay, String workTime,
			String workGender, String workAge, String workEdu, Date startDate, Date endDate, String iStatus,
			String workForm, int salary, int applyProduct, String rExplain, String peopleCount, String opName,
			String opAddress, String oName, String oTel, String oPhone, String email, String totalInfo, String termName,
			String termBigName) {
		super();
		this.num = num;
		this.title = title;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.districtName = districtName;
		this.typeName = typeName;
		this.categoryName = categoryName;
		this.logoSaveName = logoSaveName;
		this.pValid = pValid;
		this.workDay = workDay;
		this.workTime = workTime;
		this.workGender = workGender;
		this.workAge = workAge;
		this.workEdu = workEdu;
		this.startDate = startDate;
		this.endDate = endDate;
		this.iStatus = iStatus;
		this.workForm = workForm;
		this.salary = salary;
		this.applyProduct = applyProduct;
		this.rExplain = rExplain;
		this.peopleCount = peopleCount;
		this.opName = opName;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.oPhone = oPhone;
		this.email = email;
		this.totalInfo = totalInfo;
		this.termName = termName;
		this.termBigName = termBigName;
	}
	public IncruitInfo() {
	}
	public IncruitInfo(int num, String title, String roadName, int roadMain, int roadSub, String districtName,
			String typeName, String categoryName, String logoSaveName, String pValid, String workDay, String workTime,
			String workGender, String workAge, String workEdu, Date startDate, Date endDate, String iStatus,
			String workForm, int salary, int applyProduct, String rExplain, String peopleCount, String opName,
			String opAddress, String oName, String oTel, String oPhone, String email, String totalInfo) {
		this.num = num;
		this.title = title;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.districtName = districtName;
		this.typeName = typeName;
		this.categoryName = categoryName;
		this.logoSaveName = logoSaveName;
		this.pValid = pValid;
		this.workDay = workDay;
		this.workTime = workTime;
		this.workGender = workGender;
		this.workAge = workAge;
		this.workEdu = workEdu;
		this.startDate = startDate;
		this.endDate = endDate;
		this.iStatus = iStatus;
		this.workForm = workForm;
		this.salary = salary;
		this.applyProduct = applyProduct;
		this.rExplain = rExplain;
		this.peopleCount = peopleCount;
		this.opName = opName;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.oPhone = oPhone;
		this.email = email;
		this.totalInfo = totalInfo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getLogoSaveName() {
		return logoSaveName;
	}
	public void setLogoSaveName(String logoSaveName) {
		this.logoSaveName = logoSaveName;
	}
	public String getpValid() {
		return pValid;
	}
	public void setpValid(String pValid) {
		this.pValid = pValid;
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
	public String getWorkGender() {
		return workGender;
	}
	public void setWorkGender(String workGender) {
		this.workGender = workGender;
	}
	public String getWorkAge() {
		return workAge;
	}
	public void setWorkAge(String workAge) {
		this.workAge = workAge;
	}
	public String getWorkEdu() {
		return workEdu;
	}
	public void setWorkEdu(String workEdu) {
		this.workEdu = workEdu;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getiStatus() {
		return iStatus;
	}
	public void setiStatus(String iStatus) {
		this.iStatus = iStatus;
	}
	public String getWorkForm() {
		return workForm;
	}
	public void setWorkForm(String workForm) {
		this.workForm = workForm;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getApplyProduct() {
		return applyProduct;
	}
	public void setApplyProduct(int applyProduct) {
		this.applyProduct = applyProduct;
	}
	public String getrExplain() {
		return rExplain;
	}
	public void setrExplain(String rExplain) {
		this.rExplain = rExplain;
	}
	public String getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(String peopleCount) {
		this.peopleCount = peopleCount;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
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
	public String getoPhone() {
		return oPhone;
	}
	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalInfo() {
		return totalInfo;
	}
	public void setTotalInfo(String totalInfo) {
		this.totalInfo = totalInfo;
	}
	@Override
	public String toString() {
		return "IncruitInfo [num=" + num + ", title=" + title + ", roadName=" + roadName + ", roadMain=" + roadMain
				+ ", roadSub=" + roadSub + ", districtName=" + districtName + ", typeName=" + typeName
				+ ", categoryName=" + categoryName + ", logoSaveName=" + logoSaveName + ", pValid=" + pValid
				+ ", workDay=" + workDay + ", workTime=" + workTime + ", workGender=" + workGender + ", workAge="
				+ workAge + ", workEdu=" + workEdu + ", startDate=" + startDate + ", endDate=" + endDate + ", iStatus="
				+ iStatus + ", workForm=" + workForm + ", salary=" + salary + ", applyProduct=" + applyProduct
				+ ", rExplain=" + rExplain + ", peopleCount=" + peopleCount + ", opName=" + opName + ", opAddress="
				+ opAddress + ", oName=" + oName + ", oTel=" + oTel + ", oPhone=" + oPhone + ", email=" + email
				+ ", totalInfo=" + totalInfo + ", termName=" + termName + ", termBigName=" + termBigName + "]";
	}
	
	
}
