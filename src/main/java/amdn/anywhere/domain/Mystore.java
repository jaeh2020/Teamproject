package amdn.anywhere.domain;

public class Mystore {
	private String storeCode;
	private String storeLocation;
	private String bizCode;
	private String storeName;
	private String mainCateCode;
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mystore [storeCode=");
		builder.append(storeCode);
		builder.append(", storeLocation=");
		builder.append(storeLocation);
		builder.append(", bizCode=");
		builder.append(bizCode);
		builder.append(", storeName=");
		builder.append(storeName);
		builder.append(", mainCateCode=");
		builder.append(mainCateCode);
		builder.append("]");
		return builder.toString();
	}
	
}
