package amdn.anywhere.domain;

public class MemberBlackList {
	private String blackListNum;
	private String penaltyCode;
	private String blackListAskTime;
	private String blackListAsk;
	private String blackListCancelTime;
	private String StoreCode;
	private String userId;
	private String memberId;
	private String membershipCode;
	public String getBlackListNum() {
		return blackListNum;
	}
	public void setBlackListNum(String blackListNum) {
		this.blackListNum = blackListNum;
	}
	public String getPenaltyCode() {
		return penaltyCode;
	}
	public void setPenaltyCode(String penaltyCode) {
		this.penaltyCode = penaltyCode;
	}
	public String getBlackListAskTime() {
		return blackListAskTime;
	}
	public void setBlackListAskTime(String blackListAskTime) {
		this.blackListAskTime = blackListAskTime;
	}
	public String getBlackListAsk() {
		return blackListAsk;
	}
	public void setBlackListAsk(String blackListAsk) {
		this.blackListAsk = blackListAsk;
	}
	public String getBlackListCancelTime() {
		return blackListCancelTime;
	}
	public void setBlackListCancelTime(String blackListCancelTime) {
		this.blackListCancelTime = blackListCancelTime;
	}
	public String getStoreCode() {
		return StoreCode;
	}
	public void setStoreCode(String storeCode) {
		StoreCode = storeCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMembershipCode() {
		return membershipCode;
	}
	public void setMembershipCode(String membershipCode) {
		this.membershipCode = membershipCode;
	}
	@Override
	public String toString() {
		return "MemberBlackList [blackListNum=" + blackListNum + ", penaltyCode=" + penaltyCode + ", blackListAskTime="
				+ blackListAskTime + ", blackListAsk=" + blackListAsk + ", blackListCancelTime=" + blackListCancelTime
				+ ", StoreCode=" + StoreCode + ", userId=" + userId + ", memberId=" + memberId + ", membershipCode="
				+ membershipCode + "]";
	}
	
	
	
	
}
