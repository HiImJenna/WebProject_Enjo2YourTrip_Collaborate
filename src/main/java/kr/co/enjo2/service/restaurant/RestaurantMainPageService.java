package kr.co.enjo2.service.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class RestaurantMainPageService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/restaurant/restaurantMain.html");
		return forward;
	}

}
