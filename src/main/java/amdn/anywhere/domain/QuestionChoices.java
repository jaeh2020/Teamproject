package amdn.anywhere.domain;

public class QuestionChoices {
	private String code;
	private String score;
	private String cntNum;
	private String cntKor;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCntNum() {
		return cntNum;
	}
	public void setCntNum(String cntNum) {
		this.cntNum = cntNum;
	}
	public String getCntKor() {
		return cntKor;
	}
	public void setCntKor(String cntKor) {
		this.cntKor = cntKor;
	}
	@Override
	public String toString() {
		return "QuestionChoices [code=" + code + ", score=" + score + ", cntNum=" + cntNum + ", cntKor=" + cntKor + "]";
	}
	
}
