package kr.co.enjo2.service.culture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetJoinDto;

public class CultureJoinFromJoinList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String memId = (String)request.getSession().getAttribute("userid");
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		int result = 0;
		
		try {
		  CultureDao dao = new CultureDao();
		  MeetJoinDto join = new MeetJoinDto();
		  
		  join.setMemId(memId);
		  join.setMbNo(mbNo);
		  
		  if(dao.findJoin(memId, mbNo) == 0) {
			  result = dao.insertJoin(join);
		  }
		  
		  System.out.println("result : " + result);
		  
		  String msg = "";
		  String url = "";
		  
			if (result > 0) {
				msg = "참여하기 성공";
				url = "culture-gathering.culture";
			} else {
				msg = "참여하기 실패 이미 모임에 참여하기를 신청하셨습니다.";
				url = "culture-gathering.culture";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
		
		}catch (Exception e) {
		   System.out.println(e.getMessage());
		}
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/culture/redirect.jsp");
	
		return forward;
	}

}
