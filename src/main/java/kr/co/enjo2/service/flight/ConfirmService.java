package kr.co.enjo2.service.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class ConfirmService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		//System.out.println("confirmservice 토ㅇ과"); 안댐
		forward.setPath("/WEB-INF/views/flight/confirm.jsp");
		return forward;
	}

}
