package amdn.anywhere.domain;

public class Mystore {
	private String storeCode;
	private String storeLocation;
	private String bizCode;
	private String storeName;
	private String mainCateCode;
	private String menuName;
	private String menuCode;
	private String menuPrice;
	private String month;
	private String expenseItem;
	private String expenseDetail;
	private String expensePrice;
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public String getExpenseItem() {
		return expenseItem;
	}
	public void setExpenseItem(String expenseItem) {
		this.expenseItem = expenseItem;
	}
	public String getExpenseDetail() {
		return expenseDetail;
	}
	public void setExpenseDetail(String expenseDetail) {
		this.expenseDetail = expenseDetail;
	}
	public String getExpensePrice() {
		return expensePrice;
	}
	public void setExpensePrice(String expensePrice) {
		this.expensePrice = expensePrice;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getMainCateCode() {
		return mainCateCode;
	}
	public void setMainCateCode(String mainCateCode) {
		this.mainCateCode = mainCateCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Mystore [storeCode=" + storeCode + ", storeLocation=" + storeLocation + ", bizCode=" + bizCode
				+ ", storeName=" + storeName + ", mainCateCode=" + mainCateCode + ", menuName=" + menuName
				+ ", menuCode=" + menuCode + ", menuPrice=" + menuPrice + ", month=" + month + ", expenseItem="
				+ expenseItem + ", expenseDetail=" + expenseDetail + ", expensePrice=" + expensePrice + "]";
	}
	
}
