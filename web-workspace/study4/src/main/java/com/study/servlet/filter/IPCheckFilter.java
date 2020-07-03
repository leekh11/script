package com.study.servlet.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.study.common.vo.ResultMessageVO;

public class IPCheckFilter implements Filter {

	private Map<String, String> ipMap;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ipMap = new HashMap<String, String>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0:0:1", "A");
		ipMap.put("192.168.10.14", "D");
		ipMap.put("192.168.10.11", "D");
	}

	@Override
	public void destroy() {
		ipMap = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse resp = (HttpServletResponse) response;
		String ip = req.getRemoteAddr();

		for (String mapkey : ipMap.keySet()) {
			if (ip.equals(mapkey)) {
				if (ipMap.get(mapkey).equals("A")) {
					System.out.println("접속이 승인된 아이피 " + mapkey);
					chain.doFilter(request, response);
				} else if (ipMap.get(mapkey).equals("D")) {
					System.out.println("접속이 거부된 아이피 " + mapkey);
					ResultMessageVO messageVO = new ResultMessageVO();
					messageVO.setResult(false).setTitle("접속 실패").setMessage("접속이 거부된 아이피입니다!");
					req.setAttribute("messageVO", messageVO);
//	    			"/WEB-INF/views/common/message.jsp"

					RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/common/message.jsp");
					dispatcher.forward(request, response);
				}
			}
		}

	}

}
