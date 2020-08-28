package org.praktikum.tests;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test_6 {
	
	static LocalDate dateNow = LocalDate.now();
	static LocalTime timeNow = LocalTime.now();
	
	static boolean isOffTime;
	
	static String[] dateTime = {"[!]", "month", "year", "hour", "minute"};
	static String[] dateMonth = {"jan", "feb", "mar", "apr", "mai", "jun", "jul", "aug", "sep", "okt", "nov", "dez"};
	static char[] dateDays = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static char[] dateTimeChar = { '!' , 'm' , 'y'};
	
	static int[] storeDateTime = new int[5];
	static int[] localeDate = {dateNow.getDayOfMonth(), dateNow.getMonthValue(), dateNow.getYear(),
			timeNow.getHour(), timeNow.getMinute()};
	
	
	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		
		System.out.println("Followup Email: ");
		String input = user.nextLine();
		String[] eMail = input.split("@");
		
		GetMailTime(eMail);
		
		ProcessMailTime();
	}
	
	public static void GetMailTime(String[] eMail) {

// Offset Time.
		for (int i = 0; i < 10; i++) {
			if (eMail[0].contains(Character.toString(dateDays[i]))) {
				OffsetTime(eMail);
				break;
			}
		}
// Set time.
		for (int i = 0; i < 12; i++) {
			if (eMail[0].contains(dateMonth[i])) {
				SetTime(eMail, i);
				break;
			}
		}
	}
	
	public static void ProcessMailTime() {
		
		Calendar cal = Calendar.getInstance();
		
		
		if (isOffTime == true) {
			Date date = new Date(System.currentTimeMillis());
			cal.setTime(date);
			
			cal.add(Calendar.HOUR_OF_DAY, storeDateTime[3]);
			cal.add(Calendar.DAY_OF_MONTH, storeDateTime[0]);
			cal.add(Calendar.MONTH, storeDateTime[1]);
			cal.add(Calendar.YEAR, storeDateTime[2]);
			cal.add(Calendar.MINUTE, storeDateTime[4]);
		} else {
			cal.set(Calendar.HOUR, storeDateTime[3]);
			cal.set(Calendar.AM_PM, storeDateTime[3]);
			cal.set(Calendar.MONTH, storeDateTime[1] - 1);
			cal.set(Calendar.DAY_OF_MONTH, storeDateTime[0] - 4);
			cal.set(Calendar.YEAR, localeDate[2]);
			cal.set(Calendar.MINUTE, 0);
		}

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
		System.out.println(dateForm.format(cal.getTime()));
	}
	
	public static void OffsetTime(String[] eMail) {
		int index = 0;
		
		isOffTime = true;
		
		if(eMail[0].contains("week")) {
			index = eMail[0].indexOf('w');
			storeDateTime[0] = 7 * Integer.parseInt(Character.toString(eMail[0].charAt(index - 1)));
		}
		if(eMail[0].contains("day")) {
			index = eMail[0].indexOf('d');
			storeDateTime[0] = storeDateTime[0] + Integer.parseInt(Character.toString(eMail[0].charAt(index - 1)));
		}
		
		for (int i = 0; i < 3; i++) {	
			if (eMail[0].contains(dateTime[i])) {
				index = eMail[0].indexOf(dateTimeChar[i]);
				storeDateTime[i] = Integer.parseInt(Character.toString(eMail[0].charAt(index - 1)));
			}
		}
		
		if (eMail[0].contains("hour")) {
			index = eMail[0].indexOf('h');
			storeDateTime[3] = Integer.parseInt(Character.toString(eMail[0].charAt(index - 1)));
		}
		if (eMail[0].contains("minute")) {
			index = eMail[0].indexOf('n') - 2;
			storeDateTime[4] = Integer.parseInt(Character.toString(eMail[0].charAt(index - 1)));
		}
	}

	public static void SetTime(String[] eMail, int i) {
		isOffTime = false;
		
		storeDateTime[1] = i + 1;
		for (int e = 0; e < 10; e++) {
			if (eMail[0].charAt(4) == dateDays[e]) {
				String cache = Character.toString(eMail[0].charAt(3)) + "" + e;
				storeDateTime[0] = Integer.parseInt(cache);
				break;
			} else {
				storeDateTime[0] = Integer.parseInt(Character.toString(eMail[0].charAt(3)));
			}
		}
		
		for (int j = 0; j < 10; j++) {
			if (eMail[0].charAt(8) == dateDays[j]) {
				String cache = Character.toString(eMail[0].charAt(8)) + "" + (j + 1);
				int aMPM = AmPm(eMail);
				storeDateTime[3] = Integer.parseInt(cache) + aMPM;
			} else {
				int aMPM = AmPm(eMail);
				storeDateTime[3] = Integer.parseInt(Character.toString(eMail[0].charAt(6))) + aMPM;
			}
		}
	}

	public static int AmPm(String[] eMail) {
		if (eMail[0].contains("am")) {
			return 0;
		} else {
			return 12;
		}
	}
}
