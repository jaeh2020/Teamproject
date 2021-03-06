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
	private int reviewViews;
	private int reviewLikes;
	private ReviewScore reviewScore;
	private Storesearch storeSearch;
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
	public int getReviewViews() {
		return reviewViews;
	}
	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
	}
	public int getReviewLikes() {
		return reviewLikes;
	}
	public void setReviewLikes(int reviewLikes) {
		this.reviewLikes = reviewLikes;
	}
	public ReviewScore getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(ReviewScore reviewScore) {
		this.reviewScore = reviewScore;
	}
	public Storesearch getStoreSearch() {
		return storeSearch;
	}
	public void setStoreSearch(Storesearch storeSearch) {
		this.storeSearch = storeSearch;
	}
	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", reviewContents=" + reviewContents + ", reviewPhoto=" + reviewPhoto
				+ ", payComTime=" + payComTime + ", reviewComTime=" + reviewComTime + ", scoreCode=" + scoreCode
				+ ", storeCode=" + storeCode + ", bookCode=" + bookCode + ", stateCode=" + stateCode + ", memberId="
				+ memberId + ", reviewViews=" + reviewViews + ", reviewLikes=" + reviewLikes + ", reviewScore="
				+ reviewScore + ", storeSearch=" + storeSearch + "]";
	}
	
	
}
