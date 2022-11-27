package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

//서비스를 지원하는 모드 객체는 Action 인터페이스를 구현하기를 원해요
// 당신은 ActionForward execute 반드시 구현해야 한다
public class ManagementFlightService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ActionForward action = new ActionForward();
		action.setRedirect(false);
		action.setPath("/WEB-INF/views/member/managementFlight.jsp");
		return action;
	}

}