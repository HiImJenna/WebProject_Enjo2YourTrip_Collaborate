package kr.co.enjo2.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

//서비스를 지원하는 모드 객체는 Action 인터페이스를 구현하기를 원해요
// 당신은 ActionForward execute 반드시 구현해야 한다
public class ManagementService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		
		ActionForward action = new ActionForward();
		action.setRedirect(false);
		
		String path = request.getContextPath();
		
		if (type.equals("notice")) {
			// 1. 공지사항 데이터를 DAO를 통해 가져온다
			// 2. 가져온 데이터를 setAttribute ==> forward로 jsp에 넘겨준다. 넘겨준다
			
			path = "/WEB-INF/views/member/management.jsp";
			
		} else if (type.equals("qna")) {
			
		} else if (type.equals("flight")) {
			
		}else if (type.equals("chart")) {
			path = "/WEB-INF/views/member/managementChart.jsp";
		}
		
		action.setPath(path);
		
		return action;
	}

}