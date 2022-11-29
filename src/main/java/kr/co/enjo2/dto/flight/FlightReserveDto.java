package kr.co.enjo2.dto.flight;

public class FlightReserveDto {
	
	private String memberId;
	private int rsvDate;
	private String memberLastName;
	private String memberFirstName;
	private String memberBirth;
	private String memberNation;
	private String memberGender;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FlightReserveDto() {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(int rsvDate) {
		this.rsvDate = rsvDate;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberNation() {
		return memberNation;
	}

	public void setMemberNation(String memberNation) {
		this.memberNation = memberNation;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	@Override
	public String toString() {
		return "FlightReserveDto [memberId=" + memberId + ", rsvDate=" + rsvDate + ", memberLastName=" + memberLastName
				+ ", memberFirstName=" + memberFirstName + ", memberBirth=" + memberBirth + ", memberNation="
				+ memberNation + ", memberGender=" + memberGender + ", status=" + status + "]";
	}





	
	
	
}
