package amdn.anywhere.domain;

import java.util.List;

public class QuestionCate {
	
	private String cateCode;
	private String cateName;
	private String cateAddTime;
	private String cateAddId;
	private String cateUpdateTime;
	private String cateUpdateId;
	private List<Questionnaire> questionList;
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
	public String getCateAddTime() {
		return cateAddTime;
	}
	public void setCateAddTime(String cateAddTime) {
		this.cateAddTime = cateAddTime;
	}
	public String getCateAddId() {
		return cateAddId;
	}
	public void setCateAddId(String cateAddId) {
		this.cateAddId = cateAddId;
	}
	public String getCateUpdateTime() {
		return cateUpdateTime;
	}
	public void setCateUpdateTime(String cateUpdateTime) {
		this.cateUpdateTime = cateUpdateTime;
	}
	public String getCateUpdateId() {
		return cateUpdateId;
	}
	public void setCateUpdateId(String cateUpdateId) {
		this.cateUpdateId = cateUpdateId;
	}
	public List<Questionnaire> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Questionnaire> questionList) {
		this.questionList = questionList;
	}
	@Override
	public String toString() {
		return "QuestionCate [cateCode=" + cateCode + ", cateName=" + cateName + ", cateAddTime=" + cateAddTime
				+ ", cateAddId=" + cateAddId + ", cateUpdateTime=" + cateUpdateTime + ", cateUpdateId=" + cateUpdateId
				+ ", questionList=" + questionList + "]";
	}
	
}
