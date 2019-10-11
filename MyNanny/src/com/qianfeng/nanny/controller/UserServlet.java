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

	//添加用户
	public void addUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		//添加不能为空
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
			request.setAttribute("register_error", "你添加的信息有误");
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}else{
			row = registerService.Insert(user);
			if(row != 0){
				response.sendRedirect("user.do?m=UserPage");
				//request.getRequestDispatcher("SelectAllUsersServlet.do").forward(request, response);
			}else{
				request.setAttribute("register_error", "你添加的信息有误");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}
	//登录
	public void Login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
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
						rd = request.getRequestDispatcher("user.do?m=UserPage");
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
	//删除
	public void DelUser(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		UserService userService = new UserServiceImpl();
		String id = request.getParameter("id");
		System.out.println("删除的id"+id);
		userService.delUser(Integer.parseInt(id));
		response.sendRedirect("user.do?m=UserPage");
	}
	//通过id查询
	public void SelectUserById(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
		//System.out.println("id1:"+id);
		UserService userService = new UserServiceImpl();
		User user = userService.SelectUserById(Integer.parseInt(id));
		//System.out.println("user的值："+user);
		request.setAttribute("user", user);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	
	//更新
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
	//检查用户名是否已经存在
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
	
	//分页
	public void UserPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String pageNow = request.getParameter("pageNow");
		//System.out.println("pageNow:"+pageNow);
		int no =1;
		//如果不为空，把pageNow的值，转换为int 类型，赋值给no,所以no就是当前的页数，比如第三页
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
