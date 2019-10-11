package com.qianfeng.nanny.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiamfeng.nanny.entity.Administrators;
import com.qianfeng.nanny.service.LoginService;
import com.qianfeng.nanny.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防止乱码
		//request.setCharacterEncoding("utf-8");
		LoginService loginService = new LoginServiceImpl();
		//getParameter 是用来接受用post个get方法传递过来的参数的.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//从前台得到验证码
		//System.out.println("前台传的验证码："+username);
		String code = request.getParameter("code");
		//从CodeServlet得到验证码
		String codes = (String) request.getSession().getAttribute("code");
		
		//页面跳转
		RequestDispatcher rd = null;
		
		Administrators administrators =null;
		//执行登录功能
		administrators = loginService.Login(username, password);
		//如果为空，那就是没有查到，登录失败
		if(administrators != null){
			//传一个administrators的对象在浏览器里面
			request.getSession().setAttribute("admin", administrators);
			if(codes != null && codes.equals(code)){
				rd = request.getRequestDispatcher("SelectAllUsersServlet.do");
			}else{
				request.setAttribute("error","你输入的信息有误或者验证码有误，请重新登录");
				rd = request.getRequestDispatcher("login.jsp");
			}
		}else{
			 request.setAttribute("error","你输入的信息有误或者验证码有误，请重新登录");
			rd = request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
