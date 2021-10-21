package amdn.anywhere.domain;

public class SearchKeyword {
	private String searchCurCode;
	private String searchUpdateTime;
	private String searchDate;
	private String searchRank1;
	private String searchRank2;
	private String searchRank3;
	public String getSearchCurCode() {
		return searchCurCode;
	}
	public void setSearchCurCode(String searchCurCode) {
		this.searchCurCode = searchCurCode;
	}
	public String getSearchUpdateTime() {
		return searchUpdateTime;
	}
	public void setSearchUpdateTime(String searchUpdateTime) {
		this.searchUpdateTime = searchUpdateTime;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getSearchRank1() {
		return searchRank1;
	}
	public void setSearchRank1(String searchRank1) {
		this.searchRank1 = searchRank1;
	}
	public String getSearchRank2() {
		return searchRank2;
	}
	public void setSearchRank2(String searchRank2) {
		this.searchRank2 = searchRank2;
	}
	public String getSearchRank3() {
		return searchRank3;
	}
	public void setSearchRank3(String searchRank3) {
		this.searchRank3 = searchRank3;
	}
	@Override
	public String toString() {
		return "SearchKeyword [searchCurCode=" + searchCurCode + ", searchUpdateTime=" + searchUpdateTime
				+ ", searchDate=" + searchDate + ", searchRank1=" + searchRank1 + ", searchRank2=" + searchRank2
				+ ", searchRank3=" + searchRank3 + "]";
	}
	
	
	
}
