package amdn.anywhere.domain;

public class Search {
	private String searchCode;
	private String searchKey;
	private String searchTime;
	public String getSearchCode() {
		return searchCode;
	}
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	@Override
	public String toString() {
		return "Search [searchCode=" + searchCode + ", searchKey=" + searchKey + ", searchTime=" + searchTime + "]";
	}
	
	
}
