package kr.co.enjo2.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		description = "어노테이션 활용 필터 적용하기", 
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8", description = "모든 페이지 한글 처리")
		})
public class EncodingFilter implements Filter {

    private String encoding;
	
    public EncodingFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	this.encoding = fConfig.getInitParameter("encoding");
    }
	
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// UFT-8 적용
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(this.encoding); //모든 페이지에 적용되는 공통관심
		}
		
		chain.doFilter(request, response);
	}


}
