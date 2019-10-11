package com.qianfeng.nanny.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.google.gson.Gson;
import com.qiamfeng.nanny.entity.Nanny;
import com.qiamfeng.nanny.entity.NannyWorkDTO;
import com.qiamfeng.nanny.entity.Page;
import com.qianfeng.nanny.service.NannyService;
import com.qianfeng.nanny.service.impl.NannyServiceImpl;



@WebServlet("/nanny.do")
public class NannyServlet extends BaseServlet {
	public static final String UPLOAD = "D:\\Tomcat\\apache-tomcat-7.0.52\\webapps\\upload\\";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//分页
	public void NannyPage(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String pageNow = request.getParameter("pageNow");
		//System.out.println("pageNow:"+pageNow);
		int no =1;
		//如果不为空，把pageNow的值，转换为int 类型，赋值给no,所以no就是当前的页数，比如第三页
		if(pageNow != null){
			no=Integer.parseInt(pageNow);
		}
		
		NannyService nannyService = new NannyServiceImpl();
		Page<Nanny> page = nannyService.selectNannyPage(no);
		//System.out.println("-----------");
		request.setAttribute("page", page);
	//	System.out.println("page:"+page);
		request.getRequestDispatcher("SelectAllNanny.jsp").forward(request, response);
	}
	//删
	public void DeleteNanny(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
		NannyService nannyService = new NannyServiceImpl();
		nannyService.DeleteNanny(Integer.parseInt(id));
		request.getRequestDispatcher("nanny.do?m=NannyPage").forward(request, response);
	}
	
	//上传文件，增
	public void AddNanny(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		//判断是否有文件上传，在表单里面
		if(ServletFileUpload.isMultipartContent(request)){
			//创建文件上传对象
			ServletFileUpload upload = new ServletFileUpload();
			//设置文件上传的大小
			upload.setSizeMax(30*1024*1024);
			upload.setFileSizeMax(10*1024*1024);
			
			try {
				Nanny nanny = new Nanny();
				//获得文件迭代器
				FileItemIterator iter = upload.getItemIterator(request);
				System.out.println(iter);
				while(iter.hasNext()){
					FileItemStream item = iter.next();
					//判断是否是一般表
					if(item.isFormField()){
						//判断表单每一项的名称
						String value = Streams.asString(item.openStream(),"UTF-8");
						switch(item.getFieldName()){
						case "name": nanny.setName(value);break;
						case "age": nanny.setAge(Integer.parseInt(value));break;
						case "gender": nanny.setGender(value);break;
						case "tel": nanny.setTel(value);break;
						case "salary": nanny.setSalary(value);break;
						case "months": nanny.setMonths(Integer.parseInt(value));break;
						case "edu": nanny.setEdu(value);break;
						case " place": nanny.setPlace(value);break;
						case "address": nanny.setAddress(value);break;
						case "work_days": nanny.setWork_days(Integer.parseInt(value));break;
						case "phraise": nanny.setPhraise(Integer.parseInt(value));break;
						case "appointments": nanny.setAppointments(Integer.parseInt(value));break;
						case "pid": nanny.setPid(value);break;
						case "nanny_type_id": nanny.setNanny_type_id(Integer.parseInt(value));break;
						case "nation": nanny.setNation(value);break;
						case "marrital": nanny.setMarrital(value);break;
						case "zodiac": nanny.setZodiac(value);break;
						case "current_city": nanny.setCurrent_city(value);break;
						case "target_city": nanny.setTarget_city(value);break;
						case "status": nanny.setStatus(value);break;
						}
					}else{
						File file = new File(UPLOAD+UUID.randomUUID()+".jpg");
						OutputStream out = new FileOutputStream(file);
						switch(item.getFieldName()){
							case "picture":nanny.setPicture(file.getName());break;
							case "id_picture":nanny.setId_picture(file.getName());break;
						}
						Streams.copy(item.openStream(),out, true);
					}
					
				}
				NannyService nannyService = new NannyServiceImpl();
//				int row = 0;
			 nannyService.AddNanny(nanny);
			 response.sendRedirect("nanny.do?m=NannyPage");
//				System.out.println("row:"+row);
//				System.out.println("上传成功了");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	public void SelectNannyWorks(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		NannyService nannyService = new NannyServiceImpl();
		List<NannyWorkDTO>list = nannyService.SelectNannyWorks();
		//System.out.println(list);
		String json = new Gson().toJson(list);
		response.getWriter().print(json);
		
		
	}
	
	
	
	
}
