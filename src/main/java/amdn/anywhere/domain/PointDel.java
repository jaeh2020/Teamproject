package amdn.anywhere.domain;

public class PointDel {

	private String pointDelNum;
	private String userId;
	private String pointNum;
	private String poStaCode;
	private String pointDelTime;
	private String delPoint;
	private String remainPoint;
	public String getPointDelNum() {
		return pointDelNum;
	}
	public void setPointDelNum(String pointDelNum) {
		this.pointDelNum = pointDelNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPointNum() {
		return pointNum;
	}
	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}
	public String getPoStaCode() {
		return poStaCode;
	}
	public void setPoStaCode(String poStaCode) {
		this.poStaCode = poStaCode;
	}
	public String getPointDelTime() {
		return pointDelTime;
	}
	public void setPointDelTime(String pointDelTime) {
		this.pointDelTime = pointDelTime;
	}
	public String getDelPoint() {
		return delPoint;
	}
	public void setDelPoint(String delPoint) {
		this.delPoint = delPoint;
	}
	public String getRemainPoint() {
		return remainPoint;
	}
	public void setRemainPoint(String remainPoint) {
		this.remainPoint = remainPoint;
	}
	@Override
	public String toString() {
		return "PointDel [pointDelNum=" + pointDelNum + ", userId=" + userId + ", pointNum=" + pointNum + ", poStaCode="
				+ poStaCode + ", pointDelTime=" + pointDelTime + ", delPoint=" + delPoint + ", remainPoint="
				+ remainPoint + "]";
	}
	
	
}
