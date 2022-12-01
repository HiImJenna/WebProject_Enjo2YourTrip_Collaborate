package kr.co.enjo2.service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaReplyOkService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String userId = (String)request.getSession().getAttribute("userid");
			
			QnaDto qna = new QnaDto(); 
			qna.setTitle(title);
			qna.setContent(content);
			qna.setQnaRef(Integer.parseInt(no));
			qna.setMemberId(userId);
			QnaDao qnaDao = new QnaDao();
			int result = qnaDao.saveOne(qna);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>alert('등록 성공'); location.href=\"" + request.getContextPath() + "/management.do?type=qna\";</script>");
			} else {
				out.println("<script>alert('잠시 후 다시 시도해주세요'); location.href=\"" + request.getContextPath() + "/management.do?type=qna\";</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
