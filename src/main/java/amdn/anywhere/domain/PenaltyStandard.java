package amdn.anywhere.domain;

public class PenaltyStandard {
	private String penaltyStandardCode;
	private String penaltyStandard;
	private int penaltyScore;
	
	public String getPenaltyStandardCode() {
		return penaltyStandardCode;
	}
	public void setPenaltyStandardCode(String penaltyStandardCode) {
		this.penaltyStandardCode = penaltyStandardCode;
	}
	public String getPenaltyStandard() {
		return penaltyStandard;
	}
	public void setPenaltyStandard(String penaltyStandard) {
		this.penaltyStandard = penaltyStandard;
	}
	public int getPenaltyScore() {
		return penaltyScore;
	}
	public void setPenaltyScore(int penaltyScore) {
		this.penaltyScore = penaltyScore;
	}
	@Override
	public String toString() {
		return "PenaltyStandard [penaltyStandardCode=" + penaltyStandardCode + ", penaltyStandard=" + penaltyStandard
				+ ", penaltyScore=" + penaltyScore + "]";
	}
	
	
	
}
