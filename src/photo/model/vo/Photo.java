package photo.model.vo;

public class Photo {
	
	
	private int wNum;	//글번호
	private String wTitle;	// 제목
	private String saveName;//사진
	private int eNum;	//회원번호
	private int oNum;	//사업자번호
	
	public Photo() {
		super();
	}
	
	


	public Photo(int wNum, String wTitle, String saveName, int eNum, int oNum) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.saveName = saveName;
		this.eNum = eNum;
		this.oNum = oNum;
	}




	public Photo(int wNum, String wTitle, String saveName,int oNum) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.saveName = saveName;
		this.oNum = oNum;
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

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	@Override
	public String toString() {
		return "Photo [wNum=" + wNum + ", wTitle=" + wTitle + ", saveName=" + saveName + ", eNum=" + eNum + ", oNum="
				+ oNum + "]";
	}
	
	

}
