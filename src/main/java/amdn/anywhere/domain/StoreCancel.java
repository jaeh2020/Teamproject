package amdn.anywhere.domain;

public class StoreCancel {
	
	private String storeCancelCode;
	private String bizId;
	private String storeCode;
	private String storeName;
	private String storeCancelAsk;
	private String cancelTime;
	private String cancelComTime;
	private String cancelConfirmId;
	private String stateCode;
	private Store store;
	private Statement statement;
	public String getStoreCancelCode() {
		return storeCancelCode;
	}
	public void setStoreCancelCode(String storeCancelCode) {
		this.storeCancelCode = storeCancelCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
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
	public String getStoreCancelAsk() {
		return storeCancelAsk;
	}
	public void setStoreCancelAsk(String storeCancelAsk) {
		this.storeCancelAsk = storeCancelAsk;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getCancelComTime() {
		return cancelComTime;
	}
	public void setCancelComTime(String cancelComTime) {
		this.cancelComTime = cancelComTime;
	}
	public String getCancelConfirmId() {
		return cancelConfirmId;
	}
	public void setCancelConfirmId(String cancelConfirmId) {
		this.cancelConfirmId = cancelConfirmId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	@Override
	public String toString() {
		return "StoreCancel [storeCancelCode=" + storeCancelCode + ", bizId=" + bizId + ", storeCode=" + storeCode
				+ ", storeName=" + storeName + ", storeCancelAsk=" + storeCancelAsk + ", cancelTime=" + cancelTime
				+ ", cancelComTime=" + cancelComTime + ", cancelConfirmId=" + cancelConfirmId + ", stateCode="
				+ stateCode + ", store=" + store + ", statement=" + statement + "]";
	}
	
	

}
