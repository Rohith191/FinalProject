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
	public static void printWelcomeBanner() {
		System.out.println("\r\n"
				+ "\r\n"
				+ " _    _      _                            _         ______      _     _ _   _       _____ ___  ___ _____ \r\n"
				+ "| |  | |    | |                          | |        | ___ \\    | |   (_) | | |     /  __ \\|  \\/  |/  ___|\r\n"
				+ "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___   | |_/ /___ | |__  _| |_| |__   | /  \\/| .  . |\\ `--. \r\n"
				+ "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  |    // _ \\| '_ \\| | __| '_ \\  | |    | |\\/| | `--. \\\r\n"
				+ "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |\\ \\ (_) | | | | | |_| | | | | \\__/\\| |  | |/\\__/ /\r\n"
				+ " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  \\_| \\_\\___/|_| |_|_|\\__|_| |_|  \\____/\\_|  |_/\\____/ \r\n"
				+ "                                                                                                         \r\n"
				+ "                                                                                                         \r\n"
				+ "\r\n"
				+ "");
	}
}
