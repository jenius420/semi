package search.model.vo;

public class OPhoto {
	private int pNum;
	private String saveName;
	private int oNum;
	private String validPhoto;
	private int wNum;
	public OPhoto(int pNum, String saveName, String validPhoto, int wNum) {
		this.pNum = pNum;
		this.saveName = saveName;
		this.validPhoto = validPhoto;
		this.wNum = wNum;
	}
	public int getwNum() {
		return wNum;
	}
	public void setwNum(int wNum) {
		this.wNum = wNum;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
	}
	public String getValidPhoto() {
		return validPhoto;
	}
	public void setValidPhoto(String validPhoto) {
		this.validPhoto = validPhoto;
	}
	public OPhoto(int pNum, String saveName, int oNum, String validPhoto) {
		super();
		this.pNum = pNum;
		this.saveName = saveName;
		this.oNum = oNum;
		this.validPhoto = validPhoto;
	}
	public OPhoto() {
	}
	@Override
	public String toString() {
		return "OPhoto [pNum=" + pNum + ", saveName=" + saveName + ", oNum=" + oNum + ", validPhoto=" + validPhoto
				+ "]";
	}
	
	
	
}
