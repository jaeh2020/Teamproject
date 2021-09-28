package amdn.anywhere.domain;

public class Message {
	private String messageNum;
	private String confirmId;
	private String storeCode;
	private String memberId;
	private String messageCode;
	private String messageNoticeTime;
	private String messageReadTime;
	private String messageMark;
	private MessageCommon messageCommon;
	public String getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(String messageNum) {
		this.messageNum = messageNum;
	}
	public String getConfirmId() {
		return confirmId;
	}
	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
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
	public MessageCommon getMessageCommon() {
		return messageCommon;
	}
	public void setMessageCommon(MessageCommon messageCommon) {
		this.messageCommon = messageCommon;
	}
	@Override
	public String toString() {
		return "Message [messageNum=" + messageNum + ", confirmId="
				+ confirmId + ", storeCode=" + storeCode + ", memberId=" + memberId + ", messageCode=" + messageCode
				+ ", messageNoticeTime=" + messageNoticeTime + ", messageReadTime=" + messageReadTime + ", messageMark="
				+ messageMark + ", messageCommon=" + messageCommon + "]";
	}
	
	
}
