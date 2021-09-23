package amdn.anywhere.domain;

public class Questionnaire {
	private String qCode;
	private String qContent;
	private String qAddTime;
	private String qAddId;
	private String qUpdateTime;
	private String qUpdateId;
	private String qCateCode;
	private QuestionCate questionCate;
	public String getqCode() {
		return qCode;
	}
	public void setqCode(String qCode) {
		this.qCode = qCode;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqAddTime() {
		return qAddTime;
	}
	public void setqAddTime(String qAddTime) {
		this.qAddTime = qAddTime;
	}
	public String getqAddId() {
		return qAddId;
	}
	public void setqAddId(String qAddId) {
		this.qAddId = qAddId;
	}
	public String getqUpdateTime() {
		return qUpdateTime;
	}
	public void setqUpdateTime(String qUpdateTime) {
		this.qUpdateTime = qUpdateTime;
	}
	public String getqUpdateId() {
		return qUpdateId;
	}
	public void setqUpdateId(String qUpdateId) {
		this.qUpdateId = qUpdateId;
	}
	public String getqCateCode() {
		return qCateCode;
	}
	public void setqCateCode(String qCateCode) {
		this.qCateCode = qCateCode;
	}
	public QuestionCate getQuestionCate() {
		return questionCate;
	}
	public void setQuestionCate(QuestionCate questionCate) {
		this.questionCate = questionCate;
	}
	@Override
	public String toString() {
		return "Questionnaire [qCode=" + qCode + ", qContent=" + qContent + ", qAddTime=" + qAddTime + ", qAddId="
				+ qAddId + ", qUpdateTime=" + qUpdateTime + ", qUpdateId=" + qUpdateId + ", qCateCode=" + qCateCode
				+ ", questionCate=" + questionCate + "]";
	}

	
	
}
