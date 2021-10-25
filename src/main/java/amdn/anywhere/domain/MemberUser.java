package amdn.anywhere.domain;

public class MemberUser {

	private String userId;
	private String msCode;
	private int userOrderTotal;
	private int userPoint;
	private String userEvaluator;
	private int reportScore;
	private Membership membership;
	private MemberUserLike memberUserLike;
	private Point point;
	private MembershipDel membershipDel;
	
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
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	public MemberUserLike getMemberUserLike() {
		return memberUserLike;
	}
	public void setMemberUserLike(MemberUserLike memberUserLike) {
		this.memberUserLike = memberUserLike;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	
	public MembershipDel getMembershipDel() {
		return membershipDel;
	}
	public void setMembershipDel(MembershipDel membershipDel) {
		this.membershipDel = membershipDel;
	}
	@Override
	public String toString() {
		return "MemberUser [userId=" + userId + ", msCode=" + msCode + ", userOrderTotal=" + userOrderTotal
				+ ", userPoint=" + userPoint + ", userEvaluator=" + userEvaluator + ", reportScore=" + reportScore
				+ ", membership=" + membership + ", memberUserLike=" + memberUserLike + ", point=" + point
				+ ", membershipDel=" + membershipDel + "]";
	}
	
}
