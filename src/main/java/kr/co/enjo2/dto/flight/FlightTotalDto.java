package kr.co.enjo2.dto.flight;

public class FlightTotalDto {
   
//////////////////////////////rsv_info DTO/////////////////////////////////
   
   //// DB의 힘을 빌리는 영역 /////////////////////////
   private String flightInfoNo;
   private int reservationNo;
   /////////////////////////////

   // 가거나 돌아오는 날짜 (탑승 날짜)
   private String boardingDate;
   // 항공편
   private String airlineNm;
   // 출발시간
   private String departTime;
   // 도착시간
   private String arriveTime;
   // 금액
   private String price;
   // 왕편(start) 복편(end) 정보
   private String direction = "start";
   // 출발 공항
   private String departPlace;
   // 도착 공항
   private String arrivePlace;

//////////////////////////////reservation DTO/////////////////////////////////
   
   private String memberId;
   private String rsvCreatedDate;
   private String memberLastName;
   private String memberFirstName;
   private String memberBirth;
   private String memberNation;
   private String memberGender;
   private String status;
   
   public String getFlightInfoNo() {
      return flightInfoNo;
   }

   public FlightTotalDto() {
      
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

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public String getRsvCreatedDate() {
      return rsvCreatedDate;
   }

   public void setRsvCreatedDate(String rsvCreatedDate) {
      this.rsvCreatedDate = rsvCreatedDate;
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

   public void setFlightInfoNo(String flightInfoNo) {
      this.flightInfoNo = flightInfoNo;
   }

   @Override
   public String toString() {
      return "FlightTotalDto [flightInfoNo=" + flightInfoNo + ", reservationNo=" + reservationNo + ", boardingDate="
            + boardingDate + ", airlineNm=" + airlineNm + ", departTime=" + departTime + ", arriveTime="
            + arriveTime + ", price=" + price + ", direction=" + direction + ", departPlace=" + departPlace
            + ", arrivePlace=" + arrivePlace + ", memberId=" + memberId + ", rsvCreatedDate=" + rsvCreatedDate
            + ", memberLastName=" + memberLastName + ", memberFirstName=" + memberFirstName + ", memberBirth="
            + memberBirth + ", memberNation=" + memberNation + ", memberGender=" + memberGender + ", status="
            + status + "]";
   }
   
   
   

}