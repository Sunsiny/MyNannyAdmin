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
	//���ߡ������С���ַ�����ɫ
	private static final int WIDTH = 120;
	private static final int HEIGHT =60;
	private static final int FONT_SIZE =25;
	private static final String CHARS = "qwertyuiopasdfghjklzxcbnm0123456789";
    private static final Color[] COLORS = {Color.BLACK,Color.RED,Color.BLUE,Color.YELLOW,Color.WHITE,Color.gray};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ڴ�ͼƬ
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		//��û�ͼ����
		Graphics g = image.getGraphics();
		//������ɫ
		g.setColor(Color.GREEN);
		//��������
		g.setFont(new Font("����",Font.PLAIN,FONT_SIZE));
		//������
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//�����
		Random random = new Random();
		StringBuilder strb = new StringBuilder();
		for(int i =0;i<4;i++){
			//�������Ϊ�±�
			int index = random.nextInt(CHARS.length());
			char c = CHARS.charAt(index);
			//�����ַ�
			strb.append(c);
			g.setColor(COLORS[random.nextInt(COLORS.length)]);
			//�ַ�ˮƽ���Ƶ�ͼƬ��
			g.drawString(String.valueOf(c), 20 + i * FONT_SIZE, 30);
			//�������
			g.setColor(COLORS[random.nextInt(COLORS.length)]);
			g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
					random.nextInt(WIDTH),random.nextInt(HEIGHT));
			
		}
		//��֤�뱣�浽SESSION���棬����LoginServlet
		request.getSession().setAttribute("code", strb.toString());
		//ͨ��Servlet�����������ͼƬ���͵��������
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
