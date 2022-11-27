package kr.co.enjo2.controller.flight;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.service.flight.FlightMainPageMoveService;

@WebServlet({ "/FlightController", "*.flight" })
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FlightController() {
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (url_Command.equals("/mainView.flight")) {
    		action = new FlightMainPageMoveService();
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		} else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}