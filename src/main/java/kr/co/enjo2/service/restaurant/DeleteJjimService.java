package kr.co.enjo2.service.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.restaurant.RestaurantDao;

public class DeleteJjimService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		System.out.println("\nDeleteJjimService 시작");
		System.out.println("음식점 상호 : " + name);
		System.out.println("음식점 주소 : " + addr);

		try {
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				System.out.println("비회원입니다~~!!\n");
				response.setStatus(400);
			} else {
				RestaurantDao dao = new RestaurantDao();
				int result = dao.deleteJjimInfo(name, userId);
				if (result == 1) {
					response.setStatus(200);
				} else {
					response.setStatus(400);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
