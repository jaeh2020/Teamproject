package amdn.anywhere.domain;

public class BoardCate {
	private String boardCateCode;
	private String boardCateName;
	
	public String getBoardCateCode() {
		return boardCateCode;
	}
	public void setBoardCateCode(String boardCateCode) {
		this.boardCateCode = boardCateCode;
	}
	public String getBoardCateName() {
		return boardCateName;
	}
	public void setBoardCateName(String boardCateName) {
		this.boardCateName = boardCateName;
	}
	
	@Override
	public String toString() {
		return "BoardCate [boardCateCode=" + boardCateCode + ", boardCateName=" + boardCateName + "]";
	}
	
}
