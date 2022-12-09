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
    		// 맛집 메인 페이지
    		action = new RestaurantMainPageService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/recommand.restaurant")) {
    		// 맛집 추천
    		action = new RestaurantRecommandService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandChicken.restaurant")) {
    		// 치킨집 추천
    		action = new RestaurantRecommandChickenService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandPizza.restaurant")) {
    		// 피잣집 추천
    		action = new RestaurantRecommandPizzaService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/recommandPizza.restaurant")) {
    		// 피자집 추천 2
    		action = new RestaurantRecommandPizzaService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/detail.restaurant")) {
    		// 맛집 상세
    		action = new RestaurantDetailService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/searchjjim.restaurant")) {
    		// 찜 항목 검색
    		action = new SearchJjimService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/addJjim.restaurant")) {
    		// 맛집 찜하기 추가
    		action = new AddJjimService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/deleteJjim.restaurant")) {
    		// 찜하기 삭제
    		action = new DeleteJjimService();
    		forward = action.execute(request, response);
    	}else if (url_Command.equals("/jjimList.restaurant")) {
    		// 사용자 찜리스트
    		action = new JjimListService();
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { 
    			response.sendRedirect(forward.getPath());
    		}else {
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

