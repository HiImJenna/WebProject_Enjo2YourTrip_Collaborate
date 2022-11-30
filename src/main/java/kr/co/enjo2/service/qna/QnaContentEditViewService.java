package kr.co.enjo2.service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.member.MemberDto;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaContentEditViewService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			forward = new ActionForward();
			forward.setRedirect(false);
			int no = Integer.parseInt(request.getParameter("no"));
			String userId = (String) request.getSession().getAttribute("userid");
			QnaDto qna = new QnaDao().findOneByNo(no);
			MemberDto member = new MemberDao().findOne(qna.getMemberId());
			request.setAttribute("no", qna.getQnaNo());
			request.setAttribute("writer", member.getNickName());
			request.setAttribute("content", qna.getContent());
			request.setAttribute("title", qna.getTitle());
			forward.setPath("/WEB-INF/views/member/qnaEditView.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
