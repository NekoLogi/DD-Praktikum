package org.praktikum.tests;

import java.awt.List;
import java.util.Scanner;

public class Test_7 {

	public static void main(String[] args) {
		// Kassenbon
		
		String choice = "1";
		String sMoney;
		int offMoney;
		
		Scanner user = new Scanner(System.in);
		
		List wareName = new List();
		List warePrice = new List();
		List wareAmount = new List();
		
		System.out.println("Brieftaschen Inhalt: ");
		sMoney = user.nextLine();
		int money = Integer.parseInt(sMoney);
		
		while (choice == "1") {
			System.out.println("Warenname: ");
			wareName.add(user.nextLine());
			
			System.out.println("Preis: ");
			warePrice.add(user.nextLine());
			
			System.out.println("Wie viel von dieser Ware? ");
			String s = user.nextLine();
			wareAmount.add(s);
			
			System.out.println("Willst du noch eine Ware einfügen? 1 = ja | 2 = nein");
			choice = user.nextLine();
		}
		user.close();

		System.out.println("-------------------------------");
		for (int i = 0; i < wareName.getItemCount(); i++) {
			
			System.out.println(wareName.getItem(i) + "\tx" + wareAmount.getItem(i) + " " + (offMoney = (Integer.parseInt(warePrice.getItem(i)) * Integer.parseInt(wareAmount.getItem(i)))) + "€");
			money -= offMoney;
		}
		System.out.println("-------------------------------");
		
		if(money < 0) {
			String stringMoney = Integer.toString(money).trim("-");
			System.out.print("Dein Geld reicht nicht aus dir fehlen noch: " + stringMoney);
		}
		System.out.println(money + "€");
	}
}
