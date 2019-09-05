package member.model.vo;

public class Category {

	private String bigCategory;
	private String subCategory;
	public Category(String bigCategory, String subCategory) {
		this.bigCategory = bigCategory;
		this.subCategory = subCategory;
	}
	public Category() {
		super();
	}
	
	public String getBigCategory() {
		return bigCategory;
	}
	public void setBigCategory(String bigCategory) {
		this.bigCategory = bigCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "Category [bigCategory=" + bigCategory + ", subCategory=" + subCategory + "]";
	}
	
	
}
