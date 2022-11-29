package kr.co.enjo2.service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;

public class QnaViewService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String userId = (String)request.getSession().getAttribute("userid");
			if (userId != null) {
				forward = new ActionForward();
				String nickName = new MemberDao().findOne(userId).getNickName();
				forward.setRedirect(false);
				request.setAttribute("nickName", nickName);
				forward.setPath("/WEB-INF/views/member/qnaWriteView.jsp");
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인이 필요한 서비스 입니다.'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
