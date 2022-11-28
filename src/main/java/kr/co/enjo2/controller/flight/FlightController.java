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
import kr.co.enjo2.service.flight.ConfirmService;
import kr.co.enjo2.service.flight.DepartsearchService;
import kr.co.enjo2.service.flight.FlightCheckService;
import kr.co.enjo2.service.flight.FlightMainPageMoveService;
import kr.co.enjo2.service.flight.PassengerInfoService;
import kr.co.enjo2.service.flight.PaymentService;
import kr.co.enjo2.service.flight.ReturnsearchService;
import kr.co.enjo2.service.flight.TotalCheckService;

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
    	
    	if (url_Command.equals("/mainView.flight")) {		//index에서 flight_main으로
    		//홈페이지 main에서 항공 main으로 넘겨주기.
    		action = new FlightMainPageMoveService();
    		forward = action.execute(request, response);
    		//항공 main에서 departSearch로 넘겨주기.
    		
    	} else if (url_Command.equals("/departSearch.flight")) {	//flight_main에서 departSearch.jsp로
    		action = new DepartsearchService();
    		forward = action.execute(request, response);
    		
    	} else if (url_Command.equals("/returnSearch.flight")) {	//departSearch.jsp에서 returnSearch.jsp로
     		action = new ReturnsearchService();
    		forward = action.execute(request, response);

    	} else if (url_Command.equals("/flightCheck.flight")) {     //returnSearch.jsp에서 flightCheck.jsp로
    		action = new FlightCheckService();
    		forward = action.execute(request, response);
    		
    	} else if (url_Command.equals("/passengerInfo.flight")) {	//flightCheck.jsp에서 passengerInfo로
    		action = new PassengerInfoService();
    		forward = action.execute(request, response);
    	
    	} else if (url_Command.equals("/totalCheck.flight")) {		//passengerInfo.jsp에서 finalCheck로
    		action = new TotalCheckService();
    		forward = action.execute(request, response);
    		
    	} else if (url_Command.equals("/payment.flight")) {
    		action = new PaymentService();
    		forward = action.execute(request, response);
   		
    	} else if (url_Command.equals("/confirm.flight")) {
    		action = new ConfirmService();
    		forward = action.execute(request, response);
   		
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		} else { //false (모든 자원 ) 사용
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "");
	}
}