package amdn.anywhere.domain;

public class Point {

	private String pointNum;
	private String userId;
	private String oTotal;
	private String pointSave;
	private String pointContents;
	private String poStaCode;
	private String pointSaveTime;
	private String pointAdd;
	private String beforePointHistory;
	private String afterPointHistory;
	private String predDelTime;
	private PointDelStandard pointDelStandard;
	private PointDel pointDel;
	public String getPointNum() {
		return pointNum;
	}
	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getoTotal() {
		return oTotal;
	}
	public void setoTotal(String oTotal) {
		this.oTotal = oTotal;
	}
	public String getPointSave() {
		return pointSave;
	}
	public void setPointSave(String pointSave) {
		this.pointSave = pointSave;
	}
	public String getPointContents() {
		return pointContents;
	}
	public void setPointContents(String pointContents) {
		this.pointContents = pointContents;
	}
	public String getPoStaCode() {
		return poStaCode;
	}
	public void setPoStaCode(String poStaCode) {
		this.poStaCode = poStaCode;
	}
	public String getPointSaveTime() {
		return pointSaveTime;
	}
	public void setPointSaveTime(String pointSaveTime) {
		this.pointSaveTime = pointSaveTime;
	}
	public String getPointAdd() {
		return pointAdd;
	}
	public void setPointAdd(String pointAdd) {
		this.pointAdd = pointAdd;
	}
	public String getBeforePointHistory() {
		return beforePointHistory;
	}
	public void setBeforePointHistory(String beforePointHistory) {
		this.beforePointHistory = beforePointHistory;
	}
	public String getAfterPointHistory() {
		return afterPointHistory;
	}
	public void setAfterPointHistory(String afterPointHistory) {
		this.afterPointHistory = afterPointHistory;
	}
	public String getPredDelTime() {
		return predDelTime;
	}
	public void setPredDelTime(String predDelTime) {
		this.predDelTime = predDelTime;
	}
	public PointDelStandard getpointDelStandard() {
		return pointDelStandard;
	}
	public void setpointDelStandard(PointDelStandard pointDelStandard) {
		this.pointDelStandard = pointDelStandard;
	}
	public PointDel getPointDel() {
		return pointDel;
	}
	public void setPointDel(PointDel pointDel) {
		this.pointDel = pointDel;
	}
	@Override
	public String toString() {
		return "Point [pointNum=" + pointNum + ", userId=" + userId + ", oTotal=" + oTotal + ", pointSave=" + pointSave
				+ ", pointContents=" + pointContents + ", poStaCode=" + poStaCode + ", pointSaveTime=" + pointSaveTime
				+ ", pointAdd=" + pointAdd + ", beforePointHistory=" + beforePointHistory + ", afterPointHistory="
				+ afterPointHistory + ", predDelTime=" + predDelTime + ", pointDelStandard=" + pointDelStandard
				+ ", pointDel=" + pointDel + "]";
	}
	
}
