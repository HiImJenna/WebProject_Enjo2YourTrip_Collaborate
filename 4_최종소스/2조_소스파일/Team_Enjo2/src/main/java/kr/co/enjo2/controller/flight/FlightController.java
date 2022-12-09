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
import kr.co.enjo2.service.member.MyFlightService;
import kr.co.enjo2.service.flight.MyFlightListService;

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
    		//홈페이지 main에서 항공 main으로 넘겨주기.
    		action = new FlightMainPageMoveService();
    		forward = action.execute(request, response);
    		//항공 main에서 departSearch로 넘겨주기.
    	} else if (url_Command.equals("/departSearch.flight")) {
    		// 출발 검색
    		action = new DepartsearchService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/returnSearch.flight")) {
    		// 검색 결과
    		action = new ReturnsearchService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/flightCheck.flight")) {
    		// 항공 내역 확인
    		action = new FlightCheckService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/passengerInfo.flight")) {
    		// 승객 정보
    		action = new PassengerInfoService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/totalCheck.flight")) {
    		// 예약 정보 종합 체크
    		action = new TotalCheckService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/payment.flight")) {
    		// 예약 최종 결제
    		action = new PaymentService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/confirm.flight")) {
    		// 예약 확인
    		action = new ConfirmService();
    		forward = action.execute(request, response);
    	}  else if (url_Command.equals("/myFlight.flight")) {
    		// 항공 예약 화면
    		action = new MyFlightService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/myFlightList.flight")) {
    		// 항공 예매 내역 데이터 요청
    		action = new MyFlightListService();
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
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