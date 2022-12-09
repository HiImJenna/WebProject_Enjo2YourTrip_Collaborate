package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

//서비스를 지원하는 모드 객체는 Action 인터페이스를 구현하기를 원해요
// 당신은 ActionForward execute 반드시 구현해야 한다
public class MyFlightService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		 try {
	         String userId = (String) request.getSession().getAttribute("userid");
	         
	         if(userId==null) {
	            response.setContentType("text/html; charset=UTF-8");
	               PrintWriter out = response.getWriter();
	               out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script><script>swal(\"로그인이 필요한 서비스입니다.\"); history.go(-1);</script>");
	         }else {
	            forward = new ActionForward();
	            forward.setPath("/WEB-INF/views/member/myFlight.jsp");
	         }
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
		 
		 return forward;

	}

}