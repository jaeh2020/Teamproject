package amdn.anywhere.domain;


public class BoardReply {
	private String boardReplyCode;
	private String boardNum;
	private String boardReplyContents;
	private String boardReplyTime;
	private String memberId;
	public String getBoardReplyCode() {
		return boardReplyCode;
	}
	public void setBoardReplyCode(String boardReplyCode) {
		this.boardReplyCode = boardReplyCode;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardReplyContents() {
		return boardReplyContents;
	}
	public void setBoardReplyContents(String boardReplyContents) {
		this.boardReplyContents = boardReplyContents;
	}
	public String getBoardReplyTime() {
		return boardReplyTime;
	}
	public void setBoardReplyTime(String boardReplyTime) {
		this.boardReplyTime = boardReplyTime;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "BoardReply [boardReplyCode=" + boardReplyCode + ", boardNum=" + boardNum + ", boardReplyContents="
				+ boardReplyContents + ", boardReplyTime=" + boardReplyTime + ", memberId=" + memberId + "]";
	}
	
	
	
	

}
