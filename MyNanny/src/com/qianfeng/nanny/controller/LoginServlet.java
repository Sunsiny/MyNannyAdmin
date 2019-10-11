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
		//��ֹ����
		//request.setCharacterEncoding("utf-8");
		LoginService loginService = new LoginServiceImpl();
		//getParameter ������������post��get�������ݹ����Ĳ�����.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//��ǰ̨�õ���֤��
		//System.out.println("ǰ̨������֤�룺"+username);
		String code = request.getParameter("code");
		//��CodeServlet�õ���֤��
		String codes = (String) request.getSession().getAttribute("code");
		
		//ҳ����ת
		RequestDispatcher rd = null;
		
		Administrators administrators =null;
		//ִ�е�¼����
		administrators = loginService.Login(username, password);
		//���Ϊ�գ��Ǿ���û�в鵽����¼ʧ��
		if(administrators != null){
			//��һ��administrators�Ķ��������������
			request.getSession().setAttribute("admin", administrators);
			if(codes != null && codes.equals(code)){
				rd = request.getRequestDispatcher("SelectAllUsersServlet.do");
			}else{
				request.setAttribute("error","���������Ϣ���������֤�����������µ�¼");
				rd = request.getRequestDispatcher("login.jsp");
			}
		}else{
			 request.setAttribute("error","���������Ϣ���������֤�����������µ�¼");
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
