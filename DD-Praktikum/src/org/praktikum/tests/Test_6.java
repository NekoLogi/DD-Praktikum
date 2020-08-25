package org.praktikum.tests;

import java.awt.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Test_6 {

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		
		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		
		List mailDate = new List();
		List mailTime = new List();
		
		String years = "";
		String months = "";
		String weeks = "";
		String days = "";
		String hours = "";
		
		String[] stringTime = timeNow.toString().split("[:.]");
		String[] stringDate = dateNow.toString().split("[-]");
	
		System.out.println("eingabe: ");
		String input = user.nextLine();
		
		if (input.contains("hour") || input.contains("hours")) {
			hours = input.replace("hours", "");
		}
		if (input.contains("day") || input.contains("Days")) {
			days = input.replace("days", "");
		}
		if (input.contains("week") || input.contains("weeks")) {
			weeks = input.replace("weeks", "");
		}
		if (input.contains("month") || input.contains("months")) {
			months = input.replace("months", "");
		}
		if (input.contains("year") || input.contains("years")) {
			years = input.replace("years", "");
		}
		System.out.print(hours + days + weeks);
	}
}
