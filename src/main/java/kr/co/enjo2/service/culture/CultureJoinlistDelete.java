package kr.co.enjo2.service.culture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureJoinlistDelete implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int meNo = Integer.parseInt(request.getParameter("meNo"));
		String memId = request.getParameter("memId");
		PrintWriter out;
		
		ActionForward forward = new ActionForward();
		
		try {
	       CultureDao dao = new CultureDao();
	       int result = dao.deleteJoin(meNo);
	       
	       if(result > 0) {
			  forward.setRedirect(true);
			  forward.setPath(request.getContextPath() + "/culture-join-list.culture?memId=" + memId);
				
		   } else {
			    forward = null;
				response.setContentType("text/html; charset=UTF-8");
				try {
					out = response.getWriter();
					out.println("<script>alert('취소 실패, 나의 활동 모임 페이지로 돌아갑니다.'); location.href=" + "/culture-join-list.culture?memId=" + memId + ";</script>");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	       
		} catch (Exception e) {
			// TODO: handle exception
		}

		return forward;
	}

}
