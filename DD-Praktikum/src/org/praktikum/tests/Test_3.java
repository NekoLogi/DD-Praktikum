package org.praktikum.tests;

public class Test_3 {

	public static void main(String[] args) {
		FizzBuzz();
	}
	static void FizzBuzz() {
		// Fizz Buzz
		
		int e = 1;
		for (int i = 1; i < 101; i++) {
			String summe = Integer.toString(i);
			 if (summe.contains("3") && summe.contains("5")) {
				System.out.print("FizzBuzz");
			} else if (summe.contains("3") || (3 * e) == i) {
				System.out.print("Fizz");
			} else if (summe.contains("5") || (5 * e) == i) {
				System.out.print("Buzz");
			} else {
				System.out.print(i);
			}
			System.out.print(',');
			e++;
		}
	}
}
