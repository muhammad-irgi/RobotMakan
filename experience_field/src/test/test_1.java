
package test;
import java.util.Scanner;

public class test_1 {
	public void penjumlahan(int x, int y) {
		int hasil;
		hasil = x + y;
		System.out.println("hasil : "+hasil);
	}
	public void pengurangan(int x, int y) {
		int hasil;
		hasil = x - y;
		System.out.println("hasil : "+hasil);	
	}
	public void perkalian(int x, int y) {
		int hasil;
		hasil = x*y;
		System.out.println("hasil : "+hasil);
	}
	public void pembagian(int x, int y) {
		int hasil;
		hasil = x/y;
		System.out.println("hasil : "+hasil);
	}
	
	public static void main(String args[]) {
		test_1 hitung = new test_1();
		Scanner myObj = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		Scanner input_b = new Scanner(System.in);
		
		boolean i = true;
		while(i != false) {
			System.out.print("masukan angka pertama : ");
			int angka1 = myObj.nextInt();
			
			System.out.print("+/-/*/// : ");
			char comand = input.next().charAt(0);
			
			System.out.print("masukan angka kedua : ");
			int angka2 = myObj.nextInt();
			
			if(comand == '+') {
			    	// Code to execute if condition1 is true
					hitung.penjumlahan(angka1, angka2);
				} else if (comand == '-') {
					// Code to execute if condition2 is true
					hitung.pengurangan(angka1, angka2);
				} else if (comand == '*'){
					hitung.perkalian(angka1, angka2);
				} else if (comand == '/') {
					hitung.pembagian(angka1, angka2);
				} else {
					System.out.println("error");
				}
			
			System.out.print("lanjut ? ");
			boolean I = myObj.nextBoolean();
			i = I;
		}
	}
}
	
