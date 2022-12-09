package kr.co.enjo2.service.notice;

import java.io.PrintWriter;

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
				action.setPath(request.getContextPath() + "/management.do");
				return action;
			}
			noticeNo = noticeNo.trim();
			
			NoticeDto notice = dao.findOne(Integer.parseInt(noticeNo));
			
			if (notice != null) {
				dao.updateNoticeViews(Integer.parseInt(noticeNo));
				request.setAttribute("number", notice.getNoticeNo());
				request.setAttribute("title", notice.getTitle());
				request.setAttribute("content", notice.getContent());
				request.setAttribute("date", notice.getCreatedAt());
				action.setRedirect(false);
				action.setPath("/WEB-INF/views/member/noticeContent.jsp");
			} else {
				action = null;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('죄송합니다.\n 잠시후 다시 시도해주세요.'); history.go(-1); </script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}