package kr.co.enjo2.service.notice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(title);
		System.out.println(content);
		
		int result = 0;
		
		NoticeDto dto= new NoticeDto();
		
		dto.setTitle(title);
		dto.setContent(content);		/// 수정 해야함
		
		try {
			NoticeDao dao = new NoticeDao();
			result = dao.saveNoticeOne(dto);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		String msg = "";
		String url = "";
		if(result > 0) {
			msg = "insert success";
			url = "noticeList.do";
		} else {
			msg = "insert fail";
			url = "noticeWrite.do";
		}
		request.setAttribute("dto_msg", msg);
		request.setAttribute("dto_url", url);
		
		
		ActionForward action = new ActionForward();
		action.setRedirect(true);
		System.out.println("글입력");
		action.setPath(request.getContextPath() + "/management.do?type=notice");
		
		return action;
	}
	
}