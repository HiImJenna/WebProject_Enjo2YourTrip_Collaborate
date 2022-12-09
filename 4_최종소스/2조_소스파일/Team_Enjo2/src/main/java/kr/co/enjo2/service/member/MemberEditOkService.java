package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberEditOkService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			MemberDao dao = new MemberDao();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			MemberDto member = dao.findOne(id);
			member.setNickName(nickname);
			member.setPassword(pw);
			member.setEmail(email);
			int result = dao.updateMember(member);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>alert('회원정보를 수정했습니다'); location.href=\"" + request.getContextPath() + "/myMenu.do\";</script>");
			} else {
				out.println("<script>alert('잠시후 다시 시도해주세요'); location.href=\"" + request.getContextPath() + "/myMenu.do\";</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace().toString());
		}
		return forward;
	}
}
