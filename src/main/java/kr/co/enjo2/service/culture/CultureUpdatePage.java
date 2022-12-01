package kr.co.enjo2.service.culture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetBoardDto;

public class CultureUpdatePage implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		
		try {
			CultureDao dao = new CultureDao();
			MeetBoardDto oneGathering = dao.SearchOneGathering(mbNo);
			
			request.setAttribute("oneGathering", oneGathering);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		forward.setPath("/WEB-INF/views/culture/update.jsp");
		return forward;
	}

}
