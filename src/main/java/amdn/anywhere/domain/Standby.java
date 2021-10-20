package amdn.anywhere.domain;

public class Standby {
	
	private String bookStandbyCode;
	private String bookCode;
	private String userId;
	private String storeCode;
	private String waitTime;
	private String stateCode;
	private String waitCompTime;
	private Statement statement;
	public String getBookStandbyCode() {
		return bookStandbyCode;
	}
	public void setBookStandbyCode(String bookStandbyCode) {
		this.bookStandbyCode = bookStandbyCode;
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
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getWaitCompTime() {
		return waitCompTime;
	}
	public void setWaitCompTime(String waitCompTime) {
		this.waitCompTime = waitCompTime;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	@Override
	public String toString() {
		return "Standby [bookStandbyCode=" + bookStandbyCode + ", bookCode=" + bookCode + ", userId=" + userId
				+ ", storeCode=" + storeCode + ", waitTime=" + waitTime + ", stateCode=" + stateCode + ", waitCompTime="
				+ waitCompTime + ", statement=" + statement + "]";
	}
	
	

}
