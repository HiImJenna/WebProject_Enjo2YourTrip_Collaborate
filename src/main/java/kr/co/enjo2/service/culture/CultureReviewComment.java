package kr.co.enjo2.service.culture;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureReviewComment implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/* JSON 데이터 받아오는 과정 */
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		JSONParser parser = null;
		JSONObject obj = null;
		CultureDao dao = null;
		
		System.out.println("CultureReviewComment 입장");
		try {
			request.setCharacterEncoding("UTF-8");
			br = request.getReader();
			
			String line = null;			

			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			parser = new JSONParser();
			obj = (JSONObject) parser.parse(sb.toString());

			int culNo = Integer.parseInt(String.valueOf(obj.get("culNo")));
			System.out.println("culNo : " + culNo);
			
			dao = new CultureDao();
			
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();		
//			System.out.println("dao.SearchCulturePlaceReview(culNo).toJSONString() : " + dao.SearchCulturePlaceReview(culNo).toJSONString() );
			out.print(dao.SearchCulturePlaceReview(culNo).toJSONString());
			response.setStatus(200);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

}
