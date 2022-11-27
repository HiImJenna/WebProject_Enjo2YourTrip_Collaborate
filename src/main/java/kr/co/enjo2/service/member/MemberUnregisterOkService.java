package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberUnregisterOkService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 탈퇴 요청
		ActionForward action = new ActionForward();
		try {
			String id = request.getParameter("id");
			MemberDao dao = new MemberDao(); 
			MemberDto member = dao.findOne(id);
			if (member == null) {
				// 존재하지 않는 사용자인 경우
				action.setRedirect(true);
				// 메인 페이지로 가기
				action.setPath(request.getContextPath());
				// 세션 만료
				request.getSession().invalidate();
			} else {
				// 존재하는 사용자인 경우
				int result = dao.deleteOne(member);
				if (result > 0) {
					// 삭제 성공 
					action.setRedirect(false);
					action.setPath("/WEB-INF/views/member/memberUnregisterOk.jsp");
					// 세션 만료
					request.getSession().invalidate();
				} else {
					// 삭제 실패
					action = null;
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('죄송합니다.\n 잠시후 다시 시도해주세요.'); history.go(-1); </script>");
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		}
		return action;
	}
}