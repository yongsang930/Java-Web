package practice3;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		double num3 = scan.nextDouble();
		
		scan.close();
		
		System.out.printf("%7.3f%n", num1);
		System.out.printf("%7.3f%n", num2);
		System.out.printf("%7.3f", num3);
	}
}