package amdn.anywhere.domain;

public class MemberBiz {

	private String bizCode;
	private String memberId;
	private String bizNum;
	private String bizFileAtt;
	private String bizStatus;
	private String confirmId;
	private String bizReTime;
	private String bizCompTime;
	private Statement statement;
	
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBizNum() {
		return bizNum;
	}
	public void setBizNum(String bizNum) {
		this.bizNum = bizNum;
	}
	public String getBizFileAtt() {
		return bizFileAtt;
	}
	public void setBizFileAtt(String bizFileAtt) {
		this.bizFileAtt = bizFileAtt;
	}
	public String getBizStatus() {
		return bizStatus;
	}
	public void setBizStatus(String bizStatus) {
		this.bizStatus = bizStatus;
	}
	public String getConfirmId() {
		return confirmId;
	}
	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
	}
	public String getBizReTime() {
		return bizReTime;
	}
	public void setBizReTime(String bizReTime) {
		this.bizReTime = bizReTime;
	}
	public String getBizCompTime() {
		return bizCompTime;
	}
	public void setBizCompTime(String bizCompTime) {
		this.bizCompTime = bizCompTime;
	}
	
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	@Override
	public String toString() {
		return "MemberBiz [bizCode=" + bizCode + ", memberId=" + memberId + ", bizNum=" + bizNum + ", bizFileAtt="
				+ bizFileAtt + ", bizStatus=" + bizStatus + ", confirmId=" + confirmId + ", bizReTime=" + bizReTime
				+ ", bizCompTime=" + bizCompTime + ", statement=" + statement + "]";
	}
	
	
}
