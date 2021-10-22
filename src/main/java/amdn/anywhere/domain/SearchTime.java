package amdn.anywhere.domain;

public class SearchTime {
	private String searchTimeCode;
	private String seerchTimeStart;
	private String searchTimeEnd;
	public String getSearchTimeCode() {
		return searchTimeCode;
	}
	public void setSearchTimeCode(String searchTimeCode) {
		this.searchTimeCode = searchTimeCode;
	}
	public String getSeerchTimeStart() {
		return seerchTimeStart;
	}
	public void setSeerchTimeStart(String seerchTimeStart) {
		this.seerchTimeStart = seerchTimeStart;
	}
	public String getSearchTimeEnd() {
		return searchTimeEnd;
	}
	public void setSearchTimeEnd(String searchTimeEnd) {
		this.searchTimeEnd = searchTimeEnd;
	}
	@Override
	public String toString() {
		return "SearchTime [searchTimeCode=" + searchTimeCode + ", seerchTimeStart=" + seerchTimeStart
				+ ", searchTimeEnd=" + searchTimeEnd + ", getSearchTimeCode()=" + getSearchTimeCode()
				+ ", getSeerchTimeStart()=" + getSeerchTimeStart() + ", getSearchTimeEnd()=" + getSearchTimeEnd()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
