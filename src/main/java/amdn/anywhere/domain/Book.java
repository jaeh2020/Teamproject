package amdn.anywhere.domain;

import java.util.Date;

public class Book {
	private String bookCode;
	private String storeCode;
	private String userId;
	private String bookUserName;
	private String bookUserPhone;
	private int bookPeoNum;
	private Date bookSignTime;
	private Date bookCompTime;
	private String bookCallAgree;
	private String stateCode;
	private String bookPickup;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookUserName() {
		return bookUserName;
	}
	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}
	public String getBookUserPhone() {
		return bookUserPhone;
	}
	public void setBookUserPhone(String bookUserPhone) {
		this.bookUserPhone = bookUserPhone;
	}
	public int getBookPeoNum() {
		return bookPeoNum;
	}
	public void setBookPeoNum(int bookPeoNum) {
		this.bookPeoNum = bookPeoNum;
	}
	public Date getBookSignTime() {
		return bookSignTime;
	}
	public void setBookSignTime(Date bookSignTime) {
		this.bookSignTime = bookSignTime;
	}
	public Date getBookCompTime() {
		return bookCompTime;
	}
	public void setBookCompTime(Date bookCompTime) {
		this.bookCompTime = bookCompTime;
	}
	public String getBookCallAgree() {
		return bookCallAgree;
	}
	public void setBookCallAgree(String bookCallAgree) {
		this.bookCallAgree = bookCallAgree;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getBookPickup() {
		return bookPickup;
	}
	public void setBookPickup(String bookPickup) {
		this.bookPickup = bookPickup;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", storeCode=" + storeCode + ", userId=" + userId + ", bookUserName="
				+ bookUserName + ", bookUserPhone=" + bookUserPhone + ", bookPeoNum=" + bookPeoNum + ", bookSignTime="
				+ bookSignTime + ", bookCompTime=" + bookCompTime + ", bookCallAgree=" + bookCallAgree + ", stateCode="
				+ stateCode + ", bookPickup=" + bookPickup + "]";
	}
	
	
	
	
}
