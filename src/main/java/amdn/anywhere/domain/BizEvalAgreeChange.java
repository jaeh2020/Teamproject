package amdn.anywhere.domain;

public class BizEvalAgreeChange {

	private String eAgreeCode;
	private String StoreCode;
	private String eAgreeBefore;
	private String eAgreeAfter;
	private String eAgreeTime;
	private String confirmId;
	private String eConfirmTime;
	public String geteAgreeCode() {
		return eAgreeCode;
	}
	public void seteAgreeCode(String eAgreeCode) {
		this.eAgreeCode = eAgreeCode;
	}
	public String getStoreCode() {
		return StoreCode;
	}
	public void setStoreCode(String storeCode) {
		StoreCode = storeCode;
	}
	public String geteAgreeBefore() {
		return eAgreeBefore;
	}
	public void seteAgreeBefore(String eAgreeBefore) {
		this.eAgreeBefore = eAgreeBefore;
	}
	public String geteAgreeAfter() {
		return eAgreeAfter;
	}
	public void seteAgreeAfter(String eAgreeAfter) {
		this.eAgreeAfter = eAgreeAfter;
	}
	public String geteAgreeTime() {
		return eAgreeTime;
	}
	public void seteAgreeTime(String eAgreeTime) {
		this.eAgreeTime = eAgreeTime;
	}
	public String getConfirmId() {
		return confirmId;
	}
	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
	}
	public String geteConfirmTime() {
		return eConfirmTime;
	}
	public void seteConfirmTime(String eConfirmTime) {
		this.eConfirmTime = eConfirmTime;
	}
	@Override
	public String toString() {
		return "BizEvalAgreeChange [eAgreeCode=" + eAgreeCode + ", StoreCode=" + StoreCode + ", eAgreeBefore="
				+ eAgreeBefore + ", eAgreeAfter=" + eAgreeAfter + ", eAgreeTime=" + eAgreeTime + ", confirmId="
				+ confirmId + ", eConfirmTime=" + eConfirmTime + "]";
	}
	
}
