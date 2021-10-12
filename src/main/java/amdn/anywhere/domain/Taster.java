package amdn.anywhere.domain;

public class Taster {
	private String applyCode;
	private String userId;
	private String recruitBCode;
	private String applyTime;
	private String cancelReason;
	private String state;
	private String stateName;
	private String storeCode;
	private String storeName;
	private String userName;
	private RecruitTasterByBiz recruitTasterByBiz;
	public String getApplyCode() {
		return applyCode;
	}
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRecruitBCode() {
		return recruitBCode;
	}
	public void setRecruitBCode(String recruitBCode) {
		this.recruitBCode = recruitBCode;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Taster [applyCode=" + applyCode + ", userId=" + userId + ", recruitBCode=" + recruitBCode
				+ ", applyTime=" + applyTime + ", cancelReason=" + cancelReason + ", state=" + state + ", stateName="
				+ stateName + ", storeCode=" + storeCode + ", storeName=" + storeName + ", userName=" + userName
				+ ", recruitTasterByBiz=" + recruitTasterByBiz + "]";
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public RecruitTasterByBiz getRecruitTasterByBiz() {
		return recruitTasterByBiz;
	}
	public void setRecruitTasterByBiz(RecruitTasterByBiz recruitTasterByBiz) {
		this.recruitTasterByBiz = recruitTasterByBiz;
	}
	
}
