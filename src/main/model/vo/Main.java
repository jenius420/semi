package main.model.vo;

public class Main {

	private int wNum;
	private String wTitle;
	private String oName;
	private int districnum;
	private String districtname;
	private int dongnum;
	private String dongName;
	private String logo;
	
	public Main() {}

	public Main(int wNum, String wTitle, String oName, int districnum, String districtname, int dongnum,
			String dongName, String logo) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.oName = oName;
		this.districnum = districnum;
		this.districtname = districtname;
		this.dongnum = dongnum;
		this.dongName = dongName;
		this.logo = logo;
	}
	

	public Main(String logo, String wTitle) {
		super();
		this.logo = logo;
		this.wTitle = wTitle;
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

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public int getDistricnum() {
		return districnum;
	}

	public void setDistricnum(int districnum) {
		this.districnum = districnum;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public int getDongnum() {
		return dongnum;
	}

	public void setDongnum(int dongnum) {
		this.dongnum = dongnum;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Main [wNum=" + wNum + ", wTitle=" + wTitle + ", oName=" + oName + ", districnum=" + districnum
				+ ", districtname=" + districtname + ", dongnum=" + dongnum + ", dongName=" + dongName + ", logo="
				+ logo + "]";
	}
	
	
	
	
}
