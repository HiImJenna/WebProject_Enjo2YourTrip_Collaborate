package kr.co.enjo2.service.qna;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaWriteService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				// 비회원이 들어올 가능성이 있나?
			} else {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				QnaDto qnaDto = new QnaDto();
				qnaDto.setTitle(title);
				qnaDto.setContent(content);
				QnaDao qnaDao = new QnaDao();
				qnaDao.saveOne(qnaDto, userId);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				//out.println("<script>alert('등록 성공'); location.href=\"/management.do?type=qna\"; </script>");
				out.println("<script>alert('잠시 후 다시 시도해주세요'); location.href=\"" + request.getContextPath() + "/management.do?type=qna\";</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
