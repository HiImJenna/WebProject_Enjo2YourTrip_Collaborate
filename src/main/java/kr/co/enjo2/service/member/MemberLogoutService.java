package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class MemberLogoutService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		request.getSession().invalidate();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath());
		return forward;
	}

}
