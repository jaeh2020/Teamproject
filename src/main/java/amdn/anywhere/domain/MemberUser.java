package amdn.anywhere.domain;

public class MemberUser {

	private String userId;
	private String msCode;
	private int userOrderTotal;
	private int userPoint;
	private String userEvaluator;
	private int reportScore;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMsCode() {
		return msCode;
	}
	public void setMsCode(String msCode) {
		this.msCode = msCode;
	}
	public int getUserOrderTotal() {
		return userOrderTotal;
	}
	public void setUserOrderTotal(int userOrderTotal) {
		this.userOrderTotal = userOrderTotal;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getUserEvaluator() {
		return userEvaluator;
	}
	public void setUserEvaluator(String userEvaluator) {
		this.userEvaluator = userEvaluator;
	}
	public int getReportScore() {
		return reportScore;
	}
	public void setReportScore(int reportScore) {
		this.reportScore = reportScore;
	}
	@Override
	public String toString() {
		return "MemberUser [userId=" + userId + ", msCode=" + msCode + ", userOrderTotal=" + userOrderTotal
				+ ", userPoint=" + userPoint + ", userEvaluator=" + userEvaluator + ", reportScore=" + reportScore
				+ "]";
	}
	
}
