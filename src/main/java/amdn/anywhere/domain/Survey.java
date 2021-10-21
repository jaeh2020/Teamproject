package amdn.anywhere.domain;

import java.util.List;

public class Survey {
	private String createCode;
	private String storeCode;
	private String recruitBBCode;
	private String regTime;
	private String qCateList;
	private int numOfParti;
	private String stateCode;
	private String stateName;
	private Store store;
	private RecruitTasterByBiz recruitTasterByBiz;
	private List<QuestionCate> cateList;
	public String getCreateCode() {
		return createCode;
	}
	public void setCreateCode(String createCode) {
		this.createCode = createCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getRecruitBBCode() {
		return recruitBBCode;
	}
	public void setRecruitBBCode(String recruitBBCode) {
		this.recruitBBCode = recruitBBCode;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getqCateList() {
		return qCateList;
	}
	public void setqCateList(String qCateList) {
		this.qCateList = qCateList;
	}
	public int getNumOfParti() {
		return numOfParti;
	}
	public void setNumOfParti(int numOfParti) {
		this.numOfParti = numOfParti;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public RecruitTasterByBiz getRecruitTasterByBiz() {
		return recruitTasterByBiz;
	}
	public void setRecruitTasterByBiz(RecruitTasterByBiz recruitTasterByBiz) {
		this.recruitTasterByBiz = recruitTasterByBiz;
	}
	public List<QuestionCate> getCateList() {
		return cateList;
	}
	public void setCateList(List<QuestionCate> cateList) {
		this.cateList = cateList;
	}
	@Override
	public String toString() {
		return "Survey [createCode=" + createCode + ", storeCode=" + storeCode + ", recruitBBCode=" + recruitBBCode
				+ ", regTime=" + regTime + ", qCateList=" + qCateList + ", numOfParti=" + numOfParti + ", stateCode="
				+ stateCode + ", stateName=" + stateName + ", store=" + store + ", recruitTasterByBiz="
				+ recruitTasterByBiz + ", cateList=" + cateList + "]";
	}

}
