package empService.model.vo;

public class HopeEnt {
	
	private int hNum;
	private int eNum;
	private int oNum;
	private String opName;
	private String phone;
	private String opAddress;
	private String type;
	private String deleteornot;
	
	public HopeEnt() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HopeEnt(int hNum, int eNum, int oNum, String opName, String phone, String opAddress, String type,
			String deleteornot) {
		super();
		this.hNum = hNum;
		this.eNum = eNum;
		this.oNum = oNum;
		this.opName = opName;
		this.phone = phone;
		this.opAddress = opAddress;
		this.type = type;
		this.deleteornot = deleteornot;
	}



	public int gethNum() {
		return hNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOpAddress() {
		return opAddress;
	}

	public void setOpAddress(String opAddress) {
		this.opAddress = opAddress;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeleteornot() {
		return deleteornot;
	}

	public void setDeleteornot(String deleteornot) {
		this.deleteornot = deleteornot;
	}
	
	
	

}
