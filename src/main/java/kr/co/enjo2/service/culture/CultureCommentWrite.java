package kr.co.enjo2.service.culture;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetReply;

public class CultureCommentWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String comment = request.getParameter("comment");
		String title = request.getParameter("title");
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
	//	String memid =request.getParameter("memid");
		String memid = (String) request.getSession().getAttribute("userid");
		
		int result = 0;
		
		try {
			CultureDao dao = new CultureDao();
			MeetReply writerInformation = dao.findPersonInformation(memid);
			
			MeetReply reply = new MeetReply();
			
		    reply.setMrComment(comment);
		    reply.setMbNo(mbNo);
		    reply.setMemid(memid);
		    reply.setMemNic(writerInformation.getMemNic());
		    reply.setMemPro(writerInformation.getMemPro());
		    
		    result = dao.insertMeetReply(reply);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
//		String msg = "";
//		String url = "";
//		if (result > 0) {
//			msg = "insert success";
//			url = "culture-gathering-detail.culture";
//		} else {
//			msg = "insert fail";
//			url = "culture-gathering-detail.culture";
//		}
//
//	    System.out.println("CultureCommentWrite mbNo : " + mbNo);
//		request.setAttribute("mbNo", mbNo);
//		request.setAttribute("msg", msg);
//		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("culture-gathering-detail.culture");
		return forward;
	}

}
