package kr.co.enjo2.controller.restaurant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.service.basic.GatherPageMoveService;
import kr.co.enjo2.service.restaurant.AddJjimService;
import kr.co.enjo2.service.restaurant.DeleteJjimService;
import kr.co.enjo2.service.restaurant.JjimListService;
import kr.co.enjo2.service.restaurant.RestaurantDetailService;
import kr.co.enjo2.service.restaurant.RestaurantMainPageService;
import kr.co.enjo2.service.restaurant.RestaurantRecommandChickenService;
import kr.co.enjo2.service.restaurant.RestaurantRecommandPizzaService;
import kr.co.enjo2.service.restaurant.RestaurantRecommandService;
import kr.co.enjo2.service.restaurant.SearchJjimService;

@WebServlet({ "/RestaurantController", "*.restaurant" })
public class RestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RestaurantController() {
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (url_Command.equals("/mainView.restaurant")) {
    		action = new RestaurantMainPageService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/recommand.restaurant")) {
    		System.out.println("요청이 들어왔습니다.");
    		action = new RestaurantRecommandService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandChicken.restaurant")) {
    		action = new RestaurantRecommandChickenService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandPizza.restaurant")) {
    		action = new RestaurantRecommandPizzaService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandPizza.restaurant")) {
    		action = new RestaurantRecommandPizzaService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/detail.restaurant")) {
    		action = new RestaurantDetailService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/searchjjim.restaurant")) {
    		action = new SearchJjimService();
    		forward = action.execute(request, response);//searchjjim.restaurant
    	}else if (url_Command.equals("/addJjim.restaurant")) {
    		action = new AddJjimService();
    		forward = action.execute(request, response);//searchjjim.restaurant
    	}else if (url_Command.equals("/deleteJjim.restaurant")) {
    		action = new DeleteJjimService();
    		forward = action.execute(request, response);//searchjjim.restaurant
    	}else if (url_Command.equals("/jjimList.restaurant")) {
    		action = new JjimListService();
    		forward = action.execute(request, response);//searchjjim.restaurant
    	}
    	
    	// /detail.restaurant
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}

