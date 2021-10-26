package amdn.anywhere.domain;

public class Board {
	private String boardNum;
	private String boardCateCode;
	private String boardCateName;
	private String boardTitle;
	private String boardContents;
	private String boardFile;
	private int boardSecret;
	private String boardRegTime;
	private String numOfRep;
	private int boardViews;
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
	public int getBoardSecret() {
		return boardSecret;
	}
	public void setBoardSecret(int boardSecret) {
		this.boardSecret = boardSecret;
	}
	public String getBoardRegTime() {
		return boardRegTime;
	}
	public void setBoardRegTime(String boardRegTime) {
		this.boardRegTime = boardRegTime;
	}
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
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
	public String getBoardCateName() {
		return boardCateName;
	}
	public void setBoardCateName(String boardCateName) {
		this.boardCateName = boardCateName;
	}
	public String getNumOfRep() {
		return numOfRep;
	}
	public void setNumOfRep(String numOfRep) {
		this.numOfRep = numOfRep;
	}
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardCateCode=" + boardCateCode + ", boardCateName=" + boardCateName
				+ ", boardTitle=" + boardTitle + ", boardContents=" + boardContents + ", boardFile=" + boardFile
				+ ", boardSecret=" + boardSecret + ", boardRegTime=" + boardRegTime + ", numOfRep=" + numOfRep
				+ ", boardViews=" + boardViews + ", memberId=" + memberId + ", stateCode=" + stateCode + "]";
	}
	
}
