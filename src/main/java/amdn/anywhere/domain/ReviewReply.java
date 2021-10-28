package amdn.anywhere.domain;

public class ReviewReply {
	private String reviewReplyNum;
	private String reviewReplyContents;
	private String reviewReplyRegTime;
	private String reviewNum;
	private String storeCode;
	private String memberId;
	public String getReviewReplyNum() {
		return reviewReplyNum;
	}
	public void setReviewReplyNum(String reviewReplyNum) {
		this.reviewReplyNum = reviewReplyNum;
	}
	public String getReviewReplyContents() {
		return reviewReplyContents;
	}
	public void setReviewReplyContents(String reviewReplyContents) {
		this.reviewReplyContents = reviewReplyContents;
	}
	public String getReviewReplyRegTime() {
		return reviewReplyRegTime;
	}
	public void setReviewReplyRegTime(String reviewReplyRegTime) {
		this.reviewReplyRegTime = reviewReplyRegTime;
	}
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "reviewReply [reviewReplyNum=" + reviewReplyNum + ", reviewReplyContents=" + reviewReplyContents
				+ ", reviewReplyRegTime=" + reviewReplyRegTime + ", reviewNum=" + reviewNum + ", storeCode=" + storeCode
				+ ", memberId=" + memberId + "]";
	}
	
	
	
	
}
