package com.collegebox.teacher.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenerateImageCode {
	
	private static String code = null;
	private ByteArrayInputStream inputStream;

	public static void generateRandomCode(HttpServletRequest request, HttpServletResponse response)
	  throws Exception {
		int width = 75; int height = 23;
	    BufferedImage image = new BufferedImage(width, height, 1);
	    Graphics g = image.getGraphics();
	    Random random = new Random();
	    g.setColor(getRandColor(200, 250));
	    g.fillRect(0, 0, width, height);
	    g.setFont(new Font("Times New Roman", 0, 20));
	    g.setColor(getRandColor(160, 200));
	    for (int i = 0; i < 180; i++) {
	    	int x = random.nextInt(width);
	        int y = random.nextInt(height);
	        int xl = random.nextInt(12);
	        int yl = random.nextInt(12);
	        g.drawLine(x, y, x + xl, y + yl);
	    }
	    String sRand = "";

	    String s = "1234567890";

	    String[] names = { "Times New Roman", "Courier", "Arial" };
	    for (int i = 0; i < 4; i++) {
	        String rand = String.valueOf(s.charAt(random.nextInt(s.length())));
	        sRand = sRand + rand;
	        g.setColor(new Color(random.nextInt(110), random.nextInt(110), random.nextInt(110)));
	        g.setFont(new Font(names[random.nextInt(names.length)], 0, 20));
	        g.drawString(rand, 13 * i + 6, 16);
	    }
	    code = sRand;
	    HttpSession session = request.getSession();
	    session.setAttribute("captcha", code);

	    g.dispose();
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	    response.setDateHeader("Expires", 0L);
	    ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	public static Color getRandColor(int fc, int bc) {
	    Random random = new Random();
	    if (fc > 255) fc = 255;
	    if (bc > 255) bc = 255;
	    int r = fc + random.nextInt(bc - fc);
	    int g = fc + random.nextInt(bc - fc);
	    int b = fc + random.nextInt(bc - fc);
	    return new Color(r, g, b);
	}

	public ByteArrayInputStream getInputStream() {
	    return this.inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
	    this.inputStream = inputStream;
	}

}
