package kr.co.enjo2.dto.flight;

public class FlightReserveInfoDto {

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

	public String getBoardingDate() {
		return boardingDate;
	}

	public void setBoardingDate(String boardingDate) {
		this.boardingDate = boardingDate;
	}

	public int getFlightInfoNo() {
		return flightInfoNo;
	}

	public FlightReserveInfoDto() {
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

	@Override
	public String toString() {
		return "FlightReserveInfoDto [flightInfoNo=" + flightInfoNo + ", reservationNo=" + reservationNo
				+ ", boardingDate=" + boardingDate + ", airlineNm=" + airlineNm + ", departTime=" + departTime
				+ ", arriveTime=" + arriveTime + ", departPlace=" + departPlace + ", arrivePlace=" + arrivePlace
				+ ", price=" + price + ", direction=" + direction + "]";
	}
}