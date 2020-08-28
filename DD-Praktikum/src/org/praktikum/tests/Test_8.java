package org.praktikum.tests;

import java.awt.List;
import java.time.LocalDate;
import java.util.Scanner;

public class Test_8 {
	
	static List list = new List();
	static List history = new List();
	static int money = 0;
	static String[] dateMonth = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
	static LocalDate dateNow = LocalDate.now();
	static int[] localeDate = { dateNow.getMonthValue(), dateNow.getYear() };

	
	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		
		while (true) {			
			System.out.println("Haushaltsbuch:");
			String input = user.nextLine();
			String[] hb = input.split(" ");
			
			switch (hb[0]) {
			case "auszahlung":
				Auszahlung(hb);
				break;

			case "einzahlung":
				Einzahlung(hb);
				break;
				
			case "übersicht":
				Übersicht(hb);
				break;
			}
		}
		
	}
	
	private static void Übersicht(String[] hb) {
		
		try {
			System.out.println(dateMonth[Integer.parseInt(hb[1])] + " " + hb[2]);
		} catch (Exception err) {
			System.out.println(dateMonth[localeDate[0] - 1] + " " + localeDate[1]);
		}
		System.out.println("----------------------");
		System.out.println("Kassenbestand: " + money + '€');
		
		for (int i = 0; i < history.getItemCount(); i++) {
			try {
				if (history.getItem(i).contains("einzahlung") && history.getItem(i).contains(dateMonth[Integer.parseInt(hb[1])])) {
					System.out.println(history.getItem(i));
				} else {
					System.out.println(history.getItem(i));
				}
			} catch (Exception err) {
				System.out.println(history.getItem(i));
			}
			
		}
		
	}
	
	private static void Auszahlung(String[] hb) {
		
		if (list.getItemCount() == 0) {
			list.add(hb[1] + " " + hb[2] + " " + hb[3]);
			history.add("auszahlung " + " " + hb[1] + " " + dateMonth[localeDate[0] + 1] + " " + hb[2]);
		} else if (list.getItemCount() > 0) {
			
			int categoryMoney = 0;
			
			for (int i = 0; i < list.getItemCount(); i++) {
				try {
					String[][][] listParam = new String[1][1][1];
					String[] parser = new String[3];
					
					parser = list.getItem(i).split(" ");
					listParam[1][0][0] = parser[0];
					listParam[0][1][0] = parser[1];
					listParam[0][0][1] = parser[2];
					
					if(listParam[1][0][0].contains(hb[1])) {
						categoryMoney = categoryMoney + Integer.parseInt(listParam[0][0][1]);
					}
					
				} catch (Exception err) {
					String[][] listParam = new String[1][1];
					String[] parser = new String[2];
					
					parser = list.getItem(i).split(" ");
					listParam[1][0] = parser[0];
					listParam[0][1] = parser[1];
					
					if(listParam[1][0].contains(hb[1])) {
						categoryMoney = categoryMoney + Integer.parseInt(listParam[0][1]);
					}
				}
			}
			
			for (int i = 0; i < list.getItemCount(); i++) {
				System.out.println(hb[1] + ": " + categoryMoney);
			}
			System.out.println("Kassenbestand: " + (money = money - categoryMoney));
		} else {
			
			for (int i = 0; i < list.getItemCount(); i++) {
				
				if (hb[1].contains(list.getItem(i))) {
					if(!hb[2].contains(list.getItem(i))) {
						list.add(hb[1] + " " + hb[2] + " " + hb[3]);
						history.add("auszahlung " + " " + hb[1] + " " + dateMonth[localeDate[0] + 1] + " " + hb[2]);

						break;
					} else { 
						System.out.print(hb[2] + "existiert bereits."); 
						break;
					}
				} else if (list.getItemCount() == i) { 
					list.add(hb[1] + " " + hb[2] + " " + hb[3]);
					history.add("auszahlung " + " " + hb[1] + " " + dateMonth[localeDate[0] + 1] + " " + hb[2]);

					
					break;
				}
			}
			System.out.println("Kassenbestand: " + money);
		}
		
	}
	
	private static void Einzahlung(String[] hb) {
		
		money = money + Integer.parseInt(hb[1]);

		try {
			if (dateMonth[localeDate[0]] == hb[2] && localeDate[1] == Integer.parseInt(hb[3])) {
				System.out.println(dateMonth[localeDate[0] - 1] + " " + localeDate[1]);
				history.add("einzahlung " + money + " " + dateMonth[localeDate[0] - 1] + " " + localeDate[1]);
			} else { 
				System.out.println(hb[2]);
				history.add("einzahlung " + money + " " + hb[2]);

				}
		} catch (Exception err) {
			System.out.println(dateMonth[localeDate[0] - 1] + " " + localeDate[1]);
			history.add("einzahlung " + money + " " + dateMonth[localeDate[0] - 1] + " " + localeDate[1]);
		}
		System.out.println("Kassenbestand: " + money + '€');
		System.out.println("");
		
		
	}
}
