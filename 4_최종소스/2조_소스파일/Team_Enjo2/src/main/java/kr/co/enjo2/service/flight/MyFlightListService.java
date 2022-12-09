package kr.co.enjo2.service.flight;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.flight.FlightDao;
import kr.co.enjo2.dto.flight.FlightTotalDto;

public class MyFlightListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			System.out.println("서비스넘어옴");
			
			String userId = (String) request.getSession().getAttribute("userid");
			int page = Integer.parseInt(request.getParameter("page"));

			FlightDao dao = new FlightDao();
			
			List<FlightTotalDto> flightArr = dao.findUserRsvInfo(userId, page);
			
			JSONArray flightList = new JSONArray();
			
			for (FlightTotalDto f : flightArr) {
				JSONObject obj = new JSONObject();
				obj.put("rsvNo", f.getReservationNo());
				obj.put("departPlace", f.getDepartPlace());
				obj.put("infoDeparTime", f.getDepartTime());
				obj.put("arrivePlace", f.getArrivePlace());
				obj.put("infoArriveTime", f.getArriveTime());
				obj.put("lastNm", f.getMemberLastName());
				obj.put("firstNm", f.getMemberFirstName());
				obj.put("birth", f.getMemberBirth());
				obj.put("price", f.getPrice());
				obj.put("rsvCreateDate", f.getRsvDate());
				obj.put("memId", f.getMemberId());
				obj.put("bdate", f.getBoardingDate());
				flightList.add(obj);
			}
			
			//////////// 페이지 계산 ////////////
			
			// 게시글의 총 수
			int totalCount = dao.getTotalCount(userId);
			
			// 총 페이지의 수
			int numOfTotalPage = (totalCount / 10) + ( (totalCount % 10 == 0) ? 0 : 1);
			
			int start = 0;
			int end = 0;
			
			for(int n = 1; ; ++n) {
				start = 5 * n - 4;
				end = 5 * n;
				if (start <= page && page <= end) {
					break;
				}
			}
			
			int prev = 1;
			int next = 1;
			
			if (start == 1) {
				prev = 0;
			}
			
			end = Math.min(end, numOfTotalPage);
			if (end == numOfTotalPage) {
				next = 0;
			}
			
			JSONObject pageObj = new JSONObject();
			pageObj.put("prev", String.valueOf(prev));
			pageObj.put("next", String.valueOf(next));
			pageObj.put("start", String.valueOf(start));
			pageObj.put("end", String.valueOf(end));
			
			//////////// 페이지 계산 끝 /////////////

			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();

			obj.put("flightList", flightList);
			obj.put("pageInfo", pageObj);
			String result = obj.toJSONString();
			out.print(result);
			response.setStatus(200);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setStatus(400);
		}
		
		return null;
	}

}
