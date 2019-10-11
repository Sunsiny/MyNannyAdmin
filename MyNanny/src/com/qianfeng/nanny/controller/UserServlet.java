package com.qianfeng.nanny.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiamfeng.nanny.entity.Administrators;
import com.qiamfeng.nanny.entity.Page;
import com.qiamfeng.nanny.entity.User;
import com.qianfeng.nanny.service.LoginService;
import com.qianfeng.nanny.service.RegisterService;
import com.qianfeng.nanny.service.UserService;
import com.qianfeng.nanny.service.impl.LoginServiceImpl;
import com.qianfeng.nanny.service.impl.RegisterServiceImpl;
import com.qianfeng.nanny.service.impl.UserServiceImpl;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//����û�
	public void addUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		//��Ӳ���Ϊ��
		int row = 0;
		//UserService userService = new UserServiceImpl();
		
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		User user = new User();
		user.setUsername(username);
		user.setRealname(realname);
		user.setAddress(address);
		user.setTel(tel);
		
		RegisterService registerService = new RegisterServiceImpl();
		
		if(username =="" || realname=="" || address=="" || tel ==""){
			request.setAttribute("register_error", "����ӵ���Ϣ����");
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}else{
			row = registerService.Insert(user);
			if(row != 0){
				response.sendRedirect("user.do?m=UserPage");
				//request.getRequestDispatcher("SelectAllUsersServlet.do").forward(request, response);
			}else{
				request.setAttribute("register_error", "����ӵ���Ϣ����");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
	//��¼
	public void Login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
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
						rd = request.getRequestDispatcher("user.do?m=UserPage");
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
	//ɾ��
	public void DelUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		UserService userService = new UserServiceImpl();
		String id = request.getParameter("id");
		System.out.println("ɾ����id"+id);
		userService.delUser(Integer.parseInt(id));
		response.sendRedirect("user.do?m=UserPage");
	}
	//ͨ��id��ѯ
	public void SelectUserById(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
		//System.out.println("id1:"+id);
		UserService userService = new UserServiceImpl();
		User user = userService.SelectUserById(Integer.parseInt(id));
		//System.out.println("user��ֵ��"+user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	//����
	public void UpdateUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
	//	System.out.println("id2:"+id);
		String username = request.getParameter("username");
	//	System.out.println("username:"+username);
		String realname =request.getParameter("realname");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		User user = new User(Integer.parseInt(id),username,realname,address,tel);
		UserService userService = new UserServiceImpl();
		userService.UpdateUser(user);				

		response.sendRedirect("user.do?m=UserPage");
	}
	//����û����Ƿ��Ѿ�����
	public void CheckUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String username = request.getParameter("username");
		//System.out.println(username);
		UserService userService = new UserServiceImpl();
		User user =  userService.SelectUserByUsername(username);
		System.out.println(user);
		if(user == null){
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);
		}
		
	}
	
	//��ҳ
	public void UserPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String pageNow = request.getParameter("pageNow");
		//System.out.println("pageNow:"+pageNow);
		int no =1;
		//�����Ϊ�գ���pageNow��ֵ��ת��Ϊint ���ͣ���ֵ��no,����no���ǵ�ǰ��ҳ�����������ҳ
		if(pageNow != null){
			no=Integer.parseInt(pageNow);
		}
		//System.out.println("no:"+no);
		UserService service = new UserServiceImpl();
		Page<User> page = service.selectUsersPage(no);
		//System.out.println("page:"+page);
		//System.out.println("-----------");
		request.setAttribute("page", page);
		request.getRequestDispatcher("SelectAllUsers.jsp").forward(request, response);
		
	}
	
	
}
