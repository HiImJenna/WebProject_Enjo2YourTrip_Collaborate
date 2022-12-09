package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				forward.setRedirect(true);
				forward.setPath(request.getContextPath() + "/loginView.do");
			} else {
				// 아이디, 닉네임, 이메일 필요함
				MemberDto member = new MemberDao().findOne(userId);
				request.setAttribute("member", member.getId());
				request.setAttribute("nickName", member.getNickName());
				request.setAttribute("email", member.getEmail());
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/member/memberEdit.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace().toString());
		}
		return forward;
	}
}