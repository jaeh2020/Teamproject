package amdn.anywhere.domain;

public class Membership {

	private String msCode;
	private String msLevel;
	private int msDis;
	private int msStandard;
	public String getMsCode() {
		return msCode;
	}
	public void setMsCode(String msCode) {
		this.msCode = msCode;
	}
	public String getMsLevel() {
		return msLevel;
	}
	public void setMsLevel(String msLevel) {
		this.msLevel = msLevel;
	}
	public int getMsDis() {
		return msDis;
	}
	public void setMsDis(int msDis) {
		this.msDis = msDis;
	}
	public int getMsStandard() {
		return msStandard;
	}
	public void setMsStandard(int msStandard) {
		this.msStandard = msStandard;
	}
	@Override
	public String toString() {
		return "Membership [msCode=" + msCode + ", msLevel=" + msLevel + ", msDis=" + msDis + ", msStandard="
				+ msStandard + "]";
	}
	
}
