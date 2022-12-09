package kr.co.enjo2.service.culture;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetBoardDto;

public class CultureWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CultureReview 요청이 들어왔습니다.");
		
		String userId = (String) request.getSession().getAttribute("userid");
		
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		// String userId = request.getParameter("userId");
		int result = 0;
		
		MeetBoardDto meetBoard = new MeetBoardDto();
		
		meetBoard.setMbTitle(title);
		meetBoard.setMbContent(context);
		meetBoard.setMemId(userId);
		
		
		try {
			CultureDao dao = new CultureDao();
			result = dao.insertMeetBoard(meetBoard);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String url = "";
		if (result > 0) {
			msg = "insert success";
			url = "culture-gathering.culture";
		} else {
			msg = "insert fail";
			url = "write.culture";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		// forward.setRedirect(true);
		forward.setPath("/WEB-INF/views/culture/redirect.jsp");
		return forward;
	}

}
