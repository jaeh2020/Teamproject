package amdn.anywhere.domain;

public class Event {
	private String eventCode;
	private String eventName;
	private String eventImg;
	private String eventBanner;
	private String eventStr;
	private String eventFin;
	private String eventDetail;
	private String stateCode;
	private String regTime;
	private String adminId;
	private String stateName;
	
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventImg() {
		return eventImg;
	}
	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}
	public String getEventBanner() {
		return eventBanner;
	}
	public void setEventBanner(String eventBanner) {
		this.eventBanner = eventBanner;
	}
	public String getEventStr() {
		return eventStr;
	}
	public void setEventStr(String eventStr) {
		this.eventStr = eventStr;
	}
	public String getEventFin() {
		return eventFin;
	}
	public void setEventFin(String eventFin) {
		this.eventFin = eventFin;
	}
	public String getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "Event [eventCode=" + eventCode + ", eventName=" + eventName + ", eventImg=" + eventImg
				+ ", eventBanner=" + eventBanner + ", eventStr=" + eventStr + ", eventFin=" + eventFin
				+ ", eventDetail=" + eventDetail + ", stateCode=" + stateCode + ", regTime=" + regTime + ", adminId="
				+ adminId + ", stateName=" + stateName + "]";
	}
	
}
