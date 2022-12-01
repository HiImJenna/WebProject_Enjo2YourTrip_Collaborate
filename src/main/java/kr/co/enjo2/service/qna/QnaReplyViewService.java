package kr.co.enjo2.service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class QnaReplyViewService implements Action { // noticeReplyWrite.jsp
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			// 문의글 번호
			String no = request.getParameter("no");
			String userId = (String)request.getSession().getAttribute("userid");
			MemberDao memberDao = new MemberDao();
			MemberDto member = memberDao.findOne(userId);
			request.setAttribute("nickName", member.getNickName());
			request.setAttribute("no", no);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/qnaReplyWrite.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
