package common.model.vo;

public class JobType {
	
	private int typeNum;
	private String typeName;
	private String categoryName;
	public JobType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobType(int typeNum, String typeName, String categoryName) {
		super();
		this.typeNum = typeNum;
		this.typeName = typeName;
		this.categoryName = categoryName;
	}
	public int getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
