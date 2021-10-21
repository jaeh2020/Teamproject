package amdn.anywhere.domain;

public class ReviewScore {
	private String scoreCode;
	private int starCount;
	private String reviewScore;
	public String getScoreCode() {
		return scoreCode;
	}
	public void setScoreCode(String scoreCode) {
		this.scoreCode = scoreCode;
	}
	public int getStarCount() {
		return starCount;
	}
	public void setStarCount(int starCount) {
		this.starCount = starCount;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	@Override
	public String toString() {
		return "ReviewScore [scoreCode=" + scoreCode + ", starCount=" + starCount + ", reviewScore=" + reviewScore
				+ "]";
	}
	
	

}
