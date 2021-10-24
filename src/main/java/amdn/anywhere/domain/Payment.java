package amdn.anywhere.domain;

public class Payment {
	private String pCode;
	private String pmGroCode;
	private String pmDiviCode;
	private String storeCode;
	private String userId;
	private String pmDisCode;
	private String storeTableCode;
	private String pmMethodCode;
	private int oTotalPrice;
	private int usePoint;
	private int savePoint;
	private int finalPay;
	private int pmAmount;
	private String pmComTime;
	private String closeState;
	private String closeComTime;
	private String salesGroCode;
	private String bizId;
	private String reReqTime;
	private String confId;
	private String confComTime;
	private String reviseState;
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getPmGroCode() {
		return pmGroCode;
	}
	public void setPmGroCode(String pmGroCode) {
		this.pmGroCode = pmGroCode;
	}
	public String getPmDiviCode() {
		return pmDiviCode;
	}
	public void setPmDiviCode(String pmDiviCode) {
		this.pmDiviCode = pmDiviCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPmDisCode() {
		return pmDisCode;
	}
	public void setPmDisCode(String pmDisCode) {
		this.pmDisCode = pmDisCode;
	}
	public String getStoreTableCode() {
		return storeTableCode;
	}
	public void setStoreTableCode(String storeTableCode) {
		this.storeTableCode = storeTableCode;
	}
	public String getPmMethodCode() {
		return pmMethodCode;
	}
	public void setPmMethodCode(String pmMethodCode) {
		this.pmMethodCode = pmMethodCode;
	}
	public int getoTotalPrice() {
		return oTotalPrice;
	}
	public void setoTotalPrice(int oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public int getSavePoint() {
		return savePoint;
	}
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
	}
	public int getFinalPay() {
		return finalPay;
	}
	public void setFinalPay(int finalPay) {
		this.finalPay = finalPay;
	}
	public int getPmAmount() {
		return pmAmount;
	}
	public void setPmAmount(int pmAmount) {
		this.pmAmount = pmAmount;
	}
	public String getPmComTime() {
		return pmComTime;
	}
	public void setPmComTime(String pmComTime) {
		this.pmComTime = pmComTime;
	}
	public String getCloseState() {
		return closeState;
	}
	public void setCloseState(String closeState) {
		this.closeState = closeState;
	}
	public String getCloseComTime() {
		return closeComTime;
	}
	public void setCloseComTime(String closeComTime) {
		this.closeComTime = closeComTime;
	}
	public String getSalesGroCode() {
		return salesGroCode;
	}
	public void setSalesGroCode(String salesGroCode) {
		this.salesGroCode = salesGroCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getReReqTime() {
		return reReqTime;
	}
	public void setReReqTime(String reReqTime) {
		this.reReqTime = reReqTime;
	}
	public String getConfId() {
		return confId;
	}
	public void setConfId(String confId) {
		this.confId = confId;
	}
	public String getConfComTime() {
		return confComTime;
	}
	public void setConfComTime(String confComTime) {
		this.confComTime = confComTime;
	}
	public String getReviseState() {
		return reviseState;
	}
	public void setReviseState(String reviseState) {
		this.reviseState = reviseState;
	}
	@Override
	public String toString() {
		return "Payment [pCode=" + pCode + ", pmGroCode=" + pmGroCode + ", pmDiviCode=" + pmDiviCode + ", storeCode="
				+ storeCode + ", userId=" + userId + ", pmDisCode=" + pmDisCode + ", storeTableCode=" + storeTableCode
				+ ", pmMethodCode=" + pmMethodCode + ", oTotalPrice=" + oTotalPrice + ", usePoint=" + usePoint
				+ ", savePoint=" + savePoint + ", finalPay=" + finalPay + ", pmAmount=" + pmAmount + ", pmComTime="
				+ pmComTime + ", closeState=" + closeState + ", closeComTime=" + closeComTime + ", salesGroCode="
				+ salesGroCode + ", bizId=" + bizId + ", reReqTime=" + reReqTime + ", confId=" + confId
				+ ", confComTime=" + confComTime + ", reviseState=" + reviseState + "]";
	}
	
	
	
}
