package Intermediate;

import java.util.Scanner;

public class AddTwoNumbers {
	public static void main(String[] args) {
		System.out.println("Add two Numbers");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		double num1 = scanner.nextDouble();
		
		System.out.print("Enter the second number: ");
		double num2 = scanner.nextDouble();
		
		double sum = num1 + num2;
		System.out.println("Sum of" + num1 + "and" + num2 + "is:" +sum);
	}

}
