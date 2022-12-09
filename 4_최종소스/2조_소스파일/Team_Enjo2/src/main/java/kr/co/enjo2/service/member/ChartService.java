package kr.co.enjo2.service.member;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.flight.ChartDao;
import kr.co.enjo2.dto.flight.ChartDto;

public class ChartService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			ChartDao chartDao = new ChartDao();

			// 월 별 항공편 예약자 수
			List<ChartDto> rsvArr = chartDao.totalUserCount();
			JSONArray categories = new JSONArray();
			JSONArray data = new JSONArray();
			for (int i = 0; i < rsvArr.size(); ++i) {
				JSONObject totalObj = new JSONObject();
				String rsvDate = rsvArr.get(i).getInfoBoaringDate();
				int cnt = rsvArr.get(i).getCount();
				
				totalObj.put("categories", rsvDate);
				totalObj.put("count", cnt);
				categories.add(rsvDate);
				data.add(cnt);
			}

			// 항공편 예약자 남녀 성비
			List<ChartDto> rsvArr2 = chartDao.genderCount();
			JSONArray genderList = new JSONArray();
			for (int i = 0; i < rsvArr2.size(); ++i) { 
				JSONObject genderObj = new JSONObject();
				int cnt = rsvArr2.get(i).getCount();
				String gender = rsvArr2.get(i).getRsvGender();
				genderObj.put("y", cnt);
				genderObj.put("name", gender);
				genderList.add(genderObj);
			}

			// 항공사별 이용객 수
			List<ChartDto> rsvArr3 = chartDao.airCount();
			JSONArray airline = new JSONArray();
			for (int i = 0; i < rsvArr3.size(); ++i) { 
				JSONObject airlineObj = new JSONObject();
				int airlineCnt = rsvArr3.get(i).getCount();
				String airlineNm = rsvArr3.get(i).getInfoAirNm();
				airlineObj.put("name", airlineNm);
				airlineObj.put("y", airlineCnt);
				airline.add(airlineObj);		
			}
			
			/* 위에서 만든 JASON을 하나에 다 넣기 */
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			obj.put("categories", categories);
			obj.put("data", data);
			
			obj.put("genderList", genderList);
			
			obj.put("airline", airline);
			
			
			String result = obj.toJSONString();
			out.print(result);
			response.setStatus(200);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		return forward;
	}

}
