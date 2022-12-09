package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class ReturnsearchService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String sairlineNm = request.getParameter("sairlineNm"); //항공사
		String sdateM = request.getParameter("sdateM"); //가는 날짜
		String edateM = request.getParameter("edateM"); //오는 날짜
		String sdepPlandTime = request.getParameter("sdepPlandTime"); //출발시간 
		String sarrPlandTime = request.getParameter("sarrPlandTime"); //도착시간 
		String sprice = request.getParameter("sprice"); //가격

		request.setAttribute("sairlineNm", sairlineNm);
		request.setAttribute("sdateM", sdateM);
		request.setAttribute("edateM", edateM);
		request.setAttribute("sdepPlandTime", sdepPlandTime);
		request.setAttribute("sarrPlandTime", sarrPlandTime);
		request.setAttribute("sprice", sprice);
	
		
		/* 정규표현식으로 정리한 날짜 202211241526*/
		String sdateF = request.getParameter("sdateF");
		String edateF = request.getParameter("edateF");
		
		request.setAttribute("sdateF", sdateF);
		request.setAttribute("edateF", edateF);

		forward.setPath("/WEB-INF/views/flight/returnSearch.jsp");
		
		return forward;

	}

}
