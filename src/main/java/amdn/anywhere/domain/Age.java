package amdn.anywhere.domain;

public class Age {
	private String ageCode;
	private String ageGroup;
	private String ageFrom;
	private String ageTo;
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
	public String getAgeFrom() {
		return ageFrom;
	}
	public void setAgeFrom(String ageFrom) {
		this.ageFrom = ageFrom;
	}
	public String getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(String ageTo) {
		this.ageTo = ageTo;
	}
	@Override
	public String toString() {
		return "Age [ageCode=" + ageCode + ", ageGroup=" + ageGroup + ", ageFrom=" + ageFrom + ", ageTo=" + ageTo + "]";
	}
}
