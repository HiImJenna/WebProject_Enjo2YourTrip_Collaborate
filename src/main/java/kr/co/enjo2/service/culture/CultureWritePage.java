package kr.co.enjo2.service.culture;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.CultureMemberDto;
import kr.co.enjo2.dto.culture.MeetReply;

public class CultureWritePage implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String memid = (String) request.getSession().getAttribute("userid");
		
		try {
	      CultureDao dao = new CultureDao();
	      CultureMemberDto member = dao.searchMember(memid);
	      
	      request.setAttribute("member", member);
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			CultureDao dao = new CultureDao();
//			MeetReply writerInformation = dao.findPersonInformation(memid);
//			
//			MeetReply reply = new MeetReply();
//			
//		    reply.setMrComment(comment);
//		    reply.setMbNo(mbNo);
//		    reply.setMemid(memid);
//		    reply.setMemNic(writerInformation.getMemNic());
//		    reply.setMemPro(writerInformation.getMemPro());
//		    
//		    result = dao.insertMeetReply(reply);
//			
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println("CultureWritePage 요청이 들어왔습니다.");
		forward.setPath("/WEB-INF/views/culture/write.jsp");
		return forward;
	}

}
