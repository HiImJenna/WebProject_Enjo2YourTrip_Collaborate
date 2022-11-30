package kr.co.enjo2.service.restaurant;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.restaurant.RestaurantDao;
import kr.co.enjo2.dto.restaurant.JjimDto;

public class JjimListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("피자!!!!");
		try {

		
			String userId = (String) request.getSession().getAttribute("userid");
			if (userId == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('이용할 수 없는 페이지 입니다. 뒤로 이동하겠습니다.'); history.go(-1)</script>");
			} else {
				RestaurantDao dao = new RestaurantDao();
				List<JjimDto> jjimArr = dao.findAllInfo(userId);
				JSONArray jjimList = new JSONArray();
				for (JjimDto n : jjimArr) {
					JSONObject obj = new JSONObject();
					obj.put("name", n.getJ_store_nm());
					obj.put("addr", n.getJ_addr());
					jjimList.add(obj);
				}
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter out = response.getWriter();
				JSONObject obj = new JSONObject();
				obj.put("jjimList", jjimList);
				String result = obj.toJSONString();
				out.print(result);
				response.setStatus(200);
			}
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
