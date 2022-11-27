package kr.co.enjo2.service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward action = new ActionForward();
		String noticeNo = request.getParameter("no");
		NoticeDto notice = new NoticeDto();
		try {
			NoticeDao dao = new NoticeDao();
			if (noticeNo == null || noticeNo.trim().equals("")) {
				action.setRedirect(true);
				// 리다이렉트 어디로 해야하는지...??
				action.setPath(request.getContextPath() + "/noticeContent.do");
				return action;
			}
			
			notice = dao.findOne(Integer.parseInt(noticeNo));
			if (notice == null) {
				action = new ActionForward();
				action.setRedirect(true);
				action.setPath(request.getContextPath() + "/noticeContent.do");
			} else {
				request.setAttribute("title", notice.getTitle());
				request.setAttribute("content", notice.getContent());
				action = new ActionForward();
				action.setRedirect(false);
				action.setPath("/WEB-INF/views/member/noticeEdit.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}