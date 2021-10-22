package amdn.anywhere.domain;

public class TasterCancel {
	private String cancelCode;
	private String tasterApplyCode;
	private String userId;
	private String userName;
	private String cancelDate;
	private int numOfCancel;
	private String tasterApplyDate;
	private String recruitBCode;
	public String getCancelCode() {
		return cancelCode;
	}
	public void setCancelCode(String cancelCode) {
		this.cancelCode = cancelCode;
	}
	public String getTasterApplyCode() {
		return tasterApplyCode;
	}
	public void setTasterApplyCode(String tasterApplyCode) {
		this.tasterApplyCode = tasterApplyCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public int getNumOfCancel() {
		return numOfCancel;
	}
	public void setNumOfCancel(int numOfCancel) {
		this.numOfCancel = numOfCancel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "TasterCancel [cancelCode=" + cancelCode + ", tasterApplyCode=" + tasterApplyCode + ", userId=" + userId
				+ ", userName=" + userName + ", cancelDate=" + cancelDate + ", numOfCancel=" + numOfCancel
				+ ", tasterApplyDate=" + tasterApplyDate + ", recruitBCode=" + recruitBCode + "]";
	}
	public String getTasterApplyDate() {
		return tasterApplyDate;
	}
	public void setTasterApplyDate(String tasterApplyDate) {
		this.tasterApplyDate = tasterApplyDate;
	}
	public String getRecruitBCode() {
		return recruitBCode;
	}
	public void setRecruitBCode(String recruitBCode) {
		this.recruitBCode = recruitBCode;
	}
	
}
