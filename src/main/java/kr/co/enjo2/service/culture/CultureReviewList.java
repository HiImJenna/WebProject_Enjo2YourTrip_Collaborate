package kr.co.enjo2.service.culture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class CultureReviewList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String gu = request.getParameter("gu");
		
		request.setAttribute("gu", gu);
		
		forward.setPath("/WEB-INF/views/culture/culture-review-list.jsp");
		return forward;
	}

}
