package kr.co.enjo2.service.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeEditOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward action = new ActionForward();
		String noticeNo = request.getParameter("no");

		String msg = "";
		String url = "";

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
				msg = "데이터 오류";
				url = "management.do";
				
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				
				action = new ActionForward();
				action.setRedirect(false);
				action.setPath(request.getContextPath() + "/noticeContent.do");

			} else {
				request.setAttribute("noticeNo", noticeNo);
				request.setAttribute("notice", notice);

				action = new ActionForward();
				action.setRedirect(false);
				action.setPath(request.getContextPath() + "/noticeEdit.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}