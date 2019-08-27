package main.model.vo;

public class Main {

	private int onum;				// ����� ȸ����ȣ
	private int opnum;				// ����� ��ȣ
	private String opname;			// ����� �̸�
	private int dongnum;			// ����� ����ȣ
	private String dongname;		// ����� ���̸�
	private String opaddress;		// ����� ������ �ּ�
	private int typenum;			// ��������ȣ
	private String typename;		// ��������
	private String applyproduct;	// ���� ��ǰ�ڵ�
	private int pnum;				// ���� �⺻Ű
	private String saveName; 		// ����� ���� �̸� �� ���
	
	
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
