package amdn.anywhere.domain;

public class Board {
	private String boardNum;
	private String boardCateCode;
	private String boardTitle;
	private String boardContents;
	private String boardFile;
	private String boardSecret;
	private String boardRegTime;
	private String boardViews;
	private String memberId;
	private String stateCode;
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardCateCode() {
		return boardCateCode;
	}
	public void setBoardCateCode(String boardCateCode) {
		this.boardCateCode = boardCateCode;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	public String getBoardSecret() {
		return boardSecret;
	}
	public void setBoardSecret(String boardSecret) {
		this.boardSecret = boardSecret;
	}
	public String getBoardRegTime() {
		return boardRegTime;
	}
	public void setBoardRegTime(String boardRegTime) {
		this.boardRegTime = boardRegTime;
	}
	public String getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(String boardViews) {
		this.boardViews = boardViews;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardCateCode=" + boardCateCode + ", boardTitle=" + boardTitle
				+ ", boardContents=" + boardContents + ", boardFile=" + boardFile + ", boardSecret=" + boardSecret
				+ ", boardRegTime=" + boardRegTime + ", boardViews=" + boardViews + ", memberId=" + memberId
				+ ", stateCode=" + stateCode + "]";
	}
	
	
	
}
