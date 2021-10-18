package amdn.anywhere.domain;

public class Report {
	private String reportCode;
	private String reportCateCode;
	private String boardNum;
	private String reviewNum;
	private String reportContents;
	private String reportRegTime;
	private String reportConfirmTime;
	private String reportId;
	private String reportApplyId;
	private String memberId;
	private String stateCode;
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportCateCode() {
		return reportCateCode;
	}
	public void setReportCateCode(String reportCateCode) {
		this.reportCateCode = reportCateCode;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public String getReportRegTime() {
		return reportRegTime;
	}
	public void setReportRegTime(String reportRegTime) {
		this.reportRegTime = reportRegTime;
	}
	public String getReportConfirmTime() {
		return reportConfirmTime;
	}
	public void setReportConfirmTime(String reportConfirmTime) {
		this.reportConfirmTime = reportConfirmTime;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportApplyId() {
		return reportApplyId;
	}
	public void setReportApplyId(String reportApplyId) {
		this.reportApplyId = reportApplyId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "Report [reportCode=" + reportCode + ", reportCateCode=" + reportCateCode + ", boardNum=" + boardNum
				+ ", reviewNum=" + reviewNum + ", reportContents=" + reportContents + ", reportRegTime=" + reportRegTime
				+ ", reportConfirmTime=" + reportConfirmTime + ", reportId=" + reportId + ", reportApplyId="
				+ reportApplyId + ", memberId=" + memberId + ", stateCode=" + stateCode + "]";
	}
	
	
	
	
}
