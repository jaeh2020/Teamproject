package amdn.anywhere.domain;

public class NumberOfMember {
	private String levelCode;
	private int number;
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "NumberOfMember [levelCode=" + levelCode + ", number=" + number + "]";
	}
}
