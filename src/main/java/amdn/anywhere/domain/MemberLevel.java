package amdn.anywhere.domain;

public class MemberLevel {
	private String levelCode;
	private String levelName;
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	@Override
	public String toString() {
		return "MemberLevel [levelCode=" + levelCode + ", levelName=" + levelName + "]";
	}
	

}
