package org.praktikum.tests;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test_4_5 {

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);

		//FromRomanNummerals(user);
		ToRomanNummerals(user);
	}
	
	public static void FromRomanNummerals(Scanner user) {
		
		ArrayList<Character> romInput = new ArrayList<Character>();
		
		int summe = 0;
		int firstZiff = 0;
		int secZiff = 0;
		
		String romZiffer = "IVXLCDM";
		int[] dezZiffer = {1, 5, 10, 50, 100, 500, 1000};
				
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
	
	public static void ToRomanNummerals(Scanner user) {
		
		List newZiffer = new List();
		
		String[] romZiffer = {"I", "V", "X", "L", "C", "D", "M"};
		
		System.out.println("Dezimal Ziffer:");
		int input = Integer.parseInt(user.nextLine());
		
		
		while (input != 0) {
			if (input < 0) {
				input = 0;
			}
			if (input >= 1000) {
				newZiffer.add(romZiffer[6].toString());
				input -= 1000;
			} else if (input < 1000 && input > 499) {
				newZiffer.add(romZiffer[5].toString());
				input -= 500;
			} else if (input < 500 && input > 99) {
				newZiffer.add(romZiffer[4].toString());
				input -= 100;
			} else if (input < 100 && input > 49) {
				newZiffer.add(romZiffer[3].toString());
				input -= 50;
			} else if (input < 50 && input > 9) {
				newZiffer.add(romZiffer[2].toString());
				input -= 10;
			} else if (input < 10 && input > 4) {
				newZiffer.add(romZiffer[1].toString());
				input -= 5;
			} else if (input < 5 && input == 4) {
				newZiffer.add(romZiffer[0].toString());
				newZiffer.add(romZiffer[1].toString());
				input -= 4;
			} else if (input < 4 && input != 0) {
				newZiffer.add(romZiffer[0].toString());
				input -= 1;
			}
		}
		System.out.print("Ziffern: ");
		for (int i = 0; i < newZiffer.getItemCount(); i++) {
			System.out.print(newZiffer.getItem(i));
		}
	}
}