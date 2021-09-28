package amdn.anywhere.domain;

public class Mystore {
	private String storeCode;
	private String salesName;
	private String salesPrice;
	private String salesRegTime;
	private String closeTime;
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	public String getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getSalesRegTime() {
		return salesRegTime;
	}
	public void setSalesRegTime(String salesRegTime) {
		this.salesRegTime = salesRegTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sales [storeCode=");
		builder.append(storeCode);
		builder.append(", salesName=");
		builder.append(salesName);
		builder.append(", salesPrice=");
		builder.append(salesPrice);
		builder.append(", salesRegTime=");
		builder.append(salesRegTime);
		builder.append(", closeTime=");
		builder.append(closeTime);
		builder.append("]");
		return builder.toString();
	}
	
}
