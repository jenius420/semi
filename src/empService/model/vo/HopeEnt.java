package empService.model.vo;

public class HopeEnt {
	
	private int hNum;
	private int eNum;
	private int oNum;
	private String opName;
	private String phone;
	private String type;
	private String category;
	private String deleteornot;
	private String district;
	private String dong;
	private String roadName;
	private String opAddress;
	
	public HopeEnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HopeEnt(int hNum, int eNum, int oNum, String opName, String phone, String district, String dong,
			String opAddress, String type, String category, String deleteornot) {
		super();
		this.hNum = hNum;
		this.eNum = eNum;
		this.oNum = oNum;
		this.opName = opName;
		this.phone = phone;
		this.district = district;
		this.dong = dong;
		this.opAddress = opAddress;
		this.type = type;
		this.category = category;
		this.deleteornot = deleteornot;
	}

	
	
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public int gethNum() {
		return hNum;
	}

	public void sethNum(int hNum) {
		this.hNum = hNum;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getOpAddress() {
		return opAddress;
	}

	public void setOpAddress(String opAddress) {
		this.opAddress = opAddress;
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

	public String getDeleteornot() {
		return deleteornot;
	}

	public void setDeleteornot(String deleteornot) {
		this.deleteornot = deleteornot;
	}

	
	

}
