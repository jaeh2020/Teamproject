package amdn.anywhere.domain;

public class MemberShipDel {

	private String msDelCode;
	private String userId;
	private String delBeforeCount;
	private String delBeforeName;
	private String resetTime;
	public String getMsDelCode() {
		return msDelCode;
	}
	public void setMsDelCode(String msDelCode) {
		this.msDelCode = msDelCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDelBeforeCount() {
		return delBeforeCount;
	}
	public void setDelBeforeCount(String delBeforeCount) {
		this.delBeforeCount = delBeforeCount;
	}
	public String getDelBeforeName() {
		return delBeforeName;
	}
	public void setDelBeforeName(String delBeforeName) {
		this.delBeforeName = delBeforeName;
	}
	public String getResetTime() {
		return resetTime;
	}
	public void setResetTime(String resetTime) {
		this.resetTime = resetTime;
	}
	@Override
	public String toString() {
		return "MemberShipDel [msDelCode=" + msDelCode + ", userId=" + userId + ", delBeforeCount=" + delBeforeCount
				+ ", delBeforeName=" + delBeforeName + ", resetTime=" + resetTime + "]";
	}
	
}
