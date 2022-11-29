package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class PassengerInfoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//****** flightCheck 에서 받은 값들 다시 저장하기 위함임 >> 마지막 예약 확인 시 뿌려야함 ******
		
		//가는 항공편 check에서 input 가져오기
		String sdateM = request.getParameter("sdateM"); //가는 날짜
		String sairlineNm = request.getParameter("sairlineNm"); //항공편
		String sdepPlandTime = request.getParameter("sdepPlandTime"); //출발시간 
		String sarrPlandTime = request.getParameter("sarrPlandTime"); //도착시간 
		String sprice = request.getParameter("sprice"); //가격

		request.setAttribute("sdateM", sdateM);
		request.setAttribute("sairlineNm", sairlineNm);
		request.setAttribute("sdepPlandTime", sdepPlandTime);
		request.setAttribute("sarrPlandTime", sarrPlandTime);
		request.setAttribute("sprice", sprice);
		
		//오는 항공편 check에서 input 가져오기
		String edateM = request.getParameter("edateM"); //오는 날짜
		String eairlineNm = request.getParameter("eairlineNm"); //항공편
		String edepPlandTime = request.getParameter("edepPlandTime"); //출발시간 
		String earrPlandTime = request.getParameter("earrPlandTime"); //도착시간 
		String eprice = request.getParameter("eprice"); //가격

		request.setAttribute("edateM", edateM);
		request.setAttribute("eairlineNm", eairlineNm);
		request.setAttribute("edepPlandTime", edepPlandTime);
		request.setAttribute("earrPlandTime", earrPlandTime);
		request.setAttribute("eprice", eprice);

			
		forward.setPath("/WEB-INF/views/flight/passengerInfo.jsp");

		return forward;
	}

}
