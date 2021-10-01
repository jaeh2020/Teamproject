package amdn.anywhere.domain;

import java.util.Date;

public class Order {
	private String oCode;
	private String bookCode;
	private String userId;
	private String storeCode;
	private String menuCode;
	private int oCount;
	private int menuTotalPrice;
	private String oRequest;
	private String payGroCode;
	private int oTotalPrice;
	private Date orderSignTime;
	private Date orderCompTime;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getMenuTotalPrice() {
		return menuTotalPrice;
	}
	public void setMenuTotalPrice(int menuTotalPrice) {
		this.menuTotalPrice = menuTotalPrice;
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
	public int getoTotalPrice() {
		return oTotalPrice;
	}
	public void setoTotalPrice(int oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}
	public Date getOrderSignTime() {
		return orderSignTime;
	}
	public void setOrderSignTime(Date orderSignTime) {
		this.orderSignTime = orderSignTime;
	}
	public Date getOrderCompTime() {
		return orderCompTime;
	}
	public void setOrderCompTime(Date orderCompTime) {
		this.orderCompTime = orderCompTime;
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
		return "Order [oCode=" + oCode + ", bookCode=" + bookCode + ", userId=" + userId + ", storeCode=" + storeCode
				+ ", menuCode=" + menuCode + ", oCount=" + oCount + ", menuTotalPrice=" + menuTotalPrice + ", oRequest="
				+ oRequest + ", payGroCode=" + payGroCode + ", oTotalPrice=" + oTotalPrice + ", orderSignTime="
				+ orderSignTime + ", orderCompTime=" + orderCompTime + ", orderStateCode=" + orderStateCode
				+ ", storeTableCode=" + storeTableCode + ", tabelStateCode=" + tabelStateCode + "]";
	}

	
}