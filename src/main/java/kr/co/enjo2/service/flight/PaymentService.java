package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.flight.FlightDao;
import kr.co.enjo2.dto.flight.FlightReserveDto;
import kr.co.enjo2.dto.flight.FlightReserveInfoDto;

public class PaymentService implements Action {

	@Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	      ActionForward forward = new ActionForward();
	      forward.setRedirect(false);
	      try {
	         // 승객 정보 얻기
	         FlightReserveDto reserveDto = getReserve(request);
	         // 가는 편, 오는 편 정보 얻기 [오는 편, 가는 편] 배열
	         FlightReserveInfoDto[] reserveInfo = getReserveInfo(request);
	         // DAO 를 통해 DB에 정보 저장하기
	         FlightDao dao = new FlightDao();
	         int result = dao.saveFlightReservation(reserveDto, reserveInfo);
	         if (result > 0) {
	   	        forward.setRedirect(true);
	            forward.setPath(request.getContextPath() +"/confirm.flight"); 
	         }
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	         System.out.println(e.getStackTrace());
	      }
	      return forward;
	   }

	   private FlightReserveInfoDto[] getReserveInfo(HttpServletRequest request) {
	      // 가는편
	      // 날짜
	      String sdateM = request.getParameter("sdateM");
	      // 항공편
	      String sairlineNm = request.getParameter("sairlineNm");
	      // 출발시간
	      String sdepPlandTime = request.getParameter("sdepPlandTime");
	      // 도착시간
	      String sarrPlandTime = request.getParameter("sarrPlandTime");
	      // 성별
	      String sprice = request.getParameter("sprice");
	      // 출발지
	      String departPlace = request.getParameter("gimpu");
	      // 도착지
	      String arrivePlace = request.getParameter("jeju");

	      // 출력 확인
			/*
			 * System.out.println("=============================");
			 * System.out.println("가는편"); System.out.println(sdateM);
			 * System.out.println(sairlineNm); System.out.println(sdepPlandTime);
			 * System.out.println(sarrPlandTime); System.out.println(sprice);
			 * System.out.println("=============================\n");
			 */
	      // FlightReserveInfoDto 객체를 만든다.
	      FlightReserveInfoDto[] reserveInfo = {new FlightReserveInfoDto(), new FlightReserveInfoDto()};
	      reserveInfo[0].setBoardingDate(sdateM);
	      reserveInfo[0].setAirlineNm(sairlineNm);
	      reserveInfo[0].setDepartTime(sdepPlandTime);
	      reserveInfo[0].setArriveTime(sarrPlandTime);
	      reserveInfo[0].setPrice(sprice);
	      reserveInfo[0].setDepartPlace(departPlace);
	      reserveInfo[0].setArrivePlace(arrivePlace);
	      reserveInfo[0].setDirection("start");

	      /////////////////////////////////////////////////////////////

	      // 오는편
	      // 날짜
	      String edateM = request.getParameter("edateM");
	      // 항공편
	      String eairlineNm = request.getParameter("eairlineNm");
	      // 출발시간
	      String edepPlandTime = request.getParameter("edepPlandTime");
	      // 도착시간
	      String earrPlandTime = request.getParameter("earrPlandTime");
	      // 가격
	      String eprice = request.getParameter("eprice");

	      // 출력 확인
			/*
			 * System.out.println("=============================");
			 * System.out.println("오는"); System.out.println(edateM);
			 * System.out.println(eairlineNm); System.out.println(edepPlandTime);
			 * System.out.println(earrPlandTime); System.out.println(eprice);
			 * System.out.println("=============================\n");
			 */
	      reserveInfo[1].setBoardingDate(edateM);
	      reserveInfo[1].setAirlineNm(eairlineNm);
	      reserveInfo[1].setDepartTime(edepPlandTime);
	      reserveInfo[1].setArriveTime(earrPlandTime);
	      reserveInfo[1].setPrice(eprice);
	      reserveInfo[1].setDepartPlace(arrivePlace);
	      reserveInfo[1].setArrivePlace(departPlace);
	      reserveInfo[1].setDirection("end");
	      
	      return reserveInfo;
	   }

	   private FlightReserveDto getReserve(HttpServletRequest request) {
	      // 승객 정보
	      // FlightReserveDto
	      // reservationNo ==> 디비의 시퀀스를 이용
	      // memberId ==> 로그인 사용자만 예약가능하기 때문에 세션에서 데이터를 얻는다
	      // String userId = (String) request.getSession().getAttribute("userid");
	      // 일단은 임시로 멤버 아이디를 얻음
	      String userId = "user1";
	      // 예약 날짜는 쿼리에서 sysdate를 통해서 만듦

	      System.out.println("=============================");
	      System.out.println("승객정보");
	      // 성
	      String passSnm = request.getParameter("passSnm");
	      // 이름
	      String passLnm = request.getParameter("passLnm");
	      // 생년월일
	      String bday = request.getParameter("bday");
	      // 국적
	      String nation = request.getParameter("nation");
	      // 성별
	      String gender = request.getParameter("gender");
	      System.out.println("=============================\n");

	      // 출력 확인
	      // System.out.println(firstNm);
	      // System.out.println(lastNm);
	      // System.out.println(birth);
	      // System.out.println(nation);
	      // System.out.println(gender);

	      // FlightReserveDto 객체를 만든다.
	      // 예약 시간은 sysdate를 사용한다!!!!
	      FlightReserveDto reserveDto = new FlightReserveDto();
	      reserveDto.setMemberFirstName(passSnm);
	      // 일단 임시로 얻은 사용자 아이디 (세션을 이용해야함)
	      reserveDto.setMemberId(userId);
	      reserveDto.setMemberLastName(passLnm);
	      reserveDto.setMemberBirth(bday);
	      reserveDto.setMemberNation(nation);
	      reserveDto.setMemberGender(gender);
	      reserveDto.setStatus("RESERVED");

	      return reserveDto;
	   }
	   
	   
}
