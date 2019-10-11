package com.qianfeng.nanny.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet.do")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//宽、高、字体大小、字符、颜色
	private static final int WIDTH = 120;
	private static final int HEIGHT =60;
	private static final int FONT_SIZE =25;
	private static final String CHARS = "qwertyuiopasdfghjklzxcbnm0123456789";
    private static final Color[] COLORS = {Color.BLACK,Color.RED,Color.BLUE,Color.YELLOW,Color.WHITE,Color.gray};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建内存图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		//获得绘图对象
		Graphics g = image.getGraphics();
		//设置颜色
		g.setColor(Color.GREEN);
		//设置字体
		g.setFont(new Font("宋体",Font.PLAIN,FONT_SIZE));
		//填充矩形
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//随机数
		Random random = new Random();
		StringBuilder strb = new StringBuilder();
		for(int i =0;i<4;i++){
			//随机数作为下标
			int index = random.nextInt(CHARS.length());
			char c = CHARS.charAt(index);
			//连接字符
			strb.append(c);
			g.setColor(COLORS[random.nextInt(COLORS.length)]);
			//字符水平绘制到图片上
			g.drawString(String.valueOf(c), 20 + i * FONT_SIZE, 30);
			//随机线条
			g.setColor(COLORS[random.nextInt(COLORS.length)]);
			g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH),random.nextInt(HEIGHT));
			
		}
		//验证码保存到SESSION里面，传到LoginServlet
		request.getSession().setAttribute("code", strb.toString());
		//通过Servlet的输出流，把图片传送到浏览器上
		ImageIO.write(image, "PNG", response.getOutputStream());
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
