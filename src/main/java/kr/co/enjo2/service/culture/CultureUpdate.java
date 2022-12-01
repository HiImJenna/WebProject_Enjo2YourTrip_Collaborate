package kr.co.enjo2.service.culture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		 
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		
		
		try {
			CultureDao dao = new CultureDao();
			result = dao.meetBoardUpdate(mbNo, title, context);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String url = "culture-gathering.culture";
		if (result > 0) {
			msg = "update success";
		} else {
			msg = "update fail";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		
		if(result > 0){
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/culture-gathering-detail.culture?mbNo=" + mbNo);
		} else {
			forward = null;
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('수정 실패, 모임 게시판 목록 페이지로 돌아갑니다.'); location.href='culture-gathering.culture';</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return forward;
	}
	

}
