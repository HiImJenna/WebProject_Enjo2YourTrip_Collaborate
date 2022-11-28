package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class DepartsearchService implements Action {
 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		/*
		 * dateM : Main에서 선택한 날짜 (2022-11-26) 
		 * dateF : dateM을 형식 변환한 날짜 (20221126)
		 */		
		
		
		/*메인에서 선택한 날짜 받아오기*/		
		String sdateM = request.getParameter("sdateM");
		String edateM = request.getParameter("edateM");
		
		//위 팝업에 2022-11-23 형식으로 뿌리기위해 메인 선택 날짜 Set 해주기
		request.setAttribute("sdateM", sdateM);
		request.setAttribute("edateM", edateM);
		
		//API 요청을 위해 가공 시작
		String sdateF = sdateM;
		String edateF = edateM;
		
		//숫자만 남기기 ('-'제거)
		sdateF = sdateF.replaceAll("[^0-9]", "");
		edateF = edateF.replaceAll("[^0-9]", "");
		
		
		request.setAttribute("sdateF", sdateF);
		request.setAttribute("edateF", edateF);
		
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/flight/departSearch.jsp");
		
		return forward;
	}
}
