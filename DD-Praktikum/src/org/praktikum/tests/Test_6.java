package org.praktikum.tests;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Test_6 {

	public static void main(String[] args) {
		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		
		String[] stringTime = timeNow.toString().split("[:.]");
		String[] stringDate = dateNow.toString().split("[-]");
		
		System.out.println(dateNow);
		System.out.println(timeNow);
		System.out.println(stringTime[1]);
		
		Scanner user = new Scanner(System.in);
		String input = user.nextLine();
		if (input.contains("weeks") || input.contains("week")) {
			int daysNow = LocalDate.now().getDayOfMonth();
			
			
		}
	}

}
