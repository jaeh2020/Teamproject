package amdn.anywhere.domain;

public class SurveyResult {
	private String createCode;
	private String recruitBBCode;
	private RecruitTasterByBiz recruitTasterByBiz;
	private int numOfParti;
	private String qCateCode;
	private String qCateName;
	private QuestionCate questionCate;
	private String qCode;
	private String qContent;
	private int choice1;
	private int choice2;
	private int choice3;
	private int choice4;
	private int choice5;
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	public String getRecruitBBCode() {
		return recruitBBCode;
	}
	public void setRecruitBBCode(String recruitBBCode) {
		this.recruitBBCode = recruitBBCode;
	}
	public RecruitTasterByBiz getRecruitTasterByBiz() {
		return recruitTasterByBiz;
	}
	public void setRecruitTasterByBiz(RecruitTasterByBiz recruitTasterByBiz) {
		this.recruitTasterByBiz = recruitTasterByBiz;
	}
	public int getNumOfParti() {
		return numOfParti;
	}
	public void setNumOfParti(int numOfParti) {
		this.numOfParti = numOfParti;
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
	public int getChoice1() {
		return choice1;
	}
	public void setChoice1(int choice1) {
		this.choice1 = choice1;
	}
	public int getChoice2() {
		return choice2;
	}
	public void setChoice2(int choice2) {
		this.choice2 = choice2;
	}
	public int getChoice3() {
		return choice3;
	}
	public void setChoice3(int choice3) {
		this.choice3 = choice3;
	}
	public int getChoice4() {
		return choice4;
	}
	public void setChoice4(int choice4) {
		this.choice4 = choice4;
	}
	public int getChoice5() {
		return choice5;
	}
	public void setChoice5(int choice5) {
		this.choice5 = choice5;
	}
	@Override
	public String toString() {
		return "SurveyResult [createCode=" + createCode + ", recruitBBCode=" + recruitBBCode + ", recruitTasterByBiz="
				+ recruitTasterByBiz + ", numOfParti=" + numOfParti + ", qCateCode=" + qCateCode + ", qCateName="
				+ qCateName + ", questionCate=" + questionCate + ", qCode=" + qCode + ", qContent=" + qContent
				+ ", choice1=" + choice1 + ", choice2=" + choice2 + ", choice3=" + choice3 + ", choice4=" + choice4
				+ ", choice5=" + choice5 + "]";
	}
	public String getqCateName() {
		return qCateName;
	}
	public void setqCateName(String qCateName) {
		this.qCateName = qCateName;
	}
	
}
