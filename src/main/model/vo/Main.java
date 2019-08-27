package main.model.vo;

public class Main {

	private int onum;				// 사업자 회원번호
	private int opnum;				// 사업장 번호
	private String opname;			// 사업장 이름
	private int dongnum;			// 사업장 동번호
	private String dongname;		// 사업장 동이름
	private String opaddress;		// 사업장 나머지 주소
	private int typenum;			// 업직종번호
	private String typename;		// 업직종명
	private String applyproduct;	// 적용 상품코드
	private int pnum;				// 사진 기본키
	private String saveName; 		// 저장될 사진 이름 및 경로
	
	
	public Main() {}


	public Main(int onum, int opnum, String opname, int dongnum, String dongname, String opaddress, int typenum,
			String typename, String applyproduct, int pnum, String saveName) {
		super();
		this.onum = onum;
		this.opnum = opnum;
		this.opname = opname;
		this.dongnum = dongnum;
		this.dongname = dongname;
		this.opaddress = opaddress;
		this.typenum = typenum;
		this.typename = typename;
		this.applyproduct = applyproduct;
		this.pnum = pnum;
		this.saveName = saveName;
	}


	public int getOnum() {
		return onum;
	}


	public void setOnum(int onum) {
		this.onum = onum;
	}


	public int getOpnum() {
		return opnum;
	}


	public void setOpnum(int opnum) {
		this.opnum = opnum;
	}


	public String getOpname() {
		return opname;
	}


	public void setOpname(String opname) {
		this.opname = opname;
	}


	public int getDongnum() {
		return dongnum;
	}


	public void setDongnum(int dongnum) {
		this.dongnum = dongnum;
	}


	public String getDongname() {
		return dongname;
	}


	public void setDongname(String dongname) {
		this.dongname = dongname;
	}


	public String getOpaddress() {
		return opaddress;
	}


	public void setOpaddress(String opaddress) {
		this.opaddress = opaddress;
	}


	public int getTypenum() {
		return typenum;
	}


	public void setTypenum(int typenum) {
		this.typenum = typenum;
	}


	public String getTypename() {
		return typename;
	}


	public void setTypename(String typename) {
		this.typename = typename;
	}


	public String getApplyproduct() {
		return applyproduct;
	}


	public void setApplyproduct(String applyproduct) {
		this.applyproduct = applyproduct;
	}


	public int getPnum() {
		return pnum;
	}


	public void setPnum(int pnum) {
		this.pnum = pnum;
	}


	public String getSaveName() {
		return saveName;
	}


	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}


	@Override
	public String toString() {
		return "Main [onum=" + onum + ", opnum=" + opnum + ", opname=" + opname + ", dongnum=" + dongnum + ", dongname="
				+ dongname + ", opaddress=" + opaddress + ", typenum=" + typenum + ", typename=" + typename
				+ ", applyproduct=" + applyproduct + ", pnum=" + pnum + ", saveName=" + saveName + "]";
	}
	
	
	

	
}
