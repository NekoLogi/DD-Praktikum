package org.praktikum.tests;

public class Test_2 {

	public static void main(String[] args) {
		Array1D();
		Array2D();
		Array3D();
	}
	
	static void Array1D() {
		int[] meinArray1 = new int[5];
		meinArray1[0] = 0;
		meinArray1[1] = 1;
		meinArray1[2] = 2;
		meinArray1[3] = 3;
		meinArray1[4] = 4;
		
		int[] meinArray2 = new int[3];
		meinArray2[0] = 0;
		meinArray2[1] = 1;
		meinArray2[2] = 2;
		
		// 1.
		System.out.println(meinArray1.length);
		// 2.
		System.out.println(meinArray2.length);
		// 3.
		System.out.println("Ergebnis: " + meinArray1[1]); 
		// 4.
		System.out.println("Ergebnis: " + meinArray2[1]);
		// 5.
		System.out.println("Ergebnis: " + meinArray1[3]);
		// 6.
		System.out.println("Ergebnis: " + meinArray1[4]);
		// 7.
		System.out.println(meinArray1.length - 1);
		// 8.
		System.out.println(meinArray2.length - 1);
		// 9.
		System.out.println("Ergebnis: " + meinArray1[0]);
		// 10.
		System.out.println("Ergebnis: " + meinArray2[0]);
		
		//
		// 1. Gibt die länge des Array "meinArray1" aus = '5'.
		// 2. Gibt die länge des Array "meinArray2" aus = '3'.
		
		// 3. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray1[1]" aus = 'Ergebnis: 1'.
		// 4. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray2[1]" aus = 'Ergebnis: 1'.
		// 5. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray1[3]" aus = 'Ergebnis: 3'.
		// 6. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray1[4]" aus = 'Ergebnis: 4'.
		
		// 7. Gibt die länge des Array "meinArray1" minus 1 aus = '4'.
		// 8. Gibt die länge des Array "meinArray2" minus 1 aus = '2'.
		
		// 9. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray1[0]" aus = 'Ergebnis: 0'.
		// 10. Gibt den String "Ergebnis: " und den inhalt von dem Array "meinArray2[0]" aus = 'Ergebnis: 0'.
	}
	
	static void Array2D() {
		int[][] meinArray3 = new int[2][3];
		
		meinArray3[0][0] = 1;
		meinArray3[1][1] = 2;
		meinArray3[0][2] = 1;
		meinArray3[1][0] = 2;
		meinArray3[0][1] = 1;
		meinArray3[1][2] = 2;
		
		// 1.
		System.out.println(meinArray3[0][0] + meinArray3[0][1] + meinArray3[0][2]);
		// 2.
		System.out.println(meinArray3[1][0] + meinArray3[1][1] + meinArray3[1][2]);
		
		//
		// 1. Addiert den inhalt vom zweidimesionalen Array "meinArray3" ([0][0] + [0][1] + [0][2]) und gibt die summe aus = '3'.
		// 2. Addiert den inhalt vom zweidimesionalen Array "meinArray3" ([1][0] + [1][1] + [1][2]) und gibt die summe aus = '6'.
	}

	static void Array3D() {
		int[][][] meinArray3D = new int[2][2][2];
		
		meinArray3D[0][0][0] = 1;
		meinArray3D[0][1][1] = 2;
		meinArray3D[0][1][0] = 2;
		meinArray3D[0][0][1] = 1;
		
		meinArray3D[1][0][0] = 3;
		meinArray3D[1][1][1] = 4;
		meinArray3D[1][1][0] = 4;
		meinArray3D[1][0][1] = 3;
		
		// 1.
		System.out.println(meinArray3D[0][0][0] + meinArray3D[0][0][1]);
		// 2.
		System.out.println(meinArray3D[0][1][0] + meinArray3D[0][1][1]);
		// 3.
		System.out.println(meinArray3D[1][0][1] + meinArray3D[1][0][1]);
		// 4.
		System.out.println(meinArray3D[1][1][0] + meinArray3D[1][1][1]);
		
		//
		// 1. Addiert den inhalt vom dreidimesionalen Array "meinArray3D" ([0][0][0] + [0][0][1]) und gibt die summe aus = '2'.
		// 2. Addiert den inhalt vom dreidimesionalen Array "meinArray3D" ([0][1][0] + [0][1][1]) und gibt die summe aus = '4'.
		// 3. Addiert den inhalt vom dreidimesionalen Array "meinArray3D" ([1][0][0] + [1][0][1]) und gibt die summe aus = '6'.
		// 4. Addiert den inhalt vom dreidimesionalen Array "meinArray3D" ([1][1][0] + [1][1][1]) und gibt die summe aus = '8'.
	}
}
