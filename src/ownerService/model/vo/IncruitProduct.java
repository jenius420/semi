package ownerService.model.vo;

public class IncruitProduct {
	
	private int pCode;
	private String pTitle;
	private String pExplain;
	private int pPay;
	
	public IncruitProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncruitProduct(int pCode, String pTitle, String pExplain, int pPay) {
		super();
		this.pCode = pCode;
		this.pTitle = pTitle;
		this.pExplain = pExplain;
		this.pPay = pPay;
	}
	
	public IncruitProduct(String pTitle, String pExplain, int pPay) {
		super();
		this.pTitle = pTitle;
		this.pExplain = pExplain;
		this.pPay = pPay;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpExplain() {
		return pExplain;
	}

	public void setpExplain(String pExplain) {
		this.pExplain = pExplain;
	}

	public int getpPay() {
		return pPay;
	}

	public void setpPay(int pPay) {
		this.pPay = pPay;
	}
	
	

}
