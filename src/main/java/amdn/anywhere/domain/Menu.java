package amdn.anywhere.domain;

import java.util.Date;

public class Menu {
	private String menuCode;
	private String bizCode;
	private String bizId;
	private String storeCode;
	private String mainCateCode;
	private String manuCateCode;
	private String menuName;
	private String menuPrice;
	private String menuDetail;
	private Date menuRegTime;
	private String menuUsing;
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMainCateCode() {
		return mainCateCode;
	}
	public void setMainCateCode(String mainCateCode) {
		this.mainCateCode = mainCateCode;
	}
	public String getManuCateCode() {
		return manuCateCode;
	}
	public void setManuCateCode(String manuCateCode) {
		this.manuCateCode = manuCateCode;
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
	public String getMenuDetail() {
		return menuDetail;
	}
	public void setMenuDetail(String menuDetail) {
		this.menuDetail = menuDetail;
	}
	public Date getMenuRegTime() {
		return menuRegTime;
	}
	public void setMenuRegTime(Date menuRegTime) {
		this.menuRegTime = menuRegTime;
	}
	public String getMenuUsing() {
		return menuUsing;
	}
	public void setMenuUsing(String menuUsing) {
		this.menuUsing = menuUsing;
	}
	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", bizCode=" + bizCode + ", bizId=" + bizId + ", storeCode=" + storeCode
				+ ", mainCateCode=" + mainCateCode + ", manuCateCode=" + manuCateCode + ", menuName=" + menuName
				+ ", menuPrice=" + menuPrice + ", menuDetail=" + menuDetail + ", menuRegTime=" + menuRegTime
				+ ", menuUsing=" + menuUsing + "]";
	}
	
	
}
