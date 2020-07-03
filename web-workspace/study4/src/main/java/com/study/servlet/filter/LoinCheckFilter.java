package com.study.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter()
public class LoinCheckFilter implements Filter{
	
	private List<String> excludeList = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludeList = new ArrayList<String>();
		excludeList.add("/login/login.wow");
		excludeList.add("/login/logout.wow");
		excludeList.add("/free/freeList.wow");
		excludeList.add("/join/join.wow");	
	}
	
	@Override
	public void destroy() {
		excludeList = null;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 로그인 체크
		// 로그인은 세션에 정보가 있는 것!
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		// true : 세션이 존재하지 않으면 생성
		// false : 세션이 존재하지 않으면 null
		
		String uri = req.getRequestURI(); // study/login/login.wow
		uri = uri.substring(req.getContextPath().length());
		
		if(excludeList.contains(uri)) {
			chain.doFilter(request, response);
		} else {
			if(session == null || session.getAttribute("USER_INFO") == null ) {
//			return "redirect:/login/login.wow";
				System.out.println("로그인 체크에서 걸렸어요..");
//				((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/login/login.wow");
				// redirect : 클라이언트가 이동
				
				// RequestDispatcher : 서버 내부에서 이동
				
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
				rd.forward(request, response);
			} else {	
				chain.doFilter(request, response);			
			}
		}
		
		
		
		
		
	}

}
