package org.praktikum.tests;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Test_4_5 {

	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);

		FromRomanNummerals(user);
		//ToRomanNummerals(user);
	}
	
	public static void FromRomanNummerals(Scanner user) {
		
		ArrayList<Character> romZiffer = new ArrayList<Character>();
		
		System.out.println("Römische Ziffern:");
		String input = user.nextLine();
		int summe = 0;
		int iZiffer = 0;
		
		for (int i = 0; i < input.length(); i++) {
			romZiffer.add(input.charAt(i));
			
			if (romZiffer.get(i) == 'M') {
				summe += 1000;
				Test(input, 'M');
				LessThan(romZiffer, i, input);
				

			} else if (romZiffer.get(i) == 'D') {
				summe += 500;
				Test(input, 'D');
				LessThan(romZiffer, i, input);

				
			} else if (romZiffer.get(i) == 'C') {
				summe += 100;
				Test(input, 'C');
				LessThan(romZiffer, i, input);
				
			} else if (romZiffer.get(i) == 'L') {
				summe += 50;
				Test(input, 'L');
				LessThan(romZiffer, i, input);
				
			} else if (romZiffer.get(i) == 'X') {
				summe += 10;
				Test(input, 'X');
				LessThan(romZiffer, i, input);
				
			} else if (romZiffer.get(i) == 'V') {
				summe += 5;
				Test(input, 'V');
				LessThan(romZiffer, i, input);
				
			} else if (romZiffer.get(i) == 'I') {
				summe += 1;
				Test(input, 'I');
				LessThan(romZiffer, i, input);
			}
		}
		System.out.println(summe -= iZiffer);
	}
	
	public static void LessThan(ArrayList<Character> romZiffer, int i, String input) {
		try {
			String rZiffer = "IVXLCDM";
			int index = 0;
			char ziff = romZiffer.get(i);
			int current = rZiffer.charAt(romZiffer.get(i));
			
			index = i + 1;
			int next = rZiffer.charAt(romZiffer.get(index));
			current++;
			if(current < next) {
				Test(input, ziff);
				System.out.println("true");
			}
		} catch (Exception e) { }

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
	
	public static int Test(String input, char ziff) {
		int index = -1;
		int iZiffer = 0;
		String romZiffer = "IVXLCDM";
		String[] minZiffer = {"1", "5", "10", "50", "100", "500", "1000"};
		
		if (input.contains(Character.toString(ziff))) {
			index = input.lastIndexOf(ziff);
			index++;
			if (index < input.length()) {
				try {
					while (true) {
						index--;
						iZiffer++;
						if(input.charAt(index) == ziff) {	
						} else {
							break;
						}
					}
				} catch (Exception e) {
				}
			}
		}
		int indexZiff = romZiffer.lastIndexOf(ziff);
		return iZiffer * Integer.parseInt(minZiffer[indexZiff]);
	}
}
