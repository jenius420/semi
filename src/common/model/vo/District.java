package common.model.vo;

public class District {
	
	private int districtNum;
	private String districtName;
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District(int districtNum, String districtName) {
		super();
		this.districtNum = districtNum;
		this.districtName = districtName;
	}
	public int getDistrictNum() {
		return districtNum;
	}
	public void setDistrictNum(int districtNum) {
		this.districtNum = districtNum;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	

}
