package amdn.anywhere.domain;

public class MessageCommon {
	private String messageCode;
	private String messageCate1;
	private String messageIcon;
	private String messgeCate2;
	private String messageDetail;
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageCate1() {
		return messageCate1;
	}
	public void setMessageCate1(String messageCate1) {
		this.messageCate1 = messageCate1;
	}
	public String getMessageIcon() {
		return messageIcon;
	}
	public void setMessageIcon(String messageIcon) {
		this.messageIcon = messageIcon;
	}
	public String getMessgeCate2() {
		return messgeCate2;
	}
	public void setMessgeCate2(String messgeCate2) {
		this.messgeCate2 = messgeCate2;
	}
	public String getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
	@Override
	public String toString() {
		return "MessageCommon [messageCode=" + messageCode + ", messageCate1=" + messageCate1 + ", messageIcon="
				+ messageIcon + ", messgeCate2=" + messgeCate2 + ", messageDetail=" + messageDetail + "]";
	}

	
}
