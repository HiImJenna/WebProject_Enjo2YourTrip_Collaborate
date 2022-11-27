package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberRegisterOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");

			MemberDao dao = new MemberDao();

			MemberDto findMember = dao.findOne(id);

			// null이 아닌 경우는 이미 존재하는 사용자 아이디
			if (findMember != null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('중복되는 아이디 입니다.'); location.href='joinView.do';</script>");
				out.flush();
				return null;
			}

			MemberDto member = new MemberDto();
			member.setId(id);
			member.setPassword(pw);
			member.setNickName(nickname);
			member.setEmail(email);

			int result = dao.saveOne(member);

			forward = new ActionForward();
			if (result > 0) {
				// 로그인 페이지로 리다이렉트
				forward.setRedirect(true);
				// 일단 야매 "http://localhost:8090/team2" 이부분 어떻게 뽑음??
				PrintWriter out = response.getWriter();

				forward.setPath(request.getContextPath() + "/loginView.do");
			} else {
				forward = null;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잠시후 다시 시도해주세요'); location.href='joinView.do';</script>");
				out.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
