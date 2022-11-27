package kr.co.enjo2.dto.flight;

public class FlightReservationDto {
	private int reservationNo;
	private int memberNo;
	private int flightTicketNo;
	private int passengerNum;
	// reserved or canceled // 취소 요청에 관한 것도 있으면 좋을 것 같음
	private String reservationInfo;
	private int price;
}
