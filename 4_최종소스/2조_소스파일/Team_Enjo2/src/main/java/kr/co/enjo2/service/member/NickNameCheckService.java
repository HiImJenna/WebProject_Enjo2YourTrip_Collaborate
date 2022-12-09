package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class NickNameCheckService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String id = request.getParameter("id");
			String nickname = request.getParameter("nickname");
			MemberDao dao = new MemberDao();
			MemberDto member = dao.findOne(id);
			if (member.getNickName().equals(nickname)) {
				response.setStatus(200);
			} else {
				int result = dao.isNicknameExist(nickname);
				if (result == 0) {
					response.setStatus(200);
				} else {
					response.setStatus(400);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
