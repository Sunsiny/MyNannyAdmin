package com.qianfeng.nanny.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得方法名参数
		String m = request.getParameter("m");
		//提示调用者提供方法名
		if(m == null){
			new IllegalArgumentException("没有提供方法名参数");
		}
		try{
		//	System.out.println(request.getRequestURI()+"调用方法："+m);
			//通过方法名和参数类型，可以获得方法对象
			Method method = this.getClass().getDeclaredMethod(m,
					HttpServletRequest.class,HttpServletResponse.class);
			//调用方法
			method.invoke(this, request,response);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
