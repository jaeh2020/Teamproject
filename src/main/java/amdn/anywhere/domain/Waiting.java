package amdn.anywhere.domain;

public class Waiting {
	private String storeWait;
	private String storeCode;
	private String bizId;
	private int stoUseTab;
	private int stoEmpTab;
	private int waitNum;
	public String getStoreWait() {
		return storeWait;
	}
	public void setStoreWait(String storeWait) {
		this.storeWait = storeWait;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public int getStoUseTab() {
		return stoUseTab;
	}
	public void setStoUseTab(int stoUseTab) {
		this.stoUseTab = stoUseTab;
	}
	public int getStoEmpTab() {
		return stoEmpTab;
	}
	public void setStoEmpTab(int stoEmpTab) {
		this.stoEmpTab = stoEmpTab;
	}
	public int getWaitNum() {
		return waitNum;
	}
	public void setWaitNum(int waitNum) {
		this.waitNum = waitNum;
	}
	@Override
	public String toString() {
		return "Waiting [storeWait=" + storeWait + ", storeCode=" + storeCode + ", bizId=" + bizId + ", stoUseTab="
				+ stoUseTab + ", stoEmpTab=" + stoEmpTab + ", waitNum=" + waitNum + "]";
	}
	
	
	
}
