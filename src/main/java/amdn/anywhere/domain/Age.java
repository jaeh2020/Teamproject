package amdn.anywhere.domain;

public class Age {
	private String ageCode;
	private String ageGroup;
	private int ageFrom;
	private int ageTo;
	public String getAgeCode() {
		return ageCode;
	}
	public void setAgeCode(String ageCode) {
		this.ageCode = ageCode;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public int getAgeFrom() {
		return ageFrom;
	}
	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}
	public int getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	@Override
	public String toString() {
		return "Age [ageCode=" + ageCode + ", ageGroup=" + ageGroup + ", ageFrom=" + ageFrom + ", ageTo=" + ageTo + "]";
	}
}
