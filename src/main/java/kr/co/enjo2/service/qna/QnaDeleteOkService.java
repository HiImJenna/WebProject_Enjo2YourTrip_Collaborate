package kr.co.enjo2.service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.qna.QnaDao;

public class QnaDeleteOkService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			int qnaNo = Integer.parseInt(request.getParameter("no"));
			QnaDao qnaDao = new QnaDao();
			int result = qnaDao.deleteOneByNo(qnaNo);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>alert('삭제 완료'); location.href=\"" + request.getContextPath() + "/management.do?type=qna\";</script>");
			} else {
				out.println("<script>alert('잠시 후 다시 시도해주세요'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
