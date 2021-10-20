package amdn.anywhere.domain;

public class Penalty {
	private String penaltyCode;
	private String penaltyStandard;
	private int penaltyScore;
	private String reportCode;
	private String reportRegTime;
	private String penaltyCheckDate;
	private String penaltyId;
	private String memberId;
	public String getPenaltyCode() {
		return penaltyCode;
	}
	public void setPenaltyCode(String penaltyCode) {
		this.penaltyCode = penaltyCode;
	}
	public String getPenaltyStandard() {
		return penaltyStandard;
	}
	public void setPenaltyStandard(String penaltyStandard) {
		this.penaltyStandard = penaltyStandard;
	}
	public int getPenaltyScore() {
		return penaltyScore;
	}
	public void setPenaltyScore(int penaltyScore) {
		this.penaltyScore = penaltyScore;
	}
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportRegTime() {
		return reportRegTime;
	}
	public void setReportRegTime(String reportRegTime) {
		this.reportRegTime = reportRegTime;
	}
	public String getPenaltyCheckDate() {
		return penaltyCheckDate;
	}
	public void setPenaltyCheckDate(String penaltyCheckDate) {
		this.penaltyCheckDate = penaltyCheckDate;
	}
	public String getPenaltyId() {
		return penaltyId;
	}
	public void setPenaltyId(String penaltyId) {
		this.penaltyId = penaltyId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "Penalty [penaltyCode=" + penaltyCode + ", penaltyStandard=" + penaltyStandard + ", penaltyScore="
				+ penaltyScore + ", reportCode=" + reportCode + ", reportRegTime=" + reportRegTime
				+ ", penaltyCheckDate=" + penaltyCheckDate + ", penaltyId=" + penaltyId + ", memberId=" + memberId
				+ "]";
	}
	

	
	
}
