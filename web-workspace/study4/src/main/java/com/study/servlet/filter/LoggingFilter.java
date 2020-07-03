package com.study.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// 사용자의 요청uri, 소요시간을 로그처리 
public class LoggingFilter implements Filter {

	
	
	// init, destroy 필요하면 오버라이드	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리 : 요청전에 뭔가를 기술 
		long stTime = System.currentTimeMillis();
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		String ip = req.getRemoteAddr(); 
		
		chain.doFilter(request, response);
		// 후처리 : jsp, 서블릿 실행후에 뭔가를 하고싶으로면  
		
		System.out.printf("요청 URI=%s, IP=%s, 소요시간=%dms %n"
				           , uri, ip, (System.currentTimeMillis() - stTime));
	}

	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	@Override
	public void destroy() {
			
	}

}