package org.praktikum.tests;

import java.util.ArrayList;

public class New {

	public static String romZiffer = "IVXLCDM";
	public static char[] charZiffer = {'I' , 'V' , 'X' , 'L' , 'C' , 'D' , 'M'};
	public static int[] dezZiffer = {1, 5, 10, 50, 100, 500, 1000, 0};
	public static int charCount = 1;
	public static int input = 99;
	
	public static ArrayList<Character> romInput = new ArrayList<Character>();
	public static ArrayList<Character> newOutput = new ArrayList<Character>();
	
	public static void main(String[] args) {
		
		int index = 0;
		
		GetRomanNummerals();
		
		try {
			for (index = index; index < romInput.size(); index++) {
				if (romInput.get(index) == romInput.get(index + 1)) {
					charCount++;
				} else if (index + 1 >= romInput.size()) {
					break;
					}
				if(charCount > 3) {
					int n = romZiffer.indexOf(romInput.get(index));
					
					ProcessNummerals(n);
					index = index + charCount;
					charCount = 1;
				} else {
				}
			}

			
		} catch (Exception err) { }	
		for (index = index; index < romInput.size(); index++) {
			newOutput.add(romInput.get(index));
		}
		for (int i = 0; i < newOutput.size(); i++) {
			System.out.print(newOutput.get(i));
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
}
