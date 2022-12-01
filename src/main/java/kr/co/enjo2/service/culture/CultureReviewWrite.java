package kr.co.enjo2.service.culture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.CultureReviewDetailDto;

public class CultureReviewWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String comment = request.getParameter("comment");
		String memId =(String)request.getSession().getAttribute("userid");
		int culNo = Integer.parseInt(request.getParameter("culNo"));
		
		try {	
			CultureDao dao = new CultureDao();
			dao.insertReviewComment(comment, memId, culNo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("culture-review-detail.culture?culNo=" + culNo);
		return forward;
	}
}
