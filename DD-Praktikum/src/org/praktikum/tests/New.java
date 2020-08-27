package org.praktikum.tests;

import java.util.ArrayList;

public class New {

	static String romZiffer = "IVXLCDM";
	static char[] charZiffer = {'I' , 'V' , 'X' , 'L' , 'C' , 'D' , 'M'};
	static int[] dezZiffer = {1, 5, 10, 50, 100, 500, 1000, 0};
	static int charCount = 1;
	static int input = 9;
	static int index = 0;
	static int countCharCount = 0;
	
	static ArrayList<Character> romInput = new ArrayList<Character>();
	static ArrayList<Character> newOutput = new ArrayList<Character>();
	
	public static void main(String[] args) {
		
		
		
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
					//index = index + 1;
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
}
