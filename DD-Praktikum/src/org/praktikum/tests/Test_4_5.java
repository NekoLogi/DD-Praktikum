package org.praktikum.tests;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_4_5 {
	
	public static String romZiffer = "IVXLCDM";
	public static int[] dezZiffer = {1, 5, 10, 50, 100, 500, 1000, 0};
	static int charCount = 1;
	static int input = 0;
	static int index = 0;
	static int countCharCount = 0;
	
	public static ArrayList<Character> romInput = new ArrayList<Character>();
	static ArrayList<Character> newOutput = new ArrayList<Character>();

	
	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);

		//FromRomanNummerals(user);
		//ToRomanNummerals(user);
	}
	
	public static void FromRomanNummerals(Scanner user) {
		
		System.out.println("Römische Ziffern:");
		input = Integer.parseInt(user.nextLine());
		user.close();
		
		GetRomanNummerals();
		
		try {
			for (index = index; index < romInput.size(); index++) {
				if (romInput.get(index) == romInput.get(index + 1)) {
					charCount++;
					if (charCount > 3) {
						countCharCount++;
					}
				} else if (index + 1 >= romInput.size()) {
					break;
					} else if(charCount > 3) {
					int n = romZiffer.indexOf(romInput.get(index));
					
					ProcessNummerals(n);

					charCount = 1;
					countCharCount++;
				} else {
					newOutput.add(romInput.get(index));
				}
			}

			
		} catch (Exception err) { }	
		try {
			EndResult();
		} catch (Exception err) {
			EndResult();
		}
	}
	
	public static void ToRomanNummerals(Scanner user) {
		
		int charCount = 1;
		int e = 6;
		
		ArrayList<Character> newOutput = new ArrayList<Character>();
		
		System.out.println("Römische Ziffern:");
		input = Integer.parseInt(user.nextLine());
		user.close();
		
		int test = input;
		
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
	
	public static void GetRomanNummerals() {

		for (int i = 6; i > -1; i--) {
			while(input >= dezZiffer[i]) {
				input -= dezZiffer[i];
				romInput.add(romZiffer.charAt(i));
			}
		}
		
		for (int i = 0; i < romInput.size(); i++) {
			System.out.print(romInput.get(i));
		}
		System.out.println("");
	}
	
	public static void ProcessNummerals(int n) {

		if(dezZiffer[n] < dezZiffer[n + 1]) {			
			int restSumme = dezZiffer[n + 1] - (dezZiffer[n] * charCount);	
			while (restSumme != 0) {
				for (int i = 6; i > -1; i--) {
					if (restSumme >= dezZiffer[i]) {
						restSumme = restSumme - dezZiffer[i];						
						newOutput.add(romZiffer.charAt(i));
						newOutput.add(romZiffer.charAt(n + 1));
						break;
					}
				}
			}
		}
	}
	
	public static void EndResult() {
		if (charCount > 3) {
			int n = romZiffer.indexOf(romInput.get(index));
			
			ProcessNummerals(n);
			charCount = 1;
		} else {
			newOutput.add(romInput.get(index - 1));
			
			for (index = index; index < romInput.size(); index++) {
				newOutput.add(romInput.get(index));
			}
		}
		if (countCharCount != 0) {
			for (int i = 0; i < newOutput.size(); i++) {
				System.out.print(newOutput.get(i));
			}
		}
		
	}
	
	public static void GetRomanNummerals(int input) {
		for (int i = 6; i > -1; i--) {
			while(input >= dezZiffer[i]) {
				input -= dezZiffer[i];
				romInput.add(romZiffer.charAt(i));
			}
		}
	}
	
}