package com.qianfeng.nanny.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiamfeng.nanny.entity.Administrators;

//@WebFilter("/*")
public class LoginFilter implements Filter {
	
	private static final String[] EXCLUSIVE_URL = {"register.jsp","register.jsp","login.jsp",
			"LoginServlet.do","CodeServlet.do",".jpg",".png",".js",
			".css","SelectAllUsersServlet.do"};

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		
		for(String url : EXCLUSIVE_URL){
			if(request2.getRequestURI().toString().endsWith(url)){
				chain.doFilter(request, response);
				return;
			}
		}
		Administrators administrators = (Administrators) request2.getSession().getAttribute("admin");
		if(administrators == null){
			System.out.println("拦截,"+request2.getRequestURI());
			response2.sendRedirect("login.jsp");
		}else{
			System.out.println("放行的内容："+request2.getRequestURI());
			chain.doFilter(request2, response2);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
