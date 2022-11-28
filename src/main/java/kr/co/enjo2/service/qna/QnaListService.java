package kr.co.enjo2.service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class QnaListService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		try {
			String pageStr = request.getParameter("page");
			int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		return forward;
	}
}
