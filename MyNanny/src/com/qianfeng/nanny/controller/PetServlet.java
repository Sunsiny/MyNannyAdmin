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

import com.qiamfeng.nanny.entity.Pet;
import com.qianfeng.nanny.service.PetService;
import com.qianfeng.nanny.service.impl.PetServiceImpl;


@WebServlet("/pet.do")
public class PetServlet extends BaseServlet {
	public static final String UPLOAD = "D:\\Tomcat\\apache-tomcat-7.0.52\\webapps\\upload\\";
	private static final long serialVersionUID = 1L;
	
	//��
	public void SelectAllPet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		PetService petService = new PetServiceImpl();
		List<Pet> pets = petService.SelectAllPet();
//		System.out.println(pets);
		request.setAttribute("pets", pets);
		request.getRequestDispatcher("SelectAllPet.jsp").forward(request, response);
	}
	//��
	public void AddPet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		//�ж��Ƿ����ļ��ϴ����ڱ�����
		if(ServletFileUpload.isMultipartContent(request)){
			//�����ļ��ϴ�����
			ServletFileUpload upload = new ServletFileUpload();
			//�����ļ��ϴ��Ĵ�С
			upload.setSizeMax(30*1024*1024);
			upload.setFileSizeMax(10*1024*1024);
			
			try {
				Pet pet = new Pet();
				//����ļ�������
				FileItemIterator iter = upload.getItemIterator(request);
				System.out.println(iter);
				while(iter.hasNext()){
					FileItemStream item = iter.next();
					//�ж��Ƿ���һ���
					if(item.isFormField()){
						//�жϱ�ÿһ�������
						String value = Streams.asString(item.openStream(),"UTF-8");
						switch(item.getFieldName()){
						case "name": pet.setName(value);break;
						case "type": pet.setType(value);break;
						case "age": pet.setAge(Integer.parseInt(value));break;
		
						}
					}else{
						File file = new File(UPLOAD+UUID.randomUUID()+".jpg");
						OutputStream out = new FileOutputStream(file);
						switch(item.getFieldName()){
							case "image":pet.setImage(file.getName());break;
							
						}
						Streams.copy(item.openStream(),out, true);
					}
					
				}
				PetService petService = new PetServiceImpl();
				
				 petService.AddPet(pet);
				
				 response.sendRedirect("pet.do?m=SelectAllPet");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	//����Ƿ����������
	public void CheckPet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String name = request.getParameter("name");
		PetService petService = new PetServiceImpl();
		Pet pet = petService.SelectPetByName(name);
		//System.out.println("pet:"+pet);
		if(pet == null){
			response.getWriter().print(true);
		}else{
			response.getWriter().print(false);
		}
		
	}
	
	
	
	
	
	
}
