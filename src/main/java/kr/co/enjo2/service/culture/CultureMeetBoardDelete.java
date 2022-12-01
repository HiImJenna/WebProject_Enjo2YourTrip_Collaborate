package kr.co.enjo2.service.culture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureMeetBoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) { 
		
		// String memId = (String)request.getSession().getAttribute("userid"); 
		
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		
		ActionForward forward = new ActionForward();
		
		try {
			CultureDao dao = new CultureDao();
		    int result = dao.deleteMeetBoard(mbNo);
		    
		    if(result > 0) {
				  forward.setRedirect(true);
				  forward.setPath(request.getContextPath() + "/culture-gathering.culture");
			} else {
			    forward = null;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('삭제 실패, 모임 게시판 목록 페이지로 돌아갑니다.'); location.href=" + "/culture-gathering.culture;</script>");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
