package amdn.anywhere.domain;

public class FoodMainCate {
	
	private String mainCateCode;
	private String mainCateName;
	private Store store;
	public String getMainCateCode() {
		return mainCateCode;
	}
	public void setMainCateCode(String mainCateCode) {
		this.mainCateCode = mainCateCode;
	}
	public String getMainCateName() {
		return mainCateName;
	}
	public void setMainCateName(String mainCateName) {
		this.mainCateName = mainCateName;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "FoodMainCate [mainCateCode=" + mainCateCode + ", mainCateName=" + mainCateName + ", store=" + store
				+ "]";
	}
	
	
	

}
