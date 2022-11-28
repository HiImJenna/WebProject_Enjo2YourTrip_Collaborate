package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class FlightCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		/* 가는 편 정보 받기 */
		String sairlineNm = request.getParameter("sairlineNm"); //항공사
		String sdateM = request.getParameter("sdateM"); //가는 날짜
		String sdepPlandTime = request.getParameter("sdepPlandTime"); //출발시간 
		String sarrPlandTime = request.getParameter("sarrPlandTime"); //도착시간 
		String sprice = request.getParameter("sprice"); //가격

		/* 가는 편 정보 주기 */
		request.setAttribute("sairlineNm", sairlineNm);
		request.setAttribute("sdateM", sdateM);
		request.setAttribute("sdepPlandTime", sdepPlandTime);
		request.setAttribute("sarrPlandTime", sarrPlandTime);
		request.setAttribute("sprice", sprice);

		
		/* 오는 편 정보 받기 */
		String eairlineNm = request.getParameter("eairlineNm"); //항공사
		String edateM = request.getParameter("edateM"); //오는 날짜
		String edepPlandTime = request.getParameter("edepPlandTime"); //출발시간 
		String earrPlandTime = request.getParameter("earrPlandTime"); //도착시간 
		String eprice = request.getParameter("eprice"); //가격

		
		/* 오는 편 정보 주기 */
		request.setAttribute("eairlineNm", eairlineNm);
		request.setAttribute("edateM", edateM);
		request.setAttribute("edepPlandTime", edepPlandTime);
		request.setAttribute("earrPlandTime", earrPlandTime);
		request.setAttribute("eprice", eprice);
		
		//****** 승객 정보 받고 뿌리기 ~ ******
		
	    String passSnm = request.getParameter("passSnm"); //성
		String passLnm = request.getParameter("passLnm"); //이름
		String bday = request.getParameter("bday"); //생년월일
		String nation = request.getParameter("nation"); //국적
		String gender = request.getParameter("gender"); //성별
		
		request.setAttribute("passSnm", passSnm);
		request.setAttribute("passLnm", passLnm);
		request.setAttribute("bday", bday);
		request.setAttribute("nation", nation);
		request.setAttribute("gender", gender);		
		
		forward.setPath("/WEB-INF/views/flight/flightCheck.jsp");
		return forward;
	}

}
