package amdn.anywhere.domain;

import java.util.List;

public class RecruitTasterByBiz {
	private String recruitTBizCode;
	private String bizId;
	private String recruitTitle;
	private String surveyTitle;
	private int recruitNumTotal;
	private int recruitNumNow;
	private String recruitFinTime;
	private String adminId;
	private String stateCode;
	private String requestTime;
	private Menu menuCode;
	private List<String> ageCodeList;
	private List<QuestionCate> specialCateList;
	private List<QuestionCate> cateList;
	private Store StoreInfo;
	
	public String getRecruitTBizCode() {
		return recruitTBizCode;
	}
	public void setRecruitTBizCode(String recruitTBizCode) {
		this.recruitTBizCode = recruitTBizCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getRecruitTitle() {
		return recruitTitle;
	}
	public void setRecruitTitle(String recruitTitle) {
		this.recruitTitle = recruitTitle;
	}
	public String getSurveyTitle() {
		return surveyTitle;
	}
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}
	public int getRecruitNumTotal() {
		return recruitNumTotal;
	}
	public void setRecruitNumTotal(int recruitNumTotal) {
		this.recruitNumTotal = recruitNumTotal;
	}
	public int getRecruitNumNow() {
		return recruitNumNow;
	}
	public void setRecruitNumNow(int recruitNumNow) {
		this.recruitNumNow = recruitNumNow;
	}
	public String getRecruitFinTime() {
		return recruitFinTime;
	}
	public void setRecruitFinTime(String recruitFinTime) {
		this.recruitFinTime = recruitFinTime;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public Menu getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(Menu menuCode) {
		this.menuCode = menuCode;
	}
	public List<String> getAgeCodeList() {
		return ageCodeList;
	}
	public void setAgeCodeList(List<String> ageCodeList) {
		this.ageCodeList = ageCodeList;
	}
	public List<QuestionCate> getSpecialCateList() {
		return specialCateList;
	}
	public void setSpecialCateList(List<QuestionCate> specialCateList) {
		this.specialCateList = specialCateList;
	}
	public List<QuestionCate> getCateList() {
		return cateList;
	}
	public void setCateList(List<QuestionCate> cateList) {
		this.cateList = cateList;
	}
	public Store getStoreInfo() {
		return StoreInfo;
	}
	public void setStoreInfo(Store storeInfo) {
		StoreInfo = storeInfo;
	}
	@Override
	public String toString() {
		return "RecruitTasterByBiz [recruitTBizCode=" + recruitTBizCode + ", bizId=" + bizId + ", recruitTitle="
				+ recruitTitle + ", surveyTitle=" + surveyTitle + ", recruitNumTotal=" + recruitNumTotal
				+ ", recruitNumNow=" + recruitNumNow + ", recruitFinTime=" + recruitFinTime + ", adminId=" + adminId
				+ ", stateCode=" + stateCode + ", requestTime=" + requestTime + ", menuCode=" + menuCode
				+ ", ageCodeList=" + ageCodeList + ", specialCateList=" + specialCateList + ", cateList=" + cateList
				+ ", StoreInfo=" + StoreInfo + "]";
	}
	
	
}
