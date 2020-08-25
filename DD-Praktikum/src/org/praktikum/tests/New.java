package org.praktikum.tests;

import java.util.ArrayList;
import java.util.Scanner;

public class New {

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		ArrayList<Character> romZiffer = new ArrayList<Character>();
		
		int summe = 0;
		String rZiffer = "IVXLCDM";
		String[] dezZiffer = {"1", "5", "10", "50", "100", "500", "1000"};
				
		System.out.println("Römische Ziffern:");
		String input = user.nextLine();

		for (int i = 0; i < input.length(); i++) {
			romZiffer.add(input.charAt(i));
			char[] ziffer = {romZiffer.get(i), romZiffer.get(i + 1)};
			int firstZiff = rZiffer.lastIndexOf(ziffer[0]);
			int secZiff = rZiffer.lastIndexOf(ziffer[1]);
			
			if (firstZiff < secZiff) {
				int numb_1 = Integer.parseInt(dezZiffer[firstZiff]);
				int numb_2 = Integer.parseInt(dezZiffer[secZiff]);
			} else {
				
			}
		}
	}

}
