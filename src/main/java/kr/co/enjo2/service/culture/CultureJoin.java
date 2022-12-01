package kr.co.enjo2.service.culture;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;
import kr.co.enjo2.dto.culture.MeetBoardDto;
import kr.co.enjo2.dto.culture.MeetJoinDto;
import kr.co.enjo2.dto.culture.MeetReply;

public class CultureJoin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		// String memId = request.getParameter("memId");
		String memId = (String) request.getSession().getAttribute("userid");
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		int result = 0;
		// ActionForward forward = new ActionForward();
		ActionForward forward = null;
		
		System.out.println("memId : " + memId);
		System.out.println("mbNo : " +  mbNo);
		
		try {
		  CultureDao dao = new CultureDao();
		  MeetJoinDto join = new MeetJoinDto();
		  
		  join.setMemId(memId);
		  join.setMbNo(mbNo);
		  
		  if(dao.findJoin(memId, mbNo) == 0) {
			  result = dao.insertJoin(join);
		  }
		  
		    System.out.println("CultureJoin test join : " + join);
			
			response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         if (result > 0) {
	          System.out.println("CultureJoin test reuslt if문 통과 ");
	            out.println("<script>alert('참여하기에 성공했습니다'); location.href=\"" + request.getContextPath() + "/culture-gathering-detail.culture?mbNo=" + mbNo + "\""+";</script>");
	      
	         } else {
	        	 out.println("<script>alert('참여하기에 실패했습니다. 이미 참여했는지 나의 활동에서 확인해주세요.'); location.href=\"" + request.getContextPath() + "/culture-gathering-detail.culture?mbNo=" + mbNo + "\""+";</script>");
	         }
		
		}catch (Exception e) {
		   System.out.println(e.getMessage());
		}
	
		return forward;
	}

}
