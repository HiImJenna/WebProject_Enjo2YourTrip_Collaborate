package kr.co.enjo2.service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeEditOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			NoticeDao dao = new NoticeDao();
			
			String noticeNo = request.getParameter("no"); 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(noticeNo);
			System.out.println(title);
			System.out.println(content);
			
			NoticeDto notice = dao.findOne(Integer.parseInt(noticeNo));
			notice.setTitle(title);
			notice.setContent(content);
			
			int result = dao.updateOne(notice);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>alert('공지사항이 수정되었습니다'); location.href=\"" + request.getContextPath() + "/noticeContent.do?no="+ noticeNo +"\";</script>");
			} else {
				//out.println("<script>alert('잠시후 다시 시도해주세요'); location.href=\"" + request.getContextPath() + "/noticeContent.do\";</script>");
				out.println("<script>alert('잠시후 다시 시도해주세요'); history.go(-1);</script>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace().toString());
		}
		return forward;
	}
}