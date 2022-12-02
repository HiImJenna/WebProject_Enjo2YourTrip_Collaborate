package kr.co.enjo2.service.culture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetBoardDto;
import kr.co.enjo2.dto.culture.MeetReply;

public class CultureGatheringDetail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		int mbNo = 0;
				
		try {
			System.out.println("CultureGatheringDetail 요청이 들어왔습니다.");
//			int mbNo = (request.getParameter("mbNo").length() != 0) 
//					   ? Integer.parseInt(request.getParameter("mbNo"))
//					   : (int)request.getAttribute("mbNo");
			
			String mbNoString = request.getParameter("mbNo");
			
		    if ((mbNoString == null) || (mbNoString.length() == 0) || (mbNoString.equals(""))) {
		    	mbNo = (int)request.getAttribute("mbNo");
		    } else {
		    	mbNo = Integer.parseInt(request.getParameter("mbNo"));
		    }
			
			System.out.println("mbNo : " + mbNo);
			
		 	CultureDao dao = new CultureDao();
		    MeetBoardDto oneGathering = dao.SearchOneGathering(mbNo);
		    List<MeetReply> comment = dao.SearchGatheringComment(mbNo);
		    int cmNum = dao.SearchGatheringCommentNumber(mbNo);

		 	request.setAttribute("oneGathering", oneGathering);
		 	request.setAttribute("comment", comment);
		 	request.setAttribute("cmNum", cmNum);
			
		}catch(Exception e) {
		  System.out.println(e.getMessage());
		}
		forward.setPath("/WEB-INF/views/culture/culture-gathering-detail.jsp");
		return forward;
	}

}
