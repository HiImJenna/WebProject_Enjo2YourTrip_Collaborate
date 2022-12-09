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
			if (member == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디와 비밀번호를 확인해주세요'); history.go(-1);</script>");
			} else {
				if (member.getPassword().equals(pwd)) {
					forward = new ActionForward();
					HttpSession session = request.getSession();
					session.setAttribute("userid", member.getId());
					forward.setRedirect(true);
					forward.setPath(request.getContextPath());
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('아이디와 비밀번호를 확인해주세요'); history.go(-1);</script>");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
