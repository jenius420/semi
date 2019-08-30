package ownerService.model.vo;

public class Owner {
	
	private int oNum;
	private String oId;
	private String oPwd;
	private String opName;
	private int opNum;
	private int dongNum;
	private String dongName;
	private int dongMain;
	private int dongSub;
	private int roadNum;
	private String roadName;
	private int roadMain;
	private int roadSub;
	private int districtNum;
	private String district;
	private String opAddress;
	private String oName;
	private String oTel;
	private String ocNum;
	private String phone;
	private String email;
	private int typeNum;
	private String type;
	private String category;
	private String mailAccept;
	private String smsAccept;
	private String invalidId;
	private String checkONum;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	



	public Owner(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, String dongName,
			int dongMain, int dongSub, int roadNum, String roadName, int roadMain, int roadSub, int districtNum,
			String district, String opAddress, String oName, String oTel, String ocNum, String phone, String email,
			int typeNum, String type, String category, String mailAccept, String smsAccept, String invalidId,
			String checkONum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.dongName = dongName;
		this.dongMain = dongMain;
		this.dongSub = dongSub;
		this.roadNum = roadNum;
		this.roadName = roadName;
		this.roadMain = roadMain;
		this.roadSub = roadSub;
		this.districtNum = districtNum;
		this.district = district;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.type = type;
		this.category = category;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.checkONum = checkONum;
	}






	public Owner(int oNum, String oId, String oPwd, String opName, int opNum, int dongNum, int roadNum,
			String opAddress, String oName, String oTel, String ocNum, String phone, String email, int typeNum,
			String mailAccept, String smsAccept, String invalidId, String checkONum) {
		super();
		this.oNum = oNum;
		this.oId = oId;
		this.oPwd = oPwd;
		this.opName = opName;
		this.opNum = opNum;
		this.dongNum = dongNum;
		this.roadNum = roadNum;
		this.opAddress = opAddress;
		this.oName = oName;
		this.oTel = oTel;
		this.ocNum = ocNum;
		this.phone = phone;
		this.email = email;
		this.typeNum = typeNum;
		this.mailAccept = mailAccept;
		this.smsAccept = smsAccept;
		this.invalidId = invalidId;
		this.checkONum = checkONum;
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






	public String getDongName() {
		return dongName;
	}



	public void setDongName(String dongName) {
		this.dongName = dongName;
	}



	public int getDongMain() {
		return dongMain;
	}



	public void setDongMain(int dongMain) {
		this.dongMain = dongMain;
	}



	public int getDongSub() {
		return dongSub;
	}



	public void setDongSub(int dongSub) {
		this.dongSub = dongSub;
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



	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getoPwd() {
		return oPwd;
	}

	public void setoPwd(String oPwd) {
		this.oPwd = oPwd;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public int getOpNum() {
		return opNum;
	}

	public void setOpNum(int opNum) {
		this.opNum = opNum;
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

	public String getOcNum() {
		return ocNum;
	}

	public void setOcNum(String ocNum) {
		this.ocNum = ocNum;
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

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
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

	public String getInvalidId() {
		return invalidId;
	}

	public void setInvalidId(String invalidId) {
		this.invalidId = invalidId;
	}

	public String getCheckONum() {
		return checkONum;
	}

	public void setCheckONum(String checkONum) {
		this.checkONum = checkONum;
	}

	
	

}
