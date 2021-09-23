package amdn.anywhere.domain;

public class Message {
	private String messageNum;
	private String messageCheckCode;
	private String storeCode;
	private String memberId;
	private String messageCode;
	private String messageNoticeTime;
	private String messageReadTime;
	private String messageMark;
	public String getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(String messageNum) {
		this.messageNum = messageNum;
	}
	public String getMessageCheckCode() {
		return messageCheckCode;
	}
	public void setMessageCheckCode(String messageCheckCode) {
		this.messageCheckCode = messageCheckCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageNoticeTime() {
		return messageNoticeTime;
	}
	public void setMessageNoticeTime(String messageNoticeTime) {
		this.messageNoticeTime = messageNoticeTime;
	}
	public String getMessageReadTime() {
		return messageReadTime;
	}
	public void setMessageReadTime(String messageReadTime) {
		this.messageReadTime = messageReadTime;
	}
	public String getMessageMark() {
		return messageMark;
	}
	public void setMessageMark(String messageMark) {
		this.messageMark = messageMark;
	}
	@Override
	public String toString() {
		return "Message [messageNum=" + messageNum + ", messageCheckCode=" + messageCheckCode + ", storeCode="
				+ storeCode + ", memberId=" + memberId + ", messageCode=" + messageCode + ", messageNoticeTime="
				+ messageNoticeTime + ", messageReadTime=" + messageReadTime + ", messageMark=" + messageMark + "]";
	}
	
	
}
