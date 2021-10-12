package amdn.anywhere.domain;

public class Table {
	private String storeTableCode;
	private String storeCode;
	private String bizId;
	private int tableNum;
	private Store store;
	public String getStoreTableCode() {
		return storeTableCode;
	}
	public void setStoreTableCode(String storeTableCode) {
		this.storeTableCode = storeTableCode;
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
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "Table [storeTableCode=" + storeTableCode + ", storeCode=" + storeCode + ", bizId=" + bizId
				+ ", tableNum=" + tableNum + ", store=" + store + "]";
	}
	
	
	
}
