package kr.co.enjo2.service.culture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.CultureReviewDetailDto;

public class CultureReviewDetail implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int culNo = Integer.parseInt(request.getParameter("culNo"));
		
		try {		
			CultureDao dao = new CultureDao();
			List<CultureReviewDetailDto> list = dao.SearchCulturePlaceReviewObj(culNo);
		
			request.setAttribute("list", list);
			request.setAttribute("culNo", culNo);
			
			System.out.println("서블릿 list : " + list);
	
		} catch (Exception e) {
		   System.out.println(e.getMessage());
		}
		forward.setPath("/WEB-INF/views/culture/review.jsp");
		return forward;
	}

}
