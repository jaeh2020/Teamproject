package amdn.anywhere.domain;

public class BadWords {

	private String badWordsCode;
	private String banWordsList;
	
	public String getBadWordsCode() {
		return badWordsCode;
	}
	public void setBadWordsCode(String badWordsCode) {
		this.badWordsCode = badWordsCode;
	}
	public String getBanWordsList() {
		return banWordsList;
	}
	public void setBanWordsList(String banWordsList) {
		this.banWordsList = banWordsList;
	}
	@Override
	public String toString() {
		return "badWords [badWordsCode=" + badWordsCode + ", banWordsList=" + banWordsList + "]";
	}
	
	
	
}
