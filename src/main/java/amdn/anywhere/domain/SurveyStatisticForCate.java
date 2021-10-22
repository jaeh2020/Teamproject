package amdn.anywhere.domain;

public class SurveyStatisticForCate {
	private String cateCode;
	private String cateName;
	private float percentage;
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "SurveyStatisticForCate [cateCode=" + cateCode + ", cateName=" + cateName + ", percentage=" + percentage
				+ "]";
	}
}
