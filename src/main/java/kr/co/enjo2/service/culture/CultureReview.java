package kr.co.enjo2.service.culture;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.culture.CultureDao;

public class CultureReview implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/* JSON 데이터 받아오는 과정 */
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		JSONParser parser = null;
		JSONObject obj = null;
		CultureDao dao = null;
		String gu = "";
		
		try {
			request.setCharacterEncoding("UTF-8");
			br = request.getReader();
			
			String line = null;			

			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			parser = new JSONParser();
			obj = (JSONObject) parser.parse(sb.toString());
  
					
			ArrayList<Integer> listdata = new ArrayList<Integer>();

			JSONArray jArray = (JSONArray)obj.get("culturePlaceNum");
		    gu = (String) obj.get("gu");
			
 
			if (jArray != null) {
			    for (int i=0; i < jArray.size(); i++) {
			           //jArray.get(i)를 바로 읽으면 Class Case Exception이 발생한다. 이는
			           //JS의 Number를 바로 int로 변경하려고 해서 그런 것이므로 String으로 변환 후 파싱해서 사용한다.
			    	
			           listdata.add(Integer.parseInt(String.valueOf(jArray.get(i))));
			    }
			}
			
			int result = 0;
	        dao = new CultureDao();
			
			for(Integer i : listdata) { //for문을 통한 전체출력
				
				if(!dao.exist(i)){
					result += dao.insertCulturePlace(i, gu);
				}
		
			}
			
			System.out.println("dao.SearchCulturePlace(gu).toJSONString()" + dao.SearchCulturePlace(gu).toJSONString());
			
			System.out.println("result : " + result);

			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(dao.SearchCulturePlace(gu).toJSONString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}

}
