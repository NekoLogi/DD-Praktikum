package org.praktikum.tests;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_4_5 {
	
	public static ArrayList<Character> romInput = new ArrayList<Character>();
	
	public static String romZiffer = "IVXLCDM";
	public static int[] dezZiffer = {1, 5, 10, 50, 100, 500, 1000, 0};

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);

		//FromRomanNummerals(user);
		//ToRomanNummerals(user);
	}
	
	public static void FromRomanNummerals(Scanner user) {
		
		int summe = 0;
		int firstZiff = 0;
		int secZiff = 0;
				
		System.out.println("Römische Ziffern:");
		String input = user.nextLine();
		user.close();
		
		for (int i = 0; i < input.length(); i++) {
			romInput.add(input.charAt(i));
		}
		for (int i = 0; i < input.length(); i++) {
			try {
				char[] ziffer = {romInput.get(i), romInput.get(i + 1)};
				firstZiff = romZiffer.lastIndexOf(ziffer[0]);
				secZiff = romZiffer.lastIndexOf(ziffer[1]);
				
				if (firstZiff < secZiff) {
					summe += (dezZiffer[secZiff] - dezZiffer[firstZiff]);
				} else if (firstZiff >= secZiff) {
					summe += (dezZiffer[firstZiff] + dezZiffer[secZiff]);
				}
				i++;
			} catch(Exception err) {
				summe += dezZiffer[firstZiff];
			}
		}
		System.out.println(summe);
	}
	
	public static void GetRomanNummerals(int input) {
		for (int i = 6; i > -1; i--) {
			while(input >= dezZiffer[i]) {
				input -= dezZiffer[i];
				romInput.add(romZiffer.charAt(i));
			}
		}
	}
	
	public static void ToRomanNummerals(Scanner user) {
			
		int test = 42;
		int input = 42;
		int charCount = 1;
		int e = 6;
		
		ArrayList<Character> newOutput = new ArrayList<Character>();
		
		//System.out.println("Römische Ziffern:");
		//int input = Integer.parseInt(user.nextLine());
		//user.close();
		
		GetRomanNummerals(input);
		
		for (int i = 0; i < romInput.size(); i++) {
			try {
				if (romInput.get(i) == romInput.get(i + 1)) {
					charCount++;
					int n = romZiffer.indexOf(romInput.get(i));
					
					if(charCount > 3) {
						i++;
						if(dezZiffer[n] < dezZiffer[n + 1]) {
							int ziffSumme = dezZiffer[n + 1];
							ziffSumme -= dezZiffer[n];
							int restSumme = test - ziffSumme;
							System.out.println(restSumme);
							newOutput.add(romZiffer.charAt(n));
							newOutput.add(romZiffer.charAt(n + 1));
							
							while (ziffSumme != test && restSumme != 0) {
								try {									
									while (restSumme < dezZiffer[e] && e != -1) {
										e--;
									}
									if(restSumme >= dezZiffer[e]) {
										restSumme -= dezZiffer[e];
										ziffSumme += dezZiffer[e];
										newOutput.add(romZiffer.charAt(e));
									}
									
								} catch (Exception err) { }
							}
						}
					}
				}
			} catch (Exception err) { }
		}

	}
}