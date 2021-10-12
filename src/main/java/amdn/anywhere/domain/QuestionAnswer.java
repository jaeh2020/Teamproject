package amdn.anywhere.domain;

public class QuestionAnswer {
	private String answerCode;
	private String recruitBCode;
	private String recruitACode;
	private String surveyCode;
	private String questionCode;
	private String tasterChoice;
	private String userId;
	private String regTime;
	public String getAnswerCode() {
		return answerCode;
	}
	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}
	public String getRecruitBCode() {
		return recruitBCode;
	}
	public void setRecruitBCode(String recruitBCode) {
		this.recruitBCode = recruitBCode;
	}
	public String getRecruitACode() {
		return recruitACode;
	}
	public void setRecruitACode(String recruitACode) {
		this.recruitACode = recruitACode;
	}
	public String getSurveyCode() {
		return surveyCode;
	}
	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}
	public String getTasterChoice() {
		return tasterChoice;
	}
	public void setTasterChoice(String tasterChoice) {
		this.tasterChoice = tasterChoice;
	}
	public String getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "QuestionAnswer [answerCode=" + answerCode + ", recruitBCode=" + recruitBCode + ", recruitACode="
				+ recruitACode + ", surveyCode=" + surveyCode + ", tasterChoice="
				+ tasterChoice + ", userId=" + userId + ", questionCode=" + questionCode + ", regTime=" + regTime + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
