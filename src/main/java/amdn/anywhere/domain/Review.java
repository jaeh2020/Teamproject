package amdn.anywhere.domain;

public class Review {
	private String reviewNum;
	private String reviewContents;
	private String reviewPhoto;
	private String payComTime;
	private String reviewComTime;
	private String scoreCode;
	private String storeCode;
	private String bookCode;
	private String stateCode;
	private String memberId;
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewPhoto() {
		return reviewPhoto;
	}
	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}
	public String getPayComTime() {
		return payComTime;
	}
	public void setPayComTime(String payComTime) {
		this.payComTime = payComTime;
	}
	public String getReviewComTime() {
		return reviewComTime;
	}
	public void setReviewComTime(String reviewComTime) {
		this.reviewComTime = reviewComTime;
	}
	public String getScoreCode() {
		return scoreCode;
	}
	public void setScoreCode(String scoreCode) {
		this.scoreCode = scoreCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", reviewContents=" + reviewContents + ", reviewPhoto=" + reviewPhoto
				+ ", payComTime=" + payComTime + ", reviewComTime=" + reviewComTime + ", scoreCode=" + scoreCode
				+ ", storeCode=" + storeCode + ", bookCode=" + bookCode + ", stateCode=" + stateCode + ", memberId="
				+ memberId + "]";
	}
	
	
	
}
