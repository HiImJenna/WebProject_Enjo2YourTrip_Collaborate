package kr.co.enjo2.service.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class RestaurantRecommandService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		
	
		request.setAttribute("keyword", type);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/restaurant/restaurantRecommand.jsp");
		return forward;
	}

}
