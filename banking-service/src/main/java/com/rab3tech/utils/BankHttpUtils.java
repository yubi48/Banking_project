package com.rab3tech.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author nagendra
 *
 */
public class BankHttpUtils {
	public static String getServerBaseURL(HttpServletRequest request) {
		String uri = request.getScheme() + "://" + // "http" + "://
				request.getServerName() + // "localhost"
				":" + // ":"
				request.getServerPort() + // "8080"
				request.getContextPath(); // "/cubic-bank"
		return uri;
	}

	public static String generateToken() {
		String token = UUID.randomUUID().toString();
		String time = System.currentTimeMillis() + "";
		return time.substring(0, 4) + token + time.substring(4);
	}
}
