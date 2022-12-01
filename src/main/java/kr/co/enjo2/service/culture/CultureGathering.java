package kr.co.enjo2.service.culture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetBoardDto;

public class CultureGathering implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		try {
		 	CultureDao dao = new CultureDao();
		 	List<MeetBoardDto> list = dao.SearchGathering();
		 	
		 	request.setAttribute("list", list);
			
		}catch(Exception e) {
		  System.out.println(e.getMessage());
		}
		forward.setPath("/WEB-INF/views/culture/culture-gathering.jsp");
		return forward;
	}

}
