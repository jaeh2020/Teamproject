package amdn.anywhere.domain;

public class MemberLogin {

	private String loginNum;
	private String memberId;
	private String levelCode;
	private String loginTime;
	private String logoutTime;
	public String getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	@Override
	public String toString() {
		return "MemberLogin [loginNum=" + loginNum + ", memberId=" + memberId + ", levelCode=" + levelCode
				+ ", loginTime=" + loginTime + ", logoutTime=" + logoutTime + "]";
	}
	
}
