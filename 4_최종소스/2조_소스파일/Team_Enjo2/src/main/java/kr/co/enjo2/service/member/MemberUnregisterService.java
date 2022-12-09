package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberUnregisterService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward action = new ActionForward();
		action.setRedirect(false);
		action.setPath("/WEB-INF/views/member/memberUnregister.jsp");
		
		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				action.setRedirect(true);
				action.setPath(request.getContextPath() + "/loginView.do");
			} else {
				MemberDao dao = new MemberDao();
				MemberDto member = dao.findOne(userId);
				request.setAttribute("userId", member.getId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return action;
	}
}