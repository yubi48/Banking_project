package com.rab3tech.utils;

import java.util.Random;

public class Utils {

	public static String genRandomAlphaNum() {
		// pseudo code
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
		for (int i = 0; i < 5; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);
		return sb.toString();
	}

	public static String generateCustomerAccount() {
		Random r = new Random(System.currentTimeMillis());
		return "00" + (1000000000 + r.nextInt(2000000000)) + "";
	}

	public static void main(String[] args) {
		System.out.println(generateCustomerAccount());
	}

	public static int randonUrnNumber() {
		Random random = new Random();

		int number = random.nextInt(1000000);

		return number;

	}

	private static final String[] ONES = {

			"Zero", "One", "Two", "Three", "Four", "Five",

			"Six", "Seven", "Eight", "Nine" };

	private static final String[] TEENS = {

			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",

			"Fifteen", "Seventeen", "Eighteen", "Nineteen" };

	private static final String[] TENS = {

			null, null, "Twenty", "Thirty", "Forty", "Fifty",

			"Sixty", "Seventy", "Eighty", "Ninety" };

	public static String numberToWords(int number) {

		if (number < 10) {

			return ONES[number];

		} else if (number < 20) {

			int n = number - 10;

			String words = TEENS[n];

			return words == null ? ONES[n] + "teen" : TEENS[n];

		} else {

			int n = number % 10;

			return TENS[number / 10] +

					(n == 0 ? "" : (" " + numberToWords(n)));

		}

	}

}
