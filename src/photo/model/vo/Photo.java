package photo.model.vo;

public class Photo {
	
	
	private int wNum;	//글번호
	private String wTitle;	// 제목
	private String saveName;	//사진
	
	public Photo() {
		super();
	}

	public Photo(int wNum, String wTitle, String saveName) {
		super();
		this.wNum = wNum;
		this.wTitle = wTitle;
		this.saveName = saveName;
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
		return "Photo [wNum=" + wNum + ", wTitle=" + wTitle + ", saveName=" + saveName + "]";
	}
	
	

}
