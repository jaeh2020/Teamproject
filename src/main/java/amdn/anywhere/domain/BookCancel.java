package amdn.anywhere.domain;

public class BookCancel {
	
	private String cCode;
	private String bookCode;
	private String storeCode;
	private String userId;
	private String cApplyTime;
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getcApplyTime() {
		return cApplyTime;
	}
	public void setcApplyTime(String cApplyTime) {
		this.cApplyTime = cApplyTime;
	}
	@Override
	public String toString() {
		return "bookCancel [cCode=" + cCode + ", bookCode=" + bookCode + ", storeCode=" + storeCode + ", userId="
				+ userId + ", cApplyTime=" + cApplyTime + "]";
	}
	
	

}
