package com.rohit.cms.main;

import java.util.Scanner;

public class CmsUtil {
	private static Scanner input = new Scanner(System.in);
	public static String askForStringNewLine(String question) {
		System.out.println(question);
		String userEntered = input.nextLine();
		//input.close();
		return userEntered;
	}
	public static String askForStringSameLine(String question) {
		System.out.print(question);
		String userEntered = input.nextLine();
		//input.close();
		return userEntered;
	}
}
