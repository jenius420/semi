package board.model.vo;

import java.sql.Date;

public class Board {
	
	private int tNum;
	private String title;
	private int eNum;
	private String eName;
	private Date updateDate;
	private String bBody;
	private String invalidPost;
	private String isNotice;
	private int boardCount;
	private String photo;
	
	public Board() {
		super();
		
	}

	public Board(int tNum, String title, int eNum, String eName, Date updateDate, String bBody, String invalidPost,
			String isNotice, int boardCount) {
		super();
		this.tNum = tNum;
		this.title = title;
		this.eNum = eNum;
		this.eName = eName;
		this.updateDate = updateDate;
		this.bBody = bBody;
		this.invalidPost = invalidPost;
		this.isNotice = isNotice;
		this.boardCount = boardCount;
	}
	
	
	
	
	

	public Board(int tNum, String title, int eNum, String eName, Date updateDate, String bBody, String invalidPost,
			String isNotice, int boardCount, String photo) {
		super();
		this.tNum = tNum;
		this.title = title;
		this.eNum = eNum;
		this.eName = eName;
		this.updateDate = updateDate;
		this.bBody = bBody;
		this.invalidPost = invalidPost;
		this.isNotice = isNotice;
		this.boardCount = boardCount;
		this.photo = photo;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getbBody() {
		return bBody;
	}

	public void setbBody(String bBody) {
		this.bBody = bBody;
	}

	public String getInvalidPost() {
		return invalidPost;
	}

	public void setInvalidPost(String invalidPost) {
		this.invalidPost = invalidPost;
	}

	public String getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	
	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Board [tNum=" + tNum + ", title=" + title + ", eNum=" + eNum + ", eName=" + eName + ", updateDate="
				+ updateDate + ", bBody=" + bBody + ", invalidPost=" + invalidPost + ", isNotice=" + isNotice
				+ ", boardCount=" + boardCount + ", photo=" + photo + "]";
	}

}

	