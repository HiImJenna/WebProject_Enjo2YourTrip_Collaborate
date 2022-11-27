package kr.co.enjo2.service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward action = new ActionForward();
		String noticeNo = request.getParameter("no");
		try {
			NoticeDao dao = new NoticeDao();

			if (noticeNo == null || noticeNo.trim().equals("")) {
				action.setRedirect(true);
				// 리다이렉트 어디로 해야하는지...??
				action.setPath(request.getContextPath() + "/management.do");
				return action;
			}
			noticeNo = noticeNo.trim();

			String title = request.getParameter("title");
			String createdat = request.getParameter("createdat");
			String content = request.getParameter("content");
			
			NoticeDto notice = dao.findOne(Integer.parseInt(noticeNo));
			
			request.setAttribute("number", notice.getNoticeNo());
			request.setAttribute("title", notice.getTitle());
			request.setAttribute("content", notice.getContent());
			request.setAttribute("date", notice.getCreatedAt());

			action.setRedirect(false);
			action.setPath("/WEB-INF/views/member/noticeContent.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}

}