package com.rab3tech.customer.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.cutomer_card.dao.repository.CustomerCardRepository;
import com.rab3tech.dao.entity.CustomerCardEntity;



@Service
@Transactional
public class CustomerCardServiceImpl implements CustomerCardService {

	@Autowired
	private CustomerCardRepository customerCardRepository;
	
	
	@Override
	public void saveCardData(String name, String number, Date expireDate) {
		long cardNumber = Long.parseLong(number);
		DateFormat df= new SimpleDateFormat("MM/YY");
		 
		
		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/YY"); Date date
		 * = (Date) formatter.parse(expireDate);
		 */
		
		CustomerCardEntity cardEntity = new CustomerCardEntity();
		
		cardEntity.setCardNumber(cardNumber);
		cardEntity.setExpDate(expireDate);
		cardEntity.setApr(12.5);
		cardEntity.setCreditScore(750);
		cardEntity.setCurrentBalance(1000);
		//cardEntity.setCvv(ccvv);
		cardEntity.setMonthlyPayment(35);
		CustomerCardEntity cardData = customerCardRepository.save(cardEntity);
		System.out.println(cardData);
		System.out.println(cardNumber);
		/*
		 * CustomerCardEntityVO customerCardVo = new CustomerCardEntityVO();
		 * BeanUtils.copyProperties(cardEntity, customerCardVo);
		 */
		
		//cardEntity.setCustomer(customer);
	}
	
	public String generateCardNumber() {
		Random random = new Random();

		StringBuilder number = new StringBuilder();
		number.append(String.format("%04d", random.nextInt(10000)));
		number.append(String.format("%04d", random.nextInt(10000)));
		number.append(String.format("%04d", random.nextInt(10000)));
		number.append(String.format("%04d", random.nextInt(10000)));

		return number.toString();
	}

	@Override
	public Date generateExpireDate() {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.YEAR, 3);
		Date date = ca.getTime();
		return date;
	}

	@Override
	public String generateCCVNumber() {
		Random random = new Random();

		StringBuilder number = new StringBuilder();
		number.append(String.format("%03d", random.nextInt(1000)));

		return number.toString();
	}

	@Override
	public byte[] generateFrontCreditCard(String name, String number,String expireDate) {
		byte[] base64Img = null;
		
		Resource resource = new ClassPathResource("images/credit-card-front-template.jpg");
		try {
			
			InputStream resourceInputStream = resource.getInputStream();
			
			Image src = ImageIO.read(resourceInputStream);
			
			int wide = src.getWidth(null);
			int height = src.getHeight(null);
			
			BufferedImage tag = new BufferedImage(wide, height, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D g = tag.createGraphics();
			
			g.setBackground(new Color(200,250,200));
			g.clearRect(0, 0, wide, height);
			g.setColor(Color.WHITE);
			g.drawImage(src, 0, 0,wide, height, null);
			
			g.setFont(new Font("Lucida Console", Font.BOLD,36));
			g.drawString(number.substring(0,4), 40, 207);
			g.drawString(number.substring(4,8), 150, 207);
			g.drawString(number.substring(8,12), 260, 207);
			g.drawString(number.substring(12,16), 370, 207);
			
			g.setFont(new Font("Lucida Console", Font.PLAIN,24));
			g.drawString(expireDate, 65, 250);
			
			g.setFont(new Font("Tahoma",Font.PLAIN,28));
			g.drawString(name.toUpperCase(), 30, 290);
			
			g.dispose();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(tag, "jpg", out);
			out.flush();
			
			//byte[] encodeBytes = Base64.getEncoder().encode(out.toByteArray());
			//base64Img = new String(encodeBytes);
			base64Img = out.toByteArray();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return base64Img;
	}

	@Override
	public byte[] generateBackCreditCard(String cvv) {
		byte[] base64Img = null;
		
		Resource resource = new ClassPathResource("images/credit-card-back-template.jpg");	
		try {
			InputStream resourceInputStream = resource.getInputStream();
			
		Image src = ImageIO.read(resourceInputStream);
		
		int wideth = src.getWidth(null);
		int height = src.getHeight(null);
		
		BufferedImage tag = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = tag.createGraphics();
		
		g.setBackground(new Color(200, 250, 200));
		g.clearRect(0, 0, wideth, height);
		g.setColor(Color.BLACK);
		g.drawImage(src, 0, 0, wideth, height, null);
		
		g.setFont(new Font("Lucida Console", Font.BOLD,18));
		g.drawString(cvv, 360, 135);
		
		g.dispose();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(tag, "jpg", out);
		out.flush();
		
		base64Img = out.toByteArray();
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return base64Img;
	}
}
