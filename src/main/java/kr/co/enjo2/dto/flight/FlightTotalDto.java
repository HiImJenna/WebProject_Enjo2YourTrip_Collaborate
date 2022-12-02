package kr.co.enjo2.dto.flight;

public class FlightTotalDto {

//////////////////////////////rsv_info DTO/////////////////////////////////

	// 예약정보번호
	private int flightInfoNo;
	// 예약 번호
	private int reservationNo;
	// 가거나 돌아오는 날짜 (탑승 날짜)
	private String boardingDate;
	// 항공편
	private String airlineNm;
	// 출발시간
	private String departTime;
	// 도착시간
	private String arriveTime;
	// 출발지
	private String departPlace;
	// 도착지
	private String arrivePlace;
	// 금액
	private String price;
	// 왕편(start) 복편(end) 정보
	private String direction = "start";

//////////////////////////////reservation DTO/////////////////////////////////

	// 예약 번호
	private int rsvNo;
	// 사용자, 회원 아이디
	private String memberId;
	// 예약 날짜
	private String rsvDate;
	// 성, 이름
	private String memberLastName;
	private String memberFirstName;
	// 생년월일
	private String memberBirth;
	// 국적
	private String memberNation;
	// 성별
	private String memberGender;
	// 예약 상태
	private String status;

	public int getFlightInfoNo() {
		return flightInfoNo;
	}

	public void setFlightInfoNo(int flightInfoNo) {
		this.flightInfoNo = flightInfoNo;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getBoardingDate() {
		return boardingDate;
	}

	public void setBoardingDate(String boardingDate) {
		this.boardingDate = boardingDate;
	}

	public String getAirlineNm() {
		return airlineNm;
	}

	public void setAirlineNm(String airlineNm) {
		this.airlineNm = airlineNm;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}

	public String getArrivePlace() {
		return arrivePlace;
	}

	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}

	@Override
	public String toString() {
		return "FlightTotalDto [flightInfoNo=" + flightInfoNo + ", reservationNo=" + reservationNo + ", boardingDate="
				+ boardingDate + ", airlineNm=" + airlineNm + ", departTime=" + departTime + ", arriveTime="
				+ arriveTime + ", departPlace=" + departPlace + ", arrivePlace=" + arrivePlace + ", price=" + price
				+ ", direction=" + direction + ", rsvNo=" + rsvNo + ", memberId=" + memberId + ", rsvDate=" + rsvDate
				+ ", memberLastName=" + memberLastName + ", memberFirstName=" + memberFirstName + ", memberBirth="
				+ memberBirth + ", memberNation=" + memberNation + ", memberGender=" + memberGender + ", status="
				+ status + "]";
	}
}