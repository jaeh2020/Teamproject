package amdn.anywhere.domain;

public class PointDelStandard {

	private String poStaCode;;
	private String poDelStaDate;
	public String getPoStaCode() {
		return poStaCode;
	}
	public void setPoStaCode(String poStaCode) {
		this.poStaCode = poStaCode;
	}
	public String getPoDelStaDate() {
		return poDelStaDate;
	}
	public void setPoDelStaDate(String poDelStaDate) {
		this.poDelStaDate = poDelStaDate;
	}
	@Override
	public String toString() {
		return "PointDelStandard [poStaCode=" + poStaCode + ", poDelStaDate=" + poDelStaDate + "]";
	}
	
}
