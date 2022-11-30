package kr.co.enjo2.service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class NoticeWrite implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String userId = (String)request.getSession().getAttribute("userid");
			if (userId != null) {
				// 로그인 사용자인 경우
				forward = new ActionForward();
				String nickName = new MemberDao().findOne(userId).getNickName();
				forward.setRedirect(false);
				request.setAttribute("nickName", nickName);
				forward.setPath("/WEB-INF/views/member/noticeWrite.jsp");
			}
			else {
				// 비회원인 경우 (공지글을 작성할 수 없음)
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				//out.println("<script>alert('로그인이 필요한 서비스 입니다.'); history.go(-1);</script>");
				out.println("<script>const result = confirm('로그인이 필요한 서비스입니다. 로그인 페이지로 이동하시겠습니까?'); if(result){location.href=\"/loginView.do\"}else{history.go(-1);}</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}