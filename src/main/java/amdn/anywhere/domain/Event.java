package amdn.anywhere.domain;

public class Event {
	private String eventCode;
	private String eventName;
	private String eventImgName;
	private String imgStoredPath;
	private String eventBannerName;
	private String bannerStoredPath;
	private String eventStr;
	private String eventFin;
	private String eventDetail;
	private String stateCode;
	private String regTime;
	private String adminId;
	private String stateName;
	private String storeCode;
	private String storeName;

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
	public String getEventImgName() {
		return eventImgName;
	}
	public void setEventImgName(String eventImgName) {
		this.eventImgName = eventImgName;
	}
	public String getImgStoredPath() {
		return imgStoredPath;

	}
	public void setImgStoredPath(String imgStoredPath) {
		this.imgStoredPath = imgStoredPath;
	}
	public String getEventBannerName() {
		return eventBannerName;
	}
	public void setEventBannerName(String eventBannerName) {
		this.eventBannerName = eventBannerName;
	}
	public String getBannerStoredPath() {
		return bannerStoredPath;
	}
	public void setBannerStoredPath(String bannerStoredPath) {
		this.bannerStoredPath = bannerStoredPath;
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
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	@Override
	public String toString() {
		return "Event [eventCode=" + eventCode + ", eventName=" + eventName + ", eventImgName=" + eventImgName
				+ ", imgStoredPath=" + imgStoredPath + ", eventBannerName=" + eventBannerName + ", bannerStoredPath="
				+ bannerStoredPath + ", eventStr=" + eventStr + ", eventFin=" + eventFin + ", eventDetail="
				+ eventDetail + ", stateCode=" + stateCode + ", regTime=" + regTime + ", adminId=" + adminId
				+ ", stateName=" + stateName + ", storeCode=" + storeCode + ", storeName=" + storeName + "]";

	}
	
	
}
