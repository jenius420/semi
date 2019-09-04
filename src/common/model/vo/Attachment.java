package common.model.vo;

public class Attachment {
	
	private int fId;
	private String originName;
	private String changeName;
	private String filePath;
	private String status;
	private int rNum;
	private int wNum;
	private int tNum;
	
	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fId, String originName, String changeName, String filePath, String status, int rNum,
			int wNum) {
		super();
		this.fId = fId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.status = status;
		this.rNum = rNum;
		this.wNum = wNum;
	}
	
	

	public Attachment(int fId, String originName, String changeName, String filePath, String status, int tNum) {
		super();
		this.fId = fId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.status = status;
		this.tNum = tNum;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getwNum() {
		return wNum;
	}

	public void setwNum(int wNum) {
		this.wNum = wNum;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	@Override
	public String toString() {
		return "Attachment [fId=" + fId + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", status=" + status + ", rNum=" + rNum + ", wNum=" + wNum + ", tNum=" + tNum + "]";
	}

	
	
	
}
