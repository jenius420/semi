package photo.model.vo;

public class Photo {
	
	private int oNum;	//사업자회원번호
	private int saveName;	//저장될사진 이름 및 경로
	
	
	public Photo() {
		super();
	}


	public Photo(int oNum, int saveName) {
		super();
		this.oNum = oNum;
		this.saveName = saveName;
	}


	public int getoNum() {
		return oNum;
	}


	public void setoNum(int oNum) {
		this.oNum = oNum;
	}


	public int getSaveName() {
		return saveName;
	}


	public void setSaveName(int saveName) {
		this.saveName = saveName;
	}


	@Override
	public String toString() {
		return "Photo [oNum=" + oNum + ", saveName=" + saveName + "]";
	}
	
	

}
