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
		//��÷���������
		String m = request.getParameter("m");
		//��ʾ�������ṩ������
		if(m == null){
			new IllegalArgumentException("û���ṩ����������");
		}
		try{
		//	System.out.println(request.getRequestURI()+"���÷�����"+m);
			//ͨ���������Ͳ������ͣ����Ի�÷�������
			Method method = this.getClass().getDeclaredMethod(m,
					HttpServletRequest.class,HttpServletResponse.class);
			//���÷���
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
