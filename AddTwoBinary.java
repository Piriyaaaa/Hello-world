package Intermediate;

import java.util.Scanner;

public class AddTwoBinary {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first binary number: ");
		String b1 = scanner.nextLine();
		
		System.out.print("Enter second binary number:");
		String b2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(b1, 2);
		int num2 = Integer.parseInt(b2, 2);
		
		int sum = num1 + num2;
		
		System.out.println("The sum = " + Integer.toBinaryString(sum));
		
		scanner.close();
	}

}
