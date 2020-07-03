package com.study.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN); // 403, 접근 금지.
			return false;
		}
		if (session.getAttribute("USER_INFO") == null) {
			// 일반요청 or Ajax 판별해서
			//X-Requested-With 헤더가 있다면
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			if(request.getHeader("X-Requested-With") != null) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
			response.sendRedirect(request.getContextPath() + "/login/login.wow");
			}
			return false;
		}
		return true;
	} // preHandle
} // class
