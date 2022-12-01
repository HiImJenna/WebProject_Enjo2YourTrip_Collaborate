package kr.co.enjo2.service.culture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureCommentDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int mbNo = Integer.parseInt(request.getParameter("mbNo"));
		int mrNo = Integer.parseInt(request.getParameter("mrNo"));
		ActionForward forward = new ActionForward();
		
		try {
		   CultureDao dao = new CultureDao();
		   int result = dao.deleteComment(mrNo);
			
		   System.out.println("CultureCommentDelete result : " + result);
		   String msg = (result > 0) ? "delete success" : "delete fail";
		   
		   request.setAttribute("msg", msg);
		   request.setAttribute("url", "/culture-gathering-detail.culture?mbNo=" + mbNo);
		   
		   if(result > 0) {
			  forward.setRedirect(true);
			  forward.setPath(request.getContextPath() + "/culture-gathering-detail.culture?mbNo=" + mbNo);
		   } else {
			    forward = null;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('수정 실패, 모임 게시판 목록 페이지로 돌아갑니다.'); location.href=" + "/culture-gathering-detail.culture?mbNo=" + mbNo + ";</script>");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   
		   System.out.println("CultureCommentDelete forward : " + forward);
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
