package com.util.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @Description:验证码生成器
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016年10月8日
 * @author jcf
 * @vesion 2.0
 */
public class SCaptcha {
	
	/** 图片的宽度。 */
	private int width = 80;
	
	/** 图片的高度。 */
	private int height = 40;
	
	/** 验证码字符个数 */
	private int codeCount = 4;

	/** 验证码干扰线数 */
	private int lineCount = 10;

	/** 验证码 */
	private String code = null;

	/** 验证码图片Buffer */
	private BufferedImage buffImg = null;
	
	/**
	 *  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 
	 */
	private char[] codeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	/** 生成随机数 */
	private Random random = new Random();

	/**
	 * 概要：SCaptcha类的默认无参构造函数
	 *   创建图片验证码
	 */
	public SCaptcha() {
		this.createCode();
	}

	/**
	 * 概要：SCaptcha类的构造函数
	 * @param width 图片宽
	 * @param height 图片宽
	 */
	public SCaptcha(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/**
	 * 概要：SCaptcha类的构造函数
	 * @param width 图片宽
	 * @param height 图片高
	 * @param codeCount 字符个数
	 * @param lineCount 干扰线条数
	 */
	public SCaptcha(int width, int height, int codeCount, int lineCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;
		this.createCode();
	}

	/**
	 * <b>概要：</b>
	 * 	随机生成验证码
	 * <b>作者：</b>suxh </br>
	 * <b>日期：</b>2015-1-12 </br>
	 */
	public void createCode() {
		int codeX = 0;// 每个字符的宽度
		int fontHeight = 0;// 字体的高度
		fontHeight = height - 5;
		codeX = width / (codeCount);

		// 1.图像面板buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// 2.创建一个 Graphics2D，可以将它绘制到此 BufferedImage 中。 --类似绘图中的画笔
		Graphics2D graphics2d = buffImg.createGraphics();
		// 2.1 将图像填充为白色
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, width, height);
		// 2.2创建自定义的字体样式
		ImgFontByte imgFont = new ImgFontByte();
		Font font = imgFont.getFont(fontHeight);
		graphics2d.setFont(font);
		// 2.3绘制干扰线
		for (int i = 0; i < lineCount; i++) {
			int xs = getRandomNumber(width);
			int ys = getRandomNumber(height);
			int xe = xs + getRandomNumber(width / 8);
			int ye = ys + getRandomNumber(height / 8);
			graphics2d.setColor(Color.black);
			graphics2d.drawLine(xs, ys, xe, ye);//根据画笔中的属性描绘干扰线
		}
		// 2.4随机产生验证码字符
		StringBuffer randomCode = new StringBuffer();//验证码
		String[] fontNameArray = { "Font.PLAIN", "Font.BOLD", "Font.ITALIC",
				"Font.BOLD+Font.ITALIC" };
		Color[] colorArray = { Color.RED, Color.BLACK, Color.BLUE,Color.GREEN };
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);//获得随机数
			graphics2d.setColor(colorArray[random.nextInt(colorArray.length)]);// 设置字体颜色
			graphics2d.setFont(new Font(fontNameArray[random.nextInt(fontNameArray.length)],Font.ITALIC, 18));
			graphics2d.drawString(strRand, codeX*i+1,getRandomNumber(height / 2) + 20);// 设置字体位置
			randomCode.append(strRand);
		}
		code = randomCode.toString();
	}

	/**
	 * <b>概要：</b>
	 * 		获取随机数
	 * <b>作者：</b>suxh </br>
	 * <b>日期：</b>2015-1-12 </br>
	 * @param number 整型数字
	 * @return 0-number的任意数字
	 */
	private int getRandomNumber(int number) {
		return random.nextInt(number);
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}

	/**
	 * <b>概要：</b>
	 * 		使用支持给定格式 将一个图像bufferedImage写入 OutputStream 
	 * <b>作者：</b>suxh </br>
	 * <b>日期：</b>2015-1-12 </br>
	 * @param sos 输出流
	 * @throws IOException 
	 */
	public void write(OutputStream outputStream) throws IOException {
		ImageIO.write(buffImg, "png", outputStream);
		outputStream.close();
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getCode() {
		return code;
	}

	/** 字体样式内部类 */
	class ImgFontByte {
		public Font getFont(int fontHeight) {
			return new Font("Arial", Font.BOLD, fontHeight);
		}
	}
}