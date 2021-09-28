package amdn.anywhere.domain;

public class Order {
	private String oCode;
	private String bookCode;
	private String storeCode;
	private String menuCode;
	private int oCount;
	private String oRequest;
	private String payGroCode;
	private String oTotalPrice;
	private String bookSignTime;
	private String bookCompTime;
	private String orderStateCode;
	private String storeTableCode;
	private String tabelStateCode;
	public String getoCode() {
		return oCode;
	}
	public void setoCode(String oCode) {
		this.oCode = oCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public int getoCount() {
		return oCount;
	}
	public void setoCount(int oCount) {
		this.oCount = oCount;
	}
	public String getoRequest() {
		return oRequest;
	}
	public void setoRequest(String oRequest) {
		this.oRequest = oRequest;
	}
	public String getPayGroCode() {
		return payGroCode;
	}
	public void setPayGroCode(String payGroCode) {
		this.payGroCode = payGroCode;
	}
	public String getoTotalPrice() {
		return oTotalPrice;
	}
	public void setoTotalPrice(String oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}
	public String getBookSignTime() {
		return bookSignTime;
	}
	public void setBookSignTime(String bookSignTime) {
		this.bookSignTime = bookSignTime;
	}
	public String getBookCompTime() {
		return bookCompTime;
	}
	public void setBookCompTime(String bookCompTime) {
		this.bookCompTime = bookCompTime;
	}
	public String getOrderStateCode() {
		return orderStateCode;
	}
	public void setOrderStateCode(String orderStateCode) {
		this.orderStateCode = orderStateCode;
	}
	public String getStoreTableCode() {
		return storeTableCode;
	}
	public void setStoreTableCode(String storeTableCode) {
		this.storeTableCode = storeTableCode;
	}
	public String getTabelStateCode() {
		return tabelStateCode;
	}
	public void setTabelStateCode(String tabelStateCode) {
		this.tabelStateCode = tabelStateCode;
	}
	@Override
	public String toString() {
		return "Order [oCode=" + oCode + ", bookCode=" + bookCode
				+ ", storeCode=" + storeCode + ", menuCode=" + menuCode + ", oCount=" + oCount + ", oRequest="
				+ oRequest + ", payGroCode=" + payGroCode + ", oTotalPrice=" + oTotalPrice + ", bookSignTime="
				+ bookSignTime + ", bookCompTime=" + bookCompTime + ", orderStateCode=" + orderStateCode
				+ ", storeTableCode=" + storeTableCode + ", tabelStateCode=" + tabelStateCode + "]";
	}
	
	
	

}
