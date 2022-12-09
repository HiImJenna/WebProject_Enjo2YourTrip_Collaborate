package kr.co.enjo2.service.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.restaurant.RestaurantDao;

public class SearchJjimService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String name= request.getParameter("name");
		
		System.out.println("\nSearchJjimService 시작");
		System.out.println("음식점 상호 : " + name);
		
		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				System.out.println("비회원입니다~~!!\n");
				response.setStatus(400);
			} else {
				RestaurantDao dao = new RestaurantDao();
				int result =  dao.findJjimInfo(name, userId);
				if (result == 1) {
					System.out.println("회원이고 즐겨찾기를 이미 했음\n");
					response.setStatus(200);
				} else {
					System.out.println("회원이지만 즐겨찾기를 하지 않았음\n");
					response.setStatus(400);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nSearchJjimService 끝\n");
		return forward;
	}
}