package sort.model.vo;

import java.sql.Date;

public class Recruit {
	
	// 구인글
	private int rNum;		// 구인글 번호
	private String area;	// 구인 지역
	private String corName;	// 기업명
	private String title;	// 모집제목
	private String workform;// 급여형태(시급,일급,월급,연봉)
	private int salary;		// 급여
	private String time;	// 근무시간
	private Date enDate;	// 등록일
	
	
	public Recruit() {
		super();
	}


	public Recruit(int rNum, String area, String corName, String title, String workform, int salary, String time,
			Date enDate) {
		super();
		this.rNum = rNum;
		this.area = area;
		this.corName = corName;
		this.title = title;
		this.workform = workform;
		this.salary = salary;
		this.time = time;
		this.enDate = enDate;
	}


	public int getrNum() {
		return rNum;
	}


	public void setrNum(int rNum) {
		this.rNum = rNum;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCorName() {
		return corName;
	}


	public void setCorName(String corName) {
		this.corName = corName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWorkform() {
		return workform;
	}


	public void setWorkform(String workform) {
		this.workform = workform;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public Date getEnDate() {
		return enDate;
	}


	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}


	@Override
	public String toString() {
		return "Recruit [rNum=" + rNum + ", area=" + area + ", corName=" + corName + ", title=" + title + ", workform="
				+ workform + ", salary=" + salary + ", time=" + time + ", enDate=" + enDate + "]";
	}
	
	
	
}
