package kr.co.enjo2.service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaContentEditOkService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			int qnaNo = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			QnaDao qnaDao = new QnaDao();
			QnaDto qna = qnaDao.findOneByNo(qnaNo);
			qna.setTitle(title);
			qna.setContent(content);
			int result = qnaDao.updateOne(qna);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>alert('문의 글이 수정되었습니다'); location.href=\"" + request.getContextPath() + "/qnaContent.do?no="+ qnaNo +"\";</script>");
			} else {
				//out.println("<script>alert('잠시후 다시 시도해주세요'); location.href=\"" + request.getContextPath() + "/noticeContent.do\";</script>");
				out.println("<script>alert('잠시후 다시 시도해주세요'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
