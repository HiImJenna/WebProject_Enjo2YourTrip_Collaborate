package kr.co.enjo2.service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;

public class QnaViewService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String nickName = "게스트";
		try {
			String userId = (String)request.getSession().getAttribute("userid");
			if (userId != null) {
				nickName = new MemberDao().findOne(userId).getNickName();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("nickName", nickName);
		forward.setPath("/WEB-INF/views/member/qnaWriteView.jsp");
		return forward;
	}
}
