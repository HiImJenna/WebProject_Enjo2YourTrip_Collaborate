package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

//서비스를 지원하는 모드 객체는 Action 인터페이스를 구현하기를 원해요
// 당신은 ActionForward execute 반드시 구현해야 한다
public class MyMenuService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String nic = "게스트";
		
		try {
			
			String id = (String)request.getSession().getAttribute("userid");
			
			MemberDto member = null;
			if (id != null) {
				member = new MemberDao().findOne(id);
				nic = member.getNickName();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ActionForward action = new ActionForward();
		request.setAttribute("nickName", nic);
		action.setRedirect(false);
		action.setPath("/WEB-INF/views/member/myMenu.jsp");
		return action;
	}

}