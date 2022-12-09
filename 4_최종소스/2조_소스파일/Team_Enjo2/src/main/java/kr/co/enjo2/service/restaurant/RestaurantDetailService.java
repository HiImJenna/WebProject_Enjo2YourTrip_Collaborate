package kr.co.enjo2.service.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class RestaurantDetailService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String addr = request.getParameter("addr");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		System.out.println(addr);
		System.out.println(name);
		System.out.println(category);
		System.out.println("=================");
		String[] arr = category.split(">");
		System.out.println(arr[0].trim());
		System.out.println(arr[1].trim());

		
		request.setAttribute("addr",addr);
		request.setAttribute("category",category);
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		request.setAttribute("imageUrl", "images/"+arr[1].trim() + ".jpg");

		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/restaurant/restaurantDetail.jsp");
		return forward;
	}

}
