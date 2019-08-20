package board.model.vo;

import java.sql.Date;

public class Board {
	private int bId; //게시글 고유번호
	private int btype; //게시글 타입(1.일반게시판,2.사진게시판)
	private String cName; //게시글 분류(공통,운동,등산,게임 낚시, 요리,기타)
	private String bTitle;//게시글 제목
	private String bContent;//게시글 본문
	private String userName;//작성자
	private int bCount;//조회수
	private Date createDate;//생성일
	private Date modifyDate;//수정일
	private String status;//상태
	public Board(int bId, int btype, String cName, String bTitle, String bContent, String userName, int bCount,
			Date createDate, Date modifyDate, String status) {
		this.bId = bId;
		this.btype = btype;
		this.cName = cName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.userName = userName;
		this.bCount = bCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public Board() {
		super();
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Board [bId=" + bId + ", btype=" + btype + ", cName=" + cName + ", bTitle=" + bTitle + ", bContent="
				+ bContent + ", userName=" + userName + ", bCount=" + bCount + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
	
}
