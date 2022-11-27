package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberLoginOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");

			MemberDao dao = new MemberDao();
			MemberDto member = dao.findOne(id);

			// isRedirect ==> default == false
			// forward.setRedirect(false);
			if (member == null) { // 없는 사용자인 경우
				// 회원가입 페이지로 갑니다.
				// 알러트 창 어떻게 띄우죠?
				//forward.setPath("/WEB-INF/views/member/join.jsp");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원가입ㄱㄱ'); location.href='joinView.do';</script>");
			} else {
				if (member.getPassword().equals(pwd)) {
					forward = new ActionForward();
					HttpSession session = request.getSession();
					// 로그인 성공
					session.setAttribute("userid", member.getId());
					// 일단 로그인에 성공하면 랜딩 페이지로 갑니다.
					// redirectURI 받아서 처리하면 좋을 것 같음
					forward.setRedirect(true);
					forward.setPath(request.getContextPath());
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
//					out.println("<script>alert('아이디와 비밀번호를 확인해주세요'); location.href='loginView.do';</script>");
					out.println("<script>alert('아이디와 비밀번호를 확인해주세요'); history.go(-1);</script>");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
