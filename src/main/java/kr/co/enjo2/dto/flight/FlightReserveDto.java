package kr.co.enjo2.dto.flight;

public class FlightReserveDto {
	
	//private int reservationNo;
	private String memberId;
	private int rsvDate;
	private String memberLastName;
	private String memberFirstName;
	private String memberBirth;
	private String memberNation;
	private String memberGender;
	
	public FlightReserveDto() {}

	public FlightReserveDto(int reservationNo, String memberId, String memberLastName, String memberFirstName,
		String memberBirth, String memberNation, String memberGender) {
		super();
		//this.reservationNo = reservationNo;
		this.memberId = memberId;
		this.memberLastName = memberLastName;
		this.memberFirstName = memberFirstName;
		this.memberBirth = memberBirth;
		this.memberNation = memberNation;
		this.memberGender = memberGender;
	}

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

	public void setMemberBirth(String bday) {
		this.memberBirth = bday;
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

	
	/*
	 * public int getReservationNo() { return reservationNo; } public void
	 * setReservationNo(int reservationNo) { this.reservationNo = reservationNo; }
	 */	
	
	
	
}
