package kr.co.enjo2.service.culture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetJoinList;

public class CultureJoinlist implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String memId = (String)request.getSession().getAttribute("userid"); 
		
		try {
			CultureDao dao = new CultureDao();
			List<MeetJoinList> list = dao.SearchJoin(memId);
			
			request.setAttribute("list", list);
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}
		forward.setPath("/WEB-INF/views/culture/myaction.jsp");
		return forward;
	}

}
