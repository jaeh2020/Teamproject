package amdn.anywhere.domain;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String levelCode;
	private String memberGender;
	private String memberBirth;
	private String memberPhone;
	private String memberEmail;
	private String memberRegTime;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberRegTime() {
		return memberRegTime;
	}
	public void setMemberRegTime(String memberRegTime) {
		this.memberRegTime = memberRegTime;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", levelCode="
			+ levelCode + ", memberGender=" + memberGender + ", memberBirth=" + memberBirth + ", memberPhone="
			+ memberPhone + ", memberEmail=" + memberEmail + ", memberRegTime=" + memberRegTime + "]";
	}

}
