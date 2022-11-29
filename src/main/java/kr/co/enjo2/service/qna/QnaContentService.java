package kr.co.enjo2.service.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.member.MemberDto;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaContentService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				
			} else {
				// 회원인 경우
				String no = request.getParameter("no");
				System.out.println(no);
				QnaDao qnaDao = new QnaDao();
				QnaDto qna = qnaDao.findOneByNo(Integer.parseInt(no));
				if (userId.equals(qna.getMemberId())) {
					// 세션 사용자와 작성자가 같은 경우
					request.setAttribute("mine", "true");
				}
				request.setAttribute("no", qna.getQnaNo());
				request.setAttribute("title", qna.getTitle());
				request.setAttribute("date", qna.getCreatedAt());
				request.setAttribute("content", qna.getContent());
				MemberDto memberDto = new MemberDao().findOne(qna.getMemberId());
				request.setAttribute("writer", memberDto.getNickName());
				forward = new ActionForward();
				forward.setPath("/WEB-INF/views/member/qnaContent.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
